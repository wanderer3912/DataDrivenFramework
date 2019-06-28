package loginTestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jxl.Cell;
import jxl.CellView;
import jxl.Hyperlink;
import jxl.Image;
import jxl.LabelCell;
import jxl.Range;
import jxl.Sheet;
import jxl.SheetSettings;
import jxl.format.CellFormat;

public class dataDrivenUsingPOI {
	
	public void readExcel() throws IOException {
		FileInputStream excel= new FileInputStream("C:\\Users\\komal\\Documents\\loginData1.xlsx");
		Workbook workbook=new XSSFWorkbook(excel);
		
		Sheet sheet=  workbook.getSheetAt(0);
		
		sheet.it
		
	}
	public void main(String[] args)
	{
		
	}

}
