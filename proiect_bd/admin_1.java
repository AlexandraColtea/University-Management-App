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

public class admin_1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_1 frame = new admin_1();
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
	public admin_1() {
		setBackground(new Color(198, 221, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 918, 591);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Selecteaza activitate");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(57, 43, 358, 27);
		contentPane.add(lblNewLabel);
		
		JButton btnAfisari = new JButton("Afisari");
		btnAfisari.setBackground(new Color(198, 221, 255));
		btnAfisari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin_1.this.setVisible(false);
				afisari t=new afisari();
				t.setVisible(true);
			}
		});
		btnAfisari.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAfisari.setBounds(88, 110, 212, 33);
		contentPane.add(btnAfisari);
		
		JButton btnCautari = new JButton("Cautari");
		btnCautari.setBackground(new Color(198, 221, 255));
		btnCautari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin_1.this.setVisible(false);
				cautari_admin t=new cautari_admin();
				t.setVisible(true);
			}
		});
		btnCautari.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCautari.setBounds(88, 175, 212, 33);
		contentPane.add(btnCautari);
		
		JButton btnAsignari = new JButton("Asignari");
		btnAsignari.setBackground(new Color(198, 221, 255));
		btnAsignari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin_1.this.setVisible(false);
				asignari_admin t=new asignari_admin();
				t.setVisible(true);
			}
		});
		btnAsignari.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAsignari.setBounds(88, 244, 212, 33);
		contentPane.add(btnAsignari);
		
		JButton btnStergeri = new JButton("Stergeri");
		btnStergeri.setBackground(new Color(198, 221, 255));
		btnStergeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin_1.this.setVisible(false);
				stergere_utilizator t=new stergere_utilizator();
				t.setVisible(true);
			}
		});
		btnStergeri.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnStergeri.setBounds(88, 313, 212, 33);
		contentPane.add(btnStergeri);
		
		JButton btnModificari = new JButton("Modificari");
		btnModificari.setBackground(new Color(198, 221, 255));
		btnModificari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin_1.this.setVisible(false);
				modificari_utilizatori t=new modificari_utilizatori();
				t.setVisible(true);
			}
		});
		btnModificari.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnModificari.setBounds(88, 384, 212, 33);
		contentPane.add(btnModificari);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(198, 221, 255));
		btnBack.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\R.png"));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//admin_1.this.dispose();
				admin_1.this.setVisible(false);
				test1 t=new test1();
				t.getFrame().setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(768, 498, 105, 33);
		contentPane.add(btnBack);
		
		JButton btnOperatiiPeCursuri = new JButton("Operatii pe cursuri");
		btnOperatiiPeCursuri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin_1.this.setVisible(false);
				curs t=new curs();
				t.setVisible(true);
			}
		});
		btnOperatiiPeCursuri.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnOperatiiPeCursuri.setBackground(new Color(198, 221, 255));
		btnOperatiiPeCursuri.setBounds(88, 453, 212, 33);
		contentPane.add(btnOperatiiPeCursuri);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\Download premium vector of Blank notebook frame on green background vector about frames school, scrapped paper, scrap book, stationery, and scrap book craft 1215742.jpeg"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setBounds(0, 0, 904, 554);
		contentPane.add(lblNewLabel_1);
	}
}
