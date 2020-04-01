
package com.pa;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pa.page.LoginPage;
import com.pa.page.MainPage;

import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Epic("Allure examples")
@Story("正向story")
public class LoginTest {
	LoginPage login;

	private static Logger logger = LoggerFactory.getLogger(LoginTest.class);

	@Test(groups = "LoginModule")
	@Step("登陆失败")
	public void loginSuccuess() throws IOException {

		MainPage mPage = login.loginSuccess("057105", "057105");
		String file = mPage.takeScreenshot("loginSuccess");
		// 文件流
		Path screenshotPath = FileSystems.getDefault().getPath("screenshot", file + ".jpg");
		try (InputStream is = Files.newInputStream(screenshotPath)) {
			Allure.addAttachment("loginsuccess", is);
		}
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
		login.driver = InitAppium.driver;
		if (login.driver == null) {
			logger.error("driver 为空");
		}
		;

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
