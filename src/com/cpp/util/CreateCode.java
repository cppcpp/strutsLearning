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
	//struts����servletAPI
	private HttpServletResponse response=ServletActionContext.getResponse();
	private HttpServletRequest request=ServletActionContext.getRequest();
	private final int DEFAULT_WIDTH=90;
	private final int DEFAULR_HEIGHT=30;
	
	
	public String createCode(){
		try {
			System.out.println("create Code");
			//JPEGImageEncoder������һ����ָ�������������JPEGImageEncoder����
			
			//����ͼƬ��
			BufferedImage image=new BufferedImage(DEFAULT_WIDTH, DEFAULR_HEIGHT, BufferedImage.TYPE_INT_RGB);
			//��������
			Graphics graphics=image.getGraphics();
			
			//�����ɫ
			graphics.setColor(getColor());
			graphics.setFont(new Font("Arial",Font.BOLD,18));
			//������
			graphics.fillRect(0, 0,DEFAULT_WIDTH,DEFAULR_HEIGHT);
			
			//������λ�����
			String number=String.valueOf(System.currentTimeMillis()%10000+1000);
			//������λ���ŵ�session��
			//System.out.println("number:"+number);
			request.getSession().setAttribute("code",number);
			
			//��䵽����
			graphics.setColor(this.getColor());
			graphics.drawString(number, (int)(DEFAULT_WIDTH*0.3), (int)(DEFAULR_HEIGHT*0.7));
			
			//�ͷŻ���
			graphics.dispose();
		
			JPEGImageEncoder encoder=JPEGCodec.createJPEGEncoder(response.getOutputStream());
			encoder.encode(image);
			
			
			//��ͼƬˢ�µ�ҳ��
			response.getOutputStream().flush();
			//�ر���
			response.getOutputStream().close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//���return�ǿգ�response������
		return null;
	}
	
//	public BufferedImage CreateBufferedImage(){
//		//����ͼƬ��
//		BufferedImage image=new BufferedImage(DEFAULT_WIDTH, DEFAULR_HEIGHT, BufferedImage.TYPE_INT_RGB);
//		//��������
//		Graphics graphics=image.getGraphics();
//		
//		//�����ɫ
//		graphics.setColor(getColor());
//		graphics.setFont(new Font("Arial",Font.BOLD,18));
//		
//		//������
//		graphics.fillRect(0, 0,DEFAULT_WIDTH,DEFAULR_HEIGHT);
//		
//		//������λ�����
//		String number=String.valueOf(System.currentTimeMillis()%10000);
//		//������λ���ŵ�session��
//		System.out.println("number:"+number);
//		request.getSession().setAttribute("code",number);
//		
//		//��䵽����
//		graphics.drawString(number, (int)(DEFAULT_WIDTH*0.3), (int)(DEFAULR_HEIGHT*0.3));
//		graphics.setColor(this.getColor());
//		
//		//�ͷŻ���
//		graphics.dispose();
//		
//		return image;
//	}

	//�������0-255֮���������ԭɫ������ɫ
	public Color getColor(){
		int red=(int)(Math.random()*1000%256);
		int green=(int)(Math.random()*1000%256);
		int blue=(int)(Math.random()*1000%256);
		//System.out.println("red:"+red+"green:"+green+"blue:"+blue);
		return new Color(red,green,blue);
	}
}
