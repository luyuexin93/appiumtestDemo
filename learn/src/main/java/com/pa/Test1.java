package com.pa;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.pa.location.LoginLocation;

import io.appium.java_client.android.AndroidDriver;

public class Test1 {
	
		
		  private static AndroidDriver driver=null;
		  private static DesiredCapabilities cap=new DesiredCapabilities();
		  private String projectpath = System.getProperty("user.dir");
		  //获取系统属性
		  
		  public void setAppium() throws MalformedURLException{
			  cap.setCapability("automationName", "Appium");
			  cap.setCapability("deviceName", "S4");
			  cap.setCapability("platformName", "Android"); //设置平台
			  cap.setCapability("platformVersion", "9");    //设置系统版本
			  cap.setCapability("appPackage","com.zjipst.pa" ); //设置包名
			  cap.setCapability("uuid", "DWT7N19422002869");    //设置设备名  adb devices 对应设备名称
			  cap.setCapability("appActivity", ".SplashActivity"); //设置打卡的Activity
			  cap.setCapability("newCommandTimeout", "30");
			  cap.setCapability("noReset", "true");
			  driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			  
		  }
		  public void setPermission() throws Exception {
			  try {
				  driver.findElement(By.id("goto_settings")).click();
				  //权限窗口 点击始终允许
				  for(int i=0;i<6;i++) {
					  driver.findElementByXPath("//*[@text='始终允许']").click();
				  }
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		  }
		  
		  public void login() {
			  try {
				driver.findElement(By.id(LoginLocation.ACCOUNTID_STRING)).sendKeys("057105");
				driver.findElement(By.id(LoginLocation.PASSWORDID_STRING)).sendKeys("057105");
				driver.findElement(By.id(LoginLocation.LOGINID_STRING)).click();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		  }
		  
		  public boolean isElementExist(By by) {
			  try {
				  driver.findElement(by);
				  return true;
			} catch (Exception e) {
				// TODO: handle exception
				return false;
			}
			
			  
		  }
		  
		  public static void main(String []args) throws Exception {
			  Test1 test1= new Test1();
			  test1.setAppium();
//			  test1.setPermission();
			  test1.login();
			  
		  }
			  
}
