package com.cpp.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.cpp.dao.daoImpl.checkLoginDaoImpl;
import com.cpp.util.MyCookie;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/*
 *struts前台到后台传值 ---两种方法：
 *字段驱动
 *模型驱动
 * 
 * 
 * */
public class LoginAction extends ActionSupport{
	private String userName;
	private String userPassword;
	private String userCode;
	private String remenber;
	
	checkLoginDaoImpl ldi=new checkLoginDaoImpl();
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpServletResponse response=ServletActionContext.getResponse();
	HttpSession session=request.getSession();
	MyCookie mycookie=new MyCookie();
	
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
	
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	
	public String getRemenber() {
		return remenber;
	}
	public void setRemenber(String remenber) {
		this.remenber = remenber;
	}
	public String loginIn(){
		
			/*//解决乱码
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");*/
		String code=(String) session.getAttribute("code");
		System.out.println("name:"+userName+" password:"+userPassword+" userCode:"+userCode+" code:"+code+" remenber:"+remenber);
		
		
		
		//验证码
		if(code.equals(userCode)){
			boolean islogin=ldi.loginCheck(userName, userPassword);
			System.out.println("isLogin:"+islogin);
			//登录
			if(islogin){
				//记住我
				if(remenber!=null){
					System.out.println("记住密码");
					Cookie cookie= mycookie.addCookie(userName, userPassword);
					response.addCookie(cookie);
				}else{
					Cookie cookie= mycookie.removeCookie(request);
					if(cookie!=null){
						response.addCookie(cookie);
					}
				}
				return "success";
			}
			request.setAttribute("loginRong", "您的账户或密码错误");
			return "loginRong";
		}
		
		request.setAttribute("CodeRong", "验证码错误，请重新输入");
		return "CodeRong";
	}
	
}
