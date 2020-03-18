package com.pa.util;

import java.util.HashMap;

import io.appium.java_client.NetworkConnectionSetting;
import io.appium.java_client.android.AndroidDriver;

public class NetworkStates extends NetworkConnectionSetting {
	
	public static final int DATA_ONLY=4;
	public static final int WIFI_ONLY=2;
	public static final int ALL_MODE=7;
	public  int value=0;
	
	
	public NetworkStates(boolean airplaneMode, boolean wifi, boolean data) {
		super(airplaneMode, wifi, data);
		// TODO Auto-generated constructor stub
		
	}
	public NetworkStates(int bitmap) {
		super(bitmap);
	}
	
	public void setDataOnly() {
		value=DATA_ONLY;
	}
	public void setWifiOnly() {
		value=WIFI_ONLY;
	}
	public void setAll() {
		value=ALL_MODE;
	}
	public HashMap<String, Object> getNetworkState() {
//		 public int value = 0;
//		  private int airplaneMode = 1;
//		  private int wifi = 2;
//		  private int data = 4;
//
//		  /**
//		   *
//		   * @param airplaneMode boolean for airplane mode enabled
//		   * @param wifi boolean for wifi enabled
//		   * @param data boolean for data enabled
//		   */
//		  public NetworkConnectionSetting(boolean airplaneMode, boolean wifi, boolean data) {
//		    int a = airplaneMode ? this.airplaneMode : 0;
//		    int b = wifi ? this.wifi : 0;
//		    int c = data ? this.data : 0;
//
//		    value = a | b | c;
//		  }
//			public boolean airplaneModeEnabled() { return (value & airplaneMode) != 0; }
//
//		  public boolean wifiEnabled() { return (value & wifi) != 0; }
//
//		  public boolean dataEnabled() { return (value & data) != 0; }
	    HashMap<String, Object> map = new HashMap<String, Object>();
		if (airplaneModeEnabled()) {
			map.put("airplaneMode", true);
		}else {
			map.put("airplaneMode", false);
		}
		if (wifiEnabled()) {
			map.put("wifiMode", true);
		}else {
			map.put("wifiMode", false);
		}
		if (dataEnabled()) {
			map.put("dataMode", true);
		}else {
			map.put("dataMode", false);
		}
		return map;
	}
	
	public static void main(String[] args) {
		NetworkStates nss = new NetworkStates(7);
		System.out.println(nss.toString());
		System.out.println(nss.getNetworkState().get("dataMode"));
		
		
	}



}