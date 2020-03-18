package com.pa;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;


import com.pa.controller.LoginController;
import io.appium.java_client.NetworkConnectionSetting;
import io.appium.java_client.android.AndroidDriver;


public class Test2 {
	 private static AndroidDriver driver=null;
	  private static DesiredCapabilities cap=new DesiredCapabilities();
	  private String projectpath = System.getProperty("user.dir");
	  private NetworkConnectionSetting nct=new NetworkConnectionSetting(false, true, true);
	  
	  //获取系统属性
	  
	  public static void setAppium() throws MalformedURLException{
		  cap.setCapability("automationName", "Appium");
		  cap.setCapability("deviceName", "S4");
		  cap.setCapability("platformName", "Android"); //设置平台
		  cap.setCapability("platformVersion", "9");    //设置系统版本
		  cap.setCapability("appPackage","com.zjipst.pa" ); //设置包名
		  cap.setCapability("uuid", "DWT7N19422002869");    //设置设备名  adb devices 对应设备名称
		  cap.setCapability("appActivity", ".SplashActivity"); //设置打卡的Activity
		  cap.setCapability("newCommandTimeout", "30");
		  cap.setCapability("noReset", "true");//she
		  driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  driver.getNetworkConnection();
	  }
	  

	  
	  public static void main(String []args) throws Exception {
		  Test2.setAppium();
		  LoginController.login(driver, "057105", "057105");
//		  if(Element.isElementExist(LoginPage.login_Wait(driver))) {
//			  System.out.println(LoginPage.login_Wait(driver).getText());
//		  }
//		  if(Element.isElementExist(LoginPage.login_Message(driver))) {
//			  System.out.println(LoginPage.login_Message(driver).getText());
//		  }
		  try {
			  File screenShot = driver.getScreenshotAs(OutputType.FILE); //此段停止执行，提示 Connection reset
			  Date date=new Date();
			  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			  String timeString=sdf.format(date);
//			  FileUtils.copyFile(screenShot,new File("D:\\testscrren.jpg"));
			  FileUtils.copyFile(screenShot,new File("./screenshot/"+timeString+".jpg"));

			  } catch (Exception e) {
			  e.printStackTrace(); }
			  }
	  
}
