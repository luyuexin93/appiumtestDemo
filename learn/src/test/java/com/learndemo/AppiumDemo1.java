package com.learndemo;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class AppiumDemo1 {
  @Test
  public void f() throws Exception {
	  AndroidDriver driver;
	  DesiredCapabilities cap = new DesiredCapabilities();
	  cap.setCapability("automationName", "Appium");
	  cap.setCapability("deviceName", "S4");
	  cap.setCapability("platformName", "Android"); //设置平台
	  cap.setCapability("platformVersion", "9");    //设置系统版本
	  cap.setCapability("appPackage","com.zjipst.pa" ); //设置包名
	  cap.setCapability("uuid", "DWT7N19422002869");    //设置设备名  adb devices 对应设备名称
	  cap.setCapability("appActivity", ".SplashActivity"); //设置打卡的Activity
	  cap.setCapability("newCommandTimeout", "30");
	  driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.findElement(By.id("goto_settings")).click();
	  //权限窗口 点击始终允许
	  for(int i=0;i<6;i++) {
		  driver.findElementByXPath("//*[@text='始终允许']").click();
	  }
	  
	  
  }
}
