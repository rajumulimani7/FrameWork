package pratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class NonReadDataFromSql {

	public static void main(String[] args) throws SQLException {
		
		//step1=register or load the mysql database
		Driver driverRef=new Driver();
	    DriverManager.registerDriver(driverRef);
	   
	    //step2=get connect to database
	    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyanta","root","root");
	    
	  //step3=create a sql statement
	    Statement stat = conn.createStatement();
	    
	    String query="insert into student(first_name,last_name,address)values('raju','BN','INDIA')";
	    String query1 = "insert into student(first_name,last_name,address)values('Anju','BN','INDIA')";
	    String query2 = "insert into student(first_name,last_name,address)values('praveen','BN','INDIA')";
	    
	    //step4=execute query
	    int result = stat.executeUpdate(query);
	    int result1=stat.executeUpdate(query1);
	    int result2=stat.executeUpdate(query2);
	   
	    if(result==1 & result1==1 & result2==1)
	    {
	    	System.out.println("user is created");
	    }
	    else
	    {
	    	System.out.println("user is not created");
	    }
	    //step5=close the connection
	    conn.close();
	  
	}

}
