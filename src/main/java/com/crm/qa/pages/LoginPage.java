package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() {
		super();
	}

	@FindBy(name = "username")
	WebElement usernamee;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;

	@FindBy(xpath = "//a[.='Sign Up']")
	WebElement signUpBtn;

	@FindBy(xpath = "//img[@class='img-responsive']")
	WebElement crmLogo;

	public void openbrowser() throws InterruptedException {
		initialization();
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle() throws InterruptedException {
		Thread.sleep(3000);
		return driver.getTitle();
	}

	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}

	public HomePage login(String un, String pwd) throws InterruptedException {

		usernamee.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();

	}
	
}
