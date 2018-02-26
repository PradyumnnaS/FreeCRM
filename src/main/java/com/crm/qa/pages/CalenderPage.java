package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class CalenderPage extends TestBase {

	//OR for CalenderPage and comments
	@FindBy(xpath="//input[@value='<= Show Calendar for Selected User']")
	WebElement calenderlabel;
	
	@FindBy(xpath="//a[@title='Calendar']")
	WebElement calenderlink;
	
	@FindBy(xpath="//legend[contains(text(),'Event Information')]")
	WebElement neweventlable;
	
	@FindBy(xpath="//input[@id='title']")
	WebElement eventtitle;
	
	@FindBy(xpath="//select[@name='category']")
	WebElement eventcategory;
	
	@FindBy(xpath="//input[@type='radio' and @value='Y']")
	WebElement confirmationradiobtn;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']/parent::td[@align='left']")
	WebElement submiteventbtn;
	//Initialize Object repository
	
	public CalenderPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions to be done in CalenderPage
	public boolean validateCalenderPage() throws InterruptedException {
		Thread.sleep(1000);
		return calenderlabel.isDisplayed();
	}
	
	public boolean validateNewEventPage() throws InterruptedException {
		Thread.sleep(1000);
		return neweventlable.isDisplayed();
	}
	
	
	public void createNewEvent(String titleofevent,String category) throws InterruptedException {
		Thread.sleep(1000);
		eventtitle.sendKeys(titleofevent);
		
		Select select = new Select(eventcategory);
		select.selectByVisibleText(category);
		
		//confirmationradiobtn.clear();
		confirmationradiobtn.click();
		
		submiteventbtn.submit();
		
	}

}
