package com.pa.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
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
	  logger.error("this is error");
  }
  @Test
  public void f2() {
	  System.out.println("@test");
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
