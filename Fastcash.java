package bank_management_system;

import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class Fastcash extends javax.swing.JFrame {

    Connection conn;
    Statement s;
    PreparedStatement pst;
    String cardno;
    double sum, sum1, sum2, sum3, sum4;

    public Fastcash(String cardno) {
        initComponents();
        setTitle("BANGLADESH DIGITAL BANK LIMITED");
        setLocation(300, 100);
        conn = Javaconnect.connectDB();
        this.cardno = cardno;

        try {
            s = conn.createStatement();
            String sql = "Select sum(amount) from transaction_details where transaction_type = 'Deposite' and account_number = '" + cardno + "'";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                sum = resultSet.getDouble(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        try {
            s = conn.createStatement();
            String sql = "select sum(amount) from transaction_details where transaction_type = 'Withdrawl' and account_number = '" + cardno + "'";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                sum1 = resultSet.getDouble(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        try {
            s = conn.createStatement();
            String sql = "Select sum(amount) from transaction_details where transaction_type = 'Loan Paid' and account_number = '" + cardno + "'";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                sum3 = resultSet.getDouble(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        try {
            s = conn.createStatement();
            String sql = "Select sum(amount) from transaction_details where transaction_type = 'Transfered' and account_number = '" + cardno + "'";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                sum4 = resultSet.getDouble(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        sum2 = sum - sum1 - sum3 - sum4;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fivebutton = new javax.swing.JButton();
        onebutton = new javax.swing.JButton();
        twobutton = new javax.swing.JButton();
        twofivebutton = new javax.swing.JButton();
        threebutton = new javax.swing.JButton();
        fiveebutton = new javax.swing.JButton();
        exitbutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("SELECT WITHDRAWL AMOUNT");

        fivebutton.setBackground(new java.awt.Color(0, 0, 0));
        fivebutton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        fivebutton.setForeground(new java.awt.Color(51, 153, 255));
        fivebutton.setText("500");
        fivebutton.setToolTipText("");
        fivebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fivebuttonActionPerformed(evt);
            }
        });

        onebutton.setBackground(new java.awt.Color(0, 0, 0));
        onebutton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        onebutton.setForeground(new java.awt.Color(51, 153, 255));
        onebutton.setText("1000");
        onebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onebuttonActionPerformed(evt);
            }
        });

        twobutton.setBackground(new java.awt.Color(0, 0, 0));
        twobutton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        twobutton.setForeground(new java.awt.Color(51, 153, 255));
        twobutton.setText("2000");
        twobutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twobuttonActionPerformed(evt);
            }
        });

        twofivebutton.setBackground(new java.awt.Color(0, 0, 0));
        twofivebutton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        twofivebutton.setForeground(new java.awt.Color(51, 153, 255));
        twofivebutton.setText("2500");
        twofivebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twofivebuttonActionPerformed(evt);
            }
        });

        threebutton.setBackground(new java.awt.Color(0, 0, 0));
        threebutton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        threebutton.setForeground(new java.awt.Color(51, 153, 255));
        threebutton.setText("3000");
        threebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                threebuttonActionPerformed(evt);
            }
        });

        fiveebutton.setBackground(new java.awt.Color(0, 0, 0));
        fiveebutton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        fiveebutton.setForeground(new java.awt.Color(51, 153, 255));
        fiveebutton.setText("5000");
        fiveebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveebuttonActionPerformed(evt);
            }
        });

        exitbutton.setBackground(new java.awt.Color(0, 0, 0));
        exitbutton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        exitbutton.setForeground(new java.awt.Color(51, 153, 255));
        exitbutton.setText("BACK");
        exitbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(threebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(fiveebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(twobutton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(twofivebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(fivebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(onebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(exitbutton)))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fivebutton)
                    .addComponent(onebutton))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(twobutton)
                    .addComponent(twofivebutton))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(threebutton)
                    .addComponent(fiveebutton))
                .addGap(48, 48, 48)
                .addComponent(exitbutton)
                .addContainerGap(83, Short.MAX_VALUE))
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

    private void fivebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fivebuttonActionPerformed
        String transactions = fivebutton.getText();
        double intValue = Double.parseDouble(transactions);
        Date date = new Date();
        String date1 = date.toString();
        try {
            if (sum2 - intValue <= 0) {
                JOptionPane.showMessageDialog(null, "YOUR BALANCE IS INSUFICIENT FOR THIS TRANSACTION");
            } else if (fivebutton.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "PLEASE ENTER THE AMOUNT YOU WANT TO WITHDRAW");
            } else {
                String sql = "insert into transaction_details(account_number, amount, date_and_time, transaction_type)values(?, ?, ?, 'Withdrawl')";
                pst = conn.prepareStatement(sql);
                pst.setString(1, cardno);
                pst.setString(2, transactions);
                pst.setString(3, date1);
                pst.execute();
                JOptionPane.showMessageDialog(null, "WITHDRAWL HAVE DONE SUCCESSFULLY");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_fivebuttonActionPerformed

    private void onebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onebuttonActionPerformed
        String transactions = onebutton.getText();
        double intValue = Double.parseDouble(transactions);
        Date date = new Date();
        String date1 = date.toString();
        try {
            if (sum2 - intValue <= 0) {
                JOptionPane.showMessageDialog(null, "YOUR BALANCE IS INSUFICIENT FOR THIS TRANSACTION");
            } else if (onebutton.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "PLEASE ENTER THE AMOUNT YOU WANT TO WITHDRAW");
            } else {
                String sql = "insert into transaction_details(account_number, amount, date_and_time, transaction_type)values(?, ?, ?, 'Withdrawl')";
                pst = conn.prepareStatement(sql);
                pst.setString(1, cardno);
                pst.setString(2, transactions);
                pst.setString(3, date1);
                pst.execute();
                JOptionPane.showMessageDialog(null, "WITHDRAWL HAVE DONE SUCCESSFULLY");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_onebuttonActionPerformed

    private void twobuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twobuttonActionPerformed
        String transactions = twobutton.getText();
        double intValue = Double.parseDouble(transactions);
        Date date = new Date();
        String date1 = date.toString();
        try {
            if (sum2 - intValue <= 0) {
                JOptionPane.showMessageDialog(null, "YOUR BALANCE IS INSUFICIENT FOR THIS TRANSACTION");
            } else if (twobutton.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "PLEASE ENTER THE AMOUNT YOU WANT TO WITHDRAW");
            } else {
                String sql = "insert into transaction_details(account_number, amount, date_and_time, transaction_type)values(?, ?, ?, 'Withdrawl')";
                pst = conn.prepareStatement(sql);
                pst.setString(1, cardno);
                pst.setString(2, transactions);
                pst.setString(3, date1);
                pst.execute();
                JOptionPane.showMessageDialog(null, "WITHDRAWL HAVE DONE SUCCESSFULLY");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_twobuttonActionPerformed

    private void twofivebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twofivebuttonActionPerformed
        String transactions = twofivebutton.getText();
        double intValue = Double.parseDouble(transactions);
        Date date = new Date();
        String date1 = date.toString();
        try {
            if (sum2 - intValue <= 0) {
                JOptionPane.showMessageDialog(null, "YOUR BALANCE IS INSUFICIENT FOR THIS TRANSACTION");
            } else if (twofivebutton.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "PLEASE ENTER THE AMOUNT YOU WANT TO WITHDRAW");
            } else {
                String sql = "insert into transaction_details(account_number, amount, date_and_time, transaction_type)values(?, ?, ?, 'Withdrawl')";
                pst = conn.prepareStatement(sql);
                pst.setString(1, cardno);
                pst.setString(2, transactions);
                pst.setString(3, date1);
                pst.execute();
                JOptionPane.showMessageDialog(null, "WITHDRAWL HAVE DONE SUCCESSFULLY");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_twofivebuttonActionPerformed

    private void threebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_threebuttonActionPerformed
        String transactions = threebutton.getText();
        double intValue = Double.parseDouble(transactions);
        Date date = new Date();
        String date1 = date.toString();
        try {
            if (sum2 - intValue <= 0) {
                JOptionPane.showMessageDialog(null, "YOUR BALANCE IS INSUFICIENT FOR THIS TRANSACTION");
            } else if (threebutton.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "PLEASE ENTER THE AMOUNT YOU WANT TO WITHDRAW");
            } else {
                String sql = "insert into transaction_details(account_number, amount, date_and_time, transaction_type)values(?, ?, ?, 'Withdrawl')";
                pst = conn.prepareStatement(sql);
                pst.setString(1, cardno);
                pst.setString(2, transactions);
                pst.setString(3, date1);
                pst.execute();
                JOptionPane.showMessageDialog(null, "WITHDRAWL HAVE DONE SUCCESSFULLY");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_threebuttonActionPerformed

    private void fiveebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveebuttonActionPerformed
        String transactions = fiveebutton.getText();
        double intValue = Double.parseDouble(transactions);
        Date date = new Date();
        String date1 = date.toString();
        try {
            if (sum2 - intValue <= 0) {
                JOptionPane.showMessageDialog(null, "YOUR BALANCE IS INSUFICIENT FOR THIS TRANSACTION");
            } else if (fiveebutton.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "PLEASE ENTER THE AMOUNT YOU WANT TO WITHDRAW");
            } else {
                String sql = "insert into transaction_details(account_number, amount, date_and_time, transaction_type)values(?, ?, ?, 'Withdrawl')";
                pst = conn.prepareStatement(sql);
                pst.setString(1, cardno);
                pst.setString(2, transactions);
                pst.setString(3, date1);
                pst.execute();
                JOptionPane.showMessageDialog(null, "WITHDRAWL HAVE DONE SUCCESSFULLY");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_fiveebuttonActionPerformed

    private void exitbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbuttonActionPerformed
        setVisible(false);
        new User_Interface(cardno).setVisible(true);
    }//GEN-LAST:event_exitbuttonActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fastcash("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitbutton;
    private javax.swing.JButton fivebutton;
    private javax.swing.JButton fiveebutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton onebutton;
    private javax.swing.JButton threebutton;
    private javax.swing.JButton twobutton;
    private javax.swing.JButton twofivebutton;
    // End of variables declaration//GEN-END:variables
}
