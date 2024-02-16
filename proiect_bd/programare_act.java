package proiect_bd;

import java.awt.EventQueue;


import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
//import java.sql.Time;
public class programare_act extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private  int id_local;
	private String act;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					programare_act frame = new programare_act();
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
	public programare_act() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 959, 546);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Programati o activitate");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(38, 23, 249, 38);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Introduceti materia");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(53, 92, 147, 38);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(210, 101, 165, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnCurs = new JRadioButton("Curs");
		rdbtnCurs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnCurs.setBounds(38, 159, 103, 21);
		getContentPane().add(rdbtnCurs);
		rdbtnCurs.setOpaque(false);
		
		JRadioButton rdbtnSeminar = new JRadioButton("Seminar");
		rdbtnSeminar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnSeminar.setBounds(38, 186, 103, 21);
		getContentPane().add(rdbtnSeminar);
		rdbtnSeminar.setOpaque(false);
		
		JRadioButton rdbtnLaborator = new JRadioButton("Laborator");
		rdbtnLaborator.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnLaborator.setBounds(38, 216, 103, 21);
		getContentPane().add(rdbtnLaborator);
		rdbtnLaborator.setOpaque(false);
		
		ButtonGroup bd=new ButtonGroup();
		bd.add(rdbtnCurs);
		bd.add(rdbtnSeminar);
		bd.add(rdbtnLaborator);
		
		rdbtnCurs.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(rdbtnCurs.isSelected())
				{
					act="Curs";
				}
			}
		});
		rdbtnSeminar.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(rdbtnSeminar.isSelected())
				{
					act="Seminar";
				}
			}
		});
		rdbtnLaborator.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(rdbtnLaborator.isSelected())
				{
					act="Laborator";
				}
			}
		});
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.setBackground(new Color(198, 221, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect5","root","Taemin1993*");
				Statement stmt=connection.createStatement();
				CallableStatement callableStatement=null;
				ResultSet resultSet=null;
				String sql="{call programare_activitate(?,?,?,?,?,?,?)}";
				test1 obj=new test1();
				id_local=obj.getId_log();
				callableStatement=connection.prepareCall(sql);
				String t1=textField_2.getText();
				t1+=":01";
				String t2=textField_3.getText();
				t2+=":01";
				callableStatement.setString(1,act);
				callableStatement.setString(2,textField.getText());
				callableStatement.setString(3,textField_1.getText());
				callableStatement.setString(4,t1);
				callableStatement.setString(5,t2);
				callableStatement.setInt(6,Integer.parseInt(textField_4.getText()));
				callableStatement.setInt(7,id_local);
				//callableStatement.execute();
				callableStatement.executeQuery();
			 resultSet=callableStatement.getResultSet();
			 String sql2="Select * from cursuri where materie='"+textField.getText()+"'";
             ResultSet rs=stmt.executeQuery(sql2);
             int idc=0;
             if(rs.next()) idc=rs.getInt("id");
			 if(act=="Laborator") {
			 String sql3="Update profesor_curs set p_lab='"+1+"'where p_lab='"+0+"' and id_prof='"+id_local+"' and id_curs='"+idc+"'";
				stmt.execute(sql3);
			 }
			 else if(act=="Seminar") {
				 String sql3="Update profesor_curs set p_seminar='"+1+"'where p_seminar='"+0+"' and id_prof='"+id_local+"' and id_curs='"+idc+"'";
					stmt.execute(sql3);
				 }
			 else if(act=="Curs") {
				 String sql3="Update profesor_curs set p_curs='"+1+"'where p_curs='"+0+"' and id_prof='"+id_local+"' and id_curs='"+idc+"'";
					stmt.execute(sql3);
				 }
			 if(resultSet==null) {
			    
				 JOptionPane.showMessageDialog(null, "Programare cu succes!");
			   }
				connection.close();
				
			}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
		             " Details are provided below:");
		          e2.printStackTrace(System.err);};
			
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(562, 175, 103, 38);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Introduceti data:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(48, 277, 114, 21);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Introduceti ora inceput:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(48, 327, 165, 21);
		getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Introduceti ora finalizare:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1.setBounds(48, 378, 180, 21);
		getContentPane().add(lblNewLabel_2_1_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setBounds(308, 276, 165, 22);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setBounds(308, 327, 165, 21);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setBounds(308, 377, 165, 22);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Introduceti numarul de participanti:");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1.setBounds(48, 438, 250, 21);
		getContentPane().add(lblNewLabel_2_1_1_1);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(308, 437, 165, 22);
		getContentPane().add(textField_4);
		
		JButton btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\R.png"));
		btnBack.setBackground(new Color(198, 221, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				programare_act.this.setVisible(false);
				profesor t=new profesor();
				t.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(793, 440, 103, 46);
		getContentPane().add(btnBack);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\Download premium vector of Blank notebook frame on green background vector about frames school, scrapped paper, scrap book, stationery, and scrap book craft 1215742.jpeg"));
		lblNewLabel_3.setBounds(0, 0, 982, 509);
		getContentPane().add(lblNewLabel_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	}
}
