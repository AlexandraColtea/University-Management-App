package proiect_bd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
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
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class modificari_utilizatori extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private int id;
	private int f;
	private String loc;
	private String val;
	private String val2;
	private String val3;
	private String val4;
	private String val5;
	private String val6;
	private String val7;
	private int vaInt;
	private int vaInt2;
	private int vaInt3;
	private int vaInt4;
	private int absInt=0;
	private String absString="";
	private int id_local;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modificari_utilizatori frame = new modificari_utilizatori();
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
	public modificari_utilizatori() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 975, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update user");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(47, 23, 147, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nume:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(234, 34, 83, 17);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Prenume:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(521, 38, 83, 17);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(304, 23, 164, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(603, 23, 164, 34);
		contentPane.add(textField_1);
		
		JRadioButton rdbtnNume = new JRadioButton("Nume");
		rdbtnNume.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNume.setBounds(49, 82, 103, 21);
		contentPane.add(rdbtnNume);
		rdbtnNume.setOpaque(false);
		
		JRadioButton rdbtnPrenume = new JRadioButton("Prenume");
		rdbtnPrenume.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnPrenume.setBounds(49, 116, 103, 21);
		contentPane.add(rdbtnPrenume);
		rdbtnPrenume.setOpaque(false);
		
		JRadioButton rdbtnTelefon = new JRadioButton("Telefon");
		rdbtnTelefon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnTelefon.setBounds(49, 150, 103, 21);
		contentPane.add(rdbtnTelefon);
		rdbtnTelefon.setOpaque(false);
		
		JRadioButton rdbtnAdresa = new JRadioButton("Adresa");
		rdbtnAdresa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnAdresa.setBounds(49, 185, 103, 21);
		contentPane.add(rdbtnAdresa);
		rdbtnAdresa.setOpaque(false);
		
		JRadioButton rdbtnEmail = new JRadioButton("Email");
		rdbtnEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnEmail.setBounds(49, 219, 103, 21);
		contentPane.add(rdbtnEmail);
		rdbtnEmail.setOpaque(false);
		
		JRadioButton rdbtnIban = new JRadioButton("IBAN");
		rdbtnIban.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnIban.setBounds(49, 253, 103, 21);
		contentPane.add(rdbtnIban);
		rdbtnIban.setOpaque(false);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_2.setBounds(166, 84, 136, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_3.setColumns(10);
		textField_3.setBounds(166, 118, 136, 19);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_4.setColumns(10);
		textField_4.setBounds(166, 152, 136, 19);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_5.setColumns(10);
		textField_5.setBounds(166, 187, 136, 19);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_6.setColumns(10);
		textField_6.setBounds(166, 221, 136, 19);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_7.setColumns(10);
		textField_7.setBounds(166, 250, 136, 19);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_8.setBounds(539, 84, 147, 19);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_9.setColumns(10);
		textField_9.setBounds(539, 118, 147, 19);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_10.setColumns(10);
		textField_10.setBounds(539, 152, 147, 19);
		contentPane.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_11.setColumns(10);
		textField_11.setBounds(539, 221, 147, 19);
		contentPane.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_12.setColumns(10);
		textField_12.setBounds(539, 255, 147, 19);
		contentPane.add(textField_12);
		
		textField_2.hide();
		textField_3.hide();
		textField_4.hide();
		textField_5.hide();
		textField_6.hide();
		textField_7.hide();
		textField_8.hide();
		textField_9.hide();
		textField_10.hide();
		textField_11.hide();
		textField_12.hide();
		
		JRadioButton rdbtnMin = new JRadioButton("Nr_ore_min");
		rdbtnMin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnMin.setBounds(430, 83, 103, 21);
		contentPane.add(rdbtnMin);
		rdbtnMin.setOpaque(false);
		
		JRadioButton rdbtnMax = new JRadioButton("Nr_ore_max");
		rdbtnMax.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnMax.setBounds(430, 117, 103, 21);
		contentPane.add(rdbtnMax);
		rdbtnMax.setOpaque(false);
		
		JRadioButton rdbtnDep = new JRadioButton("Departament");
		rdbtnDep.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnDep.setBounds(430, 151, 103, 21);
		contentPane.add(rdbtnDep);
		rdbtnDep.setOpaque(false);
		
		
		JRadioButton rdbtnAn = new JRadioButton("An studiu");
		rdbtnAn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnAn.setBounds(430, 220, 103, 21);
		contentPane.add(rdbtnAn);
		rdbtnAn.setOpaque(false);
		
		JRadioButton rdbtnOre = new JRadioButton("Nr_ore");
		rdbtnOre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnOre.setBounds(430, 254, 103, 21);
		contentPane.add(rdbtnOre);
		rdbtnOre.setOpaque(false);
		
		ButtonGroup bd=new ButtonGroup();
		bd.add(rdbtnAn);
		bd.add(rdbtnOre);
		bd.add(rdbtnMin);
		bd.add(rdbtnMax);
		bd.add(rdbtnNume);
		bd.add(rdbtnPrenume);
		bd.add(rdbtnAdresa);
		bd.add(rdbtnIban);
		bd.add(rdbtnEmail);
		bd.add(rdbtnTelefon);
		bd.add(rdbtnDep);
		
		
		rdbtnAn.hide();
		rdbtnOre.hide();
		rdbtnMin.hide();
		rdbtnMax.hide();
		rdbtnDep.hide();
		
		JButton btnNewButton = new JButton("Enter Name");
		btnNewButton.setBackground(new Color(198, 221, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect5","root","Taemin1993*");
				Statement stmt=connection.createStatement();
				String sql="Select * from utilizator where nume='"+textField.getText()+"' and prenume='"+textField_1.getText()+"'"; 
			     
			    ResultSet rs=stmt.executeQuery(sql);
			    if(rs.next()) {
			    id=rs.getInt("id");
			    f=rs.getInt("functie");
			    
				if(f==1)
				{
					rdbtnAn.hide();
					rdbtnOre.hide();
					rdbtnMin.show();
					rdbtnMax.show();
					rdbtnDep.show();
				}
				else
				{
					if(f==2)
					{
						rdbtnAn.show();
						rdbtnOre.show();
						rdbtnMin.hide();
						rdbtnMax.hide();
						rdbtnDep.hide();
					}
				}}
				connection.close();
				}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
			             " Details are provided below:");
			          e2.printStackTrace(System.err);};
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(793, 23, 147, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\R.png"));
		btnNewButton_1.setBackground(new Color(198, 221, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificari_utilizatori.this.setVisible(false);
				admin_1 t=new admin_1();
				t.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(825, 439, 115, 42);
		contentPane.add(btnNewButton_1);

		rdbtnNume.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(rdbtnNume.isSelected())
				{
					
					loc="nume";
					textField_2.show();
					textField_3.hide();
					textField_4.hide();
					textField_5.hide();
					textField_6.hide();
					textField_7.hide();
					textField_8.hide();
					textField_9.hide();
					textField_10.hide();
					textField_11.hide();
					textField_12.hide();
			}
				
			}
		});
		
		rdbtnPrenume.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(rdbtnPrenume.isSelected())
				{
					
					loc="prenume";
					textField_2.hide();
					textField_3.show();
					textField_4.hide();
					textField_5.hide();
					textField_6.hide();
					textField_7.hide();
					textField_8.hide();
					textField_9.hide();
					textField_10.hide();
					textField_11.hide();
					textField_12.hide();
				
			}
				
			}
		});
		
		rdbtnAdresa.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(rdbtnAdresa.isSelected())
				{
				
					loc="adresa";
					textField_2.hide();
					textField_3.hide();
					textField_4.hide();
					textField_5.show();
					textField_6.hide();
					textField_7.hide();
					textField_8.hide();
					textField_9.hide();
					textField_10.hide();
					textField_11.hide();
					textField_12.hide();
			}
				
			}
		});
		
		rdbtnTelefon.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(rdbtnTelefon.isSelected())
				{
					loc="telefon";
					textField_2.hide();
					textField_3.hide();
					textField_4.show();
					textField_5.hide();
					textField_6.hide();
					textField_7.hide();
					textField_8.hide();
					textField_9.hide();
					textField_10.hide();
					textField_11.hide();
					textField_12.hide();
			}
				
			}
		});
		
		rdbtnEmail.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(rdbtnEmail.isSelected())
				{
					
					loc="email";
					textField_2.hide();
					textField_3.hide();
					textField_4.hide();
					textField_5.hide();
					textField_6.show();
					textField_7.hide();
					textField_8.hide();
					textField_9.hide();
					textField_10.hide();
					textField_11.hide();
					textField_12.hide();
			}
				
			}
		});
		
		rdbtnIban.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(rdbtnIban.isSelected())
				{
					loc="iban";
					textField_2.hide();
					textField_3.hide();
					textField_4.hide();
					textField_5.hide();
					textField_6.hide();
					textField_7.show();
					textField_8.hide();
					textField_9.hide();
					textField_10.hide();
					textField_11.hide();
					textField_12.hide();
			}
				
			}
		});
		
		rdbtnMin.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(rdbtnMin.isSelected())
				{
					loc="nr_min_ore";
					textField_2.hide();
					textField_3.hide();
					textField_4.hide();
					textField_5.hide();
					textField_6.hide();
					textField_7.hide();
					textField_8.show();
					textField_9.hide();
					textField_10.hide();
					textField_11.hide();
					textField_12.hide();
			}
				
			}
		});
		
		rdbtnMax.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(rdbtnMax.isSelected())
				{
					
					loc="nr_max_ore";
					textField_2.hide();
					textField_3.hide();
					textField_4.hide();
					textField_5.hide();
					textField_6.hide();
					textField_7.hide();
					textField_8.hide();
					textField_9.show();
					textField_10.hide();
					textField_11.hide();
					textField_12.hide();
			}
				
			}
		});
		
		rdbtnDep.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(rdbtnDep.isSelected())
				{
					
					loc="departament";
					textField_2.hide();
					textField_3.hide();
					textField_4.hide();
					textField_5.hide();
					textField_6.hide();
					textField_7.hide();
					textField_8.hide();
					textField_9.hide();
					textField_10.show();
					textField_11.hide();
					textField_12.hide();
					
			}
				
			}
		});
		
		rdbtnAn.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(rdbtnAn.isSelected())
				{
					
					loc="an_studiu";
					textField_2.hide();
					textField_3.hide();
					textField_4.hide();
					textField_5.hide();
					textField_6.hide();
					textField_7.hide();
					textField_8.hide();
					textField_9.hide();
					textField_10.hide();
					textField_11.show();
					textField_12.hide();
					
			}
				
			}
		});
		
		rdbtnOre.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(rdbtnOre.isSelected())
				{
					
					loc="nr_ore";
					textField_2.hide();
					textField_3.hide();
					textField_4.hide();
					textField_5.hide();
					textField_6.hide();
					textField_7.hide();
					textField_8.hide();
					textField_9.hide();
					textField_10.hide();
					textField_11.hide();
					textField_12.show();
					
			}
				
			}
		});
		
		JButton btnNewButton_3 = new JButton("Enter new data");
		btnNewButton_3.setBackground(new Color(198, 221, 255));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_8.getText().isEmpty()==false)
				{absInt=Integer.parseInt(textField_8.getText());
				textField_8.setText("");}
				else if(textField_9.getText().isEmpty()==false)
					{absInt=Integer.parseInt(textField_9.getText());
					textField_9.setText("");}
				else if(textField_11.getText().isEmpty()==false)
					{absInt=Integer.parseInt(textField_11.getText());
					textField_11.setText("");}
				else if(textField_12.getText().isEmpty()==false)
					{absInt=Integer.parseInt(textField_12.getText());
					textField_12.setText("");}
				else if(textField_2.getText().isEmpty()==false)
				{absString=textField_2.getText();
				textField_2.setText("");}
				else if(textField_3.getText().isEmpty()==false)
				{absString=textField_3.getText();
				textField_3.setText("");}
				else if(textField_4.getText().isEmpty()==false)
					{absString=textField_4.getText();
					textField_4.setText("");}
				else if(textField_5.getText().isEmpty()==false)
					{absString=textField_5.getText();
					textField_5.setText("");}
				else if(textField_6.getText().isEmpty()==false)
					{absString=textField_6.getText();
					textField_6.setText("");}
				else if(textField_7.getText().isEmpty()==false)
					{absString=textField_7.getText();
					textField_7.setText("");}
				else if(textField_10.getText().isEmpty()==false)
					{absString=textField_10.getText();
					textField_10.setText("");}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.setBounds(776, 177, 164, 34);
		contentPane.add(btnNewButton_3);
		
		
		
		JButton btnNewButton_2 = new JButton("Modificare date");
		btnNewButton_2.setBackground(new Color(198, 221, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect5","root","Taemin1993*");
				Statement stmt=connection.createStatement();
				CallableStatement callableStatement=null;
				ResultSet resultSet=null;
				test1 obj=new test1();
				id_local=obj.getId_log();
				String sql3="Select * from utilizator where id='"+id_local+"'";
				ResultSet rs2=stmt.executeQuery(sql3);
				int func=0;
				if(rs2.next())
				{
					func=rs2.getInt("functie");
				}
				if(f!=0 && f!=3)
				
				{String sql="{call update_utilizator(?,?,?,?)}";
				
				callableStatement=connection.prepareCall(sql);
				
				
				callableStatement.setInt(1,id);
				callableStatement.setString(2,loc);
				callableStatement.setString(3,absString);
				callableStatement.setInt(4,absInt);
				
				
				
				callableStatement.execute();
				resultSet=callableStatement.getResultSet();
				//if(resultSet!=null)
				JOptionPane.showMessageDialog(null, "Modificare facuta cu succes!");
				}
				else if(func==3)
					{String sql="{call update_utilizator(?,?,?,?)}";
					
					callableStatement=connection.prepareCall(sql);
					
					
					callableStatement.setInt(1,id);
					callableStatement.setString(2,loc);
					callableStatement.setString(3,absString);
					callableStatement.setInt(4,absInt);
					
					
					
					callableStatement.execute();
					resultSet=callableStatement.getResultSet();
					//if(resultSet!=null)
					JOptionPane.showMessageDialog(null, "Modificare facuta cu succes!");
					}
				else JOptionPane.showMessageDialog(null, "Modificare imposibila!");
				connection.close();
				
				
			}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
		             " Details are provided below:");
		          e2.printStackTrace(System.err);};
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBounds(148, 370, 235, 42);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\Download premium vector of Blank notebook frame on green background vector about frames school, scrapped paper, scrap book, stationery, and scrap book craft 1215742.jpeg"));
		lblNewLabel_2.setBounds(0, 0, 994, 509);
		contentPane.add(lblNewLabel_2);
		
		
		
		
	}

}
