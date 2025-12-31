package hastaneOtomasyonu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HastaKayitEkrani extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField adSoyad_alani, tc_alani, sikayet_alani, oda_alani;

    public HastaKayitEkrani() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 450);
        setTitle("Yeni Hasta Kaydı");
        setLocationRelativeTo(null);
        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblAd = new JLabel("Ad Soyad:");
        lblAd.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAd.setBounds(50, 50, 100, 20);
        contentPane.add(lblAd);

        adSoyad_alani = new JTextField();
        adSoyad_alani.setBounds(160, 50, 200, 25);
        contentPane.add(adSoyad_alani);

        JLabel lblTc = new JLabel("TC No:");
        lblTc.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblTc.setBounds(50, 90, 100, 20);
        contentPane.add(lblTc);

        tc_alani = new JTextField();
        tc_alani.setBounds(160, 90, 200, 25);
        contentPane.add(tc_alani);

        JLabel lblSikayet = new JLabel("Şikayet:");
        lblSikayet.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblSikayet.setBounds(50, 130, 100, 20);
        contentPane.add(lblSikayet);

        sikayet_alani = new JTextField();
        sikayet_alani.setBounds(160, 130, 200, 25);
        contentPane.add(sikayet_alani);
        
        JLabel lblOda = new JLabel("Oda No:");
        lblOda.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblOda.setBounds(50, 170, 100, 20);
        contentPane.add(lblOda);

        oda_alani = new JTextField();
        oda_alani.setBounds(160, 170, 100, 25);
        contentPane.add(oda_alani);

        JButton btnKaydet = new JButton("Kaydet");
        btnKaydet.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnKaydet.setBounds(200, 230, 120, 35);
        contentPane.add(btnKaydet);

        JButton btnGeri = new JButton("Ana Menü");
        btnGeri.setBounds(50, 230, 120, 35);
        contentPane.add(btnGeri);

        btnGeri.addActionListener(e -> {
            AnaMenuEkrani menu = new AnaMenuEkrani();
            menu.setVisible(true);
            dispose();
        });

        btnKaydet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection conn = VeriTabaniBaglantisi.getConnection();
                    String sql = "INSERT INTO hastalar (ad_soyad, tc_no, sikayet, oda_no, yatis_tarihi) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    
                    ps.setString(1, adSoyad_alani.getText());
                    ps.setString(2, tc_alani.getText());
                    ps.setString(3, sikayet_alani.getText());
                    ps.setString(4, oda_alani.getText());
                    
                    
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String tarih = sdf.format(new Date());
                    ps.setString(5, tarih);

                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(contentPane, "Hasta Kaydı Başarılı!");
                    
                    
                    adSoyad_alani.setText("");
                    tc_alani.setText("");
                    sikayet_alani.setText("");
                    oda_alani.setText("");

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(contentPane, "Kayıt Başarısız!", "Hata", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}