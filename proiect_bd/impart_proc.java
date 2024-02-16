package proiect_bd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;

public class impart_proc extends JFrame {

	private JPanel contentPane;
	private  int id_local;
	private int idc;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					impart_proc frame = new impart_proc();
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
	public impart_proc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 964, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Introduceti materia:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(62, 45, 149, 25);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(241, 34, 192, 35);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\R.png"));
		btnBack.setBackground(new Color(198, 221, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				impart_proc.this.setVisible(false);
				profesor t=new profesor();
				t.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(772, 444, 118, 53);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel_1 = new JLabel("Curs");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(62, 146, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Seminar");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(62, 198, 85, 25);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Laborator");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(62, 254, 85, 25);
		contentPane.add(lblNewLabel_1_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setBounds(178, 139, 136, 25);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(178, 198, 136, 25);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(178, 259, 136, 25);
		contentPane.add(textField_3);
		
		
		
		textField_1.hide();
		textField_2.hide();
		textField_3.hide();
		lblNewLabel_1.hide();
		lblNewLabel_1_1.hide();
		lblNewLabel_1_2 .hide();
		
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setBackground(new Color(198, 221, 255));
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect5","root","Taemin1993*");
				Statement stmt=connection.createStatement();
			    idc=0;
				test1 obj=new test1();
				id_local=obj.getId_log();
				String sql="Select * from cursuri where materie='"+textField.getText()+"'";
                ResultSet rs=stmt.executeQuery(sql);
                if(rs.next())
				{    idc=rs.getInt("id");
				System.out.println(idc);
				System.out.println(id_local);
				
				}
                CallableStatement callableStatement=null;
				ResultSet resultSet=null;
				
				String sql2="{call vizualizare_cursuri_pt_prof(?,?)}";
				
				callableStatement=connection.prepareCall(sql2);
				
				
				callableStatement.setInt(1,id_local);
				callableStatement.setInt(2,idc);
				
				
				
				callableStatement.execute();
				resultSet=callableStatement.getResultSet();
			    
				if(resultSet!=null)
				{
					int p_curs=0,p_seminar=0,p_lab=0;
					String sql3="Select * from profesor_curs where id_prof='"+id_local+"' and id_curs='"+idc+"'";
					ResultSet rs2=stmt.executeQuery(sql3);
					if(rs2.next())
					{    p_curs=rs2.getInt("p_curs");
					p_seminar=rs2.getInt("p_seminar");
					p_lab=rs2.getInt("p_lab");
					
					}
					if(p_curs!=0)
					{textField_1.show();
					
					lblNewLabel_1.show();
					}
					
					if(p_seminar!=0)
					{
					textField_2.show();
					
					lblNewLabel_1_1.show();
					}
					
					if(p_lab!=0)
					{
					textField_3.show();
					
					lblNewLabel_1_2 .show();}
					
				}
				
				connection.close();
			}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
		             " Details are provided below:");
		          e2.printStackTrace(System.err);};
			}
		});
		
		JButton btnNewButton = new JButton("Setati procentul");
		btnNewButton.setBackground(new Color(198, 221, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect5","root","Taemin1993*");
				
				CallableStatement callableStatement=null;
				ResultSet resultSet=null;
				
				String sql="{call update_procente(?,?,?,?,?)}";
				
				callableStatement=connection.prepareCall(sql);
				
				
				callableStatement.setInt(1,idc);
				callableStatement.setInt(2,id_local);
				if(textField_1.getText().isEmpty()==false)
				  callableStatement.setInt(3,Integer.parseInt(textField_1.getText()));
				else callableStatement.setInt(3,0);
				if(textField_2.getText().isEmpty()==false)
					  callableStatement.setInt(4,Integer.parseInt(textField_2.getText()));
					else callableStatement.setInt(4,0);
				if(textField_3.getText().isEmpty()==false)
					  callableStatement.setInt(5,Integer.parseInt(textField_3.getText()));
					else callableStatement.setInt(5,0);
				
				
				
				callableStatement.execute();
				resultSet=callableStatement.getResultSet();
				//if(resultSet!=null)
				JOptionPane.showMessageDialog(null, "Modificare cu succes!");
				//else JOptionPane.showMessageDialog(null, "Modificare imposibila!");
				connection.close();
				
				
			}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
		             " Details are provided below:");
		          e2.printStackTrace(System.err);};
			}
		});
		btnEnter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEnter.setBounds(502, 34, 100, 36);
		contentPane.add(btnEnter);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(109, 362, 192, 63);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\Download premium vector of Blank notebook frame on green background vector about frames school, scrapped paper, scrap book, stationery, and scrap book craft 1215742.jpeg"));
		lblNewLabel_2.setBounds(0, 0, 977, 541);
		contentPane.add(lblNewLabel_2);
		
	}

}
