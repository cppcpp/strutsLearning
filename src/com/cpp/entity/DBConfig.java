package com.cpp.entity;

public class DBConfig {
	private static String driver;
	private static String url;
	private static String userName;
	private static String password;
	
	
	public static String getDiver() {
		return driver;
	}
	public static void setDiver(String driver) {
		DBConfig.driver = driver;
	}
	public static String getUrl() {
		return url;
	}
	public static void setUrl(String url) {
		DBConfig.url = url;
	}
	public static String getUserName() {
		return userName;
	}
	public static void setUserName(String userName) {
		DBConfig.userName = userName;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		DBConfig.password = password;
	}
	@Override
	public String toString() {
		return "DBConfig [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
}
