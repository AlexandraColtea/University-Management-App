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
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class cautare_nume extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cautare_nume frame = new cautare_nume();
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
	public cautare_nume() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1014, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cautare utilizator:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(64, 40, 278, 51);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Introduceti nume:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(64, 133, 146, 25);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(267, 132, 226, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea.setBounds(64, 181, 902, 271);
		contentPane.add(textArea);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setBackground(new Color(198, 221, 255));
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect5","root","Taemin1993*");
				
				CallableStatement callableStatement=null;
				
				ResultSet resultSet=null;
				
				String sql="{call cautare_dupa_nume(?)}";
				
				callableStatement=connection.prepareCall(sql);
				
				
				callableStatement.setString(1,textField.getText());
				//callableStatement.execute();
				callableStatement.executeQuery();
			 resultSet=callableStatement.getResultSet();
			 String total="";
			 while(resultSet.next()) {
			    String re=resultSet.getString("nume");
			    String re2=resultSet.getString("prenume");
			    String re3=resultSet.getString("cnp");
			    String re4=resultSet.getString("adresa");
			    String re5=resultSet.getString("email");
			    String re6=resultSet.getString("telefon");
			    String re7=resultSet.getString("iban");
			    int re8=resultSet.getInt("functie");
			    //total.concat(re+" "+re2+", ");
			    total+="nume: ";
			    total+=re;
			    total+="\n";
			    total+="prenume: ";
			    total+=re2;
			    total+="\n";
			    total+="cnp: ";
			    total+=re3;
			    total+="\n";
			    total+="adresa: ";
			    total+=re4;
			    total+="\n";
			    total+="email: ";
			    total+=re5;
			    total+="\n";
			    total+="telefon: ";
			    total+=re6;
			    total+="\n";
			    total+="iban: ";
			    total+=re7;
			    total+="\n";
			    if(re8==1)
			    {
			    	String re9=resultSet.getString("departament");
			    	int re10=resultSet.getInt("nr_min_ore");
			    	int re11=resultSet.getInt("nr_max_ore");
			    	total+="departament: ";
			    	total+=re9;
				    total+="\n";
				    total+="numar minim de ore: ";
				    total+=re10;
				    total+="\n";
				    total+="numar maxim de ore: ";
				    total+=re11;
				   
			    }
			    else
			    	 if(re8==2)
					    {
					    	
					    	int re12=resultSet.getInt("nr_ore");
					    	int re13=resultSet.getInt("an_studiu");
					    	total+="numar de ore: ";
					    	total+=re12;
						    total+="\n";
						    total+="an studiu: ";
						    total+=re13;
						    
						    
					    }
			    total+="\n";
			    //total.concat(re2);
			   //
			   }
			 textArea.setText(total);
				connection.close();
				//callableStatement.setString(3,textField_1.getText());
				
			}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
		             " Details are provided below:");
		          e2.printStackTrace(System.err);};
			
			}
		});
		btnEnter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEnter.setBounds(544, 126, 103, 39);
		contentPane.add(btnEnter);
		
		
		
		JButton btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\R.png"));
		btnBack.setBackground(new Color(198, 221, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cautare_nume.this.setVisible(false);
				cautari_admin t=new cautari_admin();
				t.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(834, 491, 113, 51);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\Download premium vector of Blank notebook frame on green background vector about frames school, scrapped paper, scrap book, stationery, and scrap book craft 1215742.jpeg"));
		lblNewLabel_2.setBackground(new Color(240, 240, 240));
		lblNewLabel_2.setBounds(0, 0, 1000, 563);
		contentPane.add(lblNewLabel_2);
	}

}
