package com.cpp.interceptor;

import org.junit.Ignore;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.PreResultListener;

public class OrdinaryLogInterceptor implements PreResultListener{
     private String name;
     private String actionName;
	//����ͨ�û�����־��¼
	/*
	 * ����־��¼����־����¼������Ϊ
	 * 
	 * ����--
	 * 
	 * 
	 * 
	 * �Զ���ʱ������---�Զ�����
	 * 
	 * */
	public OrdinaryLogInterceptor(String name,String actionName){
		this.name=name;
		this.actionName=actionName;
	}
	
	@Ignore
	public void beforeResult(ActionInvocation invocation, String result) {
		//Action�з��ص�result
		System.out.println("ִ���˺�������������������������������������������");
		//��LOG���в�����־
		
	}

}
	