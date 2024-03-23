package com.miniProject.base;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.miniProject.utilsHelper.ConfigMngr;


public class Base {

	public static WebDriver driver = null;

	@BeforeSuite
	public void loadUrl() {
		String url = ConfigMngr.getProperty("Flipkart");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	
	@AfterSuite
	public void quit() {
		try {
	//		driver.quit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// re usable Methods

	public static void clickElement(By by) {
		try {
			explicitWaitForElementToBeClickable(Duration.ofSeconds(10), by);
			driver.findElement(by).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static String getAttribute(By by,String attribute){
		String attributeValue="";
		try {
			explicitWaitForElementToBeVisible(Duration.ofSeconds(10), by);
			attributeValue=	driver.findElement(by).getAttribute(attribute);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return attributeValue;
	}

	public static void setTextBox(By by, String text) {
		try {
			explicitWaitForElementToBeVisible(Duration.ofSeconds(10), by);
			driver.findElement(by).sendKeys(text);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void waitFor(int time) {
		try {
			Thread.sleep(time * 1000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void implicitWaitFor(int time) {
		try {
			driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void explicitWaitForElementToBeClickable(Duration time, By by) {
		try {
			WebDriverWait w = new WebDriverWait(driver, time);
			w.until(ExpectedConditions.elementToBeClickable(by));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void explicitWaitForElementToBeVisible(Duration time, By by) {
		try {
			WebDriverWait w = new WebDriverWait(driver, time);
			w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void switchtoWindow(int i) {
		try {
			waitFor(5);
			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(i));
		} catch (Exception e) {
			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));

		}
	}

}
