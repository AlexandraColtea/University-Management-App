package proiect_bd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class filtrare_studenti_cursuri extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private int id_local ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					filtrare_studenti_cursuri frame = new filtrare_studenti_cursuri();
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
	public filtrare_studenti_cursuri() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 879, 605);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Studenti inscrisi la cursul de:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(69, 46, 328, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Introduceti materia:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(69, 148, 143, 25);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(288, 148, 176, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 194, 546, 264);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setBackground(new Color(198, 221, 255));
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect5","root","Taemin1993*");
				
				CallableStatement callableStatement=null;
				
				ResultSet resultSet=null;
				
				String sql="{call afisare_studenti_curs(?,?)}";
				
				test1 obj=new test1();
				id_local=obj.getId_log();
				callableStatement=connection.prepareCall(sql);
				callableStatement.setString(1,textField.getText());
				callableStatement.setInt(2,id_local);
				callableStatement.executeQuery();
			 resultSet=callableStatement.getResultSet();
			 String total="Catalog: \n";
			 while(resultSet.next()) {
				    String re=resultSet.getString("nume");
				    String re2=resultSet.getString("prenume");
				    int nc=resultSet.getInt("nota_curs");
				    int ns=resultSet.getInt("nota_seminar");
				    int nl=resultSet.getInt("nota_lab");
				    int ne=resultSet.getInt("nota_examen_final");
				   
				   total+=re;
				   total+=" ";
				   total+=re2;
				   total+=" nota curs: ";
				   total+=nc;
				   total+=" nota seminar: ";
				   total+=ns;
				   total+=" nota lab: ";
				   total+=nl;
				   total+=" nota finala: ";
				   total+=ne;
				   total+="\n";
			 }
			 textArea.setText(total);
				connection.close();
				//callableStatement.setString(3,textField_1.getText());
				
			}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
		             " Details are provided below:");
		          e2.printStackTrace(System.err);};
			}
		});
		btnEnter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEnter.setBounds(584, 144, 127, 33);
		contentPane.add(btnEnter);
		
		
		
		JButton btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\R.png"));
		btnBack.setBackground(new Color(198, 221, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtrare_studenti_cursuri.this.setVisible(false);
				catalog t=new catalog();
				t.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(598, 483, 126, 54);
		contentPane.add(btnBack);
		
		JButton btnDownload = new JButton("Download catalog");
		btnDownload.setBackground(new Color(198, 221, 255));
		btnDownload.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\img_71049.png"));
		btnDownload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					FileWriter writer=new FileWriter("D:\\Catalog.txt");
					BufferedWriter bw=new BufferedWriter(writer);
					textArea.write(bw);
					bw.close();
					JOptionPane.showMessageDialog(null,"Catalog descarcat");
					
			}catch(Exception e2)
				{
				JOptionPane.showMessageDialog(null, e2);
				}}});
		btnDownload.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDownload.setBounds(624, 275, 212, 66);
		contentPane.add(btnDownload);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\imagini proiect\\Download premium vector of Blank notebook frame on green background vector about frames school, scrapped paper, scrap book, stationery, and scrap book craft 1215742.jpeg"));
		lblNewLabel_2.setBounds(0, 0, 934, 568);
		contentPane.add(lblNewLabel_2);
	}
}
