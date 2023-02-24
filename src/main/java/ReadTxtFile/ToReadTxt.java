package ReadTxtFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.testng.annotations.Test;

public class ToReadTxt 
{

	@Test
	public void readTextFile() throws IOException
	{
		String f="output.txt";
		boolean flag=false;
		BufferedReader br= new BufferedReader(new FileReader(f));
		String currentLine=br.readLine();
		
		while (currentLine!=null)
		{
			if(currentLine.contains("Hello World"))
			{
				System.out.println("My text is present");
				flag=true;
				break;
			}
			currentLine=br.readLine();
			
		}
		br.close();
		Assert.assertTrue(flag);
		
		
		
		
	}
	
}
