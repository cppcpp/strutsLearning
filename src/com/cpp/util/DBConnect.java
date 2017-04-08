package com.cpp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	public static Connection conn;
	
	public static Connection connect(String driver,String url,String userName,String password){
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName(driver);
			//conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","cpprootmysql");
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@127.0.0.1:1521:XE", "system", "system");
			conn=DriverManager.getConnection(url,userName,password);
			return conn;
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void closeConn(){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
