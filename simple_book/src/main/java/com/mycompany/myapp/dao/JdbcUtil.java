package com.mycompany.myapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

// 여러 DAO 파일 중 중복되는 부분 처리

public class JdbcUtil {
//	static { // static 선언 역할
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
	public static Connection getConnection() {
		
		Connection con = null;
		
		try {
//			String url = "jdbc:oracle:thin:@localhost:1521:xe";
//			String user = "javadb";
//			String password = "12345";
//			con = DriverManager.getConnection(url, user, password);
			
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
			con = ds.getConnection();
			
			
			con.setAutoCommit(false); // 자동커밋 막아서 SQL DEVELOPER처럼 작동하게 함. 다만, 저렇게 막아도 다 막진 못함. 예외 뜨면 커밋 됨.
			// 여튼 그래도 개발자가 가능한 커밋과 롤백 제어할 수 있게 하는 것
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement pstmt) {
		try {
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
