package proiect_bd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;

public class sugestii_membri extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sugestii_membri frame = new sugestii_membri();
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
	public sugestii_membri() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sugestii membri");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(83, 54, 309, 57);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Introduceti materia:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(83, 143, 150, 41);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(259, 148, 132, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setBounds(83, 207, 336, 289);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.setBackground(new Color(198, 221, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect5","root","Taemin1993*");
				Statement stmt=connection.createStatement();
				CallableStatement callableStatement=null;
				
				ResultSet resultSet=null;
				String sql2="Select * from cursuri where materie='"+textField.getText()+"'";
				ResultSet rs=stmt.executeQuery(sql2);
				int idc=0;
				if(rs.next())
				{
					idc=rs.getInt("id");
				}
				String sql4="Select * from grup_de_studiu where materia='"+textField.getText()+"'";
				ResultSet rs3=stmt.executeQuery(sql4);
				int idg=0;
				if(rs3.next())
				{
					idg=rs3.getInt("id");
				}
				String sql7="Select max(id) as count from utilizator ";
				ResultSet rs6=stmt.executeQuery(sql7);
				int x=0;
				if(rs6.next())
				{
					x=rs6.getInt("count");
				}
				String total="";
				System.out.println(x);
				for(int i=1;i<x;i++)
				{ String sql3="Select * from inscrieri where id_curs='"+idc+"' and id_student='"+i+"'";
				 ResultSet rs2=stmt.executeQuery(sql3);
				 int ids=0;
				
				
				if(rs2.next())
				{    
				   ids=rs2.getInt("id_student");
				   String sql5="Select * from mesaj where id_student='"+ids+"' and id_grup='"+idg+"'";
					ResultSet rs4=stmt.executeQuery(sql5);
					if(rs4.next())
					{   
					   System.out.println("exista"); 
					}
					else
					{
						String sql6="Select * from utilizator where id='"+ids+"'";
						ResultSet rs5=stmt.executeQuery(sql6);
						if(rs5.next()) {
						String nume=rs5.getString("nume");
						String prenume=rs5.getString("prenume");
						
						total+=nume;
						total+=" ";
						total+=prenume;
						total+="\n";}
						
					}
					
				}
				}
				//rs2.close();
				
				
			 textArea.setText(total);
				connection.close();
				//callableStatement.setString(3,textField_1.getText());
				
			}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
		             " Details are provided below:");
		          e2.printStackTrace(System.err);};
			
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(480, 143, 125, 33);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\R.png"));
		btnBack.setBackground(new Color(198, 221, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sugestii_membri.this.setVisible(false);
				grup t=new grup();
				t.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(712, 555, 125, 32);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\Download premium vector of Blank notebook frame on green background vector about frames school, scrapped paper, scrap book, stationery, and scrap book craft 1215742.jpeg"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setBounds(0, 0, 868, 608);
		contentPane.add(lblNewLabel_2);
		
		
	}
}
