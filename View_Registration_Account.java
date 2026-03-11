package bank_management_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class View_Registration_Account extends javax.swing.JFrame {

    Connection conn, conn1;
    PreparedStatement pst, pst1;

    public View_Registration_Account() {
        initComponents();
        conn = Javaconnect.connectDB();
        conn1 = Javaconnect.connectDB();
        search.setEditable(false);
        number.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        input = new javax.swing.JTextField();
        searchbutton = new javax.swing.JButton();
        box = new javax.swing.JComboBox<>();
        search = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        viewall = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        number = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "forn_no", "name", "fathers_name", "mothers_name", "date_of_birth", "gender", "religion", "mobile", "email", "nid", "marital_status", "annual_income", "occupation", "education", "address", "division", "post_code", "branch", "senior_citizen", "existing_account", "account_type", "account_number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("DETAILS OF USER");

        input.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        searchbutton.setBackground(new java.awt.Color(0, 0, 0));
        searchbutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchbutton.setForeground(new java.awt.Color(51, 153, 255));
        searchbutton.setText("SEARCH");
        searchbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbuttonActionPerformed(evt);
            }
        });

        box.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select One", "Account Number", "Form Number", "Name", "Mobile" }));

        search.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        search.setText("Search By");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(670, 670, 670)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(413, 413, 413)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchbutton)))
                .addContainerGap(792, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchbutton))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 153, 255));
        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        viewall.setBackground(new java.awt.Color(0, 0, 0));
        viewall.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        viewall.setForeground(new java.awt.Color(51, 153, 255));
        viewall.setText("VIEW ALL");
        viewall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewallActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Total Number of Account :");

        number.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(639, 639, 639)
                        .addComponent(viewall)
                        .addGap(26, 26, 26)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(505, 505, 505)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(number, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewall)
                    .addComponent(jButton1))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
        new View_and_Search().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbuttonActionPerformed
        String item = (String) box.getSelectedItem();
        if (item.equals("Account Number")) {
            try {
                String input1 = input.getText();
                String sql1 = "select form_no, name, fathers_name, mothers_name, date_of_birth, gender, religion, mobile, email, nid, marital_status, annual_income, occupation, education, address, division, post_code, branch, senior_citizen, existing_account, account_type, account_number, pin from user_registration natural join user_account where account_number like ?";
                pst1 = conn1.prepareStatement(sql1);
                pst1.setString(1, "%" + input1 + "%");
                ResultSet rs1 = pst1.executeQuery();
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);
                while (rs1.next()) {
                    model.addRow(new String[]{rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4), rs1.getString(5), rs1.getString(6), rs1.getString(7), rs1.getString(8), rs1.getString(9), rs1.getString(10), rs1.getString(11), rs1.getString(12), rs1.getString(13), rs1.getString(14), rs1.getString(15), rs1.getString(16), rs1.getString(17), rs1.getString(18), rs1.getString(19), rs1.getString(20), rs1.getString(21), rs1.getString(22)});
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } else if (item.equals("Form Number")) {
            try {
                String input1 = input.getText();
                String sql1 = "select form_no, name, fathers_name, mothers_name, date_of_birth, gender, religion, mobile, email, nid, marital_status, annual_income, occupation, education, address, division, post_code, branch, senior_citizen, existing_account, account_type, account_number, pin from user_registration natural join user_account where form_no like ?";
                pst1 = conn1.prepareStatement(sql1);
                pst1.setString(1, "%" + input1 + "%");
                ResultSet rs1 = pst1.executeQuery();
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);
                while (rs1.next()) {
                    model.addRow(new String[]{rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4), rs1.getString(5), rs1.getString(6), rs1.getString(7), rs1.getString(8), rs1.getString(9), rs1.getString(10), rs1.getString(11), rs1.getString(12), rs1.getString(13), rs1.getString(14), rs1.getString(15), rs1.getString(16), rs1.getString(17), rs1.getString(18), rs1.getString(19), rs1.getString(20), rs1.getString(21), rs1.getString(22)});
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } else if (item.equals("Name")) {
            try {
                String input1 = input.getText();
                String sql1 = "select form_no, name, fathers_name, mothers_name, date_of_birth, gender, religion, mobile, email, nid, marital_status, annual_income, occupation, education, address, division, post_code, branch, senior_citizen, existing_account, account_type, account_number, pin from user_registration natural join user_account where name like ?";
                pst1 = conn1.prepareStatement(sql1);
                pst1.setString(1, "%" + input1 + "%");
                ResultSet rs1 = pst1.executeQuery();
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);
                while (rs1.next()) {
                    model.addRow(new String[]{rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4), rs1.getString(5), rs1.getString(6), rs1.getString(7), rs1.getString(8), rs1.getString(9), rs1.getString(10), rs1.getString(11), rs1.getString(12), rs1.getString(13), rs1.getString(14), rs1.getString(15), rs1.getString(16), rs1.getString(17), rs1.getString(18), rs1.getString(19), rs1.getString(20), rs1.getString(21), rs1.getString(22)});
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } else if (item.equals("Mobile")) {
            try {
                String input1 = input.getText();
                String sql1 = "select form_no, name, fathers_name, mothers_name, date_of_birth, gender, religion, mobile, email, nid, marital_status, annual_income, occupation, education, address, division, post_code, branch, senior_citizen, existing_account, account_type, account_number, pin from user_registration natural join user_account where mobile like ?";
                pst1 = conn1.prepareStatement(sql1);
                pst1.setString(1, "%" + input1 + "%");
                ResultSet rs1 = pst1.executeQuery();
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);
                while (rs1.next()) {
                    model.addRow(new String[]{rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4), rs1.getString(5), rs1.getString(6), rs1.getString(7), rs1.getString(8), rs1.getString(9), rs1.getString(10), rs1.getString(11), rs1.getString(12), rs1.getString(13), rs1.getString(14), rs1.getString(15), rs1.getString(16), rs1.getString(17), rs1.getString(18), rs1.getString(19), rs1.getString(20), rs1.getString(21), rs1.getString(22)});
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "NOT FOUND");
        }
    }//GEN-LAST:event_searchbuttonActionPerformed

    private void viewallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewallActionPerformed
        String sql = "select * from user_registration";
        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            while (rs.next()) {
                model.addRow(new String[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20), rs.getString(21), rs.getString(22)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        try {
            String sql1 = "select count(*) from user_account";
            PreparedStatement statement = conn.prepareStatement(sql1);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int rowCount = resultSet.getInt(1);
                String str = Integer.toString(rowCount);
                number.setText(str);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_viewallActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_Registration_Account().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> box;
    private javax.swing.JTextField input;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField number;
    private javax.swing.JTextField search;
    private javax.swing.JButton searchbutton;
    private javax.swing.JTable table;
    private javax.swing.JButton viewall;
    // End of variables declaration//GEN-END:variables
}
