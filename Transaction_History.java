package bank_management_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.*;

public class Transaction_History extends javax.swing.JFrame {

    Connection conn;
    PreparedStatement pst;
    Statement s;
    int ac;
    double sum, sum1, sum2, sum3, sum4;

    public Transaction_History() {
        initComponents();
        setTitle("BANGLADESH DIGITAL BANK LIMITED");
        setLocation(300, 100);
        conn = Javaconnect.connectDB();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        accountnumber = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        numbertransaction = new javax.swing.JTextField();
        submit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        deposite = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        withdrawl = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        loan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        transfer = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        depamount = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        with = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        loantext = new javax.swing.JTextField();
        back = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        totalbalance = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("TRANSACTION HISTORY");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Account Number :");

        accountnumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        accountnumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                accountnumberKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Number of Transaction :");

        numbertransaction.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        submit.setBackground(new java.awt.Color(0, 0, 0));
        submit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        submit.setForeground(new java.awt.Color(51, 153, 255));
        submit.setText("SUBMIT");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Number of Deposite : ");

        deposite.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Number of Withdrawl :");

        withdrawl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Number of Loan : ");

        loan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Number of Transfer : ");

        transfer.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Highest Deposite :");

        depamount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Highest Withdrawl :");

        with.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Highest Loan : ");

        loantext.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        back.setBackground(new java.awt.Color(0, 0, 0));
        back.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        back.setForeground(new java.awt.Color(51, 153, 255));
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Total Balance :");

        totalbalance.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(accountnumber)
                    .addComponent(numbertransaction)
                    .addComponent(deposite)
                    .addComponent(withdrawl)
                    .addComponent(loan)
                    .addComponent(transfer)
                    .addComponent(depamount)
                    .addComponent(with)
                    .addComponent(loantext)
                    .addComponent(totalbalance))
                .addGap(61, 61, 61))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accountnumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(numbertransaction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(deposite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(withdrawl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(loan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(transfer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(depamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(with, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(loantext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(totalbalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submit)
                    .addComponent(back))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        try {
            s = conn.createStatement();
            String sql1 = "select account_number from user_account where account_number = ?";
            pst = conn.prepareStatement(sql1);
            pst.setString(1, accountnumber.getText());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                ac = rs.getInt(1);
                String accunt = accountnumber.getText();
                try {
                    String sql = "select count(*) from transaction_details where account_number = '" + accunt + "'";
                    PreparedStatement statement = conn.prepareStatement(sql);
                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        int rowCount = resultSet.getInt(1);
                        String str = Integer.toString(rowCount);
                        numbertransaction.setText(str);
                        numbertransaction.setEditable(false);
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }

                try {
                    String sql = "select count(*) from transaction_details where account_number = '" + accunt + "' and transaction_type = 'Deposite'";
                    PreparedStatement statement = conn.prepareStatement(sql);
                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        int rowCount = resultSet.getInt(1);
                        String str = Integer.toString(rowCount);
                        deposite.setText(str);
                        deposite.setEditable(false);
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }

                try {
                    String sql = "select count(*) from transaction_details where account_number = '" + accunt + "' and transaction_type = 'Withdrawl'";
                    PreparedStatement statement = conn.prepareStatement(sql);
                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        int rowCount = resultSet.getInt(1);
                        String str = Integer.toString(rowCount);
                        withdrawl.setText(str);
                        withdrawl.setEditable(false);
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }

                try {
                    String sql = "select count(*) from transaction_details where account_number = '" + accunt + "' and transaction_type = 'Loan Taken'";
                    PreparedStatement statement = conn.prepareStatement(sql);
                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        int rowCount = resultSet.getInt(1);
                        String str = Integer.toString(rowCount);
                        loan.setText(str);
                        loan.setEditable(false);
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }

                try {
                    String sql = "select count(*) from transaction_details where account_number = '" + accunt + "' and transaction_type = 'Transfered'";
                    PreparedStatement statement = conn.prepareStatement(sql);
                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        int rowCount = resultSet.getInt(1);
                        String str = Integer.toString(rowCount);
                        transfer.setText(str);
                        transfer.setEditable(false);
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }

                try {
                    String sql = "select max(amount) from transaction_details where account_number = '" + accunt + "' and transaction_type = 'Deposite'";
                    PreparedStatement statement = conn.prepareStatement(sql);
                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        int rowCount = resultSet.getInt(1);
                        String str = Integer.toString(rowCount);
                        depamount.setText(str);
                        depamount.setEditable(false);
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }

                try {
                    String sql = "select max(amount) from transaction_details where account_number = '" + accunt + "' and transaction_type = 'Withdrawl'";
                    PreparedStatement statement = conn.prepareStatement(sql);
                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        int rowCount = resultSet.getInt(1);
                        String str = Integer.toString(rowCount);
                        with.setText(str);
                        with.setEditable(false);
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }

                try {
                    String sql = "select max(amount) from transaction_details where account_number = '" + accunt + "' and transaction_type = 'Loan Taken'";
                    PreparedStatement statement = conn.prepareStatement(sql);
                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        int rowCount = resultSet.getInt(1);
                        String str = Integer.toString(rowCount);
                        loantext.setText(str);
                        loantext.setEditable(false);
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }

                try {
                    s = conn.createStatement();
                    String sql = "Select sum(amount) from transaction_details where transaction_type = 'Deposite' and account_number = '" + accunt + "'";
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
                    String sql = "Select sum(amount) from transaction_details where transaction_type = 'Withdrawl' and account_number = '" + accunt + "'";
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
                    String sql = "Select sum(amount) from transaction_details where transaction_type = 'Loan Paid' and account_number = '" + accunt + "'";
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
                    String sql = "Select sum(amount) from transaction_details where transaction_type = 'Transfered' and account_number = '" + accunt + "'";
                    PreparedStatement statement = conn.prepareStatement(sql);
                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        sum4 = resultSet.getDouble(1);
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }

                sum2 = sum - sum1 - sum3 - sum4;
                String str = Double.toString(sum2);
                totalbalance.setText(str);
                totalbalance.setEditable(false);
            } else {
                JOptionPane.showMessageDialog(null, "INCORRECT ACCOUNT NUMBER");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_submitActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        setVisible(false);
        new Admin_Interface().setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void accountnumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_accountnumberKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_accountnumberKeyTyped

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaction_History().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accountnumber;
    private javax.swing.JButton back;
    private javax.swing.JTextField depamount;
    private javax.swing.JTextField deposite;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField loan;
    private javax.swing.JTextField loantext;
    private javax.swing.JTextField numbertransaction;
    private javax.swing.JButton submit;
    private javax.swing.JTextField totalbalance;
    private javax.swing.JTextField transfer;
    private javax.swing.JTextField with;
    private javax.swing.JTextField withdrawl;
    // End of variables declaration//GEN-END:variables
}
