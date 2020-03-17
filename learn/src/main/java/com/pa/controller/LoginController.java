package com.pa.controller;

import org.openqa.selenium.WebElement;

import com.pa.page.LoginPage;
import com.pa.util.Element;

import io.appium.java_client.android.AndroidDriver;

public class LoginController {
	

	//登录首页
	public static void login(AndroidDriver driver,String username,String password) {
		if (Element.isElementExist(LoginPage.login_Account(driver))) {
			LoginPage.login_Account(driver).sendKeys(username);
		}
		if (Element.isElementExist(LoginPage.login_Password(driver))) {
			LoginPage.login_Password(driver).sendKeys(password);
		}
		if (Element.isElementExist(LoginPage.login_Btn(driver))) {
			LoginPage.login_Btn(driver).click();;
		}
		
	}
}
