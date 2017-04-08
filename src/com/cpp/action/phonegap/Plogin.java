package com.cpp.action.phonegap;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;

public class Plogin {
	private String userName;
	private String userPassword;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public String login(){
		String flag=null;
		System.out.println("userName--"+userName+"       userPassword"+userPassword);
		
		if(userName.equals("tom")&&userPassword.equals("123")){
			flag="success";
		}else{
			flag="error";
		}
		
		JSONObject json=new JSONObject();
		json.put("flag", flag);
		System.out.println(json.toString());
		
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			PrintWriter out=response.getWriter();
			out.println(json.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

}
