package com.crm.qa.testcases;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginpage = new LoginPage();
	HomePage homepage = new HomePage();
	TestUtil testutil = new TestUtil();
	ContactsPage contactPage = new ContactsPage();
	String sheetName="contacts";

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		loginpage.openbrowser();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.swithToFrame();
		
	}

	@Test(priority = 1)
	public void contactLabelIsDisplayTest() {
		contactPage.contactlnk();
		boolean lable = contactPage.contactLabelDisplayed();
		AssertJUnit.assertTrue(lable);
	}

	@Test(priority = 2)
	public void CheckboxClickTest() throws InterruptedException {
		contactPage.contactlnk();
		contactPage.selectCheckbox();
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=4)
	public void validateCreateNewContact(){
		homepage.clickOnNewContactLink();
		contactPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		//contactPage.createNewContact(title, firstName, lastName, company);
		
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
