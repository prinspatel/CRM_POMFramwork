package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DealPageTest extends TestBase {

	LoginPage loginpage = new LoginPage();
	HomePage homepage = new HomePage();
	TestUtil testutil = new TestUtil();
	Logger log = Logger.getLogger(ContactsPageTest.class);
	DealsPage dealPage = new DealsPage();
	String sheetName = "deals";

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		log.info("*************** Contacts Page Test. | Befor Test Method.  ***************");
		loginpage.openbrowser();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.swithToFrame();
		log.info("*************** Before Method Done ***************");
	}

	@Test(priority = 1)
	public void dealPageValidationTest() throws InterruptedException {
		log.info("*************** Test - 1 | Deal Page Valadition.  ***************");
		dealPage.openDealPage();
		String ExText = dealPage.veryfingDealPage();
		String ActualTest = "New Deal";
		Assert.assertEquals(ActualTest, ExText);
		log.info("*************** Test - 1 | Done ***************");
	}

	@DataProvider
	public Object[][] dealsdata() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	// @Test(priority = 2, dataProvider= "dealsdata")
	public void addNewDealTest(String Dtitle, String Dcomapny) throws InterruptedException {
		log.info("*************** Test - 2 | Deal Page Valadition.  ***************");
		dealPage.addNewDeal(Dtitle, Dcomapny);
		log.info("*************** Test -2 | Done ***************");
	}

	@Test(priority = 3)
	public void deleteDealTest() throws InterruptedException {
		log.info("*************** Test - 3 | Delete Deals Test.  ***************");
		dealPage.openDealPage();
		dealPage.deletedeals();
		log.info("*************** Test -3 | Done ***************");
	}

	@AfterMethod
	public void afterMethod() {
		log.info("*************** Closing Browser.  ***************");
		driver.quit();
	}

}
