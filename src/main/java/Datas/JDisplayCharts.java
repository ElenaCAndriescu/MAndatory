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

public class JDisplayCharts {

	private static JFrame frame = new JFrame();
	private static JButton btnNewButton;

	/**
	 * @throws SQLException 
	 * @throws IOException 
	 * @wbp.parser.entryPoint
	 */
	public static void blol(String user) throws IOException, SQLException {

		// creaza Frame
		frame = new JFrame("Charts and details");
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
		frame.setSize(679, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.CYAN);
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(null);

		btnNewButton = new JButton("Back");
		btnNewButton.setBounds(379, 262, 81, 23);
		frame.getContentPane().add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFr_FinancialHistory blol;
				try {
					blol = new JFr_FinancialHistory(user);
					frame.dispose();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		String[] categorii = JFr_TransactionFrame.getTipCheltuieli();
		
		Slice one = null; 
		Slice two = null;
		Slice three = null;
		Slice four = null;
		Slice five = null;
		Slice six = null;
		Slice seven = null;
		Slice eight = null;
		
		for (String categorie : categorii ){
			one = new Slice (obtinereValoareLunara(user, "Income", categorii[0]), Color.green);
			two = new Slice (obtinereValoareLunara(user, "Expense", categorii[1]), Color.blue);
			three = new Slice (obtinereValoareLunara(user, "Expense", categorii[2]), Color.red);
			four = new Slice (obtinereValoareLunara(user, "Expense", categorii[3]), Color.yellow);
			five = new Slice (obtinereValoareLunara(user, "Expense", categorii[4]), Color.CYAN);
			six = new Slice (obtinereValoareLunara(user, "Expense", categorii[5]), Color.PINK);
			seven = new Slice (obtinereValoareLunara(user, "Expense", categorii[6]), Color.magenta);
			eight = new Slice (obtinereValoareLunara(user, "Expense", categorii[7]), Color.orange);	
		}

		Slice[] slices ={one, two, three, four, five, six, seven, eight};
		PieChart3.setSlices(slices);
		PieChart3 pieChart3 = new PieChart3();
		pieChart3.setBounds(0, 0, 350, 300);
		frame.getContentPane().add(pieChart3);
		frame.setSize(500, 400);
		frame.setVisible(true);
		frame.setVisible(true);
	}
}
