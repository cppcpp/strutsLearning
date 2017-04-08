package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnTest {
	public static void main(String[] args) {
		//conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","cpprootmysql");
		try {
			//ORACLE中作为查询条件区别
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:XE", "system", "system");
			System.out.println(conn);
			if(conn==null){
				return;
			}
			
			Statement sta=conn.createStatement();
			String sql="select * from black";
			String sql2="select * from tab";
			ResultSet rs= sta.executeQuery(sql);
			//System.out.println(rs);
			
			System.out.println("执行");
			while(rs.next()){
				System.out.println("rs.next");
				System.out.println(rs.getString(2));
				/*if(rs.getString(1).equals("BLACK_LIST"))
					System.out.println("black_list");
				if(rs.getString(1).equals("ORDINARY_LIST"))
					System.out.println("ordinary_list");*/
			}
			sta.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
