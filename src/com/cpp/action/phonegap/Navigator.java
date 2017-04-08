package com.cpp.action.phonegap;

/**
 * @author Administrator
 *
 */
public class Navigator {
	private String latitude;
	private String longitude;
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public String execute(){
		System.out.println("执行");
		System.out.println("获得位置定位  y--->"+latitude+"x:::-->"+longitude);
		return null;
	}
}
