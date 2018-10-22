package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase{

	
	LoginPage loginpage;
	HomePage homepage;
	ContactPage contactpage;
	TestUtil testutil;
	Logger log = Logger.getLogger(ContactPageTest.class);
	
	public ContactPageTest() {
		super();
		log.info("Successfullly called TestBase Class");
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		log.info("Inside setUp of ContactPageTest");
		log.info("Calling initialize method of TestBase from ContactPageTest class");
		initialize();
		log.info("Successfully called initialize method of TestBase from ContactPageTest class");
		testutil = new TestUtil();
		loginpage = new LoginPage();
		contactpage = new ContactPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchToWindow();
		contactpage=homepage.clickonContactPage();
		
	}
	
	@Test(priority=1)
	public void validateContactPageTest() throws InterruptedException {
		log.info("Inside validateContactPageTest");
		
		Assert.assertTrue(contactpage.validateContactPage(), "Contact lable is missing on Page");
	}
	
	@AfterMethod
	public void tearDown() {
		log.info("Inside tearDown of ContactPageTest");
		driver.quit();
	}
	
}
