package DDTExcelCode;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DDTFetchAndPrint
{

	public static void main(String[] args) throws IOException 
	{
		FileInputStream fis=new FileInputStream("D://Testing_Practice//RahulShetty_tutorial_DDT From Excel//SampleData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		int sheets=workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata2"))
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
			
			if(value.getStringCellValue().equalsIgnoreCase("testcases"))
			{
				coloumn=k;
				
			}
			
			k++;
		}
		System.out.println(coloumn); //Upto here we Identified which column is present
		
		while(rows.hasNext())
		{
			Row r=rows.next();
			if(r.getCell(coloumn).getStringCellValue().equalsIgnoreCase("Purchase"))
			
		{
				//after you grab purchase testcase row = pull all the data of that row and feed into test
				
				Iterator<Cell>  cv=r.cellIterator();
				while(cv.hasNext())
				{
				System.out.println(cv.next().getStringCellValue());
		
				}
				
		}
		
		}
	
					}
		}
	}
}



