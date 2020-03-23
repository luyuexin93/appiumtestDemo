package com.pa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pa.location.LoginLocation;

import com.pa.util.Element;;

/**
 * @author lu 登陆页元素对象
 */
public class LoginPage extends BasePage {

	private WebElement Account;
	private WebElement Password;
	private WebElement LoginBtn;
	private WebElement LoginWait;
	private WebElement LoginMsg;
	private static Logger logger= LoggerFactory.getLogger(LoginPage.class);
//	public LoginPage(AndroidDriver driver) {
//		this.driver = driver;
//	}

	public WebElement getAccount() {
		try {
			Account = findElement(By.id(LoginLocation.ACCOUNTID_STRING));
			return Account;
		} catch (NoSuchElementException e) {
//			e.printStackTrace();
			
			return null;
		}
	}

	public WebElement getPassword() {
		try {
			Password = findElement(By.id(LoginLocation.PASSWORDID_STRING));
			return Password;
		} catch (NoSuchElementException e) {
//			e.printStackTrace();
			return null;
		}
	}

	public WebElement getLoginBtn() {
		try {
			LoginBtn = findElement(By.id(LoginLocation.LOGINID_STRING));
			return LoginBtn;
		} catch (NoSuchElementException e) {
//			e.printStackTrace();
			return null;
		}
	}

	public WebElement getLoginWait() {
		try {
			LoginWait = findElement(By.xpath(LoginLocation.LOGIN_WAIT));
			return LoginWait;
		} catch (NoSuchElementException e) {
//			e.printStackTrace();
			return null;
		}
	}

	public WebElement getLoginMsg() {
		try {
			LoginMsg = findElement(By.xpath(LoginLocation.LOGIN_MESSAGE));
			return LoginMsg;
		} catch (NoSuchElementException e) {
//			e.printStackTrace();
			return null;
		}
	}

	public boolean isAccountExist() {
		return Element.isElementExist(getAccount());
	}

	public boolean isPasswordExist() {
		return Element.isElementExist(getPassword());
	}

	public boolean isLoginBtnExist() {
		return Element.isElementExist(getLoginBtn());
	}

	public boolean isLoginWaitExist() {
		return Element.isElementExist(getLoginWait());
	}

	public boolean isLoginMsgExist() {
		return Element.isElementExist(getLoginMsg());
	}

	public MainPage loginSuccess(String username, String password) {
		if(this.driver==null) {
			logger.error("driver 为空");
		}
		if(this.getAccount()==null) {
			logger.error("没有找到元素");
		}
	    this.Account=getAccount();
	    Account.sendKeys(username);
		getPassword().sendKeys(password);
		getLoginBtn().click();
		return new MainPage();
	}

}
