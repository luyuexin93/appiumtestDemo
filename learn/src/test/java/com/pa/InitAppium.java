package com.pa;

import static org.testng.Assert.assertNotEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.comcast.magicwand.spells.appium.dawg.utils.AppiumServerController;
import com.github.genium_framework.appium.support.server.AppiumServer;
import com.github.genium_framework.server.ServerArguments;
import com.pa.page.LoginPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;

/**
 * @author lu 初始化Appium 及driver连接
 */
@Epic("初始化Appium及driver")
public class InitAppium {

	public String automationName = "Uiautomator2"; //
	public String deviceName;
	public String platformName = "Android";
	public String platformVersion = "7.1";
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

	private static Logger logger = LoggerFactory.getLogger(InitAppium.class);

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
		private String automationName = "Uiautomator2"; //
		private String deviceName = "S4";
		private String platformName = "Android";
		private String platformVersion = "5.1";
		private String udid = "127.0.0.1:7555"; // 设备唯一标识符
		private String appPath; // 应用apk路径
		private String appPackage = "com.zjipst.pa"; // 应用包名
		private String appActivity = ".MainActivity"; // 启动的activity
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
	@BeforeSuite(description = "启动Appiumf服务")
	@Description("启动Appium服务")

	public void startAppium() throws IOException {
		// node 和appium js 路径
//		System.setProperty("nodepath", "D:\\Program Files\\nodejs\\node.exe");
//		System.setProperty("appiumjspath",
//				"C:\\Users\\luyuexin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		// 改用appium.properties读取配置文件
		File nodeFile;
		File appiumjs;
		/**
		 * 打开appium.properties文件流 读取appium安装配置
		 */
		Path appiumPath = FileSystems.getDefault().getPath("src", "test", "resources", "appium.properties");
		try (InputStream is = Files.newInputStream(appiumPath)) {
			Properties properties = new Properties();
			properties.load(is);
			nodeFile = new File(properties.getProperty("nodepath"));
			appiumjs = new File(properties.getProperty("appiumpath"));
		}
		;
		ServerArguments serverArguments = new ServerArguments(); // 初始化服务器参数类
		aserver = new AppiumServer(nodeFile, appiumjs, serverArguments);
		aserver.startServer(30000);
		System.out.println(aserver.toString());
		// appiumserver监听类
		AppiumServerController act = new AppiumServerController();
		if (act.checkServerState("127.0.0.1", 4723)) {
			logger.info("APPIUM 服务启动成功");
		}
		;

	}

//	@BeforeTest(description = "安装应用")
	@Description
	public void installApp() throws IOException, InterruptedException {
		System.out.println("@test");
	  	File app = new File("E:/apks/PoliceAssistant_2.4.7.860_100-oatest.apk");
		if(!app.exists()) {
			return;
		}
		String appPath=app.getAbsolutePath();
		logger.error("安装包路径 "+appPath);
		logger.info("开始卸载apk");
		Process process=Runtime.getRuntime().exec("adb -s uninstall com.zjipst.pa" );
		

		process.waitFor();
		process.destroy();
		logger.info("开始安装apk");
		String cmd="adb -s 127.0.0.1:7555 install "+appPath;
		Process install=Runtime.getRuntime().exec(cmd);
		InputStream is = install.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line + "\n");
		}
//		install.wait(30);
		Thread.sleep(3000);
		install.destroy();
		is.close();
		logger.debug(sb.toString());
		
	}
	
	
	
	/**
	 * @throws MalformedURLException
	 * 
	 */
	@BeforeClass
	@Description("初始化driver连接配置，连接Appium")
	public void setAppium() throws MalformedURLException {
		InitAppium initAppium = new InitAppium();
//		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, initAppium.automationName);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Uiautomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, initAppium.deviceName);
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, initAppium.platformName); // 设置平台
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, initAppium.platformVersion); // 设置系统版本
//		cap.setCapability("udid", initAppium.udid); // 设置设备名 adb devices 对应设备名称
//		cap.setCapability("udid", "DWT7N19422002869"); // 设置设备名 adb devices 对应设备名称
		cap.setCapability("udid", "192.168.205.102:5555"); // 设置设备名 adb devices 对应设备名称
		
	  	File app = new File("E:/apks/PoliceAssistant_2.4.7.860_100-oatest.apk");
		if(!app.exists()) {
			return;
		}
		String appPath=app.getAbsolutePath();
		cap.setCapability(MobileCapabilityType.APP, appPath); // 设置包名
		cap.setCapability(MobileCapabilityType.APP_ACTIVITY, initAppium.appActivity); // 设置打卡的Activity
//		cap.setCapability(MobileCapabilityType.APP_ACTIVITY, "MainActivity"); // 设置打卡的Activity
		cap.setCapability(MobileCapabilityType.APP_PACKAGE, initAppium.appPackage); // 设置包名
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, initAppium.commandTimeout);
//		cap.setCapability("noReset", false);
		cap.setCapability("noSign", true);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@AfterSuite(description = "关闭Appium服务")
	@Description("关闭Appium服务")
	public void stopAppium() {
		logger.info("afterSuite: 关闭logger服务");
		aserver.stopServer();
	}

//	@Test
	@Description("设置权限")
	public void setRights() {
		try {
			driver.findElement(By.id("goto_settings")).click();
			// 权限窗口 点击始终允许
			for (int i = 0; i < 6; i++) {
				driver.findElementByXPath("//*[@text='始终允许']").click();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		LoginPage loginPage = new LoginPage();
		loginPage.driver = driver;
		assertNotEquals(null, loginPage.getAccount());
		loginPage.takeScreenshotByte("loginPage");
	}
	
	@Test
	public void run() {
		logger.debug("test");
	}
}
