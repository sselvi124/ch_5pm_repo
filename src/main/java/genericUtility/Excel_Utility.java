package genericUtility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class Excel_Utility {
	
	/**
	 * this method used to read data from excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 * @author Selvi
	 */
	public String getExcelData(String sheetName, int rowNum,int cellNum) throws Throwable {
		
		FileInputStream fis = new FileInputStream(iPathConstant.EXCEL_PATH);
		
//	FileInputStream fis = new FileInputStream("src/test/resources/data.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet s = wb.getSheet(sheetName);
	 Row r = s.getRow(rowNum);
	Cell c = r.getCell(cellNum);	
//	return c.getStringCellValue();
	String value = c.getStringCellValue();
	return value;

	}
	
	public String getExcelDataFromDataFormatter(String sheetName, int rowNum,int cellNum) throws Throwable {
		
		FileInputStream fis = new FileInputStream("src/test/resources/data.xlsx");	
		Workbook wb = WorkbookFactory.create(fis);
		DataFormatter format = new DataFormatter();
		String value = format.formatCellValue(wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
		return value;
		
	}
	
	public Object[][] readMultipleData(String sheetName) throws Throwable{
		FileInputStream fis = new FileInputStream("src\\test\\resources\\PractData.xlsx");	
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet s=wb.getSheet(sheetName);
		int lastRow = s.getLastRowNum()+1;
		int lastCell=s.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[lastRow][lastCell];
		
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				obj[i][j] = s.getRow(j).getCell(j).getStringCellValue();
			}
		}
		return obj;		
	}	
}
