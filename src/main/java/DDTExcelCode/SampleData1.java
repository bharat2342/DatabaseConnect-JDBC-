package DDTExcelCode;
import java.io.IOException;
import java.util.ArrayList;

public class SampleData1 
{

	public static void main(String[] args) throws IOException 
	{
		//To get the data from Testcase of Excel of any Data-Type
		DataDrivernForAnyDAta d= new DataDrivernForAnyDAta();
		ArrayList<String> data= d.getDataOfAnyType("Add Profile");
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));
		
		
	}

}
