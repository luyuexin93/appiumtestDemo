package com.pa;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.comcast.magicwand.spells.appium.dawg.utils.AppiumServerController;
import com.github.genium_framework.server.ServerArguments;
import com.pa.page.BasePage;
import com.pa.page.LoginPage;
import com.pa.util.ScreenShot;

import io.appium.java_client.NetworkConnectionSetting;
import io.appium.java_client.android.AndroidDriver;

public class Test2 extends BasePage {
//	private static AndroidDriver driver = null;
	private static DesiredCapabilities cap = new DesiredCapabilities();
	private String projectpath = System.getProperty("user.dir");
	private NetworkConnectionSetting nct = new NetworkConnectionSetting(false, true, true);

	// 获取系统属性

	public static void setAppium() throws MalformedURLException {
		cap.setCapability("automationName", "Appium");
		cap.setCapability("deviceName", "S4");
		cap.setCapability("platformName", "Android"); // 设置平台
		cap.setCapability("platformVersion", "9"); // 设置系统版本
		cap.setCapability("appPackage", "com.zjipst.pa"); // 设置包名
		cap.setCapability("uuid", "DWT7N19422002869"); // 设置设备名 adb devices 对应设备名称
		cap.setCapability("appActivity", ".MainActivity"); // 设置打卡的Activity
		cap.setCapability("newCommandTimeout", "30");
		cap.setCapability("noReset", "true");// she
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static void main(String[] args) throws Exception {
		System.setProperty("nodepath", "D:\\Program Files\\nodejs\\node.exe");
		System.setProperty("appiumjspath",
				"C:\\Users\\luyuexin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");

		File nodeFile = new File(System.getProperty("nodepath"));
		File appiumjs = new File(System.getProperty("appiumjspath"));
		ServerArguments serverArguments = new ServerArguments(); // 初始化服务器参数类
//		AppiumServer aserver = new AppiumServer(nodeFile, appiumjs, serverArguments);
//		AppiumServer aserver = new AppiumServer(serverArguments);
//
//		aserver.startServer(30000);
//		System.out.println(aserver.toString());
		// appiumserver监听类
		AppiumServerController act = new AppiumServerController();
		System.out.println(act.checkServerState("127.0.0.1", 4723));
//			aserver.stopServer();
//			System.out.println(act.checkServerState("127.0.0.1", 4723));
//		Test2 test2 = new Test2();
		Test2.setAppium();
//		LoginController loginController = new LoginController(driver);
		LoginPage loginPage = new LoginPage();
		loginPage.loginSuccess("057105", "05105");
//		  if(Element.isElementExist(LoginPage.login_Wait(driver))) {
//			  System.out.println(LoginPage.login_Wait(driver).getText());
//		  }
//		  if(Element.isElementExist(LoginPage.login_Message(driver))) {
//			  System.out.println(LoginPage.login_Message(driver).getText());
//		  }
		String nameString = "login";
		ScreenShot.takeScreenshot(driver, nameString);
	}

}
