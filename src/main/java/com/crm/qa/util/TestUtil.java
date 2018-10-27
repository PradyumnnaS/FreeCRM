package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/*import java.io.File;
import java.io.IOException;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
*/
import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIME = 20;
	public static long IMPLICITELY_WAIT = 10;
	public static String PATH_OF_DATAFILE="/home/PradyumnnaS/EclipseHome/workspace/FreeCRM/src/main/java/com/crm/qa/testdata/FreeCRMTestData.xlsx";	
	 
	public static Workbook book;
	public static Sheet sheet;
	public void switchToWindow() {
		
		driver.switchTo().frame("mainpanel");
	}
	
/*	public void takeScreenshotAtEndOfTest() throws IOException{
		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String curdir = System.getProperty("user.dir");
		FileUtils.copyFile(srcfile,new File(curdir+ "/screenshots" + System.currentTimeMillis()+ ".png"));

	}*/
	
	public static Object[][] getTestData(String sheetname) throws EncryptedDocumentException, IOException{
		FileInputStream file=null;
		
		try {
			file = new FileInputStream(PATH_OF_DATAFILE);
		}catch(FileNotFoundException fe) {
			fe.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
			
		}catch(InvalidFormatException infe) {
			infe.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		//Reading from the sheet.
		sheet = book.getSheet(sheetname);
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for (int i =0; i < sheet.getLastRowNum();i++) {
			for(int k=0; k < sheet.getRow(0).getLastCellNum();k++) {
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
			
		}
		return data;
	}
}
