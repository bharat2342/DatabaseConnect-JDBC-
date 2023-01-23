package DDTExcelCode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven 
{
	//This only accepts the data is String only if numeric choose the other DataDriven For any Data class
	public ArrayList<String> getData(String TestCaseName) throws IOException 
	{
		ArrayList<String> a=new ArrayList<String>();
		
		//A channel to read the data from excel sheet and give its path
		FileInputStream fis=new FileInputStream("D://Testing_Practice//RahulShetty_tutorial_DDT From Excel//SampleData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);

		int sheets=workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++)
		{
			//Now it is equals to our sheet it will go into this condition
		   if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
		
		   {
			   XSSFSheet sheet=workbook.getSheetAt(i);
		     //Identify Testcases coloum by scanning the entire 1st row

			   Iterator<Row>  rows= sheet.iterator();// sheet is collection of rows
			   Row firstrow= rows.next();
			   Iterator<Cell> ce=firstrow.cellIterator();//row is collection of cells
			   int k=0;
			   int coloumn = 0;
		
			   while(ce.hasNext())
		{
		
				   
				  
	    Cell value=ce.next();
		if(value.getStringCellValue().equalsIgnoreCase("TestCases"))
		{
			coloumn=k;

		}

		k++;
		
		}
		System.out.println(coloumn);

		////once coloumn is identified then scan entire testcase coloum to identify purchase testcase row
		while(rows.hasNext())
		{
			Row r=rows.next();
			if(r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(TestCaseName))
			
		{

		////after you grab purchase testcase row = pull all the data of that row and feed into test

		Iterator<Cell>  cv=r.cellIterator();
		while(cv.hasNext())
		{

		a.add(cv.next().getStringCellValue());
		}
		
		}
		}
		
		}
		}
		return a;
	}
}