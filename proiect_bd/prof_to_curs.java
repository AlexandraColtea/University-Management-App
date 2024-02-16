package proiect_bd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class prof_to_curs extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
private int p1;
private int p2;
private int p3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prof_to_curs frame = new prof_to_curs();
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
	public prof_to_curs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 843, 592);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Asignare profesori");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(72, 45, 239, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Introduceti materia:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(72, 138, 141, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Introduceti numele:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(72, 231, 141, 31);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(278, 131, 217, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(278, 239, 217, 31);
		contentPane.add(textField_1);
		

		JRadioButton rdbtnCurs = new JRadioButton("Curs");
		rdbtnCurs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnCurs.setBounds(40, 371, 103, 21);
		contentPane.add(rdbtnCurs);
		rdbtnCurs.setOpaque(false);
		
		JRadioButton rdbtnSeminar = new JRadioButton("Seminar");
		rdbtnSeminar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnSeminar.setBounds(168, 371, 103, 21);
		contentPane.add(rdbtnSeminar);
		rdbtnSeminar.setOpaque(false);
		
		JRadioButton rdbtnLaborator = new JRadioButton("Laborator");
		rdbtnLaborator.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnLaborator.setBounds(314, 371, 103, 21);
		contentPane.add(rdbtnLaborator);
		rdbtnLaborator.setOpaque(false);
		
		JLabel lblNewLabel_3 = new JLabel("Alegeti tipul de activitati");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(40, 314, 177, 24);
		contentPane.add(lblNewLabel_3);
		
		
		rdbtnCurs.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(rdbtnCurs.isSelected()){
			      p1=1;
				}
				else p1=0;
			}
	    });
		rdbtnSeminar.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(rdbtnSeminar.isSelected()){
			      p2=1;
				}
				else p2=0;
			}
	    });
		rdbtnLaborator.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(rdbtnLaborator.isSelected()){
			      p3=1;
				}
				else p3=0;
			}
	    });
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.setBackground(new Color(198, 221, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect5","root","Taemin1993*");
				
				CallableStatement callableStatement=null;
				ResultSet resultSet=null;
				
				String sql="{call asignare_profesor_curs(?,?,?,?,?,?)}";
				
				callableStatement=connection.prepareCall(sql);
				
				
				callableStatement.setString(1,textField_1.getText());
				callableStatement.setString(2,textField.getText());
				callableStatement.setInt(3,p1);
				callableStatement.setInt(4,p2);
				callableStatement.setInt(5,1);
				callableStatement.setInt(6,p3);
				
				
				
				callableStatement.execute();
				JOptionPane.showMessageDialog(null, "Asignare cu succes!");
				connection.close();
				
				
			}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
		             " Details are provided below:");
		          e2.printStackTrace(System.err);};
			}     
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(558, 180, 103, 44);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\R.png"));
		btnBack.setBackground(new Color(198, 221, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prof_to_curs.this.setVisible(false);
				asignari_admin t=new asignari_admin();
				t.setVisible(true);
			}
			
			
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(658, 484, 103, 44);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\Download premium vector of Blank notebook frame on green background vector about frames school, scrapped paper, scrap book, stationery, and scrap book craft 1215742.jpeg"));
		lblNewLabel_4.setBounds(-11, 0, 881, 555);
		contentPane.add(lblNewLabel_4);
		
	}
	

}
