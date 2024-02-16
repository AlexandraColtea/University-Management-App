package proiect_bd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;

public class descarcare_note extends JFrame {

	private JPanel contentPane;
	private int id_local;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					descarcare_note frame = new descarcare_note();
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
	public descarcare_note() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 962, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setBounds(55, 141, 619, 366);
		contentPane.add(textArea);
		
		JLabel lblNewLabel = new JLabel("Vizualizare note");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(68, 44, 245, 38);
		contentPane.add(lblNewLabel);
		
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
				
				String sql2="{call vizualizare_note_descarcare(?)}";
				
				callableStatement=connection.prepareCall(sql2);
				
				
				callableStatement.setInt(1,id_local);
				
				callableStatement.execute();
				resultSet=callableStatement.getResultSet();
				 String total="";
				while(resultSet.next()) {
				    String re=resultSet.getString("nota_curs");
				    String re2=resultSet.getString("nota_seminar");
				    String re3=resultSet.getString("nota_lab");
				    String re4=resultSet.getString("nota_examen_final");
				    String re5=resultSet.getString("materie");
				 
				    
				    total+="Materia ";
				    total+=re5;
				    total+="\n";
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
				    total+="\n";
				   
					
				}
				 
				   textArea.setText(total);
				
				connection.close();
			}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
		             " Details are provided below:");
		          e2.printStackTrace(System.err);};
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(743, 89, 132, 51);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\R.png"));
		btnBack.setBackground(new Color(198, 221, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				descarcare_note.this.setVisible(false);
				student t=new student();
				t.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(743, 476, 132, 51);
		contentPane.add(btnBack);
		
		JButton btnDownload = new JButton("Download");
		btnDownload.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\img_71049.png"));
		btnDownload.setBackground(new Color(198, 221, 255));
		btnDownload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            try {
					
					FileWriter writer=new FileWriter("D:\\Catalog_student.txt");
					BufferedWriter bw=new BufferedWriter(writer);
					textArea.write(bw);
					bw.close();
					JOptionPane.showMessageDialog(null,"Catalog descarcat");
					
			}catch(Exception e2)
				{
				JOptionPane.showMessageDialog(null, e2);
			}}
		});
		btnDownload.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDownload.setBounds(743, 274, 144, 62);
		contentPane.add(btnDownload);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\Download premium vector of Blank notebook frame on green background vector about frames school, scrapped paper, scrap book, stationery, and scrap book craft 1215742.jpeg"));
		lblNewLabel_1.setBounds(0, 0, 948, 549);
		contentPane.add(lblNewLabel_1);
	}
}
