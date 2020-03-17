package com.pa.util;

import io.appium.java_client.android.AndroidDriver;

public class NetworkState {
	private static AndroidDriver driver = null;
	
	public static void getNewworkState(AndroidDriver Driver ) {
		if(driver!=null) {
			driver.getNetworkConnection();
		}
	}
}
