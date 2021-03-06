/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic75;

import java.util.Calendar;
import java.util.Random;

/**
 *
 * @author HP
 */
public class SplashScreenFrame extends javax.swing.JFrame {

    /**
     * Creates new form SplashScreenFrame
     */
    public SplashScreenFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);

        
        
        barPB.setStringPainted(true);
        //logoL.setIcon(Basic75.ResizeImage(new javax.swing.ImageIcon(getClass().getResource("/images/752.png")), logoL));
        
        //imageL.setIcon(Basic75.ResizeImage(new javax.swing.ImageIcon(getClass().getResource("/images/sp1.png")), imageL));
     
        Calendar cal=Calendar.getInstance();
        int hourOfDay=cal.get(java.util.Calendar.HOUR_OF_DAY);
        
        if(hourOfDay<12)
        {
            morningL.setText(Basic75.firstName);
            imageL.setIcon(Basic75.ResizeImage(new javax.swing.ImageIcon(getClass().getResource("/images/sp1.png")), imageL));
        }
        else if(hourOfDay>=12&&hourOfDay<17)
        {
            afternoonL.setText(Basic75.firstName);
            imageL.setIcon(Basic75.ResizeImage(new javax.swing.ImageIcon(getClass().getResource("/images/sp2.png")), imageL));

        }
        else
        {
            afternoonL.setText(Basic75.firstName);
            imageL.setIcon(Basic75.ResizeImage(new javax.swing.ImageIcon(getClass().getResource("/images/sp3.png")), imageL));

        }
        
        
        SplashThread st=new SplashThread();
        st.start();
        
        
    }
    
    
    class SplashThread extends Thread
    {
        public void run()
        {
            int count =1;
            //Random r=new Random();
            while(barPB.getValue()<barPB.getMaximum())
            {
                try
                {
                    barPB.setValue(count);
                    this.sleep(200);
                    if(count<25)
                    {
                        //Getting Basics
                        barPB.setString("Fetching Basic Information");
                        if(Basic75.currentSem!=0)
                        {
                            Basic75.setBasic();
                            
                        }
                        count=25;
                    }
                    else if(count==25)
                    {
                        //Getting Holidays
                        barPB.setString("Fetching Holidays");
                        if(Basic75.currentSem!=0)
                        {
                            Basic75.setDate();
                            Basic75.setHolidays(Basic75.holidays,Basic75.currentSem);
                        }
                        count=50;
                    }
                    else if(count==50)
                    {
                        //Getting Subjects
                        barPB.setString("Fetching Subjects");
                        if(Basic75.currentSem!=0)
                        {
                            if(Basic75.noOfSub!=0)
                            {
                                Basic75.setArrays();
                                Basic75.setSubjects(null, Basic75.subjects ,Basic75.priority, Basic75.target,Basic75.noOfSub,Basic75.currentSem);

                            }
                              /*System.out.println("Shoeing Subjects");
                            for(int i=0;i<Basic75.noOfSub;i++)
                                System.out.println("->"+Basic75.subjects[i]);*/
                        }
                        count=75;
                    }
                    else if(count==75)
                    {
                        //Getting Time-Table
                        barPB.setString("Fetching TimeTable");
                        if(Basic75.currentSem!=0)
                        {
                            if(Basic75.noOfLec!=0)
                                Basic75.setTT(null);
                        }
                        count=100;  
                    }
                            
                }
                catch(InterruptedException ie)
                {
                    System.out.println("Error: SpalshThread Interrupt Exception: "+ie.getMessage());
                }
            }
            Basic75.hf=new HomeFrame();
            Basic75.hf.setVisible(true);
            dispose();
        }
        
        
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        barPB = new javax.swing.JProgressBar();
        jPanel2 = new javax.swing.JPanel();
        morningL = new javax.swing.JLabel();
        afternoonL = new javax.swing.JLabel();
        logoL = new javax.swing.JLabel();
        imageL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        barPB.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(null);

        morningL.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        morningL.setForeground(new java.awt.Color(66, 103, 178));
        morningL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(morningL);
        morningL.setBounds(90, 180, 410, 50);

        afternoonL.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        afternoonL.setForeground(new java.awt.Color(255, 204, 51));
        afternoonL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(afternoonL);
        afternoonL.setBounds(100, 230, 410, 60);

        logoL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/753.png"))); // NOI18N
        logoL.setText("jLabel1");
        jPanel2.add(logoL);
        logoL.setBounds(160, 300, 280, 230);

        imageL.setText("jLabel1");
        jPanel2.add(imageL);
        imageL.setBounds(10, 10, 860, 550);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(barPB, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barPB, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SplashScreenFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SplashScreenFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SplashScreenFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SplashScreenFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SplashScreenFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel afternoonL;
    private javax.swing.JProgressBar barPB;
    private javax.swing.JLabel imageL;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel logoL;
    private javax.swing.JLabel morningL;
    // End of variables declaration//GEN-END:variables
}






