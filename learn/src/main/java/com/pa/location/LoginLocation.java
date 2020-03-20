package com.pa.location;

public interface LoginLocation {

	String ACCOUNTID_STRING = "account";
	String PASSWORDID_STRING = "password";
	String LOGINID_STRING = "login_click";
	String LOGIN_MESSAGE = "//android.widget.TextView[@resource-id='android:id/message']";
	String LOGIN_WAIT = "//android.widget.TextView[@resource-id='com.zjipst.pa:id/dialog_message'][contains(@text,'正在登录')]";
}
