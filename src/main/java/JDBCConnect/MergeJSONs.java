package JDBCConnect;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.commons.lang3.StringEscapeUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class MergeJSONs 
{

	public static void main(String[] args) throws ClassNotFoundException, StreamWriteException, DatabindException, IOException, SQLException 
	{
		 Class.forName("com.mysql.cj.jdbc.Driver"); 
		 Connection connect=null;
		 connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/Business","root","Iambharat93@");
		 
		 Statement st= connect.createStatement();
		 ResultSet rs= st.executeQuery(" Select * from CustomerInfo where purchasedDate=CURDATE()-4 and Location ='Asia';");
		 
		 
		 
		 
		 ArrayList<CustomerDetails> a= new ArrayList<CustomerDetails>();
			JSONArray js= new JSONArray();

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
		
		//Create the JSON string from Java Object - gson dependancy download
		Gson gs= new Gson();
		String jsonString=gs.toJson(a.get(i));    // It converts into JSOn string
		js.add(jsonString);
		 
	}
	
	JSONObject jo= new JSONObject(); //it comes from Json-simple
	jo.put("data", js);
	System.out.println(jo.toJSONString());
	
	//for again to remove escape characters from the output we need to use dependancy
	//apache commons text dependancy
			
	String unescaped=StringEscapeUtils.unescapeJava(jo.toJSONString());
	System.out.println(unescaped);
	String mergeJSON1=unescaped.replace("\"{", "{");   // when we put a backslash java understands and allow double quote
	String mergeJSON2=mergeJSON1.replace("}\"", "}");
	
	System.out.println(mergeJSON2);
	
	//To convert into JSOn file not give the output in console
	try(FileWriter file =new FileWriter("C:\\Users\\bharat\\eclipse-workspace\\JDBCDEMO\\MergedJSON.json"))
	{
		file.write(mergeJSON2);
		System.out.println("This is converted into JSON");
		
		
	}
	

	
connect.close();
		

		
		
		

	}

}
