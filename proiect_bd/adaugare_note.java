package proiect_bd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
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
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTextArea;

public class adaugare_note extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private String act;
	private int id_local;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adaugare_note frame = new adaugare_note();
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
	public adaugare_note() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 592);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Adaugare note");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(59, 40, 261, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Introduceti materia:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(59, 134, 145, 29);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(243, 134, 183, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnCurs = new JRadioButton("Curs");
		rdbtnCurs.setBackground(new Color(255, 255, 255));
		rdbtnCurs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnCurs.setBounds(59, 208, 103, 21);
		contentPane.add(rdbtnCurs);
		rdbtnCurs.setOpaque(false);
		
		JRadioButton rdbtnSeminar = new JRadioButton("Seminar");
		rdbtnSeminar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnSeminar.setBounds(223, 208, 103, 21);
		contentPane.add(rdbtnSeminar);
		rdbtnSeminar.setOpaque(false);
		
		JRadioButton rdbtnLaborator = new JRadioButton("Laborator");
		rdbtnLaborator.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnLaborator.setBounds(395, 208, 103, 21);
		contentPane.add(rdbtnLaborator);
		rdbtnLaborator.setOpaque(false);
		
		JLabel lblNewLabel_1_1 = new JLabel("Introduceti nume:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(59, 93, 145, 29);
		contentPane.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(243, 96, 183, 26);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Introduceti prenume:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(452, 93, 145, 29);
		contentPane.add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(620, 93, 183, 26);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Introduceti nota:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2.setBounds(59, 278, 145, 29);
		contentPane.add(lblNewLabel_1_1_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(243, 285, 183, 26);
		contentPane.add(textField_3);
		
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
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setBackground(new Color(198, 221, 255));
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect5","root","Taemin1993*");
				
				CallableStatement callableStatement=null;
				
				ResultSet resultSet=null;
				
				String sql="{call adaugare_note(?,?,?,?)}";
				
				
				callableStatement=connection.prepareCall(sql);
				callableStatement.setString(1,act);
				callableStatement.setString(2,textField_1.getText());
				callableStatement.setString(3,textField.getText());
				callableStatement.setInt(4,Integer.parseInt(textField_3.getText()));
				callableStatement.executeQuery();
			 resultSet=callableStatement.getResultSet();
			 JOptionPane.showMessageDialog(null, "introducere realizata:)");
				connection.close();
				//callableStatement.setString(3,textField_1.getText());
				
			}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
		             " Details are provided below:");
		          e2.printStackTrace(System.err);};
			}
		});
		btnEnter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEnter.setBounds(90, 364, 114, 61);
		contentPane.add(btnEnter);
		
		JLabel lblNewLabel_1_2 = new JLabel("Dupa introducerea tuturor notelor ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(603, 208, 238, 43);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("apasati pentru a calcula nota finala :");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBounds(603, 271, 261, 43);
		contentPane.add(lblNewLabel_1_2_1);
		
		JButton btnNotaFinala = new JButton("Nota finala");
		btnNotaFinala.setBackground(new Color(198, 221, 255));
		btnNotaFinala.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\WhatsApp Image 2023-01-11 at 22.31.55.jpg"));
		btnNotaFinala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect5","root","Taemin1993*");
				Statement stmt=connection.createStatement();
				test1 obj=new test1();
				id_local=obj.getId_log();
				String sql1="Select * from cursuri where materie='"+textField.getText()+"'"; 
				ResultSet rs2=stmt.executeQuery(sql1);
				int idc=0;
				if(rs2.next()) 
					idc=rs2.getInt("id");
				String sql="Select * from profesor_curs where id_prof='"+id_local+"' and id_curs='"+idc+"'"; 
				
				String sql3="Select * from utilizator where nume='"+textField_1.getText()+"'"; 
				ResultSet rs4=stmt.executeQuery(sql3);
				int ids=0;
				if(rs4.next())
				  ids=rs4.getInt("id");
				
				String sql2="Select * from inscrieri where id_curs='"+idc+"' and id_student='"+ids+"'"; 
				ResultSet rs3=stmt.executeQuery(sql2);
				int n_c=0,n_s=0,n_l=0;
				if(rs3.next())
				{ n_c=rs3.getInt("nota_curs");
				 n_s=rs3.getInt("nota_seminar");
				 n_l=rs3.getInt("nota_lab");
				}
			     
			    ResultSet rs=stmt.executeQuery(sql);
			    int p_curs=0,p_seminar=0,p_lab=0;
			    if(rs.next())
			    {p_curs=rs.getInt("p_curs");
			     p_seminar=rs.getInt("p_seminar");
			     p_lab=rs.getInt("p_lab");}
			    
			    
			    float nota_finala=(float)(n_c*p_curs+n_s*p_seminar+n_l*p_lab)/100;
			    float cst=(float) 0.5;
			    int nota=(int) (nota_finala+cst);
			    System.out.println(n_c+" "+p_curs+" "+n_s+" "+p_seminar+" "+n_l+" "+p_lab);
			    
			    String sqlSt = "UPDATE inscrieri SET nota_examen_final = "+nota+" WHERE id_curs= '"+idc+"' and id_student='"+ids+"';";
			    Statement stmt2 = connection.createStatement();
				stmt2.executeUpdate(sqlSt);
				
				connection.close();
				}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
			             " Details are provided below:");
			          e2.printStackTrace(System.err);};
			}
		});
		btnNotaFinala.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNotaFinala.setBounds(644, 324, 145, 61);
		contentPane.add(btnNotaFinala);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(198, 221, 255));
		btnBack.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\R.png"));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adaugare_note.this.setVisible(false);
				catalog t=new catalog();
				t.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(754, 490, 110, 43);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBackground(new Color(198, 221, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\Download premium vector of Blank notebook frame on green background vector about frames school, scrapped paper, scrap book, stationery, and scrap book craft 1215742.jpeg"));
		lblNewLabel_2.setBounds(0, 0, 916, 555);
		contentPane.add(lblNewLabel_2);
	}
}
