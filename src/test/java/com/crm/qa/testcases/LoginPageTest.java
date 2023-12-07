package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage lp = new LoginPage();
	Logger log=Logger.getLogger(LoginPageTest.class);

	@BeforeMethod
	public void setup() throws InterruptedException {
		log.info("*************** Before Test Method ***************");
		lp.openbrowser();
	}

	@AfterMethod
	public void afterMethod() {
		log.info("*************** Closing Browser ***************");
		driver.quit();
	}

	//@Test(priority = 1)
	public void loginPageTitleTest() throws InterruptedException {
		log.info("*************** Test - 1 | Login Page Title Test ***************");
		String title = lp.validateLoginPageTitle();
		AssertJUnit.assertEquals(title, "Free CRM software for customer relationship management, sales, and support.");
	}

	//@Test(priority = 2)
	public void logoImageTest() {
		log.info("*************** Test - 2 | Logo / Image Test ***************");
		boolean logo = lp.validateCRMImage();
		AssertJUnit.assertTrue(logo);
	}

	@Test(priority = 3)
	public HomePage logintest() throws InterruptedException {
		log.info("*************** Test - 3 | Login Test ***************");
		HomePage homePage = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		return homePage;

	}

}
