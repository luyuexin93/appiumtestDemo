package com.learndemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Aweme {

	/**
	 * 抖音极速版登录 自动刷视频demo
	 * 
	 * @param args
	 * @throws MalformedURLException
	 * @throws InterruptedException
	 */

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		AndroidDriver driver;
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("deviceName", "S4");
		cap.setCapability("platformName", "Android"); // 设置平台
		cap.setCapability("platformVersion", "9"); // 设置系统版本
		cap.setCapability("appPackage", "com.ss.android.ugc.aweme.lite"); // 设置包名
		cap.setCapability("uuid", "DWT7N19422002869"); // 设置设备名 adb devices 对应设备名称
		cap.setCapability("appActivity", "com.ss.android.ugc.aweme.splash.SplashActivity");
		cap.setCapability("noReset", "true");// 设置打卡的Activity
		cap.setCapability("newCommandTimeout", 30);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		  driver.findElement(By.id("rh")).click();
		// 权限窗口 点击始终允许
//		  
//		  try {
//			  
//			  driver.findElementByXPath("//*[@text='确定']").click();
//		  } catch (Exception e) {
//			  System.out.println("ok");
//			  for(int i=0;i<2;i++) {
//				  driver.findElementByXPath("//*[@text='始终允许']").click();
//			  }
//		  }
//		  
//		  //关闭红包图片
//		  driver.findElementById("w7").click();
//		  //进入主界面
//		  driver.tap(1, 550, 1022, 100);
//		  //点击 跳转到登录页
//		  driver.findElementByXPath("//*[@resource-id='com.ss.android.ugc.aweme.lite:id/c2n'][@text='我']").click();
//		  //勾选同意隐私政策
//		  driver.findElementById("bgg").click();
//		  //本机号码一键登录
//		  driver.findElementByXPath("//*[@resource-id='com.ss.android.ugc.aweme.lite:id/b4a']").click();
		// 向上滑动
		int i = 0;
		/**
		 * 向上滑动10次
		 */
		while (i < 1000) {
//		  for(int i=0;i<3;i++) {
//			  driver.swipe(500, 1500,500, 400, 1000);
//			  Thread.currentThread();
//			  Thread.sleep(20000);
//			  
//		  }
			driver.swipe(500, 1500, 500, 400, 1000);
			Thread.currentThread();
			Thread.sleep(10000);
			i++;
		}
		// 系统回退键
		driver.sendKeyEvent(AndroidKeyCode.BACK);
		/*
		 * public interface AndroidKeyCode {
		 * 
		 * int BACK = 4; int BACKSPACE = 67; int DEL = 67; int ENTER = 66; int HOME = 3;
		 * int MENU = 82; int SETTINGS = 176; int SPACE = 62;
		 * 
		 * }
		 */
	}

}
