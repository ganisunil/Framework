package com.poc.utilities;

public class PropHolder {
	
	private static String url;
	private static String browserName;
	private static String userName;
	private static String password;
	
	public static void setUrl(String urllink) {
		url = urllink;
	}
	
	public static String getUrl() {
		return url;
	}
	
	public static void setBrowserName(String browser) {
		browserName = browser;
	}
	
	public static String getBrowserName() {
		return browserName;
	}
	
	public static void setUserName(String userNameValue) {
		userName = userNameValue;
	}

	public static String getUserName() {
		return userName;
	}

	public static void setPassword(String passwordValue) {
		password = passwordValue;
	}

	public static String getPassword() {
		return password;
	}

	
}
