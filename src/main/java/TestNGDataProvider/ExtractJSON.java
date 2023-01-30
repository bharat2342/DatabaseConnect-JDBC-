package TestNGDataProvider;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class ExtractJSON
{

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException 
	{
		 ObjectMapper mapper = new ObjectMapper();

	        // Reading JSON from a file
	        CustomerData customerData = mapper.readValue(new File("C:\\Users\\bharat\\eclipse-workspace\\JDBCDEMO\\TestData.json"), CustomerData.class);

	        
	        List<Data> dataList = customerData.getCustomerData();
	        for (Data data : dataList) 
	        {
	        	System.out.println("user1: " + data.getUsername1());
	        	System.out.println("password1: " + data.getPassword1());
	            System.out.println("password2: " + data.getPassword2());
	        }
	        // Accessing JSON data
	        //System.out.println("Password2: " + customerData.getCustomerData().get(0).getPassword2());
	        


	}

}
