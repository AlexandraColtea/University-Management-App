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

public class inscriere_grup extends JFrame {

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
					inscriere_grup frame = new inscriere_grup();
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
	public inscriere_grup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 915, 613);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inscriere grup");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(72, 67, 243, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Introduceti materia:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(72, 164, 202, 31);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(234, 164, 162, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.setBackground(new Color(198, 221, 255));
		btnNewButton.addActionListener(new ActionListener() {
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
                String sql3="Select * from grup_de_studiu where materia='"+textField.getText()+"'";
                ResultSet rs2=stmt.executeQuery(sql3);
                int idg=0;
                if(rs2.next())
                {
                	idg=rs2.getInt("id");
                }
           int ids=0;
                if(idc!=0)
                {String sql4="Select inscrieri.id_student from inscrieri,student,utilizator where utilizator.id='"+id_local+
           "'and inscrieri.id_student=student.id_utilizator and inscrieri.id_curs='"+idc
                		+ "'and student.id_utilizator=utilizator.id";
                ResultSet rs3=stmt.executeQuery(sql4);
                if(rs3.next())
                ids=rs3.getInt("id");
                
                if(ids!=0) {
				
				String sql="{call inscriere_grup(?,?,?)}";
				
				callableStatement=connection.prepareCall(sql);
				
				callableStatement.setInt(1,id_local);
				callableStatement.setString(2,textField.getText());
				callableStatement.setInt(3,idg);
				
				callableStatement.execute();
				
				
				JOptionPane.showMessageDialog(null, "Inscriere succes");
                }else JOptionPane.showMessageDialog(null, "Inscrierea nu s-a putut realiza");
                }
                else JOptionPane.showMessageDialog(null, "Inscrierea nu s-a putut realiza");
				connection.close();
				
				
			}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
		             " Details are provided below:");
		          e2.printStackTrace(System.err);};
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(475, 154, 122, 38);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\R.png"));
		btnBack.setBackground(new Color(198, 221, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inscriere_grup.this.setVisible(false);
				grup t=new grup();
				t.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(744, 509, 115, 44);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\Download premium vector of Blank notebook frame on green background vector about frames school, scrapped paper, scrap book, stationery, and scrap book craft 1215742.jpeg"));
		lblNewLabel_2.setBounds(0, 0, 901, 576);
		contentPane.add(lblNewLabel_2);
	}

}
