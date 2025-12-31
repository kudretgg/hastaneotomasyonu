package hastaneOtomasyonu;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HastaSilEkrani extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> hastaSec_combo;

    public HastaSilEkrani() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 300);
        setTitle("Hasta Taburcu / Silme");
        setLocationRelativeTo(null);
        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblSec = new JLabel("Silinecek Hasta:");
        lblSec.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblSec.setBounds(50, 50, 150, 20);
        contentPane.add(lblSec);

        hastaSec_combo = new JComboBox<>();
        hastaSec_combo.setBounds(180, 50, 200, 30);
        contentPane.add(hastaSec_combo);

        JButton btnSil = new JButton("Kaydı Sil");
        btnSil.setForeground(Color.RED);
        btnSil.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnSil.setBounds(250, 120, 130, 40);
        contentPane.add(btnSil);

        JButton btnGeri = new JButton("Ana Menü");
        btnGeri.setBounds(80, 120, 130, 40);
        contentPane.add(btnGeri);

        btnGeri.addActionListener(e -> {
            AnaMenuEkrani menu = new AnaMenuEkrani();
            menu.setVisible(true);
            dispose();
        });

        // Combo box'ı doldur
        hastalariComboYukle();

        btnSil.addActionListener(e -> {
            String secilen = (String) hastaSec_combo.getSelectedItem();
            if (secilen != null) {
                
                String adSoyad = secilen.split(" - ")[0]; 
                
                try {
                    Connection conn = VeriTabaniBaglantisi.getConnection();
                    String sql = "DELETE FROM hastalar WHERE ad_soyad = ?";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setString(1, adSoyad);
                    ps.executeUpdate();
                    
                    JOptionPane.showMessageDialog(contentPane, "Hasta başarıyla silindi.");
                    hastalariComboYukle(); 
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void hastalariComboYukle() {
        hastaSec_combo.removeAllItems();
        String sql = "SELECT * FROM hastalar";
        ResultSet rs = VeriTabaniBaglantisi.bul(sql);
        try {
            while (rs.next()) {
                // ComboBox'ta "Ad Soyad - TC" şeklinde görünsün
                String item = rs.getString("ad_soyad") + " - " + rs.getString("tc_no");
                hastaSec_combo.addItem(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}