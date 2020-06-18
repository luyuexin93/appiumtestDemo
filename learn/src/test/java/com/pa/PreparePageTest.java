package com.pa;

import static org.testng.Assert.assertNotEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.pa.page.MainPage;
import com.pa.page.PreparePage;

public class PreparePageTest {

	public PreparePage prepage = new PreparePage();
	private static Logger logger = LoggerFactory.getLogger(PreparePageTest.class);

	@Test(dependsOnGroups = "LoginModule")
	public void findwork() {
		if (prepage.driver == null) {
			logger.error("driver 为空");
		}
//		assertNotEquals(mpage.getWork(), null);
//		mpage.getWork().click();
	}
}
