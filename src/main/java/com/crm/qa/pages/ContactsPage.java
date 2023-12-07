package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//a[normalize-space()='Contacts']")
	WebElement contactsLink;

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactLabel;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Contacts')]/../../../../../..//input[@type='checkbox'][1]") })
	public List<WebElement> chechbox;
	
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveBtn;

	public ContactsPage() {
		super();
	}

	public void contactlnk() {
		PageFactory.initElements(driver, this);
		contactsLink.click();
	}

	public boolean contactLabelDisplayed() {
		return contactLabel.isDisplayed();
	}

	public void selectCheckbox() throws InterruptedException {
		for (int i = 1; i < chechbox.size(); i++) {
			if (i==1) {
				System.out.println("1");
			
			String selectcheckbox = "(//td[contains(text(),'Contacts')]/../../../../../..//input[@type='checkbox'][1])[2]";
			WebElement cbox = driver.findElement(By.xpath(selectcheckbox));
			cbox.click();
			boolean selected = cbox.isSelected();
			Assert.assertTrue(selected,"Checkbox Not Selected. ");
			break;
			}
		}
	}
	public void createNewContact(String titl, String fname, String surname, String company){
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(titl);
		
		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys(fname);		
		driver.findElement(By.id("surname")).sendKeys(surname);
		driver.findElement(By.xpath("//input[@name='client_lookup']")).sendKeys(company);
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		
	}

}
