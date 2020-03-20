package com.pa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pa.location.LoginLocation;

import io.appium.java_client.android.AndroidDriver;
public class LoginPage extends BasePage {
	private static WebElement element=null;
	
	//登录账号
	public  WebElement login_Account() {
		try {
			element = findElement(By.id(LoginLocation.ACCOUNTID_STRING));
			return element;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	//登录密码
	public  WebElement login_Password() {
		try {
			element =findElement(By.id(LoginLocation.PASSWORDID_STRING));
			return element;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	//登录按钮
	public  WebElement login_Btn() {
		try {
			element = findElement(By.id(LoginLocation.LOGINID_STRING));
			return element;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}

		
	}
	//登录提示信息
	public  WebElement login_Message() {
		try {
			element = findElement(By.xpath(LoginLocation.LOGIN_MESSAGE));
			return element;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
		
	}
	

	
	//登录等待信息
	public  WebElement login_Wait() {
		try {
			element =findElement(By.xpath(LoginLocation.LOGIN_WAIT));
			return element;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		

	}
}

