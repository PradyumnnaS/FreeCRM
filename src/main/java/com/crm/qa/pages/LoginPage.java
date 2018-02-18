package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	

	//Now user adding OR(Page Factory) for the Login Page
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//*[@id='loginForm']/div/div/input")
	WebElement loginbtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmlogo;
    
	//How to initialize page factory /object repository objects ?
	// Ans:- By calling PageFoctory.initElement() method this can be done.
	
	//Initialization
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
		//User also can write LoginPage.class instead of this
		//PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	public String validateLoginPage() {
		return driver.getTitle();
	}
	
	public boolean validateCrmImage() {
		return crmlogo.isDisplayed();
	}
	
	public HomePage login(String uname, String psswd ) throws InterruptedException {
		username.sendKeys(uname);
		password.sendKeys(psswd);
		Thread.sleep(2000);
		loginbtn.click();
		return new HomePage();
	}
}
