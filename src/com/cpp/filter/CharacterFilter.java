package com.cpp.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;



/*@WebFilter(filterName="CharacterFilter",urlPatterns="*.jsp")*/
public class CharacterFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest sRequest, ServletResponse sResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) sRequest;
		HttpServletResponse response=(HttpServletResponse) sResponse;
		
		System.out.println("Filter start");
		//Post方法乱码解决
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//将增强后的对象放行
        MyRequest myRequest = new MyRequest(request);
        filterChain.doFilter(myRequest, response);    //这样一来,后面所有的操作都是基于这个增强后的对象进行的
	}

	class MyRequest extends HttpServletRequestWrapper{
        private HttpServletRequest request;
        public MyRequest(HttpServletRequest request) {
            super(request);
            this.request = request;
        }
        public String getParameter(String name) {
            //如果请求方式是POST,则不用增强,直接调用目标对象的方法
            if(this.request.getMethod().equalsIgnoreCase("POST")){
                return this.request.getParameter(name);
            }
            /*程序运行到此,请求方式必然为GET先获取值,再进行手动转换*/
            String value = this.request.getParameter(name);
            try {
                value = new String(value.getBytes("iso8859-1"),"utf-8");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
            return value;        //返回
        }
    }
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
