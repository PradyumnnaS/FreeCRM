package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalenderPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class CalenderPageTest extends TestBase{
	
	//Objects reference of classes
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	CalenderPage calenderpage;
	
	String sheetname="Calender-Events";
	//Logger initialize
	Logger log =Logger.getLogger(CalenderPageTest.class);
	//Calling super class for initializing prop from config.properties
	public CalenderPageTest() {
		super();
		log.info("Calling TestBase class from CalenderPageTest");
	}
	
	//SetupMethod	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		log.info("Calling initialize from CalenderPageTest");
		initialize();
		log.info("Successfully called initialize CalenderPageTest");
		loginpage = new LoginPage();
		testutil= new TestUtil();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchToWindow();
		calenderpage=homepage.clickonCalender();
				
	}
	
	@Test(priority=1)
	public void validateCalenderpageTest() throws InterruptedException {
		log.info("Inside validateCalenderpageTest");
		Assert.assertTrue(calenderpage.validateCalenderPage(), "User not in CalenderPage");
	}
	
	@Test(priority=2)
	public void validateNewEventPageTest() throws InterruptedException {
		log.info("Inside validateNewEventPageTest");
		calenderpage=homepage.clickOnCalenderNewEventLink();
		Assert.assertTrue(calenderpage.validateNewEventPage(), "User not in NewEvent page of Calender");
	}
	
	//Using data provider for Test_priority=3
	@DataProvider
	public Object[][] getCalenderTestdata() throws EncryptedDocumentException, IOException {
		log.info("Using data provider");
		log.info("Calling TestData method present inside TestUtil Class");
		Object[][] data=TestUtil.getTestData(sheetname);
		log.info("Called TestData method present inside TestUtil Class and returing 2d array");
		return data;
	}
	
	@Test(priority=3,dataProvider="getCalenderTestdata")
	public void createNewEventTest(String titleofevent, String category) throws InterruptedException {
		log.info("Inside createNewEventTest method");
		
		 calenderpage=homepage.clickOnCalenderNewEventLink();
		 calenderpage.createNewEvent(titleofevent, category);
		 
	}
	
	
	//Tear down Method
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
