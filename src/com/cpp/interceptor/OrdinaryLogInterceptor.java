package com.cpp.interceptor;

import org.junit.Ignore;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.PreResultListener;

public class OrdinaryLogInterceptor implements PreResultListener{
     private String name;
     private String actionName;
	//对普通用户做日志记录
	/*
	 * 做日志记录，日志表，记录操作行为
	 * 
	 * 事务--
	 * 
	 * 
	 * 
	 * 自动定时任务类---自动化类
	 * 
	 * */
	public OrdinaryLogInterceptor(String name,String actionName){
		this.name=name;
		this.actionName=actionName;
	}
	
	@Ignore
	public void beforeResult(ActionInvocation invocation, String result) {
		//Action中返回的result
		System.out.println("执行了后置拦截器？？？？？？？？？？？？？？？？？");
		//向LOG表中插入日志
		
	}

}
	