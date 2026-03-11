package bank_management_system;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class User_Registration1 extends javax.swing.JFrame {

    Connection con1, con2;
    PreparedStatement pst, pst1;
    long random;
    
    public User_Registration1() {
        initComponents();
        setTitle("BANGLADESH DIGITAL BANK LIMITED");
        setLocation(300, 100);
        con1 = Javaconnect.connectDB();
        con2 = Javaconnect.connectDB();
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel(" " + random);
        formno.setFont(new Font("Segoe UI", Font.BOLD, 24));
        formno.setBounds(600, 50, 600, 40);
        add(formno);

        premobile.setEditable(false);
    }

    public void submit() {
        String formno = "" + random;
        String name = nametext.getText();
        String father = fathersnametext.getText();
        String mother_name = mothersnametext.getText();
        String date_of_birth = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
        String dob[] = date_of_birth.split("/");
        int day = Integer.parseInt(dob[0]);
        int month = Integer.parseInt(dob[1]);
        int year = Integer.parseInt(dob[2]);
        LocalDate selectedDate = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.now();
        int resultYear = Period.between(selectedDate, currentDate).getYears();
        String gender = (String) genderbox.getSelectedItem();
        String religion = (String) religionbox.getSelectedItem();
        String mobile = mobilenotext.getText();
        int length = mobile.length();
        String email = emailtext.getText();
        String nid_no = nidnotext.getText();
        int length1 = nid_no.length();
        String marital_status = (String) maritalstatusbox.getSelectedItem();
        String income = incometext.getText();
        String occupation = occupationtext.getText();
        String education = (String) educationbox.getSelectedItem();
        String address = addresstextfield.getText();
        String division = (String) divisionbox.getSelectedItem();
        String post_code = posttext.getText();
        int length2 = post_code.length();
        String branch = (String) branchbox.getSelectedItem();
        String account = (String) accountbox.getSelectedItem();
        String senior_citizen = null;
        if (yesbutton.isSelected()) {
            senior_citizen = "Yes";
        } else if (nobutton.isSelected()) {
            senior_citizen = "No";
        }
        String existing_account = null;
        if (yes1button.isSelected()) {
            existing_account = "Yes";
        } else if (no1button.isSelected()) {
            existing_account = "No";
        }

        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000L) + 230020100L;
        String card_no = "" + Math.abs(first7);
        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String Pin = "" + Math.abs(first3);
        String cardno = card_no;
        String pin = Pin;

        if (isValidEmail(email)) {
            try {
                if (nametext.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "FILL ALL THE REQUIRED FIELDS");
                } else if (fathersnametext.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "FILL ALL THE REQUIRED FIELDS");
                } else if (mothersnametext.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "FILL ALL THE REQUIRED FIELDS");
                } else if (((JTextField) datechooser.getDateEditor().getUiComponent()).getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "FILL ALL THE REQUIRED FIELDS");
                } else if (gender.equals("Select One")) {
                    JOptionPane.showMessageDialog(null, "FILL ALL THE REQUIRED FIELDS");
                } else if (religion.equals("Select One")) {
                    JOptionPane.showMessageDialog(null, "FILL ALL THE REQUIRED FIELDS");
                } else if (mobilenotext.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "FILL ALL THE REQUIRED FIELDS");
                } else if (emailtext.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "FILL ALL THE REQUIRED FIELDS");
                } else if (nidnotext.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "FILL ALL THE REQUIRED FIELDS");
                } else if (marital_status.equals("Select One")) {
                    JOptionPane.showMessageDialog(null, "FILL ALL THE REQUIRED FIELDS");
                } else if (incometext.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "FILL ALL THE REQUIRED FIELDS");
                } else if (occupationtext.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "FILL ALL THE REQUIRED FIELDS");
                } else if (addresstextfield.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "FILL ALL THE REQUIRED FIELDS");
                } else if (education.equals("Select One")) {
                    JOptionPane.showMessageDialog(null, "FILL ALL THE REQUIRED FIELDS");
                } else if (division.equals("Select One")) {
                    JOptionPane.showMessageDialog(null, "FILL ALL THE REQUIRED FIELDS");
                } else if (branch.equals("Select One")) {
                    JOptionPane.showMessageDialog(null, "FILL ALL THE REQUIRED FIELDS");
                } else if (posttext.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "FILL ALL THE REQUIRED FIELDS");
                } else if (senior_citizen == null) {
                    JOptionPane.showMessageDialog(null, "FILL ALL THE REQUIRED FIELDS");
                } else if (existing_account ==null){
                    JOptionPane.showMessageDialog(null, "FILL ALL THE REQUIRED FIELDS");
                } else if (account.equals("Select one")) {
                    JOptionPane.showMessageDialog(null, "FILL ALL THE REQUIRED FIELDS");
                } else if (length != 11) {
                    JOptionPane.showMessageDialog(null, "YOUR MOBILE NUMBER IS INCORRECT");
                } else if (length1 != 10) {
                    JOptionPane.showMessageDialog(null, "YOUR NID NUMBER IS INCORRECT");
                } else if (length2 != 4) {
                    JOptionPane.showMessageDialog(null, "YOUR POST CODE IS INCORRECT");
                } else if (resultYear < 18){
                    JOptionPane.showMessageDialog(null, "YOU ARE NOT ELIGEBLE FOR OPENING BANK ACCOUNT");
                }else {
                    String sql = "insert into user_registration(form_no, name, fathers_name, mothers_name, date_of_birth, gender, religion, mobile, email, nid, marital_status, annual_income, occupation, education, address, division, post_code, branch, senior_citizen, existing_account, account_type, account_number, pin)values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    String sql1 = "insert into user_account(account_number, pin)values(?, ?)";
                    pst = con1.prepareStatement(sql);
                    pst1 = con2.prepareStatement(sql1);
                    pst.setString(1, formno);
                    pst.setString(2, name);
                    pst.setString(3, father);
                    pst.setString(4, mother_name);
                    pst.setString(5, date_of_birth);
                    pst.setString(6, gender);
                    pst.setString(7, religion);
                    pst.setString(8, mobile);
                    pst.setString(9, email);
                    pst.setString(10, nid_no);
                    pst.setString(11, marital_status);
                    pst.setString(12, income);
                    pst.setString(13, occupation);
                    pst.setString(14, education);
                    pst.setString(15, address);
                    pst.setString(16, division);
                    pst.setString(17, post_code);
                    pst.setString(18, branch);
                    pst.setString(19, senior_citizen);
                    pst.setString(20, existing_account);
                    pst.setString(21, account);
                    pst.setString(22, cardno);
                    pst.setString(23, pin);
                    pst1.setString(1, cardno);
                    pst1.setString(2, pin);
                    pst.execute();
                    pst1.execute();
                    JOptionPane.showMessageDialog(null, "YOUR ACCOUNT HAS BEEN CREATED\nPRESS OK BUTTON TO GET THE ACCOUNT NUMBER & PIN");
                    JOptionPane.showMessageDialog(null, "ACCOUNT NUMBER : " + cardno + "\n PIN :" + pin);
                    JOptionPane.showMessageDialog(null, "WELCOME TO BANGLADESH DIGITAL BANK LIMITED");
                    setVisible(false);
                    new Deposite(cardno).setVisible(true);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "WORNG MAIL ADDRESS");
        }
    }
    
    private void clear() {
        try {
            nametext.setText("");
            fathersnametext.setText("");
            mothersnametext.setText("");
            mobilenotext.setText("");
            emailtext.setText("");
            nidnotext.setText("");
            incometext.setText("");
            occupationtext.setText("");
            addresstextfield.setText("");
            posttext.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void checkbox() {
        if (checkbox.isSelected()) {
            submit();
        } else {
            JOptionPane.showMessageDialog(null, "FILL ALL THE REQUIRED FIELDS");
        }
    }

    private static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addresstextfield = new javax.swing.JTextField();
        checkbox = new javax.swing.JCheckBox();
        posttext = new javax.swing.JTextField();
        branchbox = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        seniorcitizen = new javax.swing.JLabel();
        accountbox = new javax.swing.JComboBox<>();
        education = new javax.swing.JLabel();
        yesbutton = new javax.swing.JRadioButton();
        educationbox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        nobutton = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        existingaccount = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        yes1button = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        nametext = new javax.swing.JTextField();
        fathersnametext = new javax.swing.JTextField();
        mothersnametext = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        mobilenotext = new javax.swing.JTextField();
        emailtext = new javax.swing.JTextField();
        nidnotext = new javax.swing.JTextField();
        maritalstatusbox = new javax.swing.JComboBox<>();
        datechooser = new com.toedter.calendar.JDateChooser();
        religionbox = new javax.swing.JComboBox<>();
        genderbox = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        incometext = new javax.swing.JTextField();
        occupationtext = new javax.swing.JTextField();
        submitbutton = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        clear = new javax.swing.JButton();
        back = new javax.swing.JButton();
        premobile = new javax.swing.JTextField();
        postcode = new javax.swing.JLabel();
        no1button = new javax.swing.JRadioButton();
        branch = new javax.swing.JLabel();
        divisionbox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addresstextfield.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        checkbox.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        checkbox.setText("I hereby declares that the above entered details correct to the best of my knowledge");
        checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxActionPerformed(evt);
            }
        });

        posttext.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        posttext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                posttextKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                posttextKeyTyped(evt);
            }
        });

        branchbox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        branchbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select One", "DBL-2301", "DBL-2302", "DBL-2303", "DBL-2304", "DBL-2305", "DBL-2306", "DBL-2307", "DBL-2308", "DBL-2309", "DBL-2310" }));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Account Type :");

        seniorcitizen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        seniorcitizen.setText("Senior Citizen : ");

        accountbox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        accountbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select One", "General Account", "Student Account", "Saving Account", "Fixed Deposite Account" }));

        education.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        education.setText("Educational Qualification :");

        yesbutton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        yesbutton.setText("Yes");
        yesbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesbuttonActionPerformed(evt);
            }
        });

        educationbox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        educationbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select One", "SSC", "HSC", "Graduate", "Post Graduate", "Others" }));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Father's Name :");

        nobutton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nobutton.setText("No");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Name :");

        address.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        address.setText("Address :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Date of Birth :");

        existingaccount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        existingaccount.setText("Existing Account : ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Mother's Name :");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Division : ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Gender :");

        yes1button.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        yes1button.setText("Yes");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Religion :");

        nametext.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nametext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nametextActionPerformed(evt);
            }
        });
        nametext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nametextKeyTyped(evt);
            }
        });

        fathersnametext.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fathersnametext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fathersnametextKeyTyped(evt);
            }
        });

        mothersnametext.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mothersnametext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mothersnametextActionPerformed(evt);
            }
        });
        mothersnametext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mothersnametextKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Mobile No :");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Email :");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("NID No :");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Marital Status :");

        mobilenotext.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mobilenotext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mobilenotextKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mobilenotextKeyTyped(evt);
            }
        });

        emailtext.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        emailtext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emailtextKeyTyped(evt);
            }
        });

        nidnotext.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nidnotext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nidnotextKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nidnotextKeyTyped(evt);
            }
        });

        maritalstatusbox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        maritalstatusbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select One", "Married", "Unmarried", "Others" }));

        datechooser.setDateFormatString("dd/MM/yyyy");

        religionbox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        religionbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select One", "Islam", "Hindu", "Buddhist", "Christian", "Others" }));

        genderbox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        genderbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select One", "Male", "Female", "Others" }));
        genderbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderboxActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Annual Income :");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Occupation :");

        incometext.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        incometext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                incometextKeyTyped(evt);
            }
        });

        occupationtext.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        occupationtext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                occupationtextKeyTyped(evt);
            }
        });

        submitbutton.setBackground(new java.awt.Color(0, 0, 0));
        submitbutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        submitbutton.setForeground(new java.awt.Color(51, 153, 255));
        submitbutton.setText("SUBMIT");
        submitbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitbuttonActionPerformed(evt);
            }
        });

        jLabel14.setBackground(new java.awt.Color(51, 153, 255));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 153, 255));
        jLabel14.setText("        PERSONAL DETAILS");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("      APPLICATION FORM NO : ");

        clear.setBackground(new java.awt.Color(0, 0, 0));
        clear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        clear.setForeground(new java.awt.Color(51, 153, 255));
        clear.setText("CLEAR");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        back.setBackground(new java.awt.Color(0, 0, 0));
        back.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        back.setForeground(new java.awt.Color(51, 153, 255));
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        premobile.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        premobile.setText("+88");

        postcode.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        postcode.setText("Post Code : ");

        no1button.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        no1button.setText("No");

        branch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        branch.setText("Branch :");

        divisionbox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        divisionbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select One", "Barishal", "Chattogram", "Dhaka", "Khulna", "Rajshahi", "Rangpur", "Mymensingh", "Sylhet" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(occupationtext, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailtext)
                            .addComponent(mothersnametext)
                            .addComponent(fathersnametext)
                            .addComponent(nametext)
                            .addComponent(nidnotext)
                            .addComponent(maritalstatusbox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(datechooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(religionbox, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(genderbox, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(incometext, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(premobile, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mobilenotext)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(seniorcitizen)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(yesbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(existingaccount)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(yes1button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nobutton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(no1button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(branch)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(branchbox, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(postcode)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(posttext, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel16)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(divisionbox, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(address)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(addresstextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(education)
                                                .addGap(18, 18, 18)
                                                .addComponent(educationbox, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(accountbox, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(submitbutton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkbox)
                                .addGap(37, 37, 37))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nametext, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fathersnametext, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mothersnametext, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(datechooser, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(genderbox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(religionbox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mobilenotext, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(premobile))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailtext, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nidnotext, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maritalstatusbox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(incometext, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(occupationtext, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(education, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(educationbox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addresstextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(divisionbox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(postcode, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(posttext, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(branch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(branchbox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(accountbox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(seniorcitizen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yesbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nobutton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(existingaccount, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(yes1button, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(no1button, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(checkbox)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(submitbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxActionPerformed

    }//GEN-LAST:event_checkboxActionPerformed

    private void posttextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_posttextKeyPressed

    }//GEN-LAST:event_posttextKeyPressed

    private void posttextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_posttextKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_posttextKeyTyped

    private void yesbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesbuttonActionPerformed

    }//GEN-LAST:event_yesbuttonActionPerformed

    private void nametextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nametextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nametextActionPerformed

    private void nametextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nametextKeyTyped

    }//GEN-LAST:event_nametextKeyTyped

    private void fathersnametextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fathersnametextKeyTyped

    }//GEN-LAST:event_fathersnametextKeyTyped

    private void mothersnametextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mothersnametextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mothersnametextActionPerformed

    private void mothersnametextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mothersnametextKeyTyped

    }//GEN-LAST:event_mothersnametextKeyTyped

    private void mobilenotextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobilenotextKeyPressed

    }//GEN-LAST:event_mobilenotextKeyPressed

    private void mobilenotextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobilenotextKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_mobilenotextKeyTyped

    private void emailtextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailtextKeyTyped

    }//GEN-LAST:event_emailtextKeyTyped

    private void nidnotextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nidnotextKeyPressed

    }//GEN-LAST:event_nidnotextKeyPressed

    private void nidnotextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nidnotextKeyTyped
        char c1 = evt.getKeyChar();
        if (!Character.isDigit(c1)) {
            evt.consume();
        }
    }//GEN-LAST:event_nidnotextKeyTyped

    private void genderboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderboxActionPerformed

    private void incometextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_incometextKeyTyped
        char c2 = evt.getKeyChar();
        if (!Character.isDigit(c2)) {
            evt.consume();
        }
    }//GEN-LAST:event_incometextKeyTyped

    private void occupationtextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_occupationtextKeyTyped

    }//GEN-LAST:event_occupationtextKeyTyped

    private void submitbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitbuttonActionPerformed
        checkbox();
    }//GEN-LAST:event_submitbuttonActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        clear();
    }//GEN-LAST:event_clearActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        setVisible(false);
        new Admin_Interface().setVisible(true);
    }//GEN-LAST:event_backActionPerformed

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
            java.util.logging.Logger.getLogger(User_Registration1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_Registration1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_Registration1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_Registration1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User_Registration1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> accountbox;
    private javax.swing.JLabel address;
    private javax.swing.JTextField addresstextfield;
    private javax.swing.JButton back;
    private javax.swing.JLabel branch;
    private javax.swing.JComboBox<String> branchbox;
    private javax.swing.JCheckBox checkbox;
    private javax.swing.JButton clear;
    private com.toedter.calendar.JDateChooser datechooser;
    private javax.swing.JComboBox<String> divisionbox;
    private javax.swing.JLabel education;
    private javax.swing.JComboBox<String> educationbox;
    private javax.swing.JTextField emailtext;
    private javax.swing.JLabel existingaccount;
    private javax.swing.JTextField fathersnametext;
    private javax.swing.JComboBox<String> genderbox;
    private javax.swing.JTextField incometext;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> maritalstatusbox;
    private javax.swing.JTextField mobilenotext;
    private javax.swing.JTextField mothersnametext;
    private javax.swing.JTextField nametext;
    private javax.swing.JTextField nidnotext;
    private javax.swing.JRadioButton no1button;
    private javax.swing.JRadioButton nobutton;
    private javax.swing.JTextField occupationtext;
    private javax.swing.JLabel postcode;
    private javax.swing.JTextField posttext;
    private javax.swing.JTextField premobile;
    private javax.swing.JComboBox<String> religionbox;
    private javax.swing.JLabel seniorcitizen;
    private javax.swing.JButton submitbutton;
    private javax.swing.JRadioButton yes1button;
    private javax.swing.JRadioButton yesbutton;
    // End of variables declaration//GEN-END:variables
}
