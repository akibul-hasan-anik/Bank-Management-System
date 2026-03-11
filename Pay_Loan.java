package bank_management_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;

public class Pay_Loan extends javax.swing.JFrame {

    Connection conn;
    PreparedStatement pst1;
    Statement s;
    String cardno;
    double sum, sum1, sum2, sum3, sum4, sum5, value;

    public Pay_Loan(String cardno) {
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
            String sql = "select sum(amount) from transaction_details where transaction_type = 'Transfered' and account_number = '" + cardno + "'";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                sum2 = resultSet.getDouble(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        try {
            s = conn.createStatement();
            String sql1 = "select sum(amount_with_interest) from taken_loan_details where account_number = '" + cardno + "'";
            PreparedStatement statement = conn.prepareStatement(sql1);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                sum3 = resultSet.getDouble(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        try {
            s = conn.createStatement();
            String sql1 = "Select sum(amount) from transaction_details where transaction_type = 'Loan Paid' and account_number = '" + cardno + "'";
            PreparedStatement statement = conn.prepareStatement(sql1);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                sum4 = resultSet.getDouble(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        sum5 = sum - sum1 - sum2 - sum4;
    }

    private void excute() {
        Date date = new Date();
        String date1 = date.toString();
        String loan = amount.getText();
        if (amount.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "PLEASE ENTER THE AMOUNT YOU WANT TO PAY LOAN");
        } else {
            value = Double.parseDouble(loan);
            if (sum5 - value > 0 && sum3 - sum5 >= 0) {
                try {

                    String sql1 = "insert into transaction_details(account_number, amount, date_and_time, transaction_type) values(?, ?, ?, 'Loan Paid')";
                    pst1 = conn.prepareStatement(sql1);
                    pst1.setString(1, cardno);
                    pst1.setString(2, loan);
                    pst1.setString(3, date1);
                    pst1.execute();
                    JOptionPane.showMessageDialog(null, "THANK YOU FOR YOUR TRANSACTION");

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "PLEASE CHECK YOUR DUE LOAN AND BALANCE FIRST");
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        amount = new javax.swing.JTextField();
        excute = new javax.swing.JButton();
        backbutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Amount :");

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("PAY LOAN ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        amount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                amountKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                amountKeyTyped(evt);
            }
        });

        excute.setBackground(new java.awt.Color(0, 0, 0));
        excute.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        excute.setForeground(new java.awt.Color(51, 153, 255));
        excute.setText("EXCUTE");
        excute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excuteActionPerformed(evt);
            }
        });

        backbutton.setBackground(new java.awt.Color(0, 0, 0));
        backbutton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        backbutton.setForeground(new java.awt.Color(51, 153, 255));
        backbutton.setText("BACK");
        backbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(excute, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81)
                .addComponent(excute)
                .addGap(29, 29, 29)
                .addComponent(backbutton)
                .addGap(0, 77, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void amountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amountKeyPressed
        String amount_deposite = amount.getText();
        int length1 = amount_deposite.length();
        if (length1 < 5) {
            amount.setEditable(true);
        } else {
            amount.setEditable(false);
        }
    }//GEN-LAST:event_amountKeyPressed

    private void amountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amountKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_amountKeyTyped

    private void excuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excuteActionPerformed
        excute();
    }//GEN-LAST:event_excuteActionPerformed

    private void backbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbuttonActionPerformed
        setVisible(false);
        new User_Interface(cardno).setVisible(true);
    }//GEN-LAST:event_backbuttonActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pay_Loan("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amount;
    private javax.swing.JButton backbutton;
    private javax.swing.JButton excute;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
