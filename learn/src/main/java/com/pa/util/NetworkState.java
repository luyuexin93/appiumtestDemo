package com.pa.util;

import java.util.HashMap;

import io.appium.java_client.NetworkConnectionSetting;
import io.appium.java_client.android.AndroidDriver;

public class NetworkState {
	private static AndroidDriver driver = null;
	private static NetworkConnectionSetting nct=null;
	public static final int DATA_ONLY=4;
	public static final int WIFI_ONLY=2;
	public static final int ALL_MODE=7;
	
	/**
	 * format networkConnectionSetting to HashMap
	 * @param nct
	 * @return
	 */
	
	public static HashMap<String, Object> getNetworkState(NetworkConnectionSetting nct ) {
	    HashMap<String, Object> map = new HashMap<String, Object>();
		if(nct!=null) {
			try {
				if(nct.airplaneModeEnabled()) {
					map.put("airplaneMode", true);
				}else {
					map.put("airplaneMode", false);
				}
				if(nct.dataEnabled()) {
					map.put("dataMode", true);
				}else {
					map.put("dataMode", false);
				}
				if(nct.wifiEnabled()) {
					map.put("wifiMode", true);
				}else {
					map.put("wifiMode", false);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		return map;
	}
	
	public static NetworkConnectionSetting setDataOnly(NetworkConnectionSetting nct) {
		nct.value=DATA_ONLY;
		return nct;
	}
	
	public static NetworkConnectionSetting setWiFiOnly(NetworkConnectionSetting nct) {
		nct.value=WIFI_ONLY;
		return nct;
	}
	
	public static NetworkConnectionSetting setAll_Mode(NetworkConnectionSetting nct) {
		nct.value=ALL_MODE;
		return nct;
	}
	
	public static void setWiFiOff(AndroidDriver driver,NetworkConnectionSetting nct) {
		if (!driver.equals(null)) {
			nct.setWifi(false);
		}
	}
	public static void setWiFiOn(AndroidDriver driver,NetworkConnectionSetting nct) {
		if (!driver.equals(null)) {
			nct.setWifi(true);
		}
	}
	
	public static void dataOff(AndroidDriver driver,NetworkConnectionSetting nct) {
		if (!driver.equals(null)) {
			nct.setData(false);
		}
	}
	
	public static void dataOn(AndroidDriver driver,NetworkConnectionSetting nct) {
		if (!driver.equals(null)) {
			nct.setData(true);
		}
	}
	public static void airplaneOn(AndroidDriver driver,NetworkConnectionSetting nct) {
		if (!driver.equals(null)) {
			nct.setAirplaneMode(true);
		}
	}
	public static void airplaneOff(AndroidDriver driver,NetworkConnectionSetting nct) {
		if (!driver.equals(null)) {
			nct.setAirplaneMode(false);
		}
	}
	
	
	
	
	
}
