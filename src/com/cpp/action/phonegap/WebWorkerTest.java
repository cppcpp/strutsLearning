package com.cpp.action.phonegap;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class WebWorkerTest {
	private String name;
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public String test(){
		HttpServletResponse response= ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		System.out.println("Ö´ÐÐ");
		System.out.println("name----"+name);
		return null;
	}
}
