package com.pa.location;

public interface LoginLocation {

	String ACCOUNTID_STRING = "account"; // 账号id
	String PASSWORDID_STRING = "password"; // 密码id
	String LOGINID_STRING = "login_click"; // 登陆按钮id
	String LOGIN_MESSAGE = "//android.widget.TextView[@resource-id='android:id/message']";// 登陆失败返回信息
	String LOGIN_WAIT = "//android.widget.TextView[@resource-id='com.zjipst.pa:id/dialog_message'][contains(@text,'正在登录')]";// 登陆等待信息
}
