package com.cpp.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class MyCookie {
	
	public Cookie addCookie(String name,String password){
		System.out.println("添加cookie");
		try {
			//cookie传中文需要编码
			String codeName= URLEncoder.encode(name, "utf-8");
			String codePassword=URLEncoder.encode(password, "utf-8");
			Cookie cookie=new Cookie("user",codeName+","+codePassword);
			cookie.setMaxAge(60*60);
			return cookie;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Cookie removeCookie(HttpServletRequest request){
		Cookie[] cookies=request.getCookies();
		if(cookies==null){
			return null;
		}
		for(Cookie cookie:cookies){
			if(cookie.getName().equals("user")){
				cookie.setMaxAge(0);
				cookie.setValue(null);
				System.out.println("删除cookie");
				return cookie;
			}
		}
		return null;
	}
}
