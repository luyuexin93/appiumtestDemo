package com.learndemo;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pa.controller.LoginController;

import io.appium.java_client.NetworkConnectionSetting;
import io.appium.java_client.android.AndroidDriver;

public class Test1 {

	private static AndroidDriver driver = null;
	private static DesiredCapabilities cap = new DesiredCapabilities();
	private String projectpath = System.getProperty("user.dir");
	private NetworkConnectionSetting nct = new NetworkConnectionSetting(false, true, true);

	@BeforeTest
	public void setAppium() throws MalformedURLException {
		// 获取系统属性
		cap.setCapability("automationName", "Appium");
		cap.setCapability("deviceName", "S4");
		cap.setCapability("platformName", "Android"); // 设置平台
		cap.setCapability("platformVersion", "9"); // 设置系统版本
		cap.setCapability("appPackage", "com.zjipst.pa"); // 设置包名
		cap.setCapability("uuid", "DWT7N19422002869"); // 设置设备名 adb devices 对应设备名称
		cap.setCapability("appActivity", ".SplashActivity"); // 设置打卡的Activity
		cap.setCapability("newCommandTimeout", "30");
		cap.setCapability("noReset", "true");// she
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test
	public void test_login() {
		LoginController login=new LoginController(driver);
		assertEquals(1 == 1, true);
	}

}
