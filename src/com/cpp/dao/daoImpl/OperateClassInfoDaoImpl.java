package com.cpp.dao.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cpp.dao.GetConnection;
import com.cpp.entity.ClassInfo;
import com.cpp.util.DBConnect;

public class OperateClassInfoDaoImpl {
	public List<ClassInfo> CheckAllClassInfo(){
		Connection conn=GetConnection.getConn();
		List<ClassInfo> lists=new ArrayList<ClassInfo>();
		
		try {
			String sql="select * from class_info";
			Statement sta=conn.createStatement();
			ResultSet rs= sta.executeQuery(sql);
			while(rs.next()){
				ClassInfo classInfo=new ClassInfo();
				classInfo.setcId(rs.getInt(1));
				classInfo.setcName(rs.getString(2));
				classInfo.setcDesc(rs.getString(3));
				lists.add(classInfo);
			}
			
			return lists;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean modify(){
		Connection conn=GetConnection.getConn();
		
		return false;
	}
	public boolean delete(String cId){
		Connection conn=GetConnection.getConn();
		
		
		return false;
	}
}
