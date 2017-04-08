package com.cpp.dao;

import java.sql.Connection;

import com.cpp.entity.DBConfig;
import com.cpp.util.DBConnect;

public class GetConnection {
	
	public static Connection getConn(){
		System.out.println("获得连接信息：："+DBConfig.getDiver());
		Connection conn= DBConnect.connect(DBConfig.getDiver(),
				DBConfig.getUrl(),
				DBConfig.getUserName(),
				DBConfig.getPassword());
		return conn;
	}
}
