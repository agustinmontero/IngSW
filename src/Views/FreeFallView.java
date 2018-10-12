package Views;

import Models.FreeFallModel;
import javax.swing.JOptionPane;
import Observers.BPMObserver;
import Observers.BeatObserver;
import Adapter.FreeFallAdapter;

public class FreeFallView extends javax.swing.JFrame implements BPMObserver, BeatObserver {

    FreeFallModel model;
    FreeFallAdapter freeFallAdapter;
    private int initialHigh;
    private double mass;

    FreeFallView() {
        this.model = new FreeFallModel();
        this.freeFallAdapter = new FreeFallAdapter(model);
        initComponents();
        this.model.registerObserver((BeatObserver) this);
        this.model.registerObserver((BPMObserver) this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        org.jdesktop.beansbinding.BindingGroup bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        javax.swing.JProgressBar jProgressBar2 = new javax.swing.JProgressBar();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        jTextFieldHigh = new javax.swing.JTextField();
        javax.swing.JButton jButtonSetHigh = new javax.swing.JButton();
        javax.swing.JButton jButtonStart = new javax.swing.JButton();
        jTextFieldMass = new javax.swing.JTextField();
        javax.swing.JButton jButtonMass = new javax.swing.JButton();
        javax.swing.JPanel jPanel2 = new javax.swing.JPanel();
        highLabel = new javax.swing.JLabel();
        elapsedTimeLabel = new javax.swing.JLabel();
        jLabelGravity = new javax.swing.JLabel();
        jLabelKinetic = new javax.swing.JLabel();
        jLabelPotential = new javax.swing.JLabel();
        jLabelMass = new javax.swing.JLabel();
        jLabelTotalEn = new javax.swing.JLabel();
        javax.swing.JPanel jPanel4 = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jProgressBarKinetic = new javax.swing.JProgressBar();
        jProgressBarPotencial = new javax.swing.JProgressBar();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JMenuBar jMenuBar1 = new javax.swing.JMenuBar();
        javax.swing.JMenu jMenuFile = new javax.swing.JMenu();
        javax.swing.JMenuItem jMenuItemStart = new javax.swing.JMenuItem();
        javax.swing.JMenuItem jMenuItemStop = new javax.swing.JMenuItem();
        javax.swing.JMenuItem jMenuItemExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextFieldHigh.setToolTipText("");

        jButtonSetHigh.setText("Set High");
        jButtonSetHigh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSetHighActionPerformed(evt);
            }
        });

        jButtonStart.setText("Start!");
        jButtonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartActionPerformed(evt);
            }
        });

        jButtonMass.setText("Set Mass");
        jButtonMass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jButtonSetHigh))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jButtonStart)))
                        .addGap(0, 29, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jButtonMass))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldHigh, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                .addComponent(jTextFieldMass)))))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, jButtonSetHigh, jButtonStart);

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldHigh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSetHigh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldMass, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonMass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonStart)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, jButtonSetHigh, jButtonStart);

        highLabel.setText("Current High= [m]");

        elapsedTimeLabel.setText("Elapsed Time: [s]");

        jLabelGravity.setText("Gravity =  [m/s^2]");

        jLabelKinetic.setText("Kinetic Energy = [J]");

        jLabelPotential.setText("Potential Energy = [J]");

        jLabelMass.setText("Mass = [Kg]");

        jLabelTotalEn.setText("Total Energy = [J]");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelGravity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(32, 32, 32))
                    .addComponent(highLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(elapsedTimeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(71, 71, 71))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelKinetic, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelPotential, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelMass, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTotalEn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(highLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(elapsedTimeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelGravity)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelKinetic)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelPotential)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTotalEn)
                .addGap(4, 4, 4)
                .addComponent(jLabelMass)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jProgressBar1.setStringPainted(true);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jProgressBar1, org.jdesktop.beansbinding.ELProperty.create("${orientation}1"), jProgressBar1, org.jdesktop.beansbinding.BeanProperty.create("orientation"));
        bindingGroup.addBinding(binding);

        jProgressBarKinetic.setOrientation(1);
        jProgressBarKinetic.setStringPainted(true);

        jProgressBarPotencial.setOrientation(1);
        jProgressBarPotencial.setStringPainted(true);

        jLabel1.setText("Altitude");

        jLabel2.setText("Kinetic");

        jLabel3.setText("Potential");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jProgressBarKinetic, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jProgressBarPotencial, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProgressBarKinetic, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProgressBarPotencial, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        jMenuFile.setText("Menu");

        jMenuItemStart.setText("Start");
        jMenuItemStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemStartActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemStart);

        jMenuItemStop.setText("Stop");
        jMenuItemStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemStopActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemStop);

        jMenuItemExit.setText("Exit");
        jMenuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExitActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemExit);

        jMenuBar1.add(jMenuFile);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemStartActionPerformed
        freeFallAdapter.on();
        jLabelGravity.setText("Gravity = " + freeFallAdapter.getGravity() + "[m/s]");
    }//GEN-LAST:event_jMenuItemStartActionPerformed

    private void jButtonSetHighActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSetHighActionPerformed
        try {
            int bpm = Integer.parseInt(jTextFieldHigh.getText());
            this.initialHigh = bpm;
            freeFallAdapter.setBPM(bpm);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid Data! Try again..", null, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonSetHighActionPerformed

    private void jMenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItemExitActionPerformed

    private void jMenuItemStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemStopActionPerformed
        freeFallAdapter.off();
    }//GEN-LAST:event_jMenuItemStopActionPerformed

    private void jButtonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartActionPerformed
        freeFallAdapter.on();
        jLabelGravity.setText("Gravity = " + freeFallAdapter.getGravity() + "[m/s]");
    }//GEN-LAST:event_jButtonStartActionPerformed

    private void jButtonMassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMassActionPerformed
        try {
            double m = Double.parseDouble(jTextFieldMass.getText());
            this.mass = m;
            freeFallAdapter.setMass(m);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid Data! Try again..", null, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonMassActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | javax.swing.UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException ex) {
            java.util.logging.Logger.getLogger(FreeFallView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FreeFallView().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel elapsedTimeLabel;
    private javax.swing.JLabel highLabel;
    private javax.swing.JLabel jLabelGravity;
    private javax.swing.JLabel jLabelKinetic;
    private javax.swing.JLabel jLabelMass;
    private javax.swing.JLabel jLabelPotential;
    private javax.swing.JLabel jLabelTotalEn;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBarKinetic;
    private javax.swing.JProgressBar jProgressBarPotencial;
    private javax.swing.JTextField jTextFieldHigh;
    private javax.swing.JTextField jTextFieldMass;
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateBPM() {
        if (model != null) {
            highLabel.setText("Current High[m]: " + model.getAltitude());
            elapsedTimeLabel.setText("Elapsed Time[sec]: " + model.getTime());
            jLabelMass.setText("Mass = " + model.getMass() + "[Kg]");
            jLabelPotential.setText("Potential Energy = " + model.getPotencialEn() + "[J]");
            jLabelKinetic.setText("Kinetic Energy = " + model.getKineticEn() + "[J]");
            jLabelTotalEn.setText("Total Energy = " + model.getTotalEnergy() + "[J]");
        }
    }

    @Override
    public void updateBeat() {
        try {
            int altitude = model.getAltitude();
            int percentAlt = ((altitude * 100) / initialHigh);
            jProgressBar1.setValue(percentAlt);

            if (this.mass != 0) {
                int kineticEn = model.getKineticEn();
                int percentKin = ((kineticEn * 100) / model.getTotalEnergy());
                jProgressBarKinetic.setValue(percentKin);

                int potencialEn = model.getPotencialEn();
                int percentPot = ((potencialEn * 100) / model.getTotalEnergy());
                jProgressBarPotencial.setValue(percentPot);
            }
        } catch (ArithmeticException e) {
        }
    }

    void setInitialHigh(int initialHigh) {
        this.initialHigh = initialHigh;
    }

    void setMass(double mass) {
        this.mass = mass;
    }

}
