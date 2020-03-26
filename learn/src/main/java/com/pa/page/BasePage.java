package com.pa.page;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Attachment;

/**
 * @author luyuexin 页面事件基类
 */
public class BasePage {
	public static AndroidDriver driver;

	public WebElement findElement(By by) {
		return driver.findElement(by);
	}

	public List<WebElement> findElements(By by) {
		return driver.findElements(by);
	}

	public void click(By by) {
		findElement(by).click();
	}

	public void sendKeys(By by, String keys) {
		findElement(by).sendKeys(keys);
	}

	public String getText(By by) {
		return findElement(by).getText();
	}

	public String takeScreenshot(String filename) throws IOException {

		File screenShot = this.driver.getScreenshotAs(OutputType.FILE); // 创建截图文件
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String timeString = sdf.format(date);
		String tmpFilename = filename + timeString;
//		  FileUtils.copyFile(screenShot,new File("D:\\testscrren.jpg"));
		FileUtils.copyFile(screenShot, new File("./screenshot/" + tmpFilename + ".jpg"));
		return tmpFilename;
	}

	@Attachment(value = "Page screenshot", type = "image/png")
	public byte[] takeScreenshotByte(String filename) {
		byte[] screenshot = this.driver.getScreenshotAs(OutputType.BYTES);
		return screenshot;

	}

}
