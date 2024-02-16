package proiect_bd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;

public class date_personale extends JFrame {

	private JPanel contentPane;
	private int id_local;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					date_personale frame = new date_personale();
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
	public date_personale() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 592);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JTextArea textArea = new JTextArea();
		textArea.setBounds(81, 169, 437, 249);
		contentPane.add(textArea);
		
		JButton btnDate = new JButton("Vizualizare date personale");
		btnDate.setBackground(new Color(198, 221, 255));
		btnDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect5","root","Taemin1993*");
				Statement stmt=connection.createStatement();
			    
				test1 obj=new test1();
				id_local=obj.getId_log();
				
                CallableStatement callableStatement=null;
				ResultSet resultSet=null;
				
				String sql2="{call vizualizare_user_id(?)}";
				
				callableStatement=connection.prepareCall(sql2);
				
				
				callableStatement.setInt(1,id_local);
				callableStatement.execute();
				resultSet=callableStatement.getResultSet();
			    
				if(resultSet.next()) {
				    String re=resultSet.getString("nume");
				    String re2=resultSet.getString("prenume");
				    String re3=resultSet.getString("cnp");
				    String re4=resultSet.getString("adresa");
				    String re5=resultSet.getString("telefon");
				    String re6=resultSet.getString("email");
				    String re7=resultSet.getString("iban");
				    
				    String total="";
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
				    
				   textArea.setText(total);
					
				}
				
				connection.close();
			}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
		             " Details are provided below:");
		          e2.printStackTrace(System.err);};
			}
		});
		btnDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDate.setBounds(81, 60, 303, 47);
		contentPane.add(btnDate);
		
		
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\R.png"));
		btnNewButton.setBackground(new Color(198, 221, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				date_personale.this.setVisible(false);
				profesor t=new profesor();
				t.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(726, 482, 110, 47);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\Download premium vector of Blank notebook frame on green background vector about frames school, scrapped paper, scrap book, stationery, and scrap book craft 1215742.jpeg"));
		lblNewLabel.setBounds(0, 0, 886, 555);
		contentPane.add(lblNewLabel);
	}
}
