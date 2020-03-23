package com.pa.page;

import javax.annotation.Resource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class MainPage extends BasePage {
	public static WebElement work_img;
	
	public WebElement Indexbtn() {
		WebElement element = null;
		return element;
	}
	
	public WebElement getWork() {
		work_img=findElement(By.xpath("//android.widget.ImageView[@resource-id='com.zjipst.pa:id/img_work']"));
		return work_img;
	}
}
