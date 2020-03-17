package com.pa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pa.location.LoginLocation;

import io.appium.java_client.android.AndroidDriver;
public class LoginPage {
	private static WebElement element=null;
	//登录账号
	public static WebElement login_Account(AndroidDriver driver) {
		try {
			element = driver.findElement(By.id(LoginLocation.ACCOUNTID_STRING));
			return element;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	//登录密码
	public static WebElement login_Password(AndroidDriver driver) {
		try {
			element = driver.findElement(By.id(LoginLocation.PASSWORDID_STRING));
			return element;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	//登录按钮
	public static WebElement login_Btn(AndroidDriver driver) {
		try {
			element = driver.findElement(By.id(LoginLocation.LOGINID_STRING));
			return element;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}

		
	}
	//登录提示信息
	public static WebElement login_Message(AndroidDriver driver) {
		try {
			element = driver.findElement(By.xpath(LoginLocation.LOGIN_MESSAGE));
			return element;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
		
	}
	

	
	//登录等待信息
	public static WebElement login_Wait(AndroidDriver driver) {
		try {
			element = driver.findElement(By.xpath(LoginLocation.LOGIN_WAIT));
			return element;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		

	}
}

