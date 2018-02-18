package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage ;
	HomePage homepage;
	Logger log = Logger.getLogger(HomePageTest.class);
	//Before calling initialize() method calling user need to 
	// create constructor for LoginPageTest class with super() class constructor.

	public LoginPageTest() {
		
		super();
		log.info("Successfullly called TestBase Class");
	} 
	
	@BeforeMethod
	public void setUp() {
		log.info("Inside setUp of LoginPageTest");
		log.info("Calling initialize method of TestBase from LoginPageTest class");
		initialize();
		log.info("Successfully called initialize method of TestBase from LoginPageTest class");
		loginpage = new LoginPage(); 	
	}
	
	@Test(priority=1)
	public void crmLoginPageTitleTest() {
		
		log.info("Inside crmLoginPageTitleTest");
		String logintitlename = loginpage.validateLoginPage();
		Assert.assertEquals(logintitlename, "#1 Free CRM for Any Business: Online Customer Relationship Software");
	}
	
	@Test(priority=2)
	public void crmLoginPageLogoTest() {
		log.info("Inside crmLoginPageLogoTest");
		Assert.assertTrue(loginpage.validateCrmImage(),"CRM Image not found");
	}
	
	@Test(priority=3)
	public void crmValideUserLoginTest() throws InterruptedException {
		
		log.info("Inside crmValideUserLoginTest");
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	@AfterMethod
	public void tearDown(){
		log.info("Inside tearDown of LoginPageTest");
		driver.quit();
	}
}
