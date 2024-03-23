package com.miniProject.pageObjects;


import org.openqa.selenium.By;

import com.miniProject.base.Base;
import com.miniProject.utilsHelper.ConfigMngr;

public class LoginPage extends Base {
	private static By loginButton=By.xpath("//span[text()='Login']/../..");
	private static By emailOrMobile=By.xpath("//span[text()='Enter Email/Mobile number']");
	public void login() {
		try {
			clickElement(loginButton);
			waitFor(3);
			setTextBox(emailOrMobile, ConfigMngr.getProperty("Flipkart_user"));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
