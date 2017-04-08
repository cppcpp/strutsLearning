package com.cpp.entity;

public class BlackList {
	private int bId;
	private String bName;
	private String bPass;
	private String bPhone;
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getbPass() {
		return bPass;
	}
	public void setbPass(String bPass) {
		this.bPass = bPass;
	}
	public String getbPhone() {
		return bPhone;
	}
	public void setbPhone(String bPhone) {
		this.bPhone = bPhone;
	}
	public String getbDes() {
		return bDes;
	}
	public void setbDes(String bDes) {
		this.bDes = bDes;
	}
	private String bDes;
	@Override
	public String toString() {
		return "BlackList [bId=" + bId + ", bName=" + bName + ", bPass=" + bPass + ", bPhone=" + bPhone + ", bDes="
				+ bDes + "]";
	}
	
	
	
}
