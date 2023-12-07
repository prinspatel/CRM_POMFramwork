package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginpage = new LoginPage();
	HomePage homepage = new HomePage();
	TestUtil testutil = new TestUtil();
	ContactsPage contactsPage;
	Logger log = Logger.getLogger(HomePageTest.class);

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {

		contactsPage = new ContactsPage();
		loginpage.openbrowser();
		log.info("***************	HomePage Test initialize	***************");
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.swithToFrame();
		Thread.sleep(3000);
	}

	//@Test(priority = 1)
	public void varifyHomePageTitle() throws InterruptedException {
		log.info(" ***************	Test 1 - Verifying Home Page Title	*************** ");
		String htitle = homepage.verifyHomePagetitle();
		Assert.assertEquals(htitle, "CRMPRO", "Title of the Home Page is not Matched.");
	}

	//@Test(priority = 2)
	public void verifyUserNameTest() {
		log.info(" ***************	Test 2 - Verifying Username Test	*************** ");
		boolean user = homepage.verifyCurrentUserName();
		Assert.assertTrue(user);
	}

	//@Test(priority = 3)
	public void verifycontect() {
		log.info(" ***************	Test 3 - Verifying contect Test	*************** ");
		contactsPage = homepage.clickOnContactLink();
	}

	@AfterMethod
	public void afterMethod() {
		log.info("***************	After Method - Close Browser	***************");
		driver.quit();
	}

}
