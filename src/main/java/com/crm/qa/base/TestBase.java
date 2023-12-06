package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.MyWebDriverDecorator;
import com.crm.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream(
					"C:\\QA\\Proejcts\\MaveProject\\POM Framwork\\POMFramwork\\src\\main\\java\\com\\crm\\qa\\config\\cofig.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initialization() {

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.driver.chrome",
					System.getProperty("user.dir") + ".//Drivers/chromedriver.exe");
			WebDriver original = new ChromeDriver();
			driver = new MyWebDriverDecorator(original);

		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecho.chrome", "./Driver/geckodriver.exe");
			WebDriver original = new FirefoxDriver();
			driver = new MyWebDriverDecorator(original);
		} else {
			System.out.println("Exception : Driver is Null");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		
		Logger log = Logger.getLogger(TestBase.class);
		driver.get("https://www.freecrm.com/");
		log.info("************************* Openning URL **************************");
		driver.navigate().to(prop.getProperty("url"));

	}

}
