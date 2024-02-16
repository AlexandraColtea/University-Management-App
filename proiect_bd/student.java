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

public class student extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student frame = new student();
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
	public student() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 892, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Selectati actiune");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(88, 35, 214, 48);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Inscriere curs");
		btnNewButton.setBackground(new Color(198, 221, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				student.this.setVisible(false);
				inscriere_curs t=new inscriere_curs();
				t.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(88, 117, 215, 50);
		contentPane.add(btnNewButton);
		
		JButton btnRenuntareCurs = new JButton("Renuntare curs");
		btnRenuntareCurs.setBackground(new Color(198, 221, 255));
		btnRenuntareCurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				student.this.setVisible(false);
				renuntare_curs t=new renuntare_curs();
				t.setVisible(true);
			}
		});
		btnRenuntareCurs.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRenuntareCurs.setBounds(88, 187, 215, 50);
		contentPane.add(btnRenuntareCurs);
		
		JButton btnVizualizareNote = new JButton("Vizualizare note");
		btnVizualizareNote.setBackground(new Color(198, 221, 255));
		btnVizualizareNote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				student.this.setVisible(false);
				note t=new note();
				t.setVisible(true);
			}
		});
		btnVizualizareNote.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVizualizareNote.setBounds(88, 257, 215, 50);
		contentPane.add(btnVizualizareNote);
		
		JButton btnGrupuri = new JButton("Grupuri");
		btnGrupuri.setBackground(new Color(198, 221, 255));
		btnGrupuri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				student.this.setVisible(false);
				grup t=new grup();
				t.setVisible(true);
			}
		});
		btnGrupuri.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGrupuri.setBounds(88, 329, 215, 50);
		contentPane.add(btnGrupuri);
		
		JButton btnAlegeriActivitati = new JButton("Alegeri activitati");
		btnAlegeriActivitati.setBackground(new Color(198, 221, 255));
		btnAlegeriActivitati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				student.this.setVisible(false);
				inscriere_act t=new inscriere_act();
				t.setVisible(true);
			}
		});
		btnAlegeriActivitati.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAlegeriActivitati.setBounds(88, 400, 215, 50);
		contentPane.add(btnAlegeriActivitati);
		
		JButton btnDatePersonale = new JButton("Date personale");
		btnDatePersonale.setBackground(new Color(198, 221, 255));
		btnDatePersonale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				student.this.setVisible(false);
				date_personale t=new date_personale();
				t.setVisible(true);
			}
		});
		btnDatePersonale.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDatePersonale.setBounds(88, 473, 215, 50);
		contentPane.add(btnDatePersonale);
		
		JButton btnNewButton_1 = new JButton("Log out");
		btnNewButton_1.setBackground(new Color(198, 221, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				student.this.setVisible(false);
				test1 t=new test1();
				t.getFrame().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(686, 473, 131, 50);
		contentPane.add(btnNewButton_1);
		
		JButton btnVizualizareOrarSaptamanal = new JButton("Vizualizare orar saptamanal");
		btnVizualizareOrarSaptamanal.setBackground(new Color(198, 221, 255));
		btnVizualizareOrarSaptamanal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				student.this.setVisible(false);
				student_saptamana t=new student_saptamana();
				t.setVisible(true);
			}
		});
		btnVizualizareOrarSaptamanal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVizualizareOrarSaptamanal.setBounds(517, 117, 300, 48);
		contentPane.add(btnVizualizareOrarSaptamanal);
		
		JButton btnVizualizareOrarSaptamanal_1 = new JButton("Vizualizare orar zi");
		btnVizualizareOrarSaptamanal_1.setBackground(new Color(198, 221, 255));
		btnVizualizareOrarSaptamanal_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				student.this.setVisible(false);
				student_zi t=new student_zi();
				t.setVisible(true);
			}
		});
		btnVizualizareOrarSaptamanal_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVizualizareOrarSaptamanal_1.setBounds(517, 187, 300, 50);
		contentPane.add(btnVizualizareOrarSaptamanal_1);
		
		JButton btnVizualizareCatalog = new JButton("Vizualizare catalog");
		btnVizualizareCatalog.setBackground(new Color(198, 221, 255));
		btnVizualizareCatalog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				student.this.setVisible(false);
				descarcare_note t=new descarcare_note();
				t.setVisible(true);
			}
		});
		btnVizualizareCatalog.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVizualizareCatalog.setBounds(517, 266, 300, 50);
		contentPane.add(btnVizualizareCatalog);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\Download premium vector of Blank notebook frame on green background vector about frames school, scrapped paper, scrap book, stationery, and scrap book craft 1215742.jpeg"));
		lblNewLabel_1.setBounds(-13, 0, 933, 565);
		contentPane.add(lblNewLabel_1);
	}
}
