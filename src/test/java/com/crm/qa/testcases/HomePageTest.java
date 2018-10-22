package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalenderPage;
import com.crm.qa.pages.CompaniesPage;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{

	TestUtil testutil;
	LoginPage loginpage;
	HomePage homepage;
	ContactPage contactpage;
	CalenderPage calenderpage;
	CompaniesPage companiespage;
	DealsPage dealspage;
	Logger log = Logger.getLogger(HomePageTest.class);

	public HomePageTest(){
		super();
		log.info("Successfullly called TestBase Class");
	}
	
	@BeforeMethod
	
	public void setUp() throws InterruptedException {
		
		log.info("Inside setUp of HomePageTest");
		log.info("Calling initialize method of TestBase from HomePageTest class");
	
		//call initialize from Testbase class
		initialize();
		log.info("Successfully called initialize method of TestBase from HomePageTest class");
		testutil = new TestUtil();
		loginpage = new LoginPage();
		contactpage= new ContactPage();
		calenderpage= new CalenderPage();
		companiespage= new CompaniesPage();
		dealspage= new DealsPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));		
	}
	
	@Test(priority=1)
	public void validateHomePageTest() {
		log.info("Inside validateHomePageTest");
		//driver.switchTo().frame("mainpanel");
		testutil.switchToWindow();
		driver.switchTo().frame("mainpanel");

		Assert.assertTrue(homepage.validateHomePage(), "Username not displaying !");
	}
	
	@Test(priority=2)
	public void clickonCalenderLinkTest(){
		log.info("Inside clickonCalenderLinkTest");
		testutil.switchToWindow();
		driver.switchTo().frame("mainpanel");

		calenderpage=homepage.clickonCalender();
	}
	
	@Test(priority=3)
	public void clickonCompaniesLinkTest(){
		log.info("Inside clickoncompaniesLinkTest");
		testutil.switchToWindow();
		companiespage=homepage.clickonCompanies();
	}
	
	@Test(priority=4)
	public void clickonContactLinkTest() {
		log.info("Inside clickonContactPageTest");
		//driver.switchTo().frame("mainpanel");
		testutil.switchToWindow();
		contactpage=homepage.clickonContactPage();
				
	}
	@Test(priority=5)
	public void clickonDealsLinkTest() {
		log.info("Inside clickondealslinktest class");
		testutil.switchToWindow();
		dealspage=homepage.clickonDeals();
	}
	@AfterMethod
	public void tearDown() {
		log.info("Inside tearDown of HomePageTest");
		
		driver.quit();
	}
	
}
