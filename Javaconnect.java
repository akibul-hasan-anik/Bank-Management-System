package bank_management_system;

import java.sql.*;
import javax.swing.JOptionPane;

public class Javaconnect {

    static Connection con;
    static Statement s;

    public static Connection connectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "Sql-123456789");
            s = con.createStatement();
            return con;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public static void main(String[] args) {
        Connection con = connectDB();
        if (con == null) {
            System.out.println("connection is not established");
        } else {
            System.out.println("connection is established");
        }
    }
}
