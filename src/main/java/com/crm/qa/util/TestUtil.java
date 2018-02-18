package com.crm.qa.util;

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
	
	public void switchToWindow() {
		
		driver.switchTo().frame("mainpanel");
	}
	
/*	public void takeScreenshotAtEndOfTest() throws IOException{
		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String curdir = System.getProperty("user.dir");
		FileUtils.copyFile(srcfile,new File(curdir+ "/screenshots" + System.currentTimeMillis()+ ".png"));

	}*/
}
