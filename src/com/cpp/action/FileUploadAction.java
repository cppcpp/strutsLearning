package com.cpp.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;

public class FileUploadAction {
	/*
	 * �ϴ��ļ�--��������jar��
	 * commons-Fileupload����������commons-io
	 * 1.������������
	 * 2.�õ�������
	 * 3.����������ϵ��ļ���
	 * 
	 * */
    private File uploadFile;//�ϴ����ļ�-----ǰ̨��nameҪһ��
    private String uploadFileFileName;//��װ�ϴ����ļ���-----struts��FileUploadIntercepter��������������
    private String uploadFileContentType;//��װ�ϴ����ļ�����
    private String savePath;//���ڶ�̬�����ļ�����·��
    
    //�ϴ��ļ�
	public String fileUpload(){
		System.out.println("uplodFileName"+"  "+this.getUploadFileFileName());
		System.out.println("uploadFileType"+"   "+this.getUploadFileContentType());
		
		//ȡ���ϴ�·��-----��getRealPath
		String uploadPath=ServletActionContext.getServletContext().getRealPath(savePath);
		//��uploadPath�ļ�������uploadFileFileName
		File toFile=new File(uploadPath, uploadFileFileName);
		
		try(InputStream in=new FileInputStream(uploadFile);
				OutputStream out=new FileOutputStream(toFile)){
					
			//���û���
			byte[] buffer=new byte[1024];
			int length=0;
			//��ȡ�ļ�������ļ���
			while((length=in.read(buffer))>0){
				out.write(buffer,0,length);
			}
			return "success";
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "error";
	}

    public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public String getUploadFileContentType() {
		return uploadFileContentType;
	}

	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	

}
