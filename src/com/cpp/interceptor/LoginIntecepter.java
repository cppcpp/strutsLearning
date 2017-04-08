package com.cpp.interceptor;

import java.util.Map;

import com.cpp.dao.daoImpl.OrdinaryDaoImpl;
import com.cpp.entity.BlackList;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.interceptor.PreResultListener;

public class LoginIntecepter implements Interceptor{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("LoginIntecepter  starting ....");
		OrdinaryDaoImpl odi=new OrdinaryDaoImpl();
		//��������action����
		String actionName= invocation.getInvocationContext().getName();
		
		Map<String,Object> paras= invocation.getInvocationContext().getParameters();
		String[] names=(String[]) paras.get("userName");
		String name=names[0];
		
		System.out.println("invocation�õ�ǰֵ̨��"+name);
		
		BlackList blackList=odi.GetObjByName(name);
		
		System.out.println("blackList-->"+blackList);
		//������ں������еĻ�,�ͷ���
		if(blackList==null){
			System.out.println("����Ա���ں�����");
			invocation.addPreResultListener(new OrdinaryLogInterceptor(name,actionName));
			//��Ҫreturn ���Ų���ִ������
			return invocation.invoke();
		}
		System.out.println("����Ա�ں�����");
		invocation.addPreResultListener(new OrdinaryLogInterceptor(name,actionName));
		return "blacklist";
		
	}
	
}
