package proiect_bd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class update_curs extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private int f;
	private int ids;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update_curs frame = new update_curs();
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
	public update_curs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 897, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Modificare curs");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(90, 76, 210, 54);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Introduceti materia:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(90, 170, 140, 26);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(255, 171, 210, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.setBackground(new Color(198, 221, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect5","root","Taemin1993*");
				Statement stmt=connection.createStatement();
				String sql5="Select * from cursuri where materie='"+textField.getText()+"'";
				ResultSet rs4=stmt.executeQuery(sql5);
				if(rs4.next()) ids=rs4.getInt("id");
				connection.close();
				
				
			}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
		             " Details are provided below:");
		          e2.printStackTrace(System.err);};
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(566, 163, 121, 40);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\R.png"));
		btnBack.setBackground(new Color(198, 221, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update_curs.this.setVisible(false);
				curs t=new curs();
				t.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(712, 416, 127, 54);
		contentPane.add(btnBack);
		
		JRadioButton rdbtnDenumire = new JRadioButton("Denumire");
		rdbtnDenumire.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnDenumire.setBounds(90, 247, 103, 21);
		contentPane.add(rdbtnDenumire);
		rdbtnDenumire.setOpaque(false);
		
		JRadioButton rdbtnDescriere = new JRadioButton("Descriere");
		rdbtnDescriere.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnDescriere.setBounds(90, 304, 103, 21);
		contentPane.add(rdbtnDescriere);
		rdbtnDescriere.setOpaque(false);
		
		JRadioButton rdbtnNumarStudenti = new JRadioButton("Numar studenti");
		rdbtnNumarStudenti.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNumarStudenti.setBounds(90, 369, 140, 21);
		contentPane.add(rdbtnNumarStudenti);
		rdbtnNumarStudenti.setOpaque(false);
		
		ButtonGroup bd=new ButtonGroup();
		bd.add(rdbtnDenumire);
		bd.add(rdbtnDescriere);
		bd.add(rdbtnNumarStudenti);
		
		rdbtnDenumire.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(rdbtnDenumire.isSelected())
				{
					f=0;
					textField_1.setVisible(true);
					textField_2.setVisible(false);
					textField_3.setVisible(false);	
				}
				
			}
		});
		rdbtnDescriere.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(rdbtnDescriere.isSelected())
				{
					f=1;
					textField_1.setVisible(false);
					textField_2.setVisible(true);
					textField_3.setVisible(false);	
				}
				
			}
		});
		rdbtnNumarStudenti.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(rdbtnNumarStudenti.isSelected())
				{
					f=2;
					textField_1.setVisible(false);
					textField_2.setVisible(false);
					textField_3.setVisible(true);	
				}
				
			}
		});
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(255, 250, 210, 25);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(255, 302, 210, 25);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(255, 372, 210, 25);
		contentPane.add(textField_3);
		
		textField_1.setVisible(false);
		textField_2.setVisible(false);
		textField_3.setVisible(false);
		
		JButton btnModifica = new JButton("Modifica");
		btnModifica.setBackground(new Color(198, 221, 255));
		btnModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect5","root","Taemin1993*");
				Statement stmt=connection.createStatement();
				
				if(f==0)
				{String sql2="Update cursuri set materie='"+textField_1.getText()+"'where id='"+ids+"';";
				stmt.execute(sql2);
				JOptionPane.showMessageDialog(null, "Modificare reusita!");}
				else if(f==1)
				{String sql2="Update cursuri set descriere='"+textField_2.getText()+"'where id='"+ids+"';";
				stmt.execute(sql2);
				JOptionPane.showMessageDialog(null, "Modificare reusita!");}
				else if(f==2)
				{String sql2="Update cursuri set nr_max_studenti='"+Integer.parseInt(textField_3.getText())+"'where id='"+ids+"';";
				stmt.execute(sql2);
				JOptionPane.showMessageDialog(null, "Modificare reusita!");}
		
				connection.close();
				
				
			}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
		             " Details are provided below:");
		          e2.printStackTrace(System.err);};
			}
		});
		btnModifica.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnModifica.setBounds(566, 294, 127, 54);
		contentPane.add(btnModifica);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\Download premium vector of Blank notebook frame on green background vector about frames school, scrapped paper, scrap book, stationery, and scrap book craft 1215742.jpeg"));
		lblNewLabel_2.setBounds(0, 0, 883, 493);
		contentPane.add(lblNewLabel_2);
	}
}
