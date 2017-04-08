package com.cpp.interceptor;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.tomcat.util.net.URL;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.cpp.entity.DBConfig;
import com.cpp.util.DBConnect;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class ParseDB  extends DBConnect implements Interceptor{
	//���Ի��DBConfigFile��ֵ������Ϊstruts2���е�������������params
	private String dbConfigFile;
	

	public String getDbConfigFile() {
		return dbConfigFile;
	}

	public void setDbConfigFile(String dbConfigFile) {
		this.dbConfigFile = dbConfigFile;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("intercepter  destroy...");
		if(DBConnect.conn!=null){
			DBConnect.closeConn();
			System.out.println("close Database");
		}
	}

	@Override
	public void init() {
		System.out.println("��init��ִ���������ݿ����");
		System.out.println("�������ݿ������ļ�����"+dbConfigFile);
		
		/*
		 * ClassLoader�ṩ�������������ڴ�װ�ص���·����ȡ����Դ��
				public URL getResource(String name);
				public InputStream getResourceAsStream(String name);
		 * 
		 * 
		 * */
		try {
			//�ҵ������ļ���������-------���л���
			InputStream in= this.getClass().getClassLoader()
					.getResourceAsStream(dbConfigFile);
			Properties pro=new Properties();
			
			
			try {
				URI path = this.getClass().getClassLoader().getResource(dbConfigFile).toURI();
				System.out.println("path��++++"+path);
				InputStream in1=new FileInputStream(new File(path));
				
				
				pro.load(in1);
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			String usedb=(String) pro.get("dbname");
			String xmlName=(String) pro.get(usedb);
			System.out.println("usedb:"+usedb+"xmlName:"+xmlName);
			//ֻ�ܵõ�λ��src�������Դ
			InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(xmlName);
			
			//DOM4J����xml�ļ�
			SAXReader reader=new SAXReader();
			Document document= reader.read(resourceAsStream);
			Element root=document.getRootElement();
			Element info= root.element("sqlInfo");

			String driver=info.element("driver").getText();
			String url=info.element("url").getText();
			String userName=info.element("userName").getText();;
			String password=info.element("password").getText();;
			System.out.println(driver+" "+url+" "+userName+" "+password);
			
//			DBConnect.connect(driver, url, userName, password);
			//��DBConfig���еľ�̬��ֵ
			DBConfig.setDiver(driver);
			DBConfig.setUrl(url);
			DBConfig.setUserName(userName);
			DBConfig.setPassword(password);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("ParseDB intercepter  intecept...");
		
		HttpServletRequest request= ServletActionContext.getRequest();
		
		String a= "���ʵĵ�ַIP:"+request.getRemoteAddr();
		String b= "requestURI:"+request.getRequestURI();
		return invocation.invoke();
	}

}
