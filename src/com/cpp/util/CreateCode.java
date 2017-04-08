package com.cpp.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import com.sun.image.codec.jpeg.*;

public class CreateCode extends ActionSupport{
	//struts访问servletAPI
	private HttpServletResponse response=ServletActionContext.getResponse();
	private HttpServletRequest request=ServletActionContext.getRequest();
	private final int DEFAULT_WIDTH=90;
	private final int DEFAULR_HEIGHT=30;
	
	
	public String createCode(){
		try {
			System.out.println("create Code");
			//JPEGImageEncoder：创建一个和指定输出流关联的JPEGImageEncoder对象。
			
			//构建图片流
			BufferedImage image=new BufferedImage(DEFAULT_WIDTH, DEFAULR_HEIGHT, BufferedImage.TYPE_INT_RGB);
			//构建画布
			Graphics graphics=image.getGraphics();
			
			//填充颜色
			graphics.setColor(getColor());
			graphics.setFont(new Font("Arial",Font.BOLD,18));
			//填充矩形
			graphics.fillRect(0, 0,DEFAULT_WIDTH,DEFAULR_HEIGHT);
			
			//构建四位随机数
			String number=String.valueOf(System.currentTimeMillis()%10000+1000);
			//将这四位数放到session中
			//System.out.println("number:"+number);
			request.getSession().setAttribute("code",number);
			
			//填充到矩形
			graphics.setColor(this.getColor());
			graphics.drawString(number, (int)(DEFAULT_WIDTH*0.3), (int)(DEFAULR_HEIGHT*0.7));
			
			//释放画布
			graphics.dispose();
		
			JPEGImageEncoder encoder=JPEGCodec.createJPEGEncoder(response.getOutputStream());
			encoder.encode(image);
			
			
			//将图片刷新到页面
			response.getOutputStream().flush();
			//关闭流
			response.getOutputStream().close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//如果return非空，response會重新
		return null;
	}
	
//	public BufferedImage CreateBufferedImage(){
//		//构建图片流
//		BufferedImage image=new BufferedImage(DEFAULT_WIDTH, DEFAULR_HEIGHT, BufferedImage.TYPE_INT_RGB);
//		//构建画布
//		Graphics graphics=image.getGraphics();
//		
//		//填充颜色
//		graphics.setColor(getColor());
//		graphics.setFont(new Font("Arial",Font.BOLD,18));
//		
//		//填充矩形
//		graphics.fillRect(0, 0,DEFAULT_WIDTH,DEFAULR_HEIGHT);
//		
//		//构建四位随机数
//		String number=String.valueOf(System.currentTimeMillis()%10000);
//		//将这四位数放到session中
//		System.out.println("number:"+number);
//		request.getSession().setAttribute("code",number);
//		
//		//填充到矩形
//		graphics.drawString(number, (int)(DEFAULT_WIDTH*0.3), (int)(DEFAULR_HEIGHT*0.3));
//		graphics.setColor(this.getColor());
//		
//		//释放画布
//		graphics.dispose();
//		
//		return image;
//	}

	//随机生成0-255之间的数，三原色构成颜色
	public Color getColor(){
		int red=(int)(Math.random()*1000%256);
		int green=(int)(Math.random()*1000%256);
		int blue=(int)(Math.random()*1000%256);
		//System.out.println("red:"+red+"green:"+green+"blue:"+blue);
		return new Color(red,green,blue);
	}
}
