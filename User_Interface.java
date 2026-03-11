package bank_management_system;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class User_Interface extends javax.swing.JFrame {

    String cardno;
    Connection conn;
    PreparedStatement pst;


    public User_Interface(String cardno) {
        initComponents();
        setTitle("BANGLADESH DIGITAL BANK LIMITED");
        setLocation(300, 100);
        conn = Javaconnect.connectDB();
        this.cardno = cardno;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        depositebutton = new javax.swing.JButton();
        balanceenquirybutton = new javax.swing.JButton();
        fastcashbutton = new javax.swing.JButton();
        pinbutton = new javax.swing.JButton();
        cashwithdrawlbutton = new javax.swing.JButton();
        ministatementbutton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        takeloan = new javax.swing.JButton();
        payloan = new javax.swing.JButton();
        exitbutton = new javax.swing.JButton();
        moneytransfer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        depositebutton.setBackground(new java.awt.Color(0, 0, 0));
        depositebutton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        depositebutton.setForeground(new java.awt.Color(51, 153, 255));
        depositebutton.setText("DEPOSITE");
        depositebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositebuttonActionPerformed(evt);
            }
        });

        balanceenquirybutton.setBackground(new java.awt.Color(0, 0, 0));
        balanceenquirybutton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        balanceenquirybutton.setForeground(new java.awt.Color(51, 153, 255));
        balanceenquirybutton.setText("BALANCE ");
        balanceenquirybutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balanceenquirybuttonActionPerformed(evt);
            }
        });

        fastcashbutton.setBackground(new java.awt.Color(0, 0, 0));
        fastcashbutton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        fastcashbutton.setForeground(new java.awt.Color(51, 153, 255));
        fastcashbutton.setText("FAST CASH");
        fastcashbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fastcashbuttonActionPerformed(evt);
            }
        });

        pinbutton.setBackground(new java.awt.Color(0, 0, 0));
        pinbutton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        pinbutton.setForeground(new java.awt.Color(51, 153, 255));
        pinbutton.setText("PIN CHANGE");
        pinbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pinbuttonActionPerformed(evt);
            }
        });

        cashwithdrawlbutton.setBackground(new java.awt.Color(0, 0, 0));
        cashwithdrawlbutton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cashwithdrawlbutton.setForeground(new java.awt.Color(51, 153, 255));
        cashwithdrawlbutton.setText("WITHDRAWL");
        cashwithdrawlbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashwithdrawlbuttonActionPerformed(evt);
            }
        });

        ministatementbutton.setBackground(new java.awt.Color(0, 0, 0));
        ministatementbutton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ministatementbutton.setForeground(new java.awt.Color(51, 153, 255));
        ministatementbutton.setText("MINI STATEMENT");
        ministatementbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ministatementbuttonActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("PLEASE SELECT YOUR TRANSACTION");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        takeloan.setBackground(new java.awt.Color(0, 0, 0));
        takeloan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        takeloan.setForeground(new java.awt.Color(51, 153, 255));
        takeloan.setText("TAKE LOAN");
        takeloan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                takeloanActionPerformed(evt);
            }
        });

        payloan.setBackground(new java.awt.Color(0, 0, 0));
        payloan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        payloan.setForeground(new java.awt.Color(51, 153, 255));
        payloan.setText("PAY LOAN");
        payloan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payloanActionPerformed(evt);
            }
        });

        exitbutton.setBackground(new java.awt.Color(0, 0, 0));
        exitbutton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        exitbutton.setForeground(new java.awt.Color(51, 153, 255));
        exitbutton.setText("LOG OUT");
        exitbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbuttonActionPerformed(evt);
            }
        });

        moneytransfer.setBackground(new java.awt.Color(0, 0, 0));
        moneytransfer.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        moneytransfer.setForeground(new java.awt.Color(51, 153, 255));
        moneytransfer.setText("MONEY TRANSFER");
        moneytransfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moneytransferActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(pinbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ministatementbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(depositebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(balanceenquirybutton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(51, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(fastcashbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cashwithdrawlbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(takeloan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(payloan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(moneytransfer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(exitbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(depositebutton)
                    .addComponent(balanceenquirybutton))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fastcashbutton)
                    .addComponent(cashwithdrawlbutton))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pinbutton)
                    .addComponent(ministatementbutton))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(takeloan)
                    .addComponent(payloan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(moneytransfer, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(exitbutton)
                .addGap(21, 21, 21))
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

    private void moneytransferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moneytransferActionPerformed
        setVisible(false);
        new Money_Transfer(cardno).setVisible(true);
    }//GEN-LAST:event_moneytransferActionPerformed

    private void exitbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbuttonActionPerformed
        setVisible(false);
        new Home().setVisible(true);
    }//GEN-LAST:event_exitbuttonActionPerformed

    private void payloanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payloanActionPerformed
        setVisible(false);
        new Pay_Loan(cardno).setVisible(true);
    }//GEN-LAST:event_payloanActionPerformed

    private void takeloanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_takeloanActionPerformed
        setVisible(false);
        new Take_Loan(cardno).setVisible(true);
    }//GEN-LAST:event_takeloanActionPerformed

    private void ministatementbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ministatementbuttonActionPerformed
        setVisible(false);
        new Mini_Statement(cardno).setVisible(true);
    }//GEN-LAST:event_ministatementbuttonActionPerformed

    private void cashwithdrawlbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashwithdrawlbuttonActionPerformed
        setVisible(false);
        new Withdrawl(cardno).setVisible(true);
    }//GEN-LAST:event_cashwithdrawlbuttonActionPerformed

    private void pinbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pinbuttonActionPerformed
        setVisible(false);
        new Pin_Change(cardno).setVisible(true);
    }//GEN-LAST:event_pinbuttonActionPerformed

    private void fastcashbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fastcashbuttonActionPerformed
        setVisible(false);
        new Fastcash(cardno).setVisible(true);
    }//GEN-LAST:event_fastcashbuttonActionPerformed

    private void balanceenquirybuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_balanceenquirybuttonActionPerformed
        this.setVisible(false);
        new Balance_Check(cardno).setVisible(true);
    }//GEN-LAST:event_balanceenquirybuttonActionPerformed

    private void depositebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositebuttonActionPerformed
        setVisible(false);
        new Deposite(cardno).setVisible(true);
    }//GEN-LAST:event_depositebuttonActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User_Interface("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton balanceenquirybutton;
    private javax.swing.JButton cashwithdrawlbutton;
    private javax.swing.JButton depositebutton;
    private javax.swing.JButton exitbutton;
    private javax.swing.JButton fastcashbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton ministatementbutton;
    private javax.swing.JButton moneytransfer;
    private javax.swing.JButton payloan;
    private javax.swing.JButton pinbutton;
    private javax.swing.JButton takeloan;
    // End of variables declaration//GEN-END:variables
}
