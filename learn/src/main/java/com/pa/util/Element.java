package com.pa.util;

import org.openqa.selenium.WebElement;

public class Element {
	 public static boolean isElementExist (WebElement element) {
		 if (element==null) {
			return false;
		}else {
			return true;
		}
	 }
}
