package Models;
  
import javax.sound.midi.*;
import java.util.*;
import Observers.BPMObserver;
import Interfaces.BeatModelInterface;
import Observers.BeatObserver;

public class BeatModel implements BeatModelInterface, MetaEventListener {
    private Sequencer sequencer;
    private ArrayList beatObservers = new ArrayList();
    private ArrayList bpmObservers = new ArrayList();
    private int bpm = 90;
    private Sequence sequence;
    private Track track;
    //private static BeatModel uniqueInstance = null;

    public BeatModel() {
    }
    
    /*public static BeatModel getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new BeatModel();
        }
        return uniqueInstance;
    }*/
    
    
 
    public void initialize() {
        setUpMidi();
        buildTrackAndStart();
    }
 
    public void on() {
        sequencer.start();
//        setBPM(90);
        setBPM(getBPM());
    }
 
    public void off() {
		setBPM(0);
		sequencer.stop();
    }
 
    public void setBPM(int bpm) {
		this.bpm = bpm;

		//FIX
		sequencer.setMicrosecondPosition(0);
        sequencer.setTickPosition(0) ; 
            
		sequencer.setTempoInBPM(getBPM());
		notifyBPMObservers();
    }
  
	public int getBPM() {
		return bpm;
	}
  
	private void beatEvent() {
		notifyBeatObservers();
	}
  
   
	public void registerObserver(BeatObserver o) {
		beatObservers.add(o);
	}
  
	private void notifyBeatObservers() {
		for (Object beatObserver : beatObservers) {
			BeatObserver observer = (BeatObserver) beatObserver;
			observer.updateBeat();
		}
	}
  
	public void registerObserver(BPMObserver o) {
		bpmObservers.add(o);
	}
  
	private void notifyBPMObservers() {
		for (Object bpmObserver : bpmObservers) {
			BPMObserver observer = (BPMObserver) bpmObserver;
			observer.updateBPM();
		}
	}


	public void removeObserver(BeatObserver o) {
		int i = beatObservers.indexOf(o);
		if (i >= 0) {
			beatObservers.remove(i);
		}
	}



	public void removeObserver(BPMObserver o) {
		int i = bpmObservers.indexOf(o);
		if (i >= 0) {
			bpmObservers.remove(i);
		}
	}


    public void meta(MetaMessage message) {
//        if (message.getType() == 47) {
//			beatEvent();
//        	sequencer.start();
//        	setBPM(getBPM());
//        }
    	
    	//FIX
    	if (message.getType() == 0x2F ) {
			beatEvent();
			sequencer.setMicrosecondPosition(0);
            sequencer.setTickPosition(0) ; 
            sequencer.start(); 
        	setBPM(getBPM());	
        }
    }

	private void setUpMidi() {
		try {
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.addMetaEventListener(this);
			
			//Fix
			sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
			
			sequence = new Sequence(Sequence.PPQ,4);
			track = sequence.createTrack();
			sequencer.setTempoInBPM(getBPM());
		} catch(Exception e) {
				e.printStackTrace();
		}
    } 

     private void buildTrackAndStart() {
        int[] trackList = {35, 0, 46, 0};
    
        sequence.deleteTrack(null);
        track = sequence.createTrack();

      	makeTracks(trackList);
		track.add(makeEvent(192, 1,0,4));
	 	try {
			sequencer.setSequence(sequence);                    
		} catch(Exception e) {
			e.printStackTrace();
		}
    } 
            
    private void makeTracks(int[] list) {
       
       for (int i = 0; i < list.length; i++) {
          int key = list[i];

          if (key != 0) {
             track.add(makeEvent(144, key, 100, i));
             track.add(makeEvent(128, key, 100, i+1));
          }
       }
    }
        
    private MidiEvent makeEvent(int comd, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, 9, one, two);
            event = new MidiEvent(a, tick);
            
        } catch(Exception e) {
			e.printStackTrace(); 
		}
        return event;
    }
}
