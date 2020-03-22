package com.pa.controller;

import com.pa.page.MainPage;

import io.appium.java_client.android.AndroidDriver;

public class MainController {
	public MainPage mainPage = new MainPage();

	public MainController(AndroidDriver driver) {
		MainPage.driver = driver;
	}
}
