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
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;

public class grup extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					grup frame = new grup();
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
	public grup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Grupuri de studiu");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(76, 43, 239, 31);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Inscriere grup");
		btnNewButton.setBackground(new Color(198, 221, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grup.this.setVisible(false);
				inscriere_grup t=new inscriere_grup();
				t.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(78, 159, 277, 33);
		contentPane.add(btnNewButton);
		
		JButton btnVizualizareMembriGrup = new JButton("Vizualizare membrii grup");
		btnVizualizareMembriGrup.setBackground(new Color(198, 221, 255));
		btnVizualizareMembriGrup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grup.this.setVisible(false);
				membri_grup_student t=new membri_grup_student();
				t.setVisible(true);
			}
		});
		btnVizualizareMembriGrup.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVizualizareMembriGrup.setBounds(78, 219, 277, 33);
		contentPane.add(btnVizualizareMembriGrup);
		
		JButton btnMesaj = new JButton("Lasare Mesaj");
		btnMesaj.setBackground(new Color(198, 221, 255));
		btnMesaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grup.this.setVisible(false);
				mesaj t=new mesaj();
				t.setVisible(true);
			}
		});
		btnMesaj.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMesaj.setBounds(78, 280, 277, 33);
		contentPane.add(btnMesaj);
		
		JButton btnCreareActivitate = new JButton("Creare activitate");
		btnCreareActivitate.setBackground(new Color(198, 221, 255));
		btnCreareActivitate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grup.this.setVisible(false);
				creare_activitate t=new creare_activitate();
				t.setVisible(true);
			}
		});
		btnCreareActivitate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCreareActivitate.setBounds(78, 339, 277, 33);
		contentPane.add(btnCreareActivitate);
		
		JButton btnInscriereActivitate = new JButton("Inscriere activitate");
		btnInscriereActivitate.setBackground(new Color(198, 221, 255));
		btnInscriereActivitate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grup.this.setVisible(false);
				inscriere_act_grup t=new inscriere_act_grup();
				t.setVisible(true);
			}
		});
		btnInscriereActivitate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnInscriereActivitate.setBounds(78, 398, 277, 33);
		contentPane.add(btnInscriereActivitate);
		
		JButton btnSugestiiMembriiNoi = new JButton("Sugestii membri noi");
		btnSugestiiMembriiNoi.setBackground(new Color(198, 221, 255));
		btnSugestiiMembriiNoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grup.this.setVisible(false);
				sugestii_membri t=new sugestii_membri();
				t.setVisible(true);
			}
		});
		btnSugestiiMembriiNoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSugestiiMembriiNoi.setBounds(78, 455, 277, 33);
		contentPane.add(btnSugestiiMembriiNoi);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(198, 221, 255));
		btnBack.setHorizontalAlignment(SwingConstants.LEFT);
		btnBack.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\R.png"));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grup.this.setVisible(false);
				student t=new student();
				t.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(769, 508, 121, 33);
		contentPane.add(btnBack);
		
		JButton btnVizualizareMesajeDe = new JButton("Mesaje de informare");
		btnVizualizareMesajeDe.setBackground(new Color(198, 221, 255));
		btnVizualizareMesajeDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grup.this.setVisible(false);
				mesaje_informare t=new mesaje_informare();
				t.setVisible(true);
			}
		});
		btnVizualizareMesajeDe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVizualizareMesajeDe.setBounds(78, 98, 277, 33);
		contentPane.add(btnVizualizareMesajeDe);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(198, 221, 255));
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\Download premium vector of Blank notebook frame on green background vector about frames school, scrapped paper, scrap book, stationery, and scrap book craft 1215742.jpeg"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setBounds(0, 0, 931, 562);
		contentPane.add(lblNewLabel_1);
	}
}
