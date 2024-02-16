package proiect_bd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;

public class inscriere_curs extends JFrame {

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
					inscriere_curs frame = new inscriere_curs();
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
	public inscriere_curs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 968, 628);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inscriere curs");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(78, 49, 257, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Introduceti materia:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(78, 170, 146, 31);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(248, 170, 181, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnEnter = new JButton("Inscriere materie");
		btnEnter.setBackground(new Color(198, 221, 255));
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect5","root","Taemin1993*");
				Statement stmt=connection.createStatement();
				CallableStatement callableStatement=null;
				ResultSet resultSet=null;
				test1 obj=new test1();
				id_local=obj.getId_log();
				String sql2="Select * from cursuri where materie='"+textField.getText()+"'";
                ResultSet rs=stmt.executeQuery(sql2);
                int idc=0;
                if(rs.next()) idc=rs.getInt("id");
                if(idc!=0)
                {
				
				String sql="{call inscriere_curs(?,?)}";
				
				callableStatement=connection.prepareCall(sql);
				
				callableStatement.setInt(1,id_local);
				callableStatement.setString(2,textField.getText());
				
				
				callableStatement.execute();
				JOptionPane.showMessageDialog(null, "Inscriere succes");
                }
				
                else JOptionPane.showMessageDialog(null, "Inscrierea nu s-a putut realiza");
				connection.close();
				System.out.println("succes");
				
			}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
		             " Details are provided below:");
		          e2.printStackTrace(System.err);};
			}
		});
		btnEnter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEnter.setBounds(412, 285, 181, 38);
		contentPane.add(btnEnter);
		
		JButton btnBack = new JButton("Back");
		btnBack.setHorizontalAlignment(SwingConstants.LEFT);
		btnBack.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\R.png"));
		btnBack.setBackground(new Color(198, 221, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inscriere_curs.this.setVisible(false);
				student t=new student();
				t.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(791, 530, 109, 31);
		contentPane.add(btnBack);
		
		JButton btnInsc = new JButton("Inscriere activitati materie");
		btnInsc.setBackground(new Color(198, 221, 255));
		btnInsc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect5","root","Taemin1993*");
				Statement stmt=connection.createStatement();
				CallableStatement callableStatement=null;
				ResultSet resultSet=null;
				test1 obj=new test1();
				id_local=obj.getId_log();
				String sql2="Select * from cursuri where materie='"+textField.getText()+"'";
                ResultSet rs=stmt.executeQuery(sql2);
                int idc=0;
                if(rs.next()) idc=rs.getInt("id");
                if(idc!=0)
                {
				
				String sql="{call inscriere_curs(?,?)}";
				
				callableStatement=connection.prepareCall(sql);
				
				callableStatement.setInt(1,id_local);
				callableStatement.setString(2,textField.getText());
				
				
				callableStatement.execute();
				
				
				
				String sql4="Select * from activitati where activitati.id_curs='"+idc
				+"' and activitati.activitate='"+"Curs"+"'";
				ResultSet rs2=stmt.executeQuery(sql4);
				int ida=0;
				if(rs2.next()) {ida=rs2.getInt("id");
				String nume=rs2.getString("activitate");
				String data=rs2.getString("data_act");
				String ora_i=rs2.getString("ora_inceput");
				String ora_sf=rs2.getString("ora_sfarsit");
			  /* String sql3="Select count(*) as count from student_activitate where id_activitati='"+ida+"'";
			   ResultSet rs3=stmt.executeQuery(sql3);
				int nr_s=0;
				if(rs3.next()) nr_s=rs3.getInt("count");*/
				
				
				String sql5="{call inscrirere_activitate_curs(?,?,?,?,?)}";
	
				callableStatement=connection.prepareCall(sql5);
				
				callableStatement.setInt(1,id_local);
				callableStatement.setString(2,nume);
				callableStatement.setString(3,data);
				callableStatement.setString(4,ora_i);
				callableStatement.setString(5,ora_sf);
				
				//callableStatement.execute();
				callableStatement.executeQuery();
				
				
				//JOptionPane.showMessageDialog(null, "Inscriere succes");
                }
				String sql6="Select * from activitati where activitati.id_curs='"+idc
						+"' and activitati.activitate='"+"Seminar"+"'";
						ResultSet rs4=stmt.executeQuery(sql6);
						int ida2=0;
						if(rs4.next()) {ida2=rs4.getInt("id");
						String nume=rs4.getString("activitate");
						String data=rs4.getString("data_act");
						String ora_i=rs4.getString("ora_inceput");
						String ora_sf=rs4.getString("ora_sfarsit");
					  /* String sql3="Select count(*) as count from student_activitate where id_activitati='"+ida+"'";
					   ResultSet rs3=stmt.executeQuery(sql3);
						int nr_s=0;
						if(rs3.next()) nr_s=rs3.getInt("count");*/
						
						
						String sql7="{call inscrirere_activitate_curs(?,?,?,?,?)}";
			
						callableStatement=connection.prepareCall(sql7);
						
						callableStatement.setInt(1,id_local);
						callableStatement.setString(2,nume);
						callableStatement.setString(3,data);
						callableStatement.setString(4,ora_i);
						callableStatement.setString(5,ora_sf);
						
						//callableStatement.execute();
						callableStatement.executeQuery();
						//JOptionPane.showMessageDialog(null, "Inscriere succes");
		                }
						String sql8="Select * from activitati where activitati.id_curs='"+idc
								+"' and activitati.activitate='"+"Laborator"+"'";
								ResultSet rs7=stmt.executeQuery(sql8);
								int ida3=0;
								if(rs7.next()) {ida3=rs7.getInt("id");
								String nume=rs7.getString("activitate");
								String data=rs7.getString("data_act");
								String ora_i=rs7.getString("ora_inceput");
								String ora_sf=rs7.getString("ora_sfarsit");
							  /* String sql3="Select count(*) as count from student_activitate where id_activitati='"+ida+"'";
							   ResultSet rs3=stmt.executeQuery(sql3);
								int nr_s=0;
								if(rs3.next()) nr_s=rs3.getInt("count");*/
								
								
								String sql9="{call inscrirere_activitate_curs(?,?,?,?,?)}";
					
								callableStatement=connection.prepareCall(sql9);
								
								callableStatement.setInt(1,id_local);
								callableStatement.setString(2,nume);
								callableStatement.setString(3,data);
								callableStatement.setString(4,ora_i);
								callableStatement.setString(5,ora_sf);
								
								//callableStatement.execute();
								callableStatement.executeQuery();
								
								
								
				                }JOptionPane.showMessageDialog(null, "Inscriere succes");
                }
                else JOptionPane.showMessageDialog(null, "Inscrierea nu s-a putut realiza");
				connection.close();
				System.out.println("succes");
				
			}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
		             " Details are provided below:");
		          e2.printStackTrace(System.err);};
			}
		});
		btnInsc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnInsc.setBounds(97, 285, 262, 38);
		contentPane.add(btnInsc);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\Download premium vector of Blank notebook frame on green background vector about frames school, scrapped paper, scrap book, stationery, and scrap book craft 1215742.jpeg"));
		lblNewLabel_2.setBounds(0, 0, 954, 591);
		contentPane.add(lblNewLabel_2);
	}
}
