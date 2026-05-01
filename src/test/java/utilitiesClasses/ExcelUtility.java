package utilitiesClasses;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility 
{
	
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet ;
	public XSSFRow row;
	public XSSFCell cell;
	
	public String path;
	
	public ExcelUtility(String path) throws IOException 
	{
		this.path =path;
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		
	}
	
	public int getRowCount(String sheetName) throws IOException
	{
		int rowCount = 0;
		sheet = workbook.getSheet(sheetName);
		if (sheet != null)
		{
			rowCount = sheet.getLastRowNum();
		}
		workbook.close();
		fi.close();
		return rowCount;	
	}
	
	public int getCellCount(String sheetName, int rownum) throws IOException
	{
		int cellCount = 0;
		sheet = workbook.getSheet(sheetName);
		if (sheet != null)
		{
			row = sheet.getRow(rownum);
			if(row !=null)
			{
				cellCount = row.getLastCellNum();
				if (cellCount == -1)
				{
					return 0;
				}
			}
		}
		workbook.close();
		fi.close();
		return cellCount;
	}
	
	public String getCellData(String sheetName, int rownum, int colnum) throws IOException
	{
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		DataFormatter formatter = new DataFormatter();
		String data ="";
		if(sheet != null && row !=null)
		{
			cell = row.getCell(colnum);
			if(cell!=null)
			{
			 data = formatter.formatCellValue(cell);
			}
		}
		workbook.close();
		fi.close();
		return data;	
	}
	

}
