package JDBCConnect;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExtractJSON {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException
	{
		//Jackson API plays very important role 
		//JSON response we can get the data by read and Map that class and we can compare
		ObjectMapper obj=new ObjectMapper();
	CustDetailsWithStudentName c= obj.readValue(new File("C:\\Users\\bharat\\eclipse-workspace\\JDBCDEMO\\customerInfo0.json"), CustDetailsWithStudentName.class);
	System.out.println(c.getStudentName());
	System.out.println(c.getCourseName());
	
	
	
	
	}

}
