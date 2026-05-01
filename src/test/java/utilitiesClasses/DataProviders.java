package utilitiesClasses;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders 
{
	@DataProvider(name = "LoginData")
	public String [][] getData() throws IOException
	{
		String path = ".\\testdata\\LoginData.xlsx";
		ExcelUtility excel = new ExcelUtility(path);
		
		int totalrow = excel.getRowCount("Sheet1");
		System.out.println("I m in Data Provider Class So providing the row count" + totalrow );
		int totalcell = excel.getCellCount("Sheet1", 1);
		System.out.println("I m in Data Provider Class So providing the cell count" + totalcell );
		String [][] logintestdata = new String[totalrow][totalcell];
		
		// i=1 because excluding the Header first row; 
		//Here we are using i<=totalrow because getLastRowNum() Returns last row index not actual row count 
		//to get actual row count use getPhysicalNumberOfRows();
		
		//Here getLastCellNum() return excatly the acutal columns if 5 cloumns then returns 5 So j<totalcell
		
		for(int i = 1; i<=totalrow; i++)
		{
			for (int j = 0; j<totalcell; j++)
			{
				logintestdata[i-1][j] = excel.getCellData("Sheet1", i, j);
			}
		}
		return logintestdata;
		
	}

}
