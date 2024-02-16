package proiect_bd;

import java.awt.EventQueue;
import java.util.Timer;
import java.util.TimerTask;

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
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;



public class creare_activitate extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private int id_local;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					creare_activitate frame = new creare_activitate();
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
	public creare_activitate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 874, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Creare activitate");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(67, 38, 225, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Materia:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(67, 133, 114, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Denumire:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(67, 181, 114, 24);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Data si ora:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(67, 233, 114, 24);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Numar participanti:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(67, 284, 150, 24);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Durata activitatii:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(67, 342, 114, 24);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Perioada de expirare:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_5.setBounds(67, 389, 150, 24);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Nume profesor (optional):");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_6.setBounds(67, 448, 192, 24);
		contentPane.add(lblNewLabel_1_6);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(269, 133, 173, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(269, 181, 173, 24);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(269, 233, 173, 24);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(269, 284, 173, 24);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(269, 342, 173, 24);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_5.setColumns(10);
		textField_5.setBounds(269, 394, 173, 24);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_6.setColumns(10);
		textField_6.setBounds(269, 453, 173, 24);
		contentPane.add(textField_6);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.setBackground(new Color(198, 221, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect5","root","Taemin1993*");
				
				CallableStatement callableStatement=null;
				
				ResultSet resultSet=null;
				
				String sql="{call creare_activitate(?,?,?,?,?,?,?)}";
				
		
				
				
				callableStatement=connection.prepareCall(sql);
				String t1=textField_2.getText();
				t1+=":01";
				String t2=textField_4.getText();
				t2+=":01";
				String t3=textField_5.getText();
				t3+=":01";
				
				test1 obj=new test1();
				id_local=obj.getId_log();
				callableStatement.setString(1,textField.getText());
				callableStatement.setString(2,textField_1.getText());
				callableStatement.setString(3,t1);
				callableStatement.setInt(4,Integer.parseInt(textField_3.getText()));
				callableStatement.setString(5,t2);
				callableStatement.setString(6,t3);
				callableStatement.setString(7,textField_6.getText());
				//callableStatement.execute();
				callableStatement.executeQuery();
			 resultSet=callableStatement.getResultSet();
			 if(resultSet==null) {
			    
				 JOptionPane.showMessageDialog(null, "Creare cu succes!");
			   }
			 
			 TimerTask cl=new CleanUpTimerTask(textField.getText(),id_local,t1);
			 Timer timer=new Timer();
			
			 String x=t3.substring(0, 2);
			 int y=Integer.parseInt(x);
			 String x2=t3.substring(3,5 );
			 int y2=Integer.parseInt(x2);
			 long l1=y*3600000;
			 long l2=y2*60000;
			 timer.schedule(cl,l1+l2 );
			 System.out.println(x+" "+x2+" "+y+" "+y2);
				connection.close();
				//callableStatement.setString(3,textField_1.getText());
				
			}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
		             " Details are provided below:");
		          e2.printStackTrace(System.err);};
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(580, 259, 107, 50);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\R.png"));
		btnBack.setBackground(new Color(198, 221, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				creare_activitate.this.setVisible(false);
				grup t=new grup();
				t.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(674, 499, 139, 44);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\Download premium vector of Blank notebook frame on green background vector about frames school, scrapped paper, scrap book, stationery, and scrap book craft 1215742.jpeg"));
		lblNewLabel_2.setBounds(0, 0, 865, 577);
		contentPane.add(lblNewLabel_2);
	}
}
