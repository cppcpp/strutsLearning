package com.cpp.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cpp.dao.GetConnection;
import com.cpp.entity.BlackList;
import com.cpp.entity.OrdinaryList;

public class OrdinaryDaoImpl {
	public BlackList  GetObjByName(String userName ){
		Connection conn=GetConnection.getConn();
		BlackList blackList=null;
		
		String sql="select * from black_list where b_name=?";
		try {
			PreparedStatement pre= conn.prepareStatement(sql);
			pre.setString(1, "tom");
			ResultSet rs= pre.executeQuery();
			while(rs.next()){
				//在里面实例化blackList
				blackList=new BlackList();
				blackList.setbId(rs.getInt(1));
				blackList.setbName(rs.getString(2));
				blackList.setbPass(rs.getString(3));
				blackList.setbPhone(rs.getString(4));
				blackList.setbDes(rs.getString(5));
			}
			return blackList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
}
