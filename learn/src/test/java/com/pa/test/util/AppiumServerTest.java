package com.pa.test.util;

import java.io.File;
import java.util.HashMap;

import com.comcast.magicwand.spells.appium.dawg.utils.AppiumServerController;
import com.github.genium_framework.appium.support.server.AppiumServer;
import com.github.genium_framework.server.ServerArguments;

public class AppiumServerTest {
	
	public static void main(String []args) {
		System.setProperty("nodepath", "D:\\Program Files\\nodejs\\node.exe");
		System.setProperty("appiumjspath", "C:\\Users\\luyuexin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		
		File nodeFile = new File(System.getProperty("nodepath"));
		File appiumjs = new File(System.getProperty("appiumjspath"));
		ServerArguments serverArguments = new ServerArguments(); //初始化服务器参数类
		AppiumServer aserver= new AppiumServer(nodeFile, appiumjs, serverArguments);
		aserver.startServer(30000);
		System.out.println(aserver.toString());
		//appiumserver监听类
		AppiumServerController act = new AppiumServerController();
		System.out.println(act.checkServerState("127.0.0.1", 4723));
		aserver.stopServer();
		System.out.println(act.checkServerState("127.0.0.1", 4723));
	}
}
