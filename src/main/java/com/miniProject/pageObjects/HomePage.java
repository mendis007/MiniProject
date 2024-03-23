package com.miniProject.pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.miniProject.base.Base;

public class HomePage extends Base{

	
	private static By searchBox=By.xpath("//input[@name='q']");
	private static String searchItem="iphone 15 pro max";
	private static By flipkartImage=By.xpath("//a[@title and @aria-label]//img");
	private static By addToCart=By.xpath("//button[text()='Add to cart']");
	private static By cart=By.xpath("//a[contains(@href,'viewcart')]");
	public void verifyFlipkartText() {
		String attributeValue=getAttribute(flipkartImage,"title");
		Assert.assertEquals(attributeValue, "Flipkart");
	}
	public void search() {
		clickElement(cart);
		waitFor(5);
		driver.navigate().back();
		waitFor(5);
		setTextBox(searchBox, searchItem);
		By searchResult=By.xpath("(//a[contains(@href,'"+searchItem.split(" ")[0]+"')])[1]/div[text()]");
		clickElement(searchResult);
	}
	
	public void clickOnSearchedItem(int number) {
		By by=By.xpath("(//span[contains(text(),'"+searchItem.split(" ")[0]+"')]/ancestor::div//div[@data-tkid]/a[contains(@href,'"+searchItem.split(" ")[0]+"')])["+number+"]");
		clickElement(by);
	}
	
	public void addToCart() {
		clickElement(addToCart);
		switchtoWindow(0);
		clickElement(cart);
		waitFor(4);
	}
	
}
