package com.pa.page;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

/**
 * @author luyuexin
 * 页面事件基类
 */
public class BasePage {
	public  static AndroidDriver driver;
	
	
	public WebElement findElement( By by) {
	   return driver.findElement(by);
	}
	public List<WebElement> findElements(By by){
		return driver.findElements(by);
	}
	public void click(By by) {
		findElement(by).click();
	}
	
	public void sendKeys(By by,String keys) {
		findElement(by).sendKeys(keys);
	}
	
	public String getText(By by) {
		return findElement(by).getText();
	}
	
	
}
