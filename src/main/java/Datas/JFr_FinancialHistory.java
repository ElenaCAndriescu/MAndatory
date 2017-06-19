package Datas;

import static Datas.JExtractDataHistory.obtinereValoareLunara;
import static Datas.JExtractDataHistory.obtinereValoareTotala;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class JFr_FinancialHistory {

	private JFrame frame = new JFrame();
	private JPanel contentPane = new JPanel();
	private JTable table;
	private JButton btnNewButton;

	public JFr_FinancialHistory(String user) throws IOException, SQLException {

		// creaza Frame
		frame = new JFrame("Financial History " + user);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
		frame.setSize(503, 357);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.CYAN);
		frame.setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.CYAN);
		frame.getContentPane().add(contentPane);

		String[] categorii = JFr_TransactionFrame.getTipCheltuieli();
		Object[] columns = { "Categorie", "Suma lunara", "Suma totala" };
		Object[][] objects = { { "Categorie", "Suma lunara", "Suma totala" },

				{ categorii[0], obtinereValoareLunara(user, "Income", categorii[0]),
						obtinereValoareTotala(user, "Income", categorii[0]) },
				{ categorii[1], obtinereValoareLunara(user, "Expense", categorii[1]),
						obtinereValoareTotala(user, "Expense", categorii[1]) },
				{ categorii[2], obtinereValoareLunara(user, "Expense", categorii[2]),
						obtinereValoareTotala(user, "Expense", categorii[2]) },
				{ categorii[3], obtinereValoareLunara(user, "Expense", categorii[3]),
						obtinereValoareTotala(user, "Expense", categorii[3]) },
				{ categorii[4], obtinereValoareLunara(user, "Expense", categorii[4]),
						obtinereValoareTotala(user, "Expense", categorii[4]) },
				{ categorii[5], obtinereValoareLunara(user, "Expense", categorii[5]),
						obtinereValoareTotala(user, "Expense", categorii[5]) },
				{ categorii[6], obtinereValoareLunara(user, "Expense", categorii[6]),
						obtinereValoareTotala(user, "Expense", categorii[6]) },
				{ categorii[7], obtinereValoareLunara(user, "Expense", categorii[7]),
						obtinereValoareTotala(user, "Expense", categorii[7]) } };
		contentPane.setLayout(null);

		table = new JTable(objects, columns);
		table.setBounds(0, 0, 434, 144);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		contentPane.add(table);

		btnNewButton = new JButton("Back");
		btnNewButton.setBounds(312, 167, 89, 23);
		contentPane.add(btnNewButton);
		contentPane.setVisible(true);
		frame.setVisible(true);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFr_FinanceFrame.gui(user);
					frame.dispose();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}
