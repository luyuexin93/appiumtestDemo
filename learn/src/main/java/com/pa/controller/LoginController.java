package com.pa.controller;

import com.pa.page.LoginPage;

import io.appium.java_client.android.AndroidDriver;

/**
 * @author lu 首页登陆控制类
 */
public class LoginController {

	public LoginPage loginPage = new LoginPage();

	public LoginController(AndroidDriver driver) {
		LoginPage.driver = driver;
	}

	/**
	 * 登陆首页成功
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
//	public MainPage loginSuccess(String username, String password) {
//
//		if (accountExist()) {
//			this.loginPage.login_Account().sendKeys(username);
//		}
//		if (Element.isElementExist(this.loginPage.login_Password())) {
//			this.loginPage.login_Password().sendKeys(password);
//		}
//		if (Element.isElementExist(this.loginPage.login_Btn())) {
//			this.loginPage.login_Btn().click();
//		}
//		return new MainPage();
//	}
//
//	/**
//	 * 
//	 * @return
//	 */
//	public boolean accountExist() {
//		return Element.isElementExist(this.loginPage.login_Account());
//	}

}
