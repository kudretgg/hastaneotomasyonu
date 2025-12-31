package hastaneOtomasyonu;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GirisEkrani extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextField kAdi_alani;
    private JPasswordField sifre_alani;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GirisEkrani frame = new GirisEkrani();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public GirisEkrani() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setTitle("Hastane Otomasyonu - Giriş");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblKadi = new JLabel("Kullanıcı Adı:");
        lblKadi.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblKadi.setBounds(50, 60, 100, 20);
        contentPane.add(lblKadi);

        kAdi_alani = new JTextField();
        kAdi_alani.setBounds(160, 60, 150, 25);
        contentPane.add(kAdi_alani);

        JLabel lblSifre = new JLabel("Şifre:");
        lblSifre.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblSifre.setBounds(50, 100, 100, 20);
        contentPane.add(lblSifre);

        sifre_alani = new JPasswordField();
        sifre_alani.setBounds(160, 100, 150, 25);
        contentPane.add(sifre_alani);

        JButton btnGiris = new JButton("Giriş Yap");
        btnGiris.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnGiris.setBounds(160, 150, 120, 30);
        contentPane.add(btnGiris);

        btnGiris.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String kAdi = kAdi_alani.getText();
                String sifre = new String(sifre_alani.getPassword());

                try {
                    Connection conn = VeriTabaniBaglantisi.getConnection();
                    String sql = "SELECT * FROM adminler WHERE kullanici_adi=? AND sifre=?";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setString(1, kAdi);
                    ps.setString(2, sifre);
                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(contentPane, "Giriş Başarılı!");
                        AnaMenuEkrani menu = new AnaMenuEkrani();
                        menu.setVisible(true);
                        dispose(); 
                    } else {
                        JOptionPane.showMessageDialog(contentPane, "Hatalı Kullanıcı Adı veya Şifre", "Hata", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}