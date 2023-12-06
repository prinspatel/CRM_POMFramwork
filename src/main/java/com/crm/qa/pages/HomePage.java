package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "(//td[@align='left'])[1]")
	WebElement userName;

	@FindBy(xpath = "//a[normalize-space()='Contacts']")
	WebElement contactslnk;

	@FindBy(xpath = "//a[normalize-space()='Deals']")
	WebElement dealslnk;

	@FindBy(xpath = "//a[normalize-space()='Tasks']")
	WebElement tasklnk;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;

	public HomePage() {
		super();
		PageFactory.initElements(driver, this);
	}

	public void openbrowser() {
		initialization();
	}

	public String verifyHomePagetitle() {
		return driver.getTitle();
	}

	public boolean verifyCurrentUserName() {
		return userName.isDisplayed();
	}

	public ContactsPage clickOnContactLink() {
		contactslnk.click();
		return new ContactsPage();
	}

	public DealsPage clickOnDealLink() {
		dealslnk.click();
		return new DealsPage();
	}

	public TaskPage clickOnTaskLink() {
		tasklnk.click();
		return new TaskPage();
	}

	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
	}

}
