package JDBCConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JsonToJava
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver"); //It talks to the JDBC driver
		 Connection connect=null;
		 connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/Business","root","Iambharat93@");
		
		 Statement st= connect.createStatement();
	//Limit to single query
ResultSet rs= st.executeQuery("select * from CustomerInfo where purchasedDate=CURDATE() and Location ='Asia' LIMIT 1;");
		
	while(rs.next())
	{
		CustomerDetails cust= new CustomerDetails();   //here we reterive it from the java only
		cust.setCourseName(rs.getString(1));
		cust.setPurchasedDate(rs.getString(2));
		cust.setAmount(rs.getInt(3));
		cust.setLocation(rs.getString(4));
		
		System.out.println(cust.getCourseName());
		System.out.println(cust.getPurchasedDate());
		System.out.println(cust.getAmount());
		System.out.println(cust.getLocation());
}
connect.close();
		

	}

}
