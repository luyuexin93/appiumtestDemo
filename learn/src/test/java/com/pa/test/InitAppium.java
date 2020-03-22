package com.pa.test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.comcast.magicwand.spells.appium.dawg.utils.AppiumServerController;
import com.github.genium_framework.appium.support.server.AppiumServer;
import com.github.genium_framework.server.ServerArguments;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * @author lu
 *
 */
public class InitAppium {
	public String automationName = "Appium"; //
	public String deviceName;
	public String platformName = "Android";
	public String platformVersion = "9";
	public String udid; // 设备唯一标识符
	public String appPath; // 应用apk路径
	public String appPackage; // 应用包名
	public String appActivity; // 启动的activity
	public String noReset; // 默认不重置应用 清空数据
	public String noSign;
	public String commandTimeout; // 命令超时时间

	public static AndroidDriver driver = null;
	public static DesiredCapabilities cap = new DesiredCapabilities();
	// appium server 控制类
	public static AppiumServer aserver;
	public static AppiumServerController acr;

	public InitAppium() {
		this(new Builder());
	}

	// https://testerhome.com/topics/9904
	public InitAppium(Builder builder) {
		// TODO Auto-generated constructor stub
		this.automationName = builder.automationName; //
		this.deviceName = builder.deviceName;
		this.platformName = builder.platformName;
		this.platformVersion = builder.platformVersion;
		this.udid = builder.udid; // 设备唯一标识符
		this.appPath = builder.appPath; // 应用apk路径
		this.appPackage = builder.appPackage; // 应用包名
		this.appActivity = builder.appActivity; // 启动的activity
		this.noReset = builder.noReset; // 默认不重置应用 清空数据
		this.noSign = builder.noSign;
		this.commandTimeout = builder.commandTimeout; // 命令超时时间
	}

	/**
	 * @author lu 初始化默认参数内部类Builder
	 */
	public static class Builder {
		private String automationName = "Appium"; //
		private String deviceName = "S4";
		private String platformName = "Android";
		private String platformVersion = "9";
		private String udid = "DWT7N19422002869"; // 设备唯一标识符
		private String appPath; // 应用apk路径
		private String appPackage = "com.zjipst.pa"; // 应用包名
		private String appActivity = ".SplashActivity"; // 启动的activity
		private String noReset = "True"; // 默认不重置应用 清空数据
		private String noSign = "True";
		private String commandTimeout = "30"; // 命令超时时间

		public Builder() {
		}

		public Builder setAutomationName(String automationName) {
			this.automationName = automationName;
			return this;
		}

		public Builder setDeviceName(String deviceName) {
			this.deviceName = deviceName;
			return this;
		}

		public Builder setPlatformName(String platformName) {
			this.platformName = platformName;
			return this;
		}

		public Builder setPlatformVersion(String platformVersion) {
			this.platformVersion = platformVersion;
			return this;

		}

		public Builder setUdid(String udid) {
			this.udid = udid;
			return this;
		}

		public Builder setAppPathString(String appPathString) {
			this.appPath = appPathString;
			return null;
		}

		public Builder setAppPackage(String appPackage) {
			this.appPackage = appPackage;
			return this;
		}

		public Builder setAppActivity(String appActivity) {
			this.appActivity = appActivity;
			return this;
		}

		public Builder setNoReset(String noReset) {
			this.noReset = noReset;
			return this;
		}

		public Builder setNoSign(String noSign) {
			this.noSign = noSign;
			return this;
		}

		public Builder setCommandTimeout(String commandTimeout) {
			this.commandTimeout = commandTimeout;
			return this;
		}

		public InitAppium builder() {
			return new InitAppium(this);
		}

	}

	/**
	 * 测试套件 初始化appium服务
	 */
	@BeforeSuite

	public void startAppium() {
		System.setProperty("nodepath", "D:\\Program Files\\nodejs\\node.exe");
		System.setProperty("appiumjspath",
				"C:\\Users\\luyuexin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");

		File nodeFile = new File(System.getProperty("nodepath"));
		File appiumjs = new File(System.getProperty("appiumjspath"));
		ServerArguments serverArguments = new ServerArguments(); // 初始化服务器参数类
		aserver = new AppiumServer(nodeFile, appiumjs, serverArguments);
		aserver.startServer(30000);
		System.out.println(aserver.toString());
		// appiumserver监听类
		AppiumServerController act = new AppiumServerController();
		System.out.println(act.checkServerState("127.0.0.1", 4723));
	}

	/**
	 * @throws MalformedURLException
	 * 
	 */
	@BeforeTest
	public void setAppium() throws MalformedURLException {
		InitAppium initAppium = new InitAppium();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, initAppium.automationName);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, initAppium.automationName);
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, initAppium.platformName); // 设置平台
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, initAppium.platformVersion); // 设置系统版本
		cap.setCapability(MobileCapabilityType.APP_PACKAGE, initAppium.appPackage); // 设置包名
		cap.setCapability("udid", "DWT7N19422002869"); // 设置设备名 adb devices 对应设备名称
		cap.setCapability(MobileCapabilityType.APP_ACTIVITY, initAppium.appActivity); // 设置打卡的Activity
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, initAppium.commandTimeout);
		cap.setCapability("noReset", "true");// she
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	}

	@AfterSuite
	public void stopAppium() {
//		aserver.stopServer();
	}

}
