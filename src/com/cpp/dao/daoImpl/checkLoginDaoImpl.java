package com.cpp.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cpp.dao.GetConnection;

public class checkLoginDaoImpl{
	Connection conn=GetConnection.getConn();;
	public boolean loginCheck(String userName, String userPassword) {
//		String sql="select count(*) from ordinary_list where o_name=? and o_pass=?";
		
		String sql="select count(*) from ordinary_list where o_name=? and o_pass=?";
		try {
			if(conn==null){
				System.out.println("conn is null");
				return false;
			}
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, userPassword);
			System.out.println(sql);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				if(rs.getInt(1)>0){
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	

}
