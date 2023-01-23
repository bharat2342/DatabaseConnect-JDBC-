package JDBCConnect;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToJava
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException, StreamWriteException, DatabindException, IOException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver"); //It talks to the JDBC driver
		 Connection connect=null;
		  //here we reterive it from the java only
		 ArrayList<CustomerDetails> a= new ArrayList<CustomerDetails>();
		 connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/Business","root","Iambharat93@");
		
		 Statement st= connect.createStatement();
	//Limit to single query
ResultSet rs= st.executeQuery(" Select * from CustomerInfo where purchasedDate=CURDATE()-1 and Location ='Asia';");


	while(rs.next())
	{
		//Create the 3 Java Objects
		 CustomerDetails cust= new CustomerDetails(); 
		cust.setCourseName(rs.getString(1));      //using set- we insert and get-we reterive
		cust.setPurchasedDate(rs.getString(2));
		cust.setAmount(rs.getInt(3));
		cust.setLocation(rs.getString(4));
		a.add(cust);
		
}
	
	for(int i=0;i<a.size();i++) 
	{
		
		ObjectMapper obj=new ObjectMapper();
		//new JSON will be created,customerInfo json is created
		//File location of JSON and Obj of Cust
		obj.writeValue(new File("C:\\Users\\bharat\\eclipse-workspace\\JDBCDEMO\\customerInfo"+i+".json"), a.get(i));   
		
		
	}
	
	
 	
connect.close();
		

	}

}
