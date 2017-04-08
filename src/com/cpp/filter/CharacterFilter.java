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
		//Post����������
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//����ǿ��Ķ������
        MyRequest myRequest = new MyRequest(request);
        filterChain.doFilter(myRequest, response);    //����һ��,�������еĲ������ǻ��������ǿ��Ķ�����е�
	}

	class MyRequest extends HttpServletRequestWrapper{
        private HttpServletRequest request;
        public MyRequest(HttpServletRequest request) {
            super(request);
            this.request = request;
        }
        public String getParameter(String name) {
            //�������ʽ��POST,������ǿ,ֱ�ӵ���Ŀ�����ķ���
            if(this.request.getMethod().equalsIgnoreCase("POST")){
                return this.request.getParameter(name);
            }
            /*�������е���,����ʽ��ȻΪGET�Ȼ�ȡֵ,�ٽ����ֶ�ת��*/
            String value = this.request.getParameter(name);
            try {
                value = new String(value.getBytes("iso8859-1"),"utf-8");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
            return value;        //����
        }
    }
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
