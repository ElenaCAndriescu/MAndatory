package Datas;

import static Datas.JExtraxtDataFromUser.obtinereNumeUseri;
import static Datas.JFr_FinanceFrame.gui;
import static Datas.JInsertInUser.insertUser;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JFr_LogInFrame {

	public static String nume;
	private static JFrame cadru;

	private static JPanel panel;

	private static JButton b1;
	private static JButton b2;

	private static JLabel lab;
	private static JLabel lab1;

	public static JComboBox c;

	public static JTextField texts;
	private static JLabel label;

	// metoda
	/**
	 * @throws SQLException
	 * @wbp.parser.entryPoint
	 */
	public static void gus() throws IOException, SQLException {

		final List<JUtilizator> numeUseri = obtinereNumeUseri();

		// creaza Frame
		cadru = new JFrame("FinanceTracking");
		cadru.setSize(600, 400);
		cadru.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		cadru.setBackground(Color.blue);

		// creeaza Panel
		panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));

		// creaza lista
		int count = numeUseri.size();
		String[] numeUser = new String[count];
		int adresa = 0;
		for (JUtilizator element : numeUseri) {
			numeUser[adresa] = element.getNume();
			adresa += 1;
		}
		panel.setLayout(null);

		// creaza label
		lab = new JLabel("Program Login");
		lab.setBounds(263, 51, 155, 30);
		lab.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(lab);

		// adauga panel la frame
		cadru.getContentPane().add(panel, BorderLayout.CENTER);
		c = new JComboBox(numeUser);
		c.setBounds(324, 124, 186, 20);
		panel.add(c);

		// creeaza butoane in panel
		b1 = new JButton(" Enter");
		b1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		b1.setBounds(412, 155, 98, 23);
		panel.add(b1);

		// actionListener Lista
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = c.getSelectedItem().toString();
				JFr_LogInFrame.nume = userName;
				try {
					JFr_FinanceFrame.gui(userName);
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				cadru.dispose();
			}
		});
		lab1 = new JLabel("New User");
		lab1.setBounds(263, 185, 110, 20);
		lab1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(lab1);

		// creaza textField
		texts = new JTextField("Please insert name", 15);
		texts.setBounds(324, 226, 186, 24);
		texts.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel.add(texts);

		// actionListener textField
		texts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = texts.getText();
				if (!compara(numeUseri, userName)) {
					JInsertInUser.insertUser(userName);
					try {
						JFr_FinanceFrame.gui(userName);
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					cadru.dispose();
				} else {
					try {
						JFr_FinanceFrame.gui(userName);
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					cadru.dispose();
				}
			}
		});
		b2 = new JButton(" Add User");
		b2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		b2.setBounds(412, 261, 98, 23);
		panel.add(b2);

		label = new JLabel(new ImageIcon("C:\\FinanceTr\\poze\\monopoly-switch-game.jpg"));
		label.setBackground(new Color(240, 240, 240));

		label.setBounds(10, 65, 224, 286);
		panel.add(label);

		// actionListener la butonul de AddNewUser
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = texts.getText();
				if (!compara(numeUseri, userName)) {
					insertUser(userName);
					try {
						gui(userName);
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					cadru.dispose();
				} else {
					try {
						gui(userName);
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					cadru.dispose();
				}
			}
		});
		cadru.setVisible(true);
	}

	public static boolean compara(List<JUtilizator> numeUseri, String userName) {
		int i = 0;
		for (JUtilizator u : numeUseri)
			if (u.getNume().equals(userName))
				return true;
		return false;
	}
}
