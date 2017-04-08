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
		//获得请求的action名称
		String actionName= invocation.getInvocationContext().getName();
		
		Map<String,Object> paras= invocation.getInvocationContext().getParameters();
		String[] names=(String[]) paras.get("userName");
		String name=names[0];
		
		System.out.println("invocation得到前台值："+name);
		
		BlackList blackList=odi.GetObjByName(name);
		
		System.out.println("blackList-->"+blackList);
		//如果不在黑名单中的话,就放行
		if(blackList==null){
			System.out.println("该人员不在黑名单");
			invocation.addPreResultListener(new OrdinaryLogInterceptor(name,actionName));
			//需要return ，才不会执行下面
			return invocation.invoke();
		}
		System.out.println("该人员在黑名单");
		invocation.addPreResultListener(new OrdinaryLogInterceptor(name,actionName));
		return "blacklist";
		
	}
	
}
