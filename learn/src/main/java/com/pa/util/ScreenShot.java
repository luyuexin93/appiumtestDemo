/**
 * 
 */
package com.pa.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import io.appium.java_client.android.AndroidDriver;


/**
 * @author luyuexin
 * screenshot simple 
 */
public class ScreenShot {
	public static void takeScreenshot(AndroidDriver driver) {
		
		try {
			File screenShot = driver.getScreenshotAs(OutputType.FILE);  //创建截图文件
			Date date=new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String timeString=sdf.format(date);
//		  FileUtils.copyFile(screenShot,new File("D:\\testscrren.jpg"));
			FileUtils.copyFile(screenShot,new File("./screenshot/"+timeString+".jpg"));
			
		} catch (Exception e) {
			e.printStackTrace(); }
	}
}
