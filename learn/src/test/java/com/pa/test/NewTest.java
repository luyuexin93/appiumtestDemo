package com.pa.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest {
	
  private static   Logger logger = LoggerFactory.getLogger(NewTest.class);
  
  @Test
  public void f() {
	  System.out.println("@test");
	 System.out.println(System.getProperty("user.dir"));
	  logger.error("this is error");
  }
  @Test
  public void f2() throws IOException, InterruptedException {
//	  String adbHome="/Users/xiaowen/Library/Android/sdk/platform-tools/";
//      String cmd=adbHome+"adb version";
//      Process process;
//      try {
//          process=Runtime.getRuntime().exec(cmd);
//          System.out.println(InputStream2String(process.getInputStream()));
//      } catch (IOException e) {
//          e.printStackTrace();
//      }

	  
	  	System.out.println("@test");
	  	File app = new File("E:/apks/PoliceAssistant_2.4.7.860_100-oatest.apk");
		if(!app.exists()) {
			return;
		}
		String appPath=app.getAbsolutePath();
		logger.error("安装包路径 "+appPath);
		logger.info("开始卸载apk");
		Process process=Runtime.getRuntime().exec("adb -s 127.0.0.1:7555 uninstall com.zjipst.pa" );
		

		process.waitFor();
		process.destroy();
		logger.info("开始安装apk");
		String cmd="adb -s 127.0.0.1:7555 install "+appPath;
		Process install=Runtime.getRuntime().exec(cmd);
		InputStream is = install.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line + "\n");
		}
//		install.wait(30);
		Thread.sleep(3000);
		install.destroy();
		is.close();
		System.out.println(sb.toString());
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("@beforemethodtest");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("@aftermethotest");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("this @beforeclass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("this is @afterclasstest");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("this is @beforetest");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println(" this is @aftertest");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("this is @beforesuitetest");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("this is @aftersuitetest");
  }

}
