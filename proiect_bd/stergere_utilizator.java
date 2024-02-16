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
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class stergere_utilizator extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
    private int id_local;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stergere_utilizator frame = new stergere_utilizator();
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
	public stergere_utilizator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 892, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Stergere utilizator");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(58, 32, 186, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Introduceti nume");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(44, 115, 130, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Introduceti prenume");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(44, 214, 170, 28);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(205, 115, 179, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(205, 214, 179, 28);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.setBackground(new Color(198, 221, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect5","root","Taemin1993*");
				Statement stmt=connection.createStatement();
				CallableStatement callableStatement=null;
				ResultSet resultSet=null;
				String sql2="Select * from utilizator where nume='"+textField.getText()+"'";
				ResultSet rs=stmt.executeQuery(sql2);
				int f=0;
				if(rs.next())
				{
					f=rs.getInt("functie");
				}
				test1 obj=new test1();
				id_local=obj.getId_log();
				String sql3="Select * from utilizator where id='"+id_local+"'";
				ResultSet rs2=stmt.executeQuery(sql3);
				int func=0;
				if(rs2.next())
				{
					func=rs2.getInt("functie");
				}
				if(f!=0 &&f!=3)
				{
				String sql="{call delete_utilizator(?,?)}";
				
				callableStatement=connection.prepareCall(sql);
				
				
				callableStatement.setString(1,textField.getText());
				callableStatement.setString(2,textField_1.getText());
				
				
				
				callableStatement.execute();
				resultSet=callableStatement.getResultSet();
				if(resultSet!=null)
				JOptionPane.showMessageDialog(null, "Stergere facuta cu succes!");
				else JOptionPane.showMessageDialog(null, "Stergere imposibila!");
				}
				else if(func==3)
				{
				String sql="{call delete_utilizator(?,?)}";
				
				callableStatement=connection.prepareCall(sql);
				
				
				callableStatement.setString(1,textField.getText());
				callableStatement.setString(2,textField_1.getText());
				
				
				
				callableStatement.execute();
				resultSet=callableStatement.getResultSet();
				if(resultSet!=null)
				JOptionPane.showMessageDialog(null, "Stergere facuta cu succes!");
				else JOptionPane.showMessageDialog(null, "Stergere imposibila!");
				}
				else JOptionPane.showMessageDialog(null, "Stergere imposibila!");
				connection.close();
				
				
			}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
		             " Details are provided below:");
		          e2.printStackTrace(System.err);};
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(569, 153, 120, 50);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\R.png"));
		btnBack.setBackground(new Color(198, 221, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stergere_utilizator.this.setVisible(false);
				admin_1 t=new admin_1();
				t.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(707, 472, 120, 50);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\2.png"));
		lblNewLabel_3.setBounds(169, 276, 269, 246);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\Download premium vector of Blank notebook frame on green background vector about frames school, scrapped paper, scrap book, stationery, and scrap book craft 1215742.jpeg"));
		lblNewLabel_2.setBounds(-13, 0, 914, 548);
		contentPane.add(lblNewLabel_2);
	}

}
