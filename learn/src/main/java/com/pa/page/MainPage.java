package com.pa.page;

import javax.annotation.Resource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pa.location.MainLocation;




public class MainPage extends BasePage {
//	String QB_STRING = "//*android.widget.RelativeLayout[@resource-id='com.zjipst.pa:id/rl1']"; //全部警情
//	String DQS_STRING = "//*android.widget.RelativeLayout[@resource-id='com.zjipst.pa:id/rl2']";//待签收
//	String CLZ_STRING = "//*android.widget.RelativeLayout[@resource-id='com.zjipst.pa:id/rl3']";//处理中
//	String YWC_String = "//*android.widget.RelativeLayout[@resource-id='com.zjipst.pa:id/rl3']";//已完成
//	String QS_btn ="txt_sign";//签收按钮
	private WebElement all_jq;
	private WebElement dqs_jq;
	private WebElement clz_jq;
	private WebElement ywc_jq;
	public WebElement getAll_jq() {
		all_jq=findElement(By.xpath(MainLocation.QB_STRING));
		return all_jq;
	}
	public WebElement getDqs_jq() {
		dqs_jq=findElement(By.xpath(MainLocation.DQS_STRING));
		return dqs_jq;
	}
	public WebElement getClz_jq() {
		clz_jq=findElement(By.xpath(MainLocation.CLZ_STRING));
		return clz_jq;
	}
	public WebElement getYwc_jq() {
		ywc_jq=findElement(By.xpath(MainLocation.YWC_String));
		return ywc_jq;
	}
	
	
	

}
