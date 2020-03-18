package com.pa.test.util;

public class SimpleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		  int value = 0;
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
		
		System.out.println(1|2|4);
		System.out.println(1|0|4);
		System.out.println(0|2|4);
		System.out.println(1|2|0);
		System.out.println(1|0|4);
		
		
	}

}
