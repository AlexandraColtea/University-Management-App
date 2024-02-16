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

public class catalog extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					catalog frame = new catalog();
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
	public catalog() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 961, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Catalog");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(93, 37, 200, 46);
		contentPane.add(lblNewLabel);
		
		JButton btnStudenti = new JButton("Studenti ");
		btnStudenti.setBackground(new Color(198, 221, 255));
		btnStudenti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				catalog.this.setVisible(false);
				filtrare_studenti_cursuri t=new filtrare_studenti_cursuri();
				t.setVisible(true);
			}
		});
		btnStudenti.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnStudenti.setBounds(93, 136, 235, 56);
		contentPane.add(btnStudenti);
		
		JButton btnAdaugareNote = new JButton("Adaugare note");
		btnAdaugareNote.setBackground(new Color(198, 221, 255));
		btnAdaugareNote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				catalog.this.setVisible(false);
				adaugare_note t=new adaugare_note();
				t.setVisible(true);
			}
		});
		btnAdaugareNote.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAdaugareNote.setBounds(93, 282, 235, 56);
		contentPane.add(btnAdaugareNote);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\R.png"));
		btnNewButton.setBackground(new Color(198, 221, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				catalog.this.setVisible(false);
				profesor t=new profesor();
				t.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(776, 469, 119, 41);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\Download premium vector of Blank notebook frame on green background vector about frames school, scrapped paper, scrap book, stationery, and scrap book craft 1215742.jpeg"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setBounds(0, 0, 966, 542);
		contentPane.add(lblNewLabel_1);
	}

}
