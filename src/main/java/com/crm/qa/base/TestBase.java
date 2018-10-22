// Omm
package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {

	//Comments
	public static WebDriver driver;
	public static Properties prop;    
	public static EventFiringWebDriver e_driver;
	public static WebEventListener weblistener; 
	Logger log = Logger.getLogger(TestBase.class);
	/* Creating constructor and then read config.properties*/
	public TestBase() {
		
		//log.info("TestBase class called from Test Classes");
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/crm/qa/config/config.properties");
			prop.load(ip);
		//	log.info("System.getProperty for config.properties");
		}catch(FileNotFoundException e) {
			log.error("File Not Found Exception:");
			e.printStackTrace();
			
		}catch(IOException e) {
			log.error("Exception occur in IO:");
			e.printStackTrace();
		}
	}
	
	public static void initialize() {
		
		// Getting browsername from config.properties file
		
		String browserName = prop.getProperty("browser");
		
		if (browserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver",

					"/home/PradyumnnaS/EclipseHome/Java/chromedriver");
			driver = new ChromeDriver();
		}else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver",
					"/home/PradyumnnaS/EclipseHome/Java/geckodriver");

					
			driver = new ChromeDriver();
		}else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver",
					"F:/WorkPlatForm/geckodriver.exe");

			driver = new FirefoxDriver();
		}
		
		//Creating WebDriver Fire event object
		//that is creating objects for WebDriverEventListener
		e_driver = new EventFiringWebDriver(driver);
		weblistener = new WebEventListener();
		e_driver.register(weblistener);
		driver = e_driver;
		
		// Default value for webdriver driver 
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITELY_WAIT, TimeUnit.SECONDS);
			
			
		// Calling url
			driver.get(prop.getProperty("url"));
	}	

}
