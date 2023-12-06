package com.crm.qa.util;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class MyWebDriverDecorator extends EventFiringWebDriver {
	public MyWebDriverDecorator(WebDriver driver) {
		super(driver);
		this.register(new MyWebDriverEventListener());
	}

	private static final Logger log = Logger.getLogger(MyWebDriverDecorator.class);

	private class MyWebDriverEventListener implements WebDriverEventListener {
		@Override
		public void beforeFindBy(By by, WebElement element, WebDriver driver) {
			//System.out.println("Trying to find Element By : " + by.toString());
			log.info("Trying to find Element By : " + by.toString());
		}

		@Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
        	//System.out.println("Found Element By : " + by.toString());
        	log.info("Found Element By : " + by.toString());
        	  }

		@Override
		public void beforeClickOn(WebElement element, WebDriver driver) {
			//System.out.println("Trying to click on: " + element.toString());
			log.info("Trying to click on: " + element.toString());
		}

		@Override
		public void afterClickOn(WebElement element, WebDriver driver) {
			//System.out.println("Clicked on: " + element.toString());
			log.info("Clicked on: " + element.toString());}

		@Override
		public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
			//System.out.println("Value of the:" + element.toString() + " before any changes made");
			log.info("Value of the:" + element.toString() + " before any changes made");
		}

		@Override
		public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
			//System.out.println("Element value changed to: " + element.toString());
			log.info("Element value changed to: " + element.toString());
		}

		@Override
		public void beforeNavigateTo(String url, WebDriver driver) {
			//System.out.println("Before navigating to: '" + url + "'");
			log.info("Before navigating to: '" + url + "'");
			}

		@Override
		public void afterNavigateTo(String url, WebDriver driver) {
			//System.out.println("Navigated to:'" + url + "'");
			log.info("Navigated to:'" + url + "'");
			}

		@Override
		public void beforeNavigateBack(WebDriver driver) {
			//System.out.println("Navigating back to previous page");
			log.info("Navigating back to previous page");
		}

		@Override
		public void afterNavigateBack(WebDriver driver) {
			//System.out.println("Navigated back to previous page");
			log.info("Navigated back to previous page");
			}

		@Override
		public void beforeNavigateForward(WebDriver driver) {
			//System.out.println("Navigating forward to next page");
			log.info("Navigating forward to next page");
		}

		@Override
		public void afterNavigateForward(WebDriver driver) {
			//System.out.println("Navigated forward to next page");
			log.info("Navigated forward to next page");
		}

		@Override
		public void beforeNavigateRefresh(WebDriver driver) {
			log.info(" Before Page Refresh");
		}

		@Override
		public void afterNavigateRefresh(WebDriver driver) {
			log.info(" Page Refreshed ");
		}

		@Override
		public void beforeAlertAccept(WebDriver driver) {
			log.info("Before Aert Accept ");

		}

		@Override
		public void afterAlertAccept(WebDriver driver) {
			log.info("** After Alert Accept **");
		}

		@Override
		public void beforeAlertDismiss(WebDriver driver) {
			log.info("Before Aert Dismiss ");
		}

		@Override
		public void afterAlertDismiss(WebDriver driver) {
			log.info("** After Aert Dismiss **");
		}

		@Override
		public void beforeScript(String script, WebDriver driver) {
			// Do nothing
		}

		@Override
		public void afterScript(String script, WebDriver driver) {
			// Do nothing
		}

		@Override
		public void onException(Throwable throwable, WebDriver driver) {
			log.info("***** Exception occured + Screenshot After End of the Test. *****");
			System.out.println("Exception occured: " + throwable);
			try {
				TestUtil.takeScreenshotAtEndOfTest();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void beforeSwitchToWindow(String windowName, WebDriver driver) {
			log.info("Before Switch to window ");
		}

		@Override
		public void afterSwitchToWindow(String windowName, WebDriver driver) {
			log.info("After Switch to window ");

		}

		@Override
		public <X> void beforeGetScreenshotAs(OutputType<X> target) {
			log.info("Before Getting screendhprt");

		}

		@Override
		public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
			log.info("Getting screendhprt");

		}

		@Override
		public void beforeGetText(WebElement element, WebDriver driver) {
			//System.out.println("Getting Text from WebElement : " + element);
			log.info("Before GetText from WebElement : " + element);

		}

		@Override
		public void afterGetText(WebElement element, WebDriver driver, String text) {
			//System.out.println("Getting Text from WebElement : " + element);
			log.info("Getting Text from WebElement : " + element +" ( Text : " + text +" )");

		}
	}
}
