package com.crm.qa.pages;


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	//Need to create OR for HomePage
	//User can also directly select through findElement
	@FindBy(xpath="//td[contains(text(),'User: Pradyumnna Satapathy')]")
	WebElement usernamelabel;
	
	@FindBy(xpath="//a[@title='Calendar']")
	WebElement calenderlink;
	
	@FindBy(xpath="//a[@title='New Event']")
	WebElement neweventlink;
	
	@FindBy(xpath="//a[@title='Companies']")
	WebElement companieslink;
	
	@FindBy(xpath="//a[@title='Contacts']")
	WebElement contactlink;
	
	@FindBy(xpath="//a[@title='Deals']")
	WebElement dealslink;
	
	@FindBy(xpath="//a[@title='Tasks']")
	WebElement tasklink;
	
	@FindBy(xpath="//a[@title='Cases']")
	WebElement caseslink;
	
	@FindBy(xpath="//a[@title='Call']")
	WebElement calllink;
	
	@FindBy(xpath="//a[@title='Email']")
	WebElement emaillink;
	
	@FindBy(xpath="//a[@title='Text/SMS']")
	WebElement tasksmslink;
	
	@FindBy(xpath="//a[@title='Print']")
	WebElement printlink;
	
	@FindBy(xpath="//a[@title='Campaigns']")
	WebElement campaignslink;
	
	@FindBy(xpath="//a[@title='Docs']")
	WebElement docslink;
	
	@FindBy(xpath="//a[@title='Forms']")
	WebElement formslink;
	
	@FindBy(xpath="//a[@title='Reports']")
	WebElement reportslink;
	
	
	
	//How to initialize page factory /object repository objects ?
		// Ans:- By calling PageFoctory.initElement() method this can be done.
		
		//Initialization
	public HomePage() {
		PageFactory.initElements(driver, this);
			
			//User also can write LoginPage.class instead of this
			//PageFactory.initElements(driver, this);
	}
	
	//Actions need to be performed in this page
	
	public Boolean validateHomePage() {
		
		return usernamelabel.isDisplayed();
	}
    //Click on contact link
	public ContactPage clickonContactPage() {
		contactlink.click();
		return new ContactPage();
	}
	
	//Click on Calender link
	public CalenderPage clickonCalender() {
	    calenderlink.click();
	    return new CalenderPage();
	}
	
	public CalenderPage clickOnCalenderNewEventLink() {
		Actions action = new Actions(driver);
		action.moveToElement(calenderlink).build().perform();
		neweventlink.click();
		return new CalenderPage();
	}
	
	//Click on companies link
	public CompaniesPage clickonCompanies() {
		companieslink.click();
		return new CompaniesPage();
		
	}
	
	//Click on Deals link
	public DealsPage clickonDeals() {
		dealslink.click();
		return new DealsPage();
		
	}
	
	//Click on Tasks link
	public TaskPage clickonTask() {
		tasklink.click();
		return new TaskPage();
		
	}
	
	//Click on cases link
	public CasesPage clickonCases() {
		caseslink.click();
		return new CasesPage();
			
	}
	
	//Click on Call link
	public CallPage clickonCall() {
		
		calllink.click();
		return new CallPage();
	}
	
	//Click on email link
	public EmailPage clickonEmail() {
		emaillink.click();
		return new EmailPage();
	}
	
	//Click on Text/sms link
	public TextSmsPage clickonTextSms() {
		tasksmslink.click();
		return new TextSmsPage();
	}
	
	//Click on Print link
	public PrintPage clickonPrint() {
		printlink.click();
		return new PrintPage();
	}
	
	//Click on Campaings link
	public CampaignsPage clickonCampaings() {
		campaignslink.click();
		return new CampaignsPage();
	}
	
	//Click on Docs link
	public DocsPage clickonDocs() {
		docslink.click();
		return new DocsPage();
	}
	
	//Click on Forms link
	public FormPage clickonForms() {
		formslink.click();
		return new FormPage();
	}
	
	//Click on Reports link
	public ReportsPage clickonReports() {
		reportslink.click();
		return new ReportsPage();
	}
	
}
