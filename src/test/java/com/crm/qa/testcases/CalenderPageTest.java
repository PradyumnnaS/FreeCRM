package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
	
	@Test
	public void validateCalenderpageTest() throws InterruptedException {
		log.info("Inside validateCalenderpageTest");
		Assert.assertTrue(calenderpage.validateCalenderPage(), "User not in CalenderPage");
	}
	
	
	//Teardown Method
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
