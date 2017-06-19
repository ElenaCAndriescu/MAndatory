package Datas;

import static Datas.JInsertInTransactionTable.insertUser;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import javax.swing.AbstractAction;
import javax.swing.Action;

//GUI adaugare tranzactii

public class JFr_TransactionFrame {

	private static JFrame jf;
	private static JPanel jp;
	private static JLabel jl;
	private static JLabel jl1;
	private static JLabel jl2;
	private static JLabel jl3;
	private static JButton jb1;
	private static JTextField jt1;
	private static JTextField jt2;
	private static JCheckBox jc;
	private static Boolean recurent = false;
	private static String[] tipCheltuieli = { "Salary", "Food", "Entertainment", "Personal Care", "Home", "Pets",
			"Utilities", "Clothes" };

	public static String[] getTipCheltuieli() {
		return tipCheltuieli;
	}

	public static void setTipCheltuieli(String[] tipCheltuieli) {
		JFr_TransactionFrame.tipCheltuieli = tipCheltuieli;
	}

	// method de creare JFrame
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void gup(final String userName, final String tip) {

		// creaza frame
		jf = new JFrame("Financial Operations " + userName);
		jf.setSize(600, 400);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setBackground(Color.BLUE);

		// creaza obiecte
		jp = new JPanel();
		jp.setBackground(Color.LIGHT_GRAY);
		jf.getContentPane().add(jp);
		jp.setLayout(null);

		jl = new JLabel("Transaction details");
		jl.setBounds(212, 58, 160, 24);
		jl.setFont(new Font("Times New Roman", Font.BOLD, 20));
		jp.add(jl);
		jl3 = new JLabel("Please insert the amount in RON");
		jl3.setBounds(51, 109, 233, 14);
		jl3.setAlignmentY(200);
		jp.add(jl3);

		jt1 = new JTextField(10);
		jt1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					evt.consume();
				}
			}
		});
		jt1.setBounds(364, 106, 91, 20);
		jp.add(jt1);
		jl1 = new JLabel("Please insert title of the expense");
		jl1.setBounds(51, 150, 246, 14);
		jl1.setAlignmentY(200);
		jp.add(jl1);
		jt2 = new JTextField(10);
		jt2.setBounds(364, 147, 91, 20);
		jp.add(jt2);
		jl2 = new JLabel("Please select date of transaction");
		jl2.setBounds(51, 194, 301, 14);
		jl2.setAlignmentY(200);
		jp.add(jl2);

		final JComboBox comboBox = new JComboBox(tipCheltuieli);
		comboBox.setBounds(364, 228, 91, 20);
		jp.add(comboBox);

		jc = new JCheckBox("Recurent", false);
		jc.setBounds(364, 269, 69, 23);
		jp.add(jc);

		jc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recurent = true;
			}
		});

		jb1 = new JButton("Save");
		jb1.setBounds(364, 315, 57, 23);
		jp.add(jb1);

		final JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(364, 188, 91, 20);
		jp.add(dateChooser_1);
		
		JLabel lblNewLabel = new JLabel("Category");
		lblNewLabel.setBounds(51, 234, 46, 14);
		jp.add(lblNewLabel);

		//actionlistener la butonul de salvare
		
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				java.util.Date datay = dateChooser_1.getDate();
				String tipCheltuieli = comboBox.getSelectedItem().toString();
				String titleOfExpense = jt2.getText();

				insertUser(userName, Integer.parseInt(jt1.getText()), titleOfExpense, datay, recurent, tipCheltuieli,
						tip);

				try {
					JFr_FinanceFrame.gui(userName);
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				jf.dispose();
			}
		});
		jf.setVisible(true);

		jf.setVisible(true);
	}
}