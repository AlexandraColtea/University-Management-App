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

public class asignari_admin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					asignari_admin frame = new asignari_admin();
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
	public asignari_admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 993, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Asignari");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(56, 24, 128, 44);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Asignare student la curs");
		btnNewButton.setBackground(new Color(198, 221, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asignari_admin.this.setVisible(false);
				inscriere_student t=new inscriere_student();
				t.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(56, 133, 348, 45);
		contentPane.add(btnNewButton);
		
		JButton btnAsignareProfesorLa = new JButton("Asignare profesor la curs");
		btnAsignareProfesorLa.setBackground(new Color(198, 221, 255));
		btnAsignareProfesorLa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asignari_admin.this.setVisible(false);
				prof_to_curs t=new prof_to_curs();
				t.setVisible(true);
			}
		});
		btnAsignareProfesorLa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAsignareProfesorLa.setBounds(56, 222, 348, 45);
		contentPane.add(btnAsignareProfesorLa);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\R.png"));
		btnNewButton_1.setBackground(new Color(198, 221, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asignari_admin.this.setVisible(false);
				admin_1 t=new admin_1();
				t.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(835, 483, 106, 44);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\Download premium vector of Blank notebook frame on green background vector about frames school, scrapped paper, scrap book, stationery, and scrap book craft 1215742.jpeg"));
		lblNewLabel_1.setBounds(0, -11, 979, 572);
		contentPane.add(lblNewLabel_1);
	}

}
