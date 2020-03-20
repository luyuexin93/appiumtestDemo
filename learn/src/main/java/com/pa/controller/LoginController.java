package com.pa.controller;

import org.openqa.selenium.WebElement;

import com.pa.page.LoginPage;
import com.pa.util.Element;

import io.appium.java_client.android.AndroidDriver;

public class LoginController {
	
	private static LoginPage loginPage=new LoginPage();
	
	public LoginController(AndroidDriver driver) {
		this.loginPage.driver=driver;
	}

	//登录首页
	public  void login(String username,String password) {

		if (Element.isElementExist(this.loginPage.login_Account())) {
			this.loginPage.login_Account().sendKeys(username);
		}
		if (Element.isElementExist(this.loginPage.login_Password())) {
			this.loginPage.login_Password().sendKeys(password);
		}
		if (Element.isElementExist(this.loginPage.login_Btn())){
			this.loginPage.login_Btn().click();
		}
		
	}
	
	
		
	
}
