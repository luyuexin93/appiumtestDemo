package com.pa.test;

import static org.testng.Assert.assertNotEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.pa.page.MainPage;

public class MainPageTest {
	
  public MainPage mpage = new MainPage();
  private static Logger logger= LoggerFactory.getLogger(MainPageTest.class);
  @Test
  public void findwork() {
	  if (mpage.driver==null) {
			 logger.error("driver 为空");
		 }
	  assertNotEquals(mpage.getWork(), null);
	  mpage.getWork().click();
  }
}
