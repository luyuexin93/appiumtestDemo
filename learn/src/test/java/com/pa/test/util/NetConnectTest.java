package com.pa.test.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.pa.util.NetworkState;
import io.appium.java_client.NetworkConnectionSetting;
import io.appium.java_client.android.AndroidDriver;

public class NetConnectTest {
	private static AndroidDriver driver=null;
	  private static DesiredCapabilities cap=new DesiredCapabilities();
	  private String projectpath = System.getProperty("user.dir");
	  private static NetworkConnectionSetting nct;
	  
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
		  
	  }
	  
	public static void main(String [] args) throws MalformedURLException {
		HashMap<String, Object> map = new HashMap<String, Object>();
		HashMap<String, Object> map2 = new HashMap<String, Object>();
		NetConnectTest.setAppium();
		nct=driver.getNetworkConnection();
		String netString=nct.toString();
		System.out.println(netString);
		map=NetworkState.getNetworkState(nct);
		if(map.get("wifiMode").equals(true)) {
			System.out.println("wifiEnabled");
		}else {
			System.out.println("wifiDisabled");
		}
		if (map.get("dataMode").equals(true)) {
			System.out.println("data is ok");
		}
		NetworkState.setWiFiOn(driver, nct);
		
	}
}
