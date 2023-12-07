package com.crm.qa.testcases;

import org.apache.log4j.Logger;
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
	String sheetName = "contacts";
	Logger log= Logger.getLogger(ContactsPageTest.class);

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		log.info("*************** Contacts Page Test | Befor Test Method  ***************");
		loginpage.openbrowser();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("*************** Befor Test Method | Done  ***************");

	}

	//@Test(priority = 1)
	public void contactLabelIsDisplayTest() {
		log.info("*************** Test - 1 | Contect Lable is Display Test ***************");
		testutil.swithToFrame();
		contactPage.contactlnk();
		boolean lable = contactPage.contactLabelDisplayed();
		AssertJUnit.assertTrue(lable);
		log.info("*************** Test - 1 | Done  ***************");
	}

	@Test(priority = 2)
	public void CheckboxClickTest() throws InterruptedException {
		log.info("*************** Test - 2 | Checkbox in conct click Test ***************");
		testutil.swithToFrame();
		contactPage.contactlnk();
		contactPage.selectCheckbox();
		log.info("*************** Test - 2 | Done  ***************");
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	//@Test(priority = 3,  dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company) {
		log.info("*************** Test - 3 | Creating New Contect  ***************");
		testutil.swithToFrame();
		homepage.clickOnNewContactLink();
		contactPage.createNewContact(title, firstName, lastName, company);
		log.info("*************** Test - 3 | Done  ***************");
	}
	
	@Test(priority = 4)
	public void delateContectsTest() throws InterruptedException {
		log.info("*************** Test - 4 | Delating All Contects  ***************");
		testutil.swithToFrame();
		contactPage.contactlnk();
		contactPage.delateContect();
		log.info("*************** Test - 4 | Done  ***************");
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		log.info("*************** Closing Browser ***************");
		Thread.sleep(3000);
		driver.quit();
	}

}
