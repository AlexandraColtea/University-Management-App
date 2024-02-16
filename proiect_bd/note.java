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
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class note extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private int id_local;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					note frame = new note();
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
	public note() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 842, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Vizualizare note");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(88, 64, 283, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Introduceti materie:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(88, 158, 189, 38);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(315, 164, 162, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(88, 236, 434, 200);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.setBackground(new Color(198, 221, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect5","root","Taemin1993*");
				Statement stmt=connection.createStatement();
			    
				test1 obj=new test1();
				id_local=obj.getId_log();
				
                CallableStatement callableStatement=null;
				ResultSet resultSet=null;
				
				String sql2="{call vizualizare_note(?,?)}";
				
				callableStatement=connection.prepareCall(sql2);
				
				
				callableStatement.setInt(1,id_local);
				callableStatement.setString(2,textField.getText());
				callableStatement.execute();
				resultSet=callableStatement.getResultSet();
			    
				if(resultSet.next()) {
				    String re=resultSet.getString("nota_curs");
				    String re2=resultSet.getString("nota_seminar");
				    String re3=resultSet.getString("nota_lab");
				    String re4=resultSet.getString("nota_examen_final");
				 
				    
				    String total="";
				    total+="nota_curs: ";
				    total+=re;
				    total+="\n";
				    total+="nota_seminar: ";
				    total+=re2;
				    total+="\n";
				    total+="nota_laborator: ";
				    total+=re3;
				    total+="\n";
				    total+="nota_examen_final: ";
				    total+=re4;
				    
				    total+="\n";
				    
				   textArea.setText(total);
					
				}
				
				connection.close();
			}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
		             " Details are provided below:");
		          e2.printStackTrace(System.err);};
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(570, 155, 92, 45);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\R.png"));
		btnBack.setBackground(new Color(198, 221, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				note.this.setVisible(false);
				student t=new student();
				t.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(679, 465, 101, 54);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\Download premium vector of Blank notebook frame on green background vector about frames school, scrapped paper, scrap book, stationery, and scrap book craft 1215742.jpeg"));
		lblNewLabel_2.setBounds(0, 0, 844, 538);
		contentPane.add(lblNewLabel_2);
		
		
	}

}
