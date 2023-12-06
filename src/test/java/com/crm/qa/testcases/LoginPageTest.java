package com.crm.qa.testcases;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage lp = new LoginPage();

	@BeforeMethod
	public void setup() throws InterruptedException {
		lp.openbrowser();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() throws InterruptedException {
		String title = lp.validateLoginPageTitle();
		AssertJUnit.assertEquals(title, "Free CRM software for customer relationship management, sales, and support.");
	}

	@Test(priority = 2)
	public void logoImageTest() {
		boolean logo = lp.validateCRMImage();
		AssertJUnit.assertTrue(logo);
	}

	@Test(priority = 3)
	public HomePage logintest() throws InterruptedException {
		HomePage homePage = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		return homePage;

	}

}
