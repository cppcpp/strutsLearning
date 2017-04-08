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
	 * 上传文件--导入两个jar包
	 * commons-Fileupload，，，，，commons-io
	 * 1.定义三个变量
	 * 2.得到输入流
	 * 3.穿入服务器上的文件夹
	 * 
	 * */
    private File uploadFile;//上传的文件-----前台的name要一样
    private String uploadFileFileName;//封装上传的文件名-----struts的FileUploadIntercepter拦截这两个属性
    private String uploadFileContentType;//封装上传的文件类型
    private String savePath;//用于动态设置文件保存路径
    
    //上传文件
	public String fileUpload(){
		System.out.println("uplodFileName"+"  "+this.getUploadFileFileName());
		System.out.println("uploadFileType"+"   "+this.getUploadFileContentType());
		
		//取到上传路径-----用getRealPath
		String uploadPath=ServletActionContext.getServletContext().getRealPath(savePath);
		//用uploadPath文件名代替uploadFileFileName
		File toFile=new File(uploadPath, uploadFileFileName);
		
		try(InputStream in=new FileInputStream(uploadFile);
				OutputStream out=new FileOutputStream(toFile)){
					
			//设置缓存
			byte[] buffer=new byte[1024];
			int length=0;
			//读取文件到输出文件中
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
