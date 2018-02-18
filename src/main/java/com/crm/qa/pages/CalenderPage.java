package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CalenderPage extends TestBase {

	//OR for CalenderPage
	@FindBy(xpath="//input[@value=\"<= Show Calendar for Selected User\"]")
	WebElement calenderlabel;
	
	@FindBy(xpath="//a[@title=\"New Event\"]")
	WebElement neweventlink;
	//Initialize Object repository
	public CalenderPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions to be done in CalenderPage
	public boolean validateCalenderPage() throws InterruptedException {
		Thread.sleep(1000);
		return calenderlabel.isDisplayed();
	}
	
	public void createNewEvent() {
		
	}
	
}
