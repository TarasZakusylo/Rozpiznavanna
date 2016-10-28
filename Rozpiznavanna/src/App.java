
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

class Reader extends JFrame {

	JFrame Reader = new JFrame("Класифікатор 0.2");

	JButton Vhid = new JButton("Почати роботу");
	JLabel Pusto, l_Text1, l_Text2, l_Text3;
	
	String f = "res/logo.png";
  
	ImageIcon logo = new ImageIcon(f);
	JLabel l_logo = new JLabel(logo);

	eHandler handler = new eHandler();

	public Reader(String s) {
		super(s);
	 
		
		Pusto = new JLabel("");
		Pusto.setBounds(10, 10, 10, 10);

		Vhid.setBounds(150, 230, 300, 50);
		add(Vhid);

	

		l_Text1 = new JLabel("Класифікатор даних");
		l_Text1.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 20));
		l_Text1.setForeground(Color.GREEN);
		l_Text1.setBounds(310, 20, 500, 25);
		add(l_Text1);		

		l_Text2 = new JLabel("на основі одношарової");
		l_Text2.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 20));
		l_Text2.setBounds(290, 50, 500, 25);		
		l_Text2.setForeground(Color.GREEN);
		add(l_Text2);
		
		l_Text3 = new JLabel("нейронної мережі");
		l_Text3.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 20));
		l_Text3.setBounds(335, 80, 500,  25);		
		l_Text3.setForeground(Color.GREEN);
		add(l_Text3);
		
		l_logo.setBounds(5, 5, 375, 355);
		add(l_logo);

		add(Pusto);

		Vhid.addActionListener(handler);
	}

	public class eHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				if (e.getSource() == Vhid) {
				new Navc_m("");
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "System error");

			}
		}
	}

}

public class App {
	public static void main(String[] args) {
		Reader r = new Reader("NTHI0.2");

		r.setVisible(true);
		r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		r.setSize(600, 400);
		r.setResizable(false);
		r.setLocationRelativeTo(null);
	}
}
