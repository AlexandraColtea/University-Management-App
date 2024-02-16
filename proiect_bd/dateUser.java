package proiect_bd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
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

public class dateUser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dateUser frame = new dateUser();
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
	public dateUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1044, 616);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Introducere date");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(36, 23, 285, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nume");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(46, 73, 130, 31);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(134, 73, 257, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setBounds(57, 178, 846, 266);
		contentPane.add(textArea);
		
		JButton BackBtn = new JButton("Back");
		BackBtn.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\R.png"));
		BackBtn.setBackground(new Color(198, 221, 255));
		BackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dateUser.this.setVisible(false);
				afisari t=new afisari();
				t.setVisible(true);
			}
		});
		BackBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BackBtn.setBounds(878, 500, 113, 51);
		contentPane.add(BackBtn);
		
		JButton EnterBtn = new JButton("Enter");
		EnterBtn.setBackground(new Color(198, 221, 255));
		EnterBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect5","root","Taemin1993*");
				
				CallableStatement callableStatement=null;
				
				ResultSet resultSet=null;
				
				String sql="{call vizualizare_date_user(?)}";
				
				callableStatement=connection.prepareCall(sql);
				
				
				callableStatement.setString(1,textField.getText());
				//callableStatement.execute();
				callableStatement.executeQuery();
			 resultSet=callableStatement.getResultSet();
			 if(resultSet.next()) {
			    String re=resultSet.getString("nume");
			    String re2=resultSet.getString("prenume");
			    String re3=resultSet.getString("cnp");
			    String re4=resultSet.getString("adresa");
			    String re5=resultSet.getString("telefon");
			    String re6=resultSet.getString("email");
			    String re7=resultSet.getString("iban");
			    
			   textArea.setText(re+" "+re2+" "+re3+" "+re4+" "+re5+" "+re6+" "+re7);
			   }
				connection.close();
				//callableStatement.setString(3,textField_1.getText());
				
			}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
		             " Details are provided below:");
		          e2.printStackTrace(System.err);};
			}
		});
		EnterBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		EnterBtn.setBounds(441, 73, 106, 31);
		contentPane.add(EnterBtn);
		
		JLabel lblNewLabel_2 = new JLabel("Nume");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(72, 155, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Prenume");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1.setBounds(134, 155, 58, 13);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("CNP");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_2.setBounds(253, 155, 45, 13);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Adresa");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_3.setBounds(374, 155, 45, 13);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Telefon");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_4.setBounds(488, 155, 45, 13);
		contentPane.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("E-mail");
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_5.setBounds(619, 155, 45, 13);
		contentPane.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_6 = new JLabel("IBAN");
		lblNewLabel_2_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_6.setBounds(765, 155, 45, 13);
		contentPane.add(lblNewLabel_2_6);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\Download premium vector of Blank notebook frame on green background vector about frames school, scrapped paper, scrap book, stationery, and scrap book craft 1215742.jpeg"));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setBounds(0, 0, 1041, 579);
		contentPane.add(lblNewLabel_3);
	}
}
