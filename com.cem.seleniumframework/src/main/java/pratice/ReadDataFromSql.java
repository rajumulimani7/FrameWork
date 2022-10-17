package pratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadDataFromSql {

	public static void main(String[] args) throws Throwable {
		
		//step1=register or load the mysql database
    Driver driverRef=new Driver();
    DriverManager.registerDriver(driverRef);
    
    //step2=get connect to database                                              
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyanta","root","root");
    
    //step3=create a sql statement
    Statement stat = conn.createStatement();
    
                                  //tablename
    String selectQuery = "select * from student";
    
    //step4= exccute statement/query
  ResultSet result = stat.executeQuery(selectQuery);
  while(result.next())
  {
	  System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
  }
  //step5= close the database connection
  conn.close();
	}

}
