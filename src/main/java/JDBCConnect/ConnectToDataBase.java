package JDBCConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectToDataBase 
{
  public static void main(String[] args) throws ClassNotFoundException, SQLException 
  {
	  //This is for the connect from the Database and fetch the details
	  Class.forName("com.mysql.cj.jdbc.Driver"); //It talks to the JDBC driver
	  Connection connect=null;
	 connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/Business","root","Iambharat93@"); //Connection string to jdbc driver
	  
	  //Object of statememnt class will help us to execute the queries
	 Statement st= connect.createStatement();
	ResultSet rs= st.executeQuery("select * from CustomerInfo where purchasedDate=CURDATE() and Location ='Asia';");
	//Now query for single will be
	//(select * from CustomerInfo where purchasedDate=CURDATE() and Location ='Asia' LIMIT 1;)
	//rs is kind of array which stores the values of the queries
	//rs.next(); //Setting the pointer to particular row
	/*
	 * rs.getString(1); 
	 * rs.getString(2);  // we cant give like this for 100 rows which is not possible so we go for while loop
	 * rs.getInt(3); 
	 * rs.getString(4); 
	 * rs.next();
	 * 
	 
	 */
	while(rs.next())
	{
		System.out.println(rs.getString(1));
		System.out.println(rs.getString(2));
		System.out.println(rs.getInt(3));
		System.out.println(rs.getString(4));
		
		
	}
	connect.close();
	
	
	
  }
}
