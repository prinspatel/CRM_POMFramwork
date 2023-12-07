package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TaskPage;
import com.crm.qa.util.TestUtil;

public class TaskPageTest extends TestBase {
	
	LoginPage loginpage = new LoginPage();
	HomePage homepage = new HomePage();
	TestUtil testutil = new TestUtil();
	TaskPage taskPage= new TaskPage();
	String sheetName = "Task";
  
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  log.info("*************** Task Page Test. | Befor Test Method.  ***************");
		loginpage.openbrowser();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.swithToFrame();
		taskPage.initialPageFactory();
		log.info("*************** Before Method is Done. ***************");
  }
  

  @Test ( priority = 1)
  public void taskPageValidationTest() throws InterruptedException {
	  log.info("*************** Test - 1 | Validating Task Page. ***************");
	  taskPage.taskPageValidation();
	  log.info("*************** Test - 1 is Done. ***************");
  }
  
  @DataProvider
  public Object[][] newTask(){
	  Object data[][] = TestUtil.getTestData(sheetName);
		return data;
  }
  
  @Test (priority = 2, dataProvider = "newTask")
  public void addNewTaskTest(String tit,String del,String cas,String com) throws InterruptedException {
	  log.info("*************** Test - 2 | Adding New Task. ***************");
	  taskPage.addNewTask(tit, del, cas, com);
	  log.info("*************** Test - 2 is Done. ***************");
  }
  
  @Test(priority = 3)
  public void verifyaddedtaskTest() {
	  log.info("*************** Test - 3 | Verify Added New Task. ***************");
	  taskPage.verifyaddedtask();
	  log.info("*************** Test - 3 is Done. ***************");
  }
  
  @Test(priority = 4)
  public void delateTaskTest() throws InterruptedException {
	  log.info("*************** Test - 4 | Delating New Task. ***************");
	  taskPage.delateTask();
	  log.info("*************** Test - 4 is Done. ***************");
  }

  
  @AfterMethod
  public void afterMethod() {
	  log.info("*************** Closing Browser. ***************");
	  driver.quit();
  }

}
