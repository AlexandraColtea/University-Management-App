package proiect_bd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import java.awt.TextArea;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;

public class cautare_tip extends JFrame {

	private JPanel contentPane;
	private int f;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cautare_tip frame = new cautare_tip();
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
	public cautare_tip() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 998, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cautare dupa tip de utilizator");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(73, 53, 414, 55);
		contentPane.add(lblNewLabel);
		
		JRadioButton rdbtnAdmin = new JRadioButton("Admin");
		rdbtnAdmin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnAdmin.setBounds(73, 179, 103, 21);
		contentPane.add(rdbtnAdmin);
		rdbtnAdmin.setOpaque(false);
		
		JRadioButton rdbtnProfesor = new JRadioButton("Profesor");
		rdbtnProfesor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnProfesor.setBounds(73, 253, 103, 21);
		contentPane.add(rdbtnProfesor);
		rdbtnProfesor.setOpaque(false);
		
		JRadioButton rdbtnStudent = new JRadioButton("Student");
		rdbtnStudent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnStudent.setBounds(73, 330, 103, 21);
		contentPane.add(rdbtnStudent);
		rdbtnStudent.setOpaque(false);
		
		ButtonGroup bd=new ButtonGroup();
		bd.add(rdbtnAdmin);
		bd.add(rdbtnProfesor);
		bd.add(rdbtnStudent);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(286, 160, 579, 236);
		contentPane.add(scrollPane_1);
		
		TextArea textArea = new TextArea();
		scrollPane_1.setViewportView(textArea);

		rdbtnAdmin.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(rdbtnAdmin.isSelected()){
			      f=0;
				}
			}
	    });
		
		rdbtnProfesor.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(rdbtnProfesor.isSelected()){
			      f=1;
				}
			}
	    });
		
		rdbtnStudent.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(rdbtnStudent.isSelected()){
			      f=2;
				}
			}
	    });
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\R.png"));
		btnNewButton.setBackground(new Color(198, 221, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cautare_tip.this.setVisible(false);
				cautari_admin t=new cautari_admin();
				t.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(831, 494, 103, 48);
		contentPane.add(btnNewButton);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setBackground(new Color(198, 221, 255));
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect5","root","Taemin1993*");
				
				CallableStatement callableStatement=null;
				
				ResultSet resultSet=null;
				
				String sql="{call filtrare_tip(?)}";
				
				callableStatement=connection.prepareCall(sql);
				
				
				callableStatement.setInt(1,f);
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
			    total+="\n";
			   
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
		btnEnter.setBounds(73, 474, 103, 48);
		contentPane.add(btnEnter);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\Download premium vector of Blank notebook frame on green background vector about frames school, scrapped paper, scrap book, stationery, and scrap book craft 1215742.jpeg"));
		lblNewLabel_1.setBounds(0, 0, 984, 583);
		contentPane.add(lblNewLabel_1);
		
		
		
		
	}
}
