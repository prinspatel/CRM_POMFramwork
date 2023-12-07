package com.crm.qa.pages;

import java.time.Duration;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase {
	Logger log = Logger.getLogger(DealsPage.class);

	@FindBy(xpath = "//a[normalize-space()='Deals']")
	WebElement dealslnk;

	@FindBy(xpath = "//input[@value='New Deal']")
	WebElement newdeal;

	@FindBy(id = "title")
	public WebElement title;

	@FindBy(xpath = "//input[@name='client_lookup']")
	public WebElement company;

	public DealsPage() {
		super();
	}

	public void openDealPage() throws InterruptedException {
		PageFactory.initElements(driver, this);
		dealslnk.click();
	}

	public String veryfingDealPage() {
		return newdeal.getAttribute("value");
	}

	public void addNewDeal(String Dtitle, String Dcompany) throws InterruptedException {
		WebElement dealslink = driver.findElement(By.xpath("//a[normalize-space()='Deals']"));
		Actions action = new Actions(driver);
		action.moveToElement(dealslink).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[normalize-space()='New Deal']")).click();

		driver.findElement(By.id("title")).sendKeys(Dtitle);
		driver.findElement(By.xpath("//input[@name='client_lookup']")).sendKeys(Dcompany);

		driver.findElement(By.xpath("//input[@value='Save']")).click();
	}

	public void deletedeals() throws InterruptedException {

		List<WebElement> totaldeals = driver
				.findElements(By.xpath("//td[@class='datalistrow']//a//i[@title='Delete']"));
		System.out.println("Total Deals = " + totaldeals.size());

		int b = 0;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		for (int i = 1; i <= totaldeals.size(); i++) {
			log.info("Delating Deal No :" + i);
			String webelemtn = "(//td[@class='datalistrow']//a//i[@title='Delete'])[1]";
			WebElement delate = driver.findElement(By.xpath(webelemtn));
			delate.click();
			 wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
		}

	}

}
