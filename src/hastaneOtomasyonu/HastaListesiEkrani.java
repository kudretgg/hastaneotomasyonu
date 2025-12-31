package hastaneOtomasyonu;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class HastaListesiEkrani extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
    private DefaultTableModel model;

    public HastaListesiEkrani() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 500);
        setTitle("Kayıtlı Hastalar");
        setLocationRelativeTo(null);
        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        model = new DefaultTableModel();
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 540, 350);
        contentPane.add(scrollPane);

        JButton btnGeri = new JButton("Ana Menü");
        btnGeri.setBounds(200, 400, 150, 30);
        contentPane.add(btnGeri);

        btnGeri.addActionListener(e -> {
            AnaMenuEkrani menu = new AnaMenuEkrani();
            menu.setVisible(true);
            dispose();
        });

        hastalariYukle();
    }

    private void hastalariYukle() {
        String sql = "SELECT * FROM hastalar";
        ResultSet rs = VeriTabaniBaglantisi.bul(sql);
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            int colCount = metaData.getColumnCount();
            String[] colNames = new String[colCount];
            for (int i = 1; i <= colCount; i++) {
                colNames[i - 1] = metaData.getColumnName(i);
            }
            model.setColumnIdentifiers(colNames);
            
            while (rs.next()) {
                Object[] row = new Object[colCount];
                for (int i = 1; i <= colCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}