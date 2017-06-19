package Datas;

import static Datas.JExtractDataGeneral.obtinereValoare;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class JFr_FinanceFrame {

	private static JFrame f;
	private static JPanel p1;
	private static JButton b1;
	private static JButton b2;
	private static JLabel lab;
	private static JButton btnNewButton;

	/**
	 * @throws SQLException
	 * @wbp.parser.entryPoint
	 */
	public static void gui(final String userNam) throws IOException, SQLException {
		// creaza Frame
		f = new JFrame("FinanceTracking " + userNam);
		f.setVisible(true);
		f.setSize(515, 343);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBackground(Color.CYAN);

		p1 = new JPanel();
		p1.setBackground(new Color(153, 204, 204));
		f.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));

		// adauga panel la frame

		f.getContentPane().add(p1, BorderLayout.NORTH);

		final String userName = userNam.trim();
		int income = obtinereValoare(userName, "Income");
		int expense = obtinereValoare(userName, "Expense");
		int remainder = income - expense;

		Object[] columns = { "Income", "Expenses", "Balance up to date" };
		Object[][] objects = { { "Income  ", "Expenses  ", "Balance  " }, { income, expense, remainder } };
		p1.setLayout(null);

		// creaza label
		Date ziua = new Date();
		String zi = ziua.toString();
		lab = new JLabel("General Overview ");
		lab.setBounds(24, 103, 173, 24);
		p1.add(lab);
		lab.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JTable tabl = new JTable(objects, columns);
		tabl.setLocation(10, 219);
		tabl.setSize(214, 32);

		p1.add(tabl);
		f.getContentPane().add(p1, BorderLayout.NORTH);

		btnNewButton = new JButton("Financial History");
		btnNewButton.setBounds(39, 259, 140, 23);
		p1.add(btnNewButton);

		// creeaza butoane in panel/*-

		b1 = new JButton(" ADD INCOME");
		b1.setBounds(283, 215, 173, 23);
		p1.add(b1);
		b2 = new JButton(" ADD EXPENSE");
		b2.setBounds(283, 259, 173, 23);
		p1.add(b2);

		JLabel lblNewLabel;
		lblNewLabel = new JLabel(zi);
		lblNewLabel.setBounds(10, 155, 187, 14);
		p1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(new ImageIcon("C:\\FinanceTr\\poze\\images.jpg"));
		lblNewLabel_1.setBounds(187, -2, 312, 206);
		p1.add(lblNewLabel_1);

		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tip = "Expense";
				JFr_TransactionFrame.gup(userName, tip);
				f.dispose();
			}
		});

		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tip = "Income";
				JFr_TransactionFrame.gup(userName, tip);
				f.dispose();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFr_FinancialHistory blol;
				try {
					blol = new JFr_FinancialHistory(userNam);
					f.dispose();
				} catch (IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		f.setVisible(true);
	}
}
