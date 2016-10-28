import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Navc_m extends JFrame {

	JFrame Navc_m = new JFrame("Введення");

	JLabel Pusto;

	JLabel l_misce_teach = new JLabel("Вкажіть кількість даних для вибірки");

	JButton b_vkazatu_fayl1 = new JButton("Завантажити");
	JButton b_vkazatu_fayl2 = new JButton("Завантажити");
	JButton b_Navc = new JButton("Запустити");
	JButton b_ocustutu = new JButton("Очистити");
	JButton b_zberegtu1 = new JButton("Зберегти");
 	JButton b_zberegtu2 = new JButton("Зберегти");

	JLabel l_navc = new JLabel("Навчання           Тестування");

	JTextField t_rozmirnict = new JTextField();

	static Scanner scn;
 

	JTextArea textArea = new JTextArea();
	String TEXT;
	JPanel panel = new JPanel();
	JPanel mainPanel = new JPanel();
	JTextArea area = new JTextArea();

	JTextArea textArea1 = new JTextArea();
	String TEXT1;
	JPanel panel1 = new JPanel();
	JPanel mainPanel1 = new JPanel();
	JTextArea area1 = new JTextArea();

 
	
	public Formatter x ,x1;

	eHandler handler = new eHandler();

	public Navc_m(String s) {
		super(s);

		Navc_m.setVisible(true);
		Navc_m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Navc_m.setSize(720, 400);
		Navc_m.setResizable(false);
		Navc_m.setLocationRelativeTo(null);
		
		/////
		
		b_vkazatu_fayl1.setBounds(30, 245, 130, 50);
		Navc_m.add(b_vkazatu_fayl1);
		b_vkazatu_fayl2.setBounds(420, 245, 130, 50);
		Navc_m.add(b_vkazatu_fayl2);
		b_ocustutu.setBounds(290, 245, 130, 50);
		Navc_m.add(b_ocustutu);
		b_zberegtu1.setBounds(160, 245, 130, 50);
		Navc_m.add(b_zberegtu1);
		b_zberegtu2.setBounds(550, 245, 130, 50);
		Navc_m.add(b_zberegtu2);

		b_Navc.setBounds(30, 295, 650, 30);
		Navc_m.add(b_Navc);



		// ////////////

		mainPanel.setLayout(new BorderLayout());

		textArea.setText(TEXT);
		// textArea.setCaretPosition(0);
		JScrollPane scrollPane = new JScrollPane(textArea);
		mainPanel.add(scrollPane, BorderLayout.CENTER);

		scrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		// area.setLayout(new FlowLayout());
		mainPanel.add(area, BorderLayout.SOUTH);
		mainPanel.setBounds(100, 60, 210, 200);

		Navc_m.getContentPane().add(mainPanel);

		// /

		mainPanel1.setLayout(new BorderLayout());

		textArea1.setText(TEXT1);
		// textArea.setCaretPosition(0);
		JScrollPane scrollPane1 = new JScrollPane(textArea1);
		mainPanel1.add(scrollPane1, BorderLayout.CENTER);

		scrollPane1
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane1
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		// area.setLayout(new FlowLayout());
		mainPanel1.add(area1, BorderLayout.SOUTH);
		mainPanel1.setBounds(390, 60, 210, 200);

		Navc_m.getContentPane().add(mainPanel1);

		// ///////////

		t_rozmirnict.setBounds(510, 330, 100, 20);
		Navc_m.add(t_rozmirnict);
		l_misce_teach.setBounds(130, 330, 290, 20);
		Navc_m.add(l_misce_teach);

		Pusto = new JLabel("");
		Pusto.setBounds(10, 10, 10, 10);

		l_navc.setBounds(100, 20, 550, 30);
		l_navc.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 30));
		Navc_m.add(l_navc);

		
		Navc_m.add(Pusto);
		
		
		b_vkazatu_fayl1.addActionListener(handler);
		b_vkazatu_fayl2.addActionListener(handler);
		b_Navc.addActionListener(handler);
		b_ocustutu.addActionListener(handler);
		b_zberegtu1.addActionListener(handler);
		b_zberegtu2.addActionListener(handler);

	}

	public class eHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				if (e.getSource() == b_Navc) {

				 
					
					String s_rozmirnict = t_rozmirnict.getText();
					String s_perehid = textArea.getText();
					String s_perehid1 = textArea1.getText();
					
					int i_rozmirnict = Integer.parseInt(s_rozmirnict);

					if (i_rozmirnict > 0 && i_rozmirnict <= 10) {

						if (s_rozmirnict != null) {
							// String s = textArea.getText();

							s_rozmirnict = "system" + "/" + "rozmirnict"
									+ ".java";
							// System.out.println(dofaylu);

							x = new Formatter(s_rozmirnict);
							x.format("" + i_rozmirnict);
							x.close();

							// JOptionPane.showMessageDialog(null, "Збережено");
						}

 

					   String 	dofaylu = "system" + "/" + "perehid" + ".txt";
					   String 	dofaylu1 = "system" + "/" + "perehid1" + ".txt";
						x = new Formatter(dofaylu);
						x.format(s_perehid);
						x.close();
 
							x1 = new Formatter(dofaylu1);
							x1.format(s_perehid1);
							x1.close();
						
						
						
						Classificator net = new Classificator();
						net.loadPatterns(dofaylu); // шаблони
						net.loadTargets("system/targets.dat"); // цільові
						net.loadTests(dofaylu1);
						net.teach();
						net.makeTest();

					} else {
						JOptionPane.showMessageDialog(null,
								"Помилкове введення");
					}

				}

				if (e.getSource() == b_vkazatu_fayl1) {

					JFileChooser fileopen = new JFileChooser();

					FileFilter ft = new FileNameExtensionFilter("Text Files",
							"txt");
					fileopen.addChoosableFileFilter(ft);
					FileFilter ft1 = new FileNameExtensionFilter("Java Files",
							"java");
					fileopen.addChoosableFileFilter(ft1);
					FileFilter ft2 = new FileNameExtensionFilter("Folder",
							"null");
					fileopen.addChoosableFileFilter(ft2);
					FileFilter ft3 = new FileNameExtensionFilter("DAT", "dat");
					fileopen.addChoosableFileFilter(ft3);

					int ret = fileopen.showDialog(null, "Открыть файл");
					if (ret == JFileChooser.APPROVE_OPTION) {
						File file = fileopen.getSelectedFile();

						String st = "";

						String name = file.getAbsolutePath();

						try {
							try {
								scn = new Scanner(new File(name));
							} catch (Exception ez) {
								JOptionPane
										.showMessageDialog(
												null,
												"Невірно введено(не введено)"
														+ " або такого файлу не існує.");
							}

							BufferedReader reader = new BufferedReader(
									new FileReader(name));

							String line;
							List<String> lines = new ArrayList<String>();

							while ((line = reader.readLine()) != null) {
								lines.add(line);
							}
							String[] linesAsArray = lines
									.toArray(new String[lines.size()]);

							for (int i = 0; i < linesAsArray.length; i++) {
								// System.out.println(linesAsArray[i]);
								st = st + linesAsArray[i] + "\n";
							}

						} catch (Exception ez) {
						}

						textArea.setText(st);

					}				 
				}
				
				if (e.getSource() == b_vkazatu_fayl2) {

					JFileChooser fileopen = new JFileChooser();

					FileFilter ft = new FileNameExtensionFilter("Text Files",
							"txt");
					fileopen.addChoosableFileFilter(ft);
					FileFilter ft1 = new FileNameExtensionFilter("Java Files",
							"java");
					fileopen.addChoosableFileFilter(ft1);
					FileFilter ft2 = new FileNameExtensionFilter("Folder",
							"null");
					fileopen.addChoosableFileFilter(ft2);
					FileFilter ft3 = new FileNameExtensionFilter("DAT", "dat");
					fileopen.addChoosableFileFilter(ft3);

					int ret = fileopen.showDialog(null, "Открыть файл");
					if (ret == JFileChooser.APPROVE_OPTION) {
						File file = fileopen.getSelectedFile();

						String st = "";

						String name = file.getAbsolutePath();

						try {
							try {
								scn = new Scanner(new File(name));
							} catch (Exception ez) {
								JOptionPane
										.showMessageDialog(
												null,
												"Невірно введено(не введено)"
														+ " або такого файлу не існує.");
							}

							BufferedReader reader = new BufferedReader(
									new FileReader(name));

							String line;
							List<String> lines = new ArrayList<String>();

							while ((line = reader.readLine()) != null) {
								lines.add(line);
							}
							String[] linesAsArray = lines
									.toArray(new String[lines.size()]);

							for (int i = 0; i < linesAsArray.length; i++) {
								// System.out.println(linesAsArray[i]);
								st = st + linesAsArray[i] + "\n";
							}

						} catch (Exception ez) {
						}

						textArea1.setText(st);

					}				 
				}
				
				if (e.getSource() == b_ocustutu) {
					textArea.setText(null);
					textArea1.setText(null);
				}
				if (e.getSource() == b_zberegtu1) {
					String dofaylu = JOptionPane
							.showInputDialog("Вкажіть шлях до файла.");

					if (dofaylu != null) {
						String dofaylu1 = JOptionPane
								.showInputDialog("Вкажіть ім’я файла.");

						if (dofaylu != null) {
							String s = textArea.getText();

							dofaylu = dofaylu + "/" + dofaylu1 + ".txt";
//							System.out.println(dofaylu);

							x = new Formatter(dofaylu);
							x.format(s);
							x.close();

							JOptionPane.showMessageDialog(null, "Збережено");
						}
					}
				}
				if (e.getSource() == b_zberegtu2) {
					String dofaylu = JOptionPane
							.showInputDialog("Вкажіть шлях до файла.");

					if (dofaylu != null) {
						String dofaylu1 = JOptionPane
								.showInputDialog("Вкажіть ім’я файла.");

						if (dofaylu != null) {
							String s = textArea1.getText();

							dofaylu = dofaylu + "/" + dofaylu1 + ".txt";
//							System.out.println(dofaylu);

							x = new Formatter(dofaylu);
							x.format(s);
							x.close();

							JOptionPane.showMessageDialog(null, "Збережено");
						}
					}
				}

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Помилкове введення");

			}
		}
	}
}
