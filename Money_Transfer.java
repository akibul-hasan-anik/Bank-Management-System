package bank_management_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;

public class Money_Transfer extends javax.swing.JFrame {

    Connection conn;
    PreparedStatement pst, pst1, pst2;
    Statement s;
    String cardno;
    double sum, sum1, sum2, sum3, sum4, sum5;

    public Money_Transfer(String cardno) {
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
            String sql = "select sum(amount) from transaction_details where transaction_type = 'Loan Paid' and account_number = '" + cardno + "'";
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
            String sql = "select sum(amount) from transaction_details where transaction_type = 'Transfered' and account_number = '" + cardno + "'";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                sum3 = resultSet.getDouble(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        sum4 = sum - sum1 - sum2 - sum3;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        account = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        transfer = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        amount = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("MONEY TRANSFER");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(jLabel1)
                .addContainerGap(196, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Account Number : ");

        account.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        account.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                accountKeyTyped(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 153, 255));

        transfer.setBackground(new java.awt.Color(0, 0, 0));
        transfer.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        transfer.setForeground(new java.awt.Color(51, 153, 255));
        transfer.setText("TRANSFER");
        transfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferActionPerformed(evt);
            }
        });

        back.setBackground(new java.awt.Color(0, 0, 0));
        back.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        back.setForeground(new java.awt.Color(51, 153, 255));
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Amount :");

        amount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                amountKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                amountKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(545, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(transfer)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(account, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                            .addComponent(amount))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(account, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(101, 101, 101))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 264, Short.MAX_VALUE)
                        .addComponent(transfer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(back)
                .addGap(0, 48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void transferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferActionPerformed
        String account_number = account.getText();
        String transfer = amount.getText();

        if (account.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "FILL ALL THE REQUIRED FIELDS");
        } else if (amount.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "FILL ALL THE REQUIRED FIELDS");
        } else if (account.getText().equals(cardno)) {
            JOptionPane.showMessageDialog(null, "YOU CAN NOT TRANSFER ON YOUR OWN ACCOUNT NUMBER");
        } else {
            Date date = new Date();
            String date1 = date.toString();
            sum5 = Double.parseDouble(transfer);

            if (sum4 - sum5 > 0) {
                try {
                    Javaconnect c1 = new Javaconnect();
                    s = conn.createStatement();
                    String sql = "select * from user_account WHERE account_number = '" + account_number + "'";
                    ResultSet rs = c1.s.executeQuery(sql);

                    if (rs.next()) {
                        String sql1 = "insert into transaction_details(account_number, amount, date_and_time, transaction_type) values(?, ?, ?, 'Deposite')";
                        String sql2 = "insert into transaction_details(account_number, amount, date_and_time, transaction_type) values(?, ?, ?, 'Transfered')";
                        pst1 = conn.prepareStatement(sql1);
                        pst2 = conn.prepareStatement(sql2);
                        pst1.setString(1, account_number);
                        pst1.setString(2, transfer);
                        pst1.setString(3, date1);
                        pst2.setString(1, cardno);
                        pst2.setString(2, transfer);
                        pst2.setString(3, date1);
                        pst1.execute();
                        pst2.execute();
                        JOptionPane.showMessageDialog(null, "THANK YOU FOR YOUR TRANSACTION");
                    } else {
                        JOptionPane.showMessageDialog(null, "INCORRECT ACCOUNT NUMBER");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "INSUFFICIENT BALANCE");
            }
        }
    }//GEN-LAST:event_transferActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        setVisible(false);
        new User_Interface(cardno).setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void accountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_accountKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_accountKeyTyped

    private void amountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amountKeyTyped
        char c1 = evt.getKeyChar();
        if (!Character.isDigit(c1)) {
            evt.consume();
        }
    }//GEN-LAST:event_amountKeyTyped

    private void amountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amountKeyPressed
        String amount_trans = amount.getText();
        int length1 = amount_trans.length();
        if (length1 < 5) {
            account.setEditable(true);
        } else {
            account.setEditable(false);
        }
    }//GEN-LAST:event_amountKeyPressed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Money_Transfer("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField account;
    private javax.swing.JTextField amount;
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton transfer;
    // End of variables declaration//GEN-END:variables
}
