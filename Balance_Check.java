package bank_management_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.*;

public class Balance_Check extends javax.swing.JFrame {

    Connection conn;
    Statement s;
    String cardno;
    double sum, sum1, sum2, sum3, sum4;

    public Balance_Check(String cardno) {
        initComponents();
        setTitle("BANGLADESH DIGITAL BANK LIMITED");
        setLocation(300, 100);
        conn = Javaconnect.connectDB();
        this.cardno = cardno;
        amounttext.setEditable(false);

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
            String sql = "Select sum(amount) from transaction_details where transaction_type = 'Withdrawl' and account_number = '" + cardno + "'";
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
        String str = Double.toString(sum2);
        amounttext.setText(str);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        backbutton = new javax.swing.JButton();
        amounttext = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 153, 255));
        jLabel1.setText("YOUR CURRENT ACCOUNT BALANCE IS ");

        backbutton.setBackground(new java.awt.Color(0, 0, 0));
        backbutton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        backbutton.setForeground(new java.awt.Color(51, 153, 255));
        backbutton.setText("BACK");
        backbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbuttonActionPerformed(evt);
            }
        });

        amounttext.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        amounttext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amounttextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(backbutton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(amounttext))))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(amounttext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                .addComponent(backbutton)
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbuttonActionPerformed
        setVisible(false);
        new User_Interface(cardno).setVisible(true);
    }//GEN-LAST:event_backbuttonActionPerformed

    private void amounttextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amounttextActionPerformed
    }//GEN-LAST:event_amounttextActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Balance_Check("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amounttext;
    private javax.swing.JButton backbutton;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
