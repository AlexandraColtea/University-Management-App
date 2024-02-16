package proiect_bd;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

public class CleanUpTimerTask extends TimerTask{
	public CleanUpTimerTask(String materie,int id_local,String data_act) {
		super();
		this.materie = materie;
		this.id_local=id_local;
		this.data_act=data_act;
	}

	private String materie;
	private int id_local;
	private String data_act;
	
	public void run() {
		
		
          
          try {Class.forName("com.mysql.jdbc.Driver");
  		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect5","root","Taemin1993*");
  		Statement stmt=connection.createStatement();
  		
  		String sql="Select * from grup_de_studiu where materia='"+this.materie+"'";
        ResultSet rs=stmt.executeQuery(sql);
        int idg=0;
        if(rs.next())
        {
        	idg=rs.getInt("id");
        }
        String sql3="Select * from activitate_grup where id_grup='"+idg+"' and data_activitate='"+this.data_act+"'";
        ResultSet rs3=stmt.executeQuery(sql3);
        int n1=0,n2=0;
        if(rs3.next())
        {
        	n1=rs3.getInt("nr_participanti");
        	n2=rs3.getInt("nr_participanti_curent");
        }
        String sql2="Select * from mesaj where id_grup='"+idg+"' and id_student='"+id_local+"'";
        ResultSet rs2=stmt.executeQuery(sql2);
        if(rs2.next())
        {
        	if(n2<n1)
        	   JOptionPane.showMessageDialog(null, "Anulare activitate Pregatire "+this.materie);
        }
  		
  		connection.close();
  		//callableStatement.setString(3,textField_1.getText());
  		
  	}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
               " Details are provided below:");
            e2.printStackTrace(System.err);};
            try {Class.forName("com.mysql.jdbc.Driver");
    		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect5","root","Taemin1993*");
    		
    		CallableStatement callableStatement=null;
    		
    		ResultSet resultSet=null;
    		
    		String sql="{call mesaj_anulare(?,?)}";
    		
    		callableStatement=connection.prepareCall(sql);
    		
    		callableStatement.setString(1,this.materie);
    		callableStatement.setString(2,this.data_act);
    		
    		callableStatement.executeQuery();
    		connection.close();
    		//callableStatement.setString(3,textField_1.getText());
    		
    	}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
                 " Details are provided below:");
              e2.printStackTrace(System.err);};
	}

}
