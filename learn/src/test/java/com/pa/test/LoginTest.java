package com.pa.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.apache.commons.lang.ObjectUtils.Null;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pa.page.LoginPage;
import com.pa.page.MainPage;


public class LoginTest  {
	LoginPage login;
	
	private static Logger logger= LoggerFactory.getLogger(LoginTest.class);
	@Test
	public void loginSuccuess() {
		
		MainPage mPage=login.loginSuccess("057105", "057105");
		assertEquals(mPage.driver, login.driver);
	}

	@BeforeMethod
	public void beforeMethod() {
		
	}

	@AfterMethod
	public void afterMethod() {
	}

	@BeforeClass
	public void beforeClass() {
		 login = new LoginPage();
		 login.driver= InitAppium.driver;
		 if (login.driver==null) {
			 logger.error("driver 为空");
		 };
		 
	}


	@BeforeTest
	public void beforeTest() {
		logger.info("开始登陆测试集");
	}

	@AfterTest
	public void afterTest() {
		logger.info("登陆测试集运行结束");
	}

}
