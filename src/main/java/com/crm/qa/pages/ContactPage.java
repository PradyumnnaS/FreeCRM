package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase{

	//OR
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	//@FindBy(xpath="//td[@class='datacardtitle' and contains(text(),'Contacts')]")
	WebElement contactpagelable;
	
	//Initialization
	public ContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	public boolean validateContactPage() throws InterruptedException {
	    Thread.sleep(1000);
		return contactpagelable.isDisplayed();
	}
}
