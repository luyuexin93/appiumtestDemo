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
	
	
	
	public static HashMap<String, Object> getNetworkState(NetworkConnectionSetting nct ) {
//		public int value = 0;
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
	
}
