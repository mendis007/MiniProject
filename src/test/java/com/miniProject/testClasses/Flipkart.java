package com.miniProject.testClasses;

import org.testng.annotations.Test;

import com.miniProject.base.Base;
import com.miniProject.pageObjects.HomePage;
import com.miniProject.pageObjects.LoginPage;

public class Flipkart extends Base {

	static LoginPage lp=new LoginPage();
	HomePage hp=new HomePage();
	
	
			
	@Test
	private void verifyAddToCart() {
//		lp.login();
		hp.verifyFlipkartText();
		hp.search();
		hp.clickOnSearchedItem(1);
		waitFor(3);
		switchtoWindow(1);
		hp.addToCart();
		
	}
}
