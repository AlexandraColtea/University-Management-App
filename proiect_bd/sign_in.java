package proiect_bd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument.Content;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
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
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class sign_in extends JFrame {

	private static JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JFrame frame;
	private static int ok=0;
	private int f;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private int nr_min,nr_max,nr_ore,an_studiu;
	//private String departament;
	
	/**
	 * Launch the application.
	 */
 	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sign_in frame = new sign_in();
					frame.setVisible(true);
					JButton btnNewButton_1 = new JButton("<-Back");
					btnNewButton_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//getFrame().dispose();
							//contentPane.setLayout(null);
							//contentPane.get
							
							frame.dispose();
							test1 window = new test1();
							window.getFrame().setVisible(true);
						}
					});
					if(ok==0) {
					btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
					btnNewButton_1.setBounds(657, 631, 89, 21);
					ok++;}
					if(ok==0)
					try {
						contentPane.add(btnNewButton_1);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		}

	/**
	 * Create the frame.
	 */
	public sign_in() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Creaza un cont nou");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(171, 45, 318, 51);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CNP");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(61, 131, 66, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nume");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(61, 172, 102, 31);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Prenume");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(61, 224, 102, 31);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Adresa");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(61, 279, 89, 31);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Telefon");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(61, 335, 66, 31);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("E-mail");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_5.setBounds(61, 397, 66, 31);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("IBAN");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_6.setBounds(61, 449, 66, 31);
		contentPane.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Rol");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_7.setBounds(61, 500, 66, 31);
		contentPane.add(lblNewLabel_1_7);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(269, 131, 243, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(269, 173, 243, 29);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(269, 226, 243, 29);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(269, 280, 243, 29);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_4.setColumns(10);
		textField_4.setBounds(269, 336, 243, 29);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_5.setColumns(10);
		textField_5.setBounds(269, 397, 243, 29);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_6.setColumns(10);
		textField_6.setBounds(269, 451, 243, 29);
		contentPane.add(textField_6);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Administrator");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButton.setBounds(225, 509, 154, 21);
		contentPane.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setOpaque(false);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Profesor");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButton_1.setBounds(409, 509, 154, 21);
		contentPane.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setOpaque(false);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Student");
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButton_2.setBounds(565, 507, 103, 21);
		contentPane.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setOpaque(false);
		
		ButtonGroup bd=new ButtonGroup();
		bd.add(rdbtnNewRadioButton);
		bd.add(rdbtnNewRadioButton_1);
		bd.add(rdbtnNewRadioButton_2);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_7.setBounds(607, 138, 116, 21);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		//textField_7.hide();
		
		
		JLabel lblNewLabel_2 = new JLabel("Numar ore minim");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(607, 98, 128, 13);
		contentPane.add(lblNewLabel_2);
		//lblNewLabel_2.hide();
		
		JLabel lblNewLabel_2_1 = new JLabel("Numar ore maxim");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(781, 100, 134, 13);
		contentPane.add(lblNewLabel_2_1);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_8.setColumns(10);
		textField_8.setBounds(781, 138, 116, 21);
		contentPane.add(textField_8);
		
		JLabel lblNewLabel_2_2 = new JLabel("Departament");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2.setBounds(607, 185, 101, 13);
		contentPane.add(lblNewLabel_2_2);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_9.setColumns(10);
		textField_9.setBounds(607, 218, 116, 21);
		contentPane.add(textField_9);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("An studiu");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2_1.setBounds(607, 269, 101, 13);
		contentPane.add(lblNewLabel_2_2_1);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_10.setColumns(10);
		textField_10.setBounds(607, 298, 116, 21);
		contentPane.add(textField_10);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Numar de ore");
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2_1_1.setBounds(781, 271, 101, 13);
		contentPane.add(lblNewLabel_2_2_1_1);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_11.setColumns(10);
		textField_11.setBounds(781, 298, 116, 21);
		contentPane.add(textField_11);
		textField_7.hide();
		lblNewLabel_2.hide();
		
		textField_8.hide();
		lblNewLabel_2_1.hide();
		
		textField_9.hide();
		lblNewLabel_2_2.hide();
		textField_10.hide();
		lblNewLabel_2_2_1.hide();
		
		textField_11.hide();
		lblNewLabel_2_2_1_1.hide();

		
		//administrator
		rdbtnNewRadioButton.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(rdbtnNewRadioButton.isSelected())
				{
					f=0;
					textField_7.hide();
					lblNewLabel_2.hide();
					
					textField_8.hide();
					lblNewLabel_2_1.hide();
					
					textField_9.hide();
					lblNewLabel_2_2.hide();
					textField_10.hide();
					lblNewLabel_2_2_1.hide();
					
					textField_11.hide();
					lblNewLabel_2_2_1_1.hide();
			
					
				}
				
			}
		});
		
		rdbtnNewRadioButton_1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(rdbtnNewRadioButton_1.isSelected())
				{
					f=1;
					textField_7.show();
					lblNewLabel_2.show();
					textField_8.show();
					lblNewLabel_2_1.show();
					
					textField_9.show();
					lblNewLabel_2_2.show();
					
					textField_10.hide();
					lblNewLabel_2_2_1.hide();
					
					textField_11.hide();
					lblNewLabel_2_2_1_1.hide();
					
					
					
				}
				
			}
		});
		
		rdbtnNewRadioButton_2.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(rdbtnNewRadioButton_2.isSelected())
				{
					f=2;
					textField_7.hide();
					lblNewLabel_2.hide();
					textField_8.hide();
					lblNewLabel_2_1.hide();
					
					textField_9.hide();
					lblNewLabel_2_2.hide();
					
					textField_10.show();
					lblNewLabel_2_2_1.show();
					
					textField_11.show();
					lblNewLabel_2_2_1_1.show();
					
					
				}
				
			}
		});
	
		JButton btnNewButton = new JButton("Creaza cont");
		btnNewButton.setBackground(new Color(198, 221, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect5","root","Taemin1993*");
				
				CallableStatement callableStatement=null;
				ResultSet resultSet=null;
				
				String sql="{call inserare_tabela_utilizator(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
				
				callableStatement=connection.prepareCall(sql);
				
				callableStatement.setInt(1,f);
				callableStatement.setString(2,textField.getText());
				callableStatement.setString(3,textField_1.getText());
				callableStatement.setString(4,textField_2.getText());
				callableStatement.setString(5,textField_3.getText());
				callableStatement.setString(6,textField_4.getText());
				callableStatement.setString(7,textField_5.getText());
				callableStatement.setString(8,textField_6.getText());
				
				if(textField_10.getText().isEmpty())
					callableStatement.setInt(9,0);
				else callableStatement.setInt(9,Integer.parseInt(textField_10.getText()));
				if(textField_11.getText().isEmpty())
					callableStatement.setInt(10,0);
				else callableStatement.setInt(10,Integer.parseInt(textField_11.getText()));
				if(textField_7.getText().isEmpty())
					callableStatement.setInt(11,0);
				else callableStatement.setInt(11,Integer.parseInt(textField_7.getText()));
				if(textField_8.getText().isEmpty())
					callableStatement.setInt(12,0);
				else callableStatement.setInt(12,Integer.parseInt(textField_8.getText()));
				if(textField_9.getText().isEmpty())
					callableStatement.setString(13,"-");
				else callableStatement.setString(13,textField_9.getText());
				
				callableStatement.execute();
				connection.close();
				JOptionPane.showMessageDialog(null,"Contul a fost inregistrat");
				System.out.println("succes");
				
			}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
		             " Details are provided below:");
		          e2.printStackTrace(System.err);};
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(225, 571, 323, 51);
		contentPane.add(btnNewButton);
		
		JButton butonBack = new JButton("Back");
		butonBack.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\R.png"));
		butonBack.setBackground(new Color(198, 221, 255));
		butonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sign_in.this.setVisible(false);
				test1 t=new test1();
				t.getFrame().setVisible(true);
			}
		});
		butonBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		butonBack.setBounds(805, 576, 128, 44);
		contentPane.add(butonBack);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\sign.png"));
		lblNewLabel_4.setBounds(41, 19, 128, 102);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\Download premium vector of Blank notebook frame on green background vector about frames school, scrapped paper, scrap book, stationery, and scrap book craft 1215742.jpeg"));
		lblNewLabel_3.setBounds(-11, 0, 1058, 678);
		contentPane.add(lblNewLabel_3);
	
		
		}

	public JFrame getFrame() {
		return this.frame;
	}
}
