package proiect_bd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;

public class afisari extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					afisari frame = new afisari();
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
	public afisari() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 951, 633);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton vizDate = new JButton("Vizualizare date user");
		vizDate.setBackground(new Color(198, 221, 255));
		vizDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afisari.this.setVisible(false);
				dateUser t=new dateUser();
				t.setVisible(true);
			}
		});
		vizDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		vizDate.setBounds(57, 110, 375, 45);
		contentPane.add(vizDate);
		
		JButton btnVizualizareProfesorCurs = new JButton("Vizualizare profesor curs");
		btnVizualizareProfesorCurs.setBackground(new Color(198, 221, 255));
		btnVizualizareProfesorCurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afisari.this.setVisible(false);
				profesor_curs t=new profesor_curs();
				t.setVisible(true);
			}
		});
		btnVizualizareProfesorCurs.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVizualizareProfesorCurs.setBounds(57, 179, 375, 45);
		contentPane.add(btnVizualizareProfesorCurs);
		
		JButton btnParticipantiStudentCurs = new JButton("Participanti student curs ");
		btnParticipantiStudentCurs.setBackground(new Color(198, 221, 255));
		btnParticipantiStudentCurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afisari.this.setVisible(false);
				studenti_curs t=new studenti_curs();
				t.setVisible(true);
			}
		});
		btnParticipantiStudentCurs.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnParticipantiStudentCurs.setBounds(57, 255, 375, 45);
		contentPane.add(btnParticipantiStudentCurs);
		
		JButton btnVizualizareMembriiGrup = new JButton("Vizualizare membrii grup");
		btnVizualizareMembriiGrup.setBackground(new Color(198, 221, 255));
		btnVizualizareMembriiGrup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afisari.this.setVisible(false);
				membri_grup t=new membri_grup();
				t.setVisible(true);
			}
		});
		btnVizualizareMembriiGrup.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVizualizareMembriiGrup.setBounds(57, 333, 375, 45);
		contentPane.add(btnVizualizareMembriiGrup);
		
		JLabel lblNewLabel = new JLabel("Vizualizare date");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(72, 31, 200, 31);
		contentPane.add(lblNewLabel);
		
		JButton BackBtn = new JButton("Back");
		BackBtn.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\R.png"));
		BackBtn.setBackground(new Color(198, 221, 255));
		BackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afisari.this.setVisible(false);
				admin_1 t=new admin_1();
				t.setVisible(true);
			}
		});
		BackBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BackBtn.setBounds(789, 528, 105, 43);
		contentPane.add(BackBtn);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\Download premium vector of Blank notebook frame on green background vector about frames school, scrapped paper, scrap book, stationery, and scrap book craft 1215742.jpeg"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setBounds(0, 0, 949, 596);
		contentPane.add(lblNewLabel_1);
	}

}
