package hastaneOtomasyonu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnaMenuEkrani extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AnaMenuEkrani() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setBounds(100, 100, 500, 500);
        setTitle("Hastane Yönetim Paneli");
        setLocationRelativeTo(null);
        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblBaslik = new JLabel("HASTANE YÖNETİM SİSTEMİ");
        lblBaslik.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblBaslik.setHorizontalAlignment(SwingConstants.CENTER);
        lblBaslik.setBounds(50, 20, 400, 30);
        contentPane.add(lblBaslik);

       
        ImageIcon logoIconIslem = new ImageIcon("images1.jpg");
        Image image = logoIconIslem.getImage(); 
        Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); 
        ImageIcon finalLogoIcon = new ImageIcon(newimg);
        JLabel lblLogo = new JLabel(finalLogoIcon);
        lblLogo.setBounds(200, 60, 100, 100);
        contentPane.add(lblLogo);

        JButton btnHastaEkle = new JButton("Hasta Kayıt");
        btnHastaEkle.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnHastaEkle.setBounds(150, 180, 180, 40);
        contentPane.add(btnHastaEkle);

        btnHastaEkle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                HastaKayitEkrani kayit = new HastaKayitEkrani();
                kayit.setVisible(true);
                dispose();
            }
        });

        JButton btnHastaSil = new JButton("Hasta Taburcu/Sil");
        btnHastaSil.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        btnHastaSil.setBounds(150, 240, 180, 40);
        contentPane.add(btnHastaSil);

        btnHastaSil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                HastaSilEkrani sil = new HastaSilEkrani();
                sil.setVisible(true);
                dispose();
            }
        });

        JButton btnListele = new JButton("Hasta Listesi");
        btnListele.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        btnListele.setBounds(150, 300, 180, 40);
        contentPane.add(btnListele);

        btnListele.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                HastaListesiEkrani liste = new HastaListesiEkrani();
                liste.setVisible(true);
                dispose();
            }
        });

        JButton btnCikis = new JButton("Çıkış Yap");
        btnCikis.setBackground(Color.RED);
        btnCikis.setForeground(Color.WHITE);
        
        btnCikis.setBounds(150, 380, 180, 30);
        contentPane.add(btnCikis);

        btnCikis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GirisEkrani giris = new GirisEkrani();
                giris.setVisible(true);
                dispose();
            }
        });
    }
}