package com.cpp.entity;

public class ClassInfo {
	private int cId;
	private String cName;
	private String cDesc;
	
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcDesc() {
		return cDesc;
	}
	public void setcDesc(String cDesc) {
		this.cDesc = cDesc;
	}
	@Override
	public String toString() {
		return "ClassInfo [cId=" + cId + ", cName=" + cName + ", cDesc=" + cDesc + "]";
	}
	
	
}
