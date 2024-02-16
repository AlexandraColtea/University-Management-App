package proiect_bd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import net.proteanit.sql.DbUtils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
public class inscriere_act_grup extends JFrame {
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
					inscriere_act_grup frame = new inscriere_act_grup();
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
	public inscriere_act_grup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 918, 629);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(73, 198, 465, 261);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
				
			}
		});
		
		
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Inscriere activitate");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(97, 45, 206, 31);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Introduceti materia:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(97, 126, 150, 31);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(257, 126, 174, 27);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.setBackground(new Color(198, 221, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect5","root","Taemin1993*");
				
				CallableStatement callableStatement=null;
				
				ResultSet resultSet=null;
				
				String denumireAct="Pregatire "+textField.getText();
				
				String sql3="Select nume,data_activitate,durata_activitate,timp_expirare from activitate_grup where nume='"+denumireAct+"'";
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
		btnNewButton.setBounds(492, 126, 97, 28);
		getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.setHorizontalAlignment(SwingConstants.LEFT);
		btnBack.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\R.png"));
		btnBack.setBackground(new Color(198, 221, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inscriere_act_grup.this.setVisible(false);
				grup t=new grup();
				t.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(742, 513, 115, 39);
		getContentPane().add(btnBack);
		
		JLabel lblNewLabel_2 = new JLabel("Nume");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(580, 200, 85, 21);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Data si ora");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(580, 260, 85, 21);
		getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Durata activitate");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2.setBounds(580, 325, 123, 21);
		getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Timp de expirare");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_3.setBounds(580, 379, 123, 21);
		getContentPane().add(lblNewLabel_2_3);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setBounds(580, 223, 161, 27);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(580, 291, 161, 27);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(580, 345, 161, 27);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(580, 403, 161, 27);
		getContentPane().add(textField_4);
		
		JButton btnParticipa = new JButton("Participa");
		btnParticipa.setBackground(new Color(198, 221, 255));
		btnParticipa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect5","root","Taemin1993*");
				
				CallableStatement callableStatement=null;
				
				ResultSet resultSet=null;
				
				String sql="{call inscriere_activitate_grup(?,?,?,?,?)}";
	
				callableStatement=connection.prepareCall(sql);
				
				test1 obj=new test1();
				id_local=obj.getId_log();
				callableStatement.setInt(1,id_local);
				callableStatement.setString(2,textField_1.getText());
				callableStatement.setString(3,textField_3.getText());
				callableStatement.setString(4,textField_2.getText());
				callableStatement.setString(5,textField_4.getText());
				
				//callableStatement.execute();
				callableStatement.executeQuery();
				JOptionPane.showMessageDialog(null, "Inscriere cu succes");
				
				connection.close();
				//callableStatement.setString(3,textField_1.getText());
				
			}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
		             " Details are provided below:");
		          e2.printStackTrace(System.err);};
			}
		});
		btnParticipa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnParticipa.setBounds(580, 453, 123, 39);
		getContentPane().add(btnParticipa);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\Download premium vector of Blank notebook frame on green background vector about frames school, scrapped paper, scrap book, stationery, and scrap book craft 1215742.jpeg"));
		lblNewLabel_3.setBounds(0, 0, 904, 592);
		getContentPane().add(lblNewLabel_3);
	}
      
}
