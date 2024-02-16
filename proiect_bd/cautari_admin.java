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
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;

public class cautari_admin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cautari_admin frame = new cautari_admin();
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
	public cautari_admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 619);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cautari");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(53, 26, 253, 46);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Cautare user");
		btnNewButton.setBackground(new Color(198, 221, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cautari_admin.this.setVisible(false);
				cautare_nume t=new cautare_nume();
				t.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(53, 124, 340, 65);
		contentPane.add(btnNewButton);
		
		JButton btnCautareDupaTip = new JButton("Cautare dupa tip de utilizator");
		btnCautareDupaTip.setBackground(new Color(198, 221, 255));
		btnCautareDupaTip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cautari_admin.this.setVisible(false);
				cautare_tip t=new cautare_tip();
				t.setVisible(true);
			}
		});
		btnCautareDupaTip.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCautareDupaTip.setBounds(53, 244, 340, 65);
		contentPane.add(btnCautareDupaTip);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\R.png"));
		btnNewButton_1.setBackground(new Color(198, 221, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cautari_admin.this.setVisible(false);
				admin_1 t=new admin_1();
				t.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(755, 506, 110, 46);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\Download premium vector of Blank notebook frame on green background vector about frames school, scrapped paper, scrap book, stationery, and scrap book craft 1215742.jpeg"));
		lblNewLabel_1.setBounds(0, 0, 896, 582);
		contentPane.add(lblNewLabel_1);
	}

}
