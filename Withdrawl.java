package bank_management_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.*;
import java.io.FileWriter;

public class Withdrawl extends javax.swing.JFrame {

    Connection conn;
    Statement s;
    PreparedStatement pst;
    String cardno;
    ResultSet rs = null;
    double sum, sum1, sum2, sum3, sum4;

    public Withdrawl(String cardno) {
        initComponents();
        setTitle("BANGLADESH DIGITAL BANK LIMITED");
        setLocation(300, 100);
        conn = Javaconnect.connectDB();
        this.cardno = cardno;

        try {
            s = conn.createStatement();
            String sql = "select sum(amount) from transaction_details where transaction_type = 'Deposite' and account_number = '" + cardno + "'";
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
            String sql = "select sum(amount) from transaction_details where transaction_type = 'Loan Paid' and account_number = '" + cardno + "'";
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
            String sql = "select sum(amount) from transaction_details where transaction_type = 'Transfered' and account_number = '" + cardno + "'";
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
        jLabel2 = new javax.swing.JLabel();
        amountbutton = new javax.swing.JTextField();
        withdraw = new javax.swing.JButton();
        exitbutton = new javax.swing.JButton();
        clear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MAXIMUM WITHDRAWL IS 99,999 TK");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("PLEASE YOUR ENTER AMOUNT ");

        amountbutton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        amountbutton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                amountbuttonKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                amountbuttonKeyTyped(evt);
            }
        });

        withdraw.setBackground(new java.awt.Color(0, 0, 0));
        withdraw.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        withdraw.setForeground(new java.awt.Color(51, 153, 255));
        withdraw.setText("WITHDRAW");
        withdraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawActionPerformed(evt);
            }
        });
        withdraw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                withdrawKeyTyped(evt);
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

        clear.setBackground(new java.awt.Color(0, 0, 0));
        clear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        clear.setForeground(new java.awt.Color(51, 153, 255));
        clear.setText("CLEAR");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(exitbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(amountbutton)
                            .addComponent(withdraw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(amountbutton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clear)
                    .addComponent(exitbutton))
                .addGap(18, 18, 18)
                .addComponent(withdraw)
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

    private void withdrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawActionPerformed
        String transactions = amountbutton.getText();
        if (amountbutton.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "PLEASE ENTER THE AMOUNT YOU WANT TO WITHDRAWL");
            }else{
        double intValue = Double.parseDouble(transactions);
        Date date = new Date();
        String date1 = date.toString();

          if (sum2 - intValue <= 0) {
                JOptionPane.showMessageDialog(null, "YOUR BALANCE IS INSUFICIENT FOR THIS TRANSACTION");
            } else {
        try {
            
                FileWriter fWriter = new FileWriter("D:\\Project\\Withdrawl.txt", true);
                String withdrawldata = String.format("Account No: %s,   Amount : %s,    Date and Time: %s%n", cardno, transactions, date1);
                fWriter.append(withdrawldata);
                fWriter.close();
                String sql = "insert into transaction_details(account_number, amount, date_and_time, transaction_type)values(?, ?, ?, 'Withdrawl')";
                pst = conn.prepareStatement(sql);
                pst.setString(1, cardno);
                pst.setString(2, transactions);
                pst.setString(3, date1);
                pst.execute();
                JOptionPane.showMessageDialog(null, "THANK YOU FOR YOUR TRANSACTION");
            }
         catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }}}
    }//GEN-LAST:event_withdrawActionPerformed

    private void exitbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbuttonActionPerformed
        setVisible(false);
        new User_Interface(cardno).setVisible(true);
    }//GEN-LAST:event_exitbuttonActionPerformed

    private void amountbuttonKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amountbuttonKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_amountbuttonKeyTyped

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        try {
            amountbutton.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_clearActionPerformed

    private void withdrawKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_withdrawKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_withdrawKeyTyped

    private void amountbuttonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amountbuttonKeyPressed
        String amount_withdraw = amountbutton.getText();
        int length1 = amount_withdraw.length();
        if (length1 < 5) {
            amountbutton.setEditable(true);
        } else {
            amountbutton.setEditable(false);
        }
    }//GEN-LAST:event_amountbuttonKeyPressed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Withdrawl("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountbutton;
    private javax.swing.JButton clear;
    private javax.swing.JButton exitbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton withdraw;
    // End of variables declaration//GEN-END:variables
}
