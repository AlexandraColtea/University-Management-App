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

public class curs extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					curs frame = new curs();
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
	public curs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 875, 605);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Operatii pe cursuri");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(106, 82, 240, 52);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Creare curs");
		btnNewButton.setBackground(new Color(198, 221, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				curs.this.setVisible(false);
				creare_curs t=new creare_curs();
				t.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(123, 214, 193, 52);
		contentPane.add(btnNewButton);
		
		JButton btnModificareCurs = new JButton("Modificare curs");
		btnModificareCurs.setBackground(new Color(198, 221, 255));
		btnModificareCurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				curs.this.setVisible(false);
				update_curs t=new update_curs();
				t.setVisible(true);
			}
		});
		btnModificareCurs.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnModificareCurs.setBounds(123, 325, 193, 52);
		contentPane.add(btnModificareCurs);
		
		JButton btnStergereCurs = new JButton("Stergere curs");
		btnStergereCurs.setBackground(new Color(198, 221, 255));
		btnStergereCurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				curs.this.setVisible(false);
				delete_curs t=new delete_curs();
				t.setVisible(true);
			}
		});
		btnStergereCurs.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnStergereCurs.setBounds(123, 431, 193, 52);
		contentPane.add(btnStergereCurs);
		
		JButton btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\R.png"));
		btnBack.setBackground(new Color(198, 221, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				curs.this.setVisible(false);
				admin_1 t=new admin_1();
				t.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(655, 506, 157, 52);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\Download premium vector of Blank notebook frame on green background vector about frames school, scrapped paper, scrap book, stationery, and scrap book craft 1215742.jpeg"));
		lblNewLabel_1.setBounds(0, 0, 861, 578);
		contentPane.add(lblNewLabel_1);
	}
}
