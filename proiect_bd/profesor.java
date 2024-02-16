package proiect_bd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class profesor extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					profesor frame = new profesor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public profesor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 943, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Selectati actiune");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(50, 31, 215, 42);
		contentPane.add(lblNewLabel);
		
		JButton btnProcent = new JButton("Impartire procentuala");
		btnProcent.setBackground(new Color(198, 221, 255));
		btnProcent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				profesor.this.setVisible(false);
				impart_proc t=new impart_proc();
				t.setVisible(true);
			}
		});
		btnProcent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnProcent.setBounds(60, 92, 298, 42);
		contentPane.add(btnProcent);
		
		JButton btnProgramareActivitati = new JButton("Programare activitati");
		btnProgramareActivitati.setBackground(new Color(198, 221, 255));
		btnProgramareActivitati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				profesor.this.setVisible(false);
				programare_act t=new programare_act();
				t.setVisible(true);
			}
		});
		btnProgramareActivitati.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnProgramareActivitati.setBounds(60, 155, 298, 42);
		contentPane.add(btnProgramareActivitati);
		
		JButton btnCatalog = new JButton("Catalog");
		btnCatalog.setBackground(new Color(198, 221, 255));
		btnCatalog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				profesor.this.setVisible(false);
				catalog t=new catalog();
				t.setVisible(true);
			}
		});
		btnCatalog.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCatalog.setBounds(60, 216, 298, 42);
		contentPane.add(btnCatalog);
		
		JButton btnNewButton = new JButton("Log out");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\R.png"));
		btnNewButton.setBackground(new Color(198, 221, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				profesor.this.setVisible(false);
				test1 t=new test1();
				t.getFrame().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(765, 414, 122, 42);
		contentPane.add(btnNewButton);
		
		JButton btnDatePersonale = new JButton("Date personale");
		btnDatePersonale.setBackground(new Color(198, 221, 255));
		btnDatePersonale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				profesor.this.setVisible(false);
				date_personale t=new date_personale();
				t.setVisible(true);
			}
		});
		btnDatePersonale.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDatePersonale.setBounds(60, 284, 298, 42);
		contentPane.add(btnDatePersonale);
		
		JButton btnActivitatiZi = new JButton("Activitati zi");
		btnActivitatiZi.setBackground(new Color(198, 221, 255));
		btnActivitatiZi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				profesor.this.setVisible(false);
				profesor_zi t=new profesor_zi();
				t.setVisible(true);
			}
		});
		btnActivitatiZi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnActivitatiZi.setBounds(557, 92, 298, 42);
		contentPane.add(btnActivitatiZi);
		
		JButton btnActivitatiSaptamnale = new JButton("Activitati saptamnale");
		btnActivitatiSaptamnale.setBackground(new Color(198, 221, 255));
		btnActivitatiSaptamnale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				profesor.this.setVisible(false);
				profesor_saptamana t=new profesor_saptamana();
				t.setVisible(true);
			}
		});
		btnActivitatiSaptamnale.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnActivitatiSaptamnale.setBounds(557, 170, 298, 42);
		contentPane.add(btnActivitatiSaptamnale);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\Download premium vector of Blank notebook frame on green background vector about frames school, scrapped paper, scrap book, stationery, and scrap book craft 1215742.jpeg"));
		lblNewLabel_1.setBounds(0, 0, 960, 486);
		contentPane.add(lblNewLabel_1);
	}
}
