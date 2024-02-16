package proiect_bd;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;

public class inscriere_act extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private int id_local;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inscriere_act frame = new inscriere_act();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
private void tableMouseClicked(java.awt.event.MouseEvent evt) {                                     
        
        // get the model from the jtable
       DefaultTableModel model = (DefaultTableModel)table.getModel();

        // get the selected row index
       int selectedRowIndex = table.getSelectedRow();
       
        // set the selected row data into jtextfields
       textField_1.setText(model.getValueAt(selectedRowIndex, 0).toString());
       textField_2.setText(model.getValueAt(selectedRowIndex, 1).toString());
       textField_3.setText(model.getValueAt(selectedRowIndex, 2).toString());
       textField_4.setText(model.getValueAt(selectedRowIndex, 3).toString());
        
    } 
	/**
	 * Create the frame.
	 */
	public inscriere_act() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inscriere activitate");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(70, 51, 228, 38);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(70, 175, 380, 307);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Introduceti materia:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(70, 122, 157, 25);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(249, 121, 170, 25);
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
				String sql1="Select * from cursuri where materie='"+textField.getText()+"'";
			    resultSet=stmt.executeQuery(sql1);
			    
			    int idc=0;
			    if(resultSet.next())
			    {
			    	idc=resultSet.getInt("id");
			    }
				
				String sql3="Select activitate,data_act,ora_inceput,ora_sfarsit from activitati where id_curs='"+idc+"'";
				PreparedStatement ps=connection.prepareStatement(sql3);
				ResultSet rs=ps.executeQuery();
		        table.setModel(DbUtils.resultSetToTableModel(rs));
			
				connection.close();
				//callableStatement.setString(3,textField_1.getText());
				
			}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
		             " Details are provided below:");
		          e2.printStackTrace(System.err);};
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(480, 120, 122, 27);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Nume");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(480, 176, 85, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Data");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(480, 235, 85, 21);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Ora inceput");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2.setBounds(480, 294, 85, 21);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Ora sfarsit");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_3.setBounds(480, 352, 85, 21);
		contentPane.add(lblNewLabel_2_3);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(480, 200, 170, 25);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(480, 266, 170, 25);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(480, 325, 170, 25);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(480, 375, 170, 25);
		contentPane.add(textField_4);
		
		JButton btnParticip = new JButton("Particip");
		btnParticip.setBackground(new Color(198, 221, 255));
		btnParticip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect5","root","Taemin1993*");
				Statement stmt=connection.createStatement(); 
				CallableStatement callableStatement=null;
				test1 obj=new test1();
				id_local=obj.getId_log();
				
				ResultSet resultSet=null;
				String sql2="Select id from activitati,student_activitate where( (activitati.ora_inceput>='"+textField_3.getText()
				+"' and activitati.ora_inceput<='"+textField_4.getText()+"') or (activitati.ora_sfarsit>='"+textField_3.getText()
				+"' and activitati.ora_sfarsit<='"+textField_4.getText()+"')) and weekday(activitati.data_act)=weekday('"+textField_2.getText()
				+"') and activitati.id=student_activitate.id_activitati and student_activitate.id_student='"+id_local+"'";
				ResultSet rs2=stmt.executeQuery(sql2);
				if(rs2.next())
				{
					int a=rs2.getInt("id");
					System.out.println(a);
					JOptionPane.showMessageDialog(null, "Inscrierea nu s-a putut realiza. Suprapunere");
				}
				else {
				String sql="{call inscrirere_activitate_curs(?,?,?,?,?)}";
	
				callableStatement=connection.prepareCall(sql);
				
			
				callableStatement.setInt(1,id_local);
				callableStatement.setString(2,textField_1.getText());
				callableStatement.setString(3,textField_2.getText());
				callableStatement.setString(4,textField_3.getText());
				callableStatement.setString(5,textField_4.getText());
				
				//callableStatement.execute();
				callableStatement.executeQuery();
				ResultSet rs3=callableStatement.getResultSet();
				if(rs3!=null)
				{
					JOptionPane.showMessageDialog(null, "Activitate plina");
				}
				else JOptionPane.showMessageDialog(null, "Inscriere cu succes");
				}
				connection.close();
				//callableStatement.setString(3,textField_1.getText());
				
			}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
		             " Details are provided below:");
		          e2.printStackTrace(System.err);};
			}
		});
		btnParticip.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnParticip.setBounds(480, 436, 122, 38);
		contentPane.add(btnParticip);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(198, 221, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inscriere_act.this.setVisible(false);
				student t=new student();
				t.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(666, 486, 108, 38);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\Download premium vector of Blank notebook frame on green background vector about frames school, scrapped paper, scrap book, stationery, and scrap book craft 1215742.jpeg"));
		lblNewLabel_3.setBounds(0, 0, 852, 567);
		contentPane.add(lblNewLabel_3);
	}

}
