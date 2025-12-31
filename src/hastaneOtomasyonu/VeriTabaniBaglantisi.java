package hastaneOtomasyonu;

import java.sql.*;
import javax.swing.JOptionPane;

public class VeriTabaniBaglantisi {
    
    static Connection myConn;
    static Statement myState;

    
    static final String DB_URL = "jdbc:mysql://localhost:3306/hastaneotomasyonu";
    static final String USER = "kudretgg";
    static final String PASS = "kudret1234."; 

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Listeleme işlemleri için ResultSet döndüren metod
    static ResultSet bul(String sql) {
        ResultSet myRs = null;
        try {
            myConn = getConnection();
            myState = myConn.createStatement();
            myRs = myState.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Veri Çekilemedi!", "Hata", JOptionPane.ERROR_MESSAGE);
        }
        return myRs;
    }

    public static void sorguCalistir(String sql) {
        try {
            myConn = getConnection();
            myState = myConn.createStatement();
            myState.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}