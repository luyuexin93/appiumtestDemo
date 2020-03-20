package com.pa.test;

public class InitAppium {
	private static String automationName = "Appium"; //
	private static String deviceName;
	private static String platformName = "Android";
	private static String platformVersion = "9";
	private static String udid; // 设备唯一标识符
	private static String appPath; // 应用apk路径
	private static String appPackage; // 应用包名
	private static String appActivity; // 启动的activity
	private static String noReset; // 默认不重置应用 清空数据
	private static String noSign;
	private static String commandTimeout; // 命令超时时间

	public InitAppium() {
		this(new Builder());
	}

	// https://testerhome.com/topics/9904
	public InitAppium(Builder builder) {
		// TODO Auto-generated constructor stub
		this.automationName = builder.automationName; //
		this.deviceName = builder.deviceName;
		this.platformName = builder.platformName;
		this.platformVersion = builder.platformName;
		this.udid = builder.udid; // 设备唯一标识符
		this.appPath = builder.appPath; // 应用apk路径
		this.appPackage = builder.appPackage; // 应用包名
		this.appActivity = builder.appActivity; // 启动的activity
		this.noReset = builder.noReset; // 默认不重置应用 清空数据
		this.noSign = builder.noSign;
		this.commandTimeout = builder.commandTimeout; // 命令超时时间
	}

	/**
	 * @author lu 初始化默认参数内部类Builder
	 */
	public static class Builder {
		private String automationName = "Appium"; //
		private String deviceName = "S4";
		private String platformName = "Android";
		private String platformVersion = "9";
		private String udid = "DWT7N19422002869"; // 设备唯一标识符
		private String appPath; // 应用apk路径
		private String appPackage = "com.zjipst.pa"; // 应用包名
		private String appActivity = ".SplashActivity"; // 启动的activity
		private String noReset = "True"; // 默认不重置应用 清空数据
		private String noSign = "True";
		private String commandTimeout = "30"; // 命令超时时间

		public Builder() {
		}

		public Builder setAutomationName(String automationName) {
			this.automationName = automationName;
			return this;
		}

		public Builder setDeviceName(String deviceName) {
			this.deviceName = deviceName;
			return this;
		}

		public Builder setPlatformName(String platformName) {
			this.platformName = platformName;
			return this;
		}

		public Builder setPlatformVersion(String platformVersion) {
			this.platformVersion = platformVersion;
			return this;

		}

		public Builder setUdid(String udid) {
			this.udid = udid;
			return this;
		}

		public Builder setAppPathString(String appPathString) {
			this.appPath = appPathString;
			return null;
		}

		public Builder setAppPackage(String appPackage) {
			this.appPackage = appPackage;
			return this;
		}

		public Builder setAppActivity(String appActivity) {
			this.appActivity = appActivity;
			return this;
		}

		public Builder setNoReset(String noReset) {
			this.noReset = noReset;
			return this;
		}

		public Builder setNoSign(String noSign) {
			this.noSign = noSign;
			return this;
		}

		public Builder setCommandTimeout(String commandTimeout) {
			this.commandTimeout = commandTimeout;
			return this;
		}

		public InitAppium builder() {
			return new InitAppium(this);
		}

	}
}
