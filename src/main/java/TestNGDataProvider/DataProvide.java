package TestNGDataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvide 

{
	//This is the data we can extract from the excelprovider
	@Test(dataProvider = "driveTest")
	public void testCaseData(String greeting, String commnication,int id)
	
	{
		System.out.println(greeting+commnication+id);
		
	}


	@DataProvider(name="driveTest")
	public Object[][] getData()
	{
		//Object is the superset of all the data
		Object[][] data= {{"hello","text",1},{"bye","message",143},{"solo","call",453} };
		return data;
	}
	
	
}
