package proiect_bd;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class test1 {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private static int id_log;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {Class.forName("com.mysql.jdbc.Driver").newInstance();
			}catch(Exception e) {System.err.println("An Exception occured during JDBC Driver loading." + 
		             " Details are provided below:");
		          e.printStackTrace(System.err);};
		          Connection connection = null;
			      Statement stmt = null, insertStatement = null;
			      ResultSet rs = null;
			      ResultSetMetaData rsmd = null;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test1 window = new test1();
					window.getFrame().setVisible(true);
					window.setId_log(id_log);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 25));
		getFrame().setBounds(100, 100, 973, 636);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		
		JButton btnNewButton = new JButton("Log in");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(198, 221, 253));
		btnNewButton.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				try {Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect5","root","Taemin1993*");
				String sql="Select * from utilizator where nume='"+textField.getText()+"' and cnp='"+passwordField.getText().toString()+"'"; 
				Statement stmt=connection.createStatement(); 
			     
			    ResultSet rs=stmt.executeQuery(sql);
			  
				if(rs.next())
				{   int fun=rs.getInt("functie");
				    id_log=rs.getInt("id");
				    
				    //System.out.println(id_log);
					JOptionPane.showMessageDialog(null, "Login succes");
					if(fun==0 || fun==3) {
				     getFrame().dispose();
					admin_1 f3=new admin_1();
					f3.setVisible(true);}
					if(fun==1) {
					     getFrame().dispose();
						profesor f4=new profesor();
						f4.setVisible(true);}
					else
					if(fun==2)
					{
						getFrame().dispose();
						student f4=new student();
						f4.setVisible(true);
					}
				 }
				
				else
				{
					JOptionPane.showMessageDialog(null, "incorrect name and password");
				}
				connection.close();
				}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
			             " Details are provided below:");
			          e2.printStackTrace(System.err);};
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(312, 370, 271, 43);
		getFrame().getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Log in");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(385, 97, 99, 39);
		getFrame().getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nume");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(254, 186, 85, 21);
		getFrame().getContentPane().add(lblNewLabel_1);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Parola");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(254, 301, 85, 39);
		getFrame().getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(385, 181, 234, 26);
		getFrame().getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBounds(385, 307, 234, 26);
		getFrame().getContentPane().add(passwordField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(385, 243, 234, 26);
		getFrame().getContentPane().add(textField_1);
		
		JLabel lblNewLabel_3 = new JLabel("sau");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(398, 423, 89, 33);
		getFrame().getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Creati un cont nou");
		btnNewButton_1.setBackground(new Color(198, 221, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getFrame().dispose();
				sign_in f2=new sign_in();
				f2.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_1.setBounds(312, 474, 271, 44);
		getFrame().getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Prenume");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(226, 248, 113, 21);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblPlatformaDeStudiu = new JLabel("Platforma de studiu");
		lblPlatformaDeStudiu.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPlatformaDeStudiu.setBounds(312, 23, 321, 39);
		frame.getContentPane().add(lblPlatformaDeStudiu);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\log.png"));
		lblNewLabel_5.setBounds(46, 44, 167, 141);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_4.setBackground(new Color(240, 240, 240));
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\Download premium vector of Blank notebook frame on green background vector about frames school, scrapped paper, scrap book, stationery, and scrap book craft 1215742.jpeg"));
		lblNewLabel_4.setBounds(0, 0, 959, 599);
		frame.getContentPane().add(lblNewLabel_4);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public int getId_log() {
		return id_log;
	}

	public void setId_log(int id_log) {
		this.id_log = id_log;
	}
}
