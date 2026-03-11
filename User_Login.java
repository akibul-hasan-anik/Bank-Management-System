package bank_management_system;

import java.sql.*;
import javax.swing.JOptionPane;

public class User_Login extends javax.swing.JFrame {

    Connection conn;

    public User_Login() {
        initComponents();
        setTitle("BANGLADESH DIGITAL BANK LIMITED");
        setLocation(300, 100);
        conn = Javaconnect.connectDB();
    }

    private void login() {
        try {
            Javaconnect c1 = new Javaconnect();
            String cardno = cardnotext.getText();
            String pin = pintext.getText();
            Statement s = conn.createStatement();
            String q = "select * from user_account where account_number = '" + cardno + "' and pin = '" + pin + "'";
            ResultSet rs = c1.s.executeQuery(q);

            if (rs.next()) {
                setVisible(false);
                new User_Interface(cardno).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "INCORRECT CARD NUMBER OR PIN");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void clear() {
        try {
            cardnotext.setText("");
            pintext.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void signup() {
        try {
            setVisible(false);
            new User_Registration().setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void check() {
        if (checkbox.isSelected()) {
            pintext.setEchoChar((char) 0);
        } else {
            pintext.setEchoChar('*');
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cardnotext = new javax.swing.JTextField();
        loginbutton = new javax.swing.JButton();
        clearbutton = new javax.swing.JButton();
        signupbutton = new javax.swing.JButton();
        pintext = new javax.swing.JPasswordField();
        checkbox = new javax.swing.JCheckBox();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setForeground(new java.awt.Color(0, 102, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("WELCOME TO BDBL");
        jLabel1.setPreferredSize(new java.awt.Dimension(350, 50));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("ACCOUNT :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("PIN :");

        cardnotext.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cardnotext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cardnotextKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cardnotextKeyTyped(evt);
            }
        });

        loginbutton.setBackground(new java.awt.Color(0, 0, 0));
        loginbutton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        loginbutton.setForeground(new java.awt.Color(51, 153, 255));
        loginbutton.setText("LOG IN");
        loginbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbuttonActionPerformed(evt);
            }
        });

        clearbutton.setBackground(new java.awt.Color(0, 0, 0));
        clearbutton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        clearbutton.setForeground(new java.awt.Color(51, 153, 255));
        clearbutton.setText("CLEAR");
        clearbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbuttonActionPerformed(evt);
            }
        });

        signupbutton.setBackground(new java.awt.Color(0, 0, 0));
        signupbutton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        signupbutton.setForeground(new java.awt.Color(51, 153, 255));
        signupbutton.setText("SIGN UP");
        signupbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupbuttonActionPerformed(evt);
            }
        });

        pintext.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        pintext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pintextKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pintextKeyTyped(evt);
            }
        });

        checkbox.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        checkbox.setText("Show PIN");
        checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(checkbox)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(signupbutton, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                .addComponent(cardnotext)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(loginbutton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(clearbutton))
                                .addComponent(pintext)))))
                .addGap(126, 126, 126))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardnotext, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pintext))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkbox)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearbutton)
                    .addComponent(loginbutton))
                .addGap(18, 18, 18)
                .addComponent(signupbutton)
                .addGap(18, 18, 18)
                .addComponent(back)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbuttonActionPerformed
        login();
    }//GEN-LAST:event_loginbuttonActionPerformed

    private void clearbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbuttonActionPerformed
        clear();
    }//GEN-LAST:event_clearbuttonActionPerformed

    private void signupbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupbuttonActionPerformed
        signup();
    }//GEN-LAST:event_signupbuttonActionPerformed

    private void checkboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxActionPerformed
        check();
    }//GEN-LAST:event_checkboxActionPerformed

    private void cardnotextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cardnotextKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_cardnotextKeyTyped

    private void pintextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pintextKeyTyped
        char c1 = evt.getKeyChar();
        if (!Character.isDigit(c1)) {
            evt.consume();
        }
    }//GEN-LAST:event_pintextKeyTyped

    private void cardnotextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cardnotextKeyPressed

    }//GEN-LAST:event_cardnotextKeyPressed

    private void pintextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pintextKeyPressed

    }//GEN-LAST:event_pintextKeyPressed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        setVisible(false);
        new Home().setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JTextField cardnotext;
    private javax.swing.JCheckBox checkbox;
    private javax.swing.JButton clearbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginbutton;
    private javax.swing.JPasswordField pintext;
    private javax.swing.JButton signupbutton;
    // End of variables declaration//GEN-END:variables
}
