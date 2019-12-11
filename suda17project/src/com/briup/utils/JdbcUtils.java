package com.briup.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {
	
	private static String driverClass;
	private static String url;
	private static String user;
	private static String password;
	
	static {
		//init
		try {
			Properties p = new Properties();
			InputStream in = JdbcUtils.class.getResourceAsStream("/jdbc.properties");
//			InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
//			InputStream in = new FileInputStream("src/jdbc.properties");
			p.load(in);
			
			driverClass = p.getProperty("jdbc.driverClass");
			url 		= p.getProperty("jdbc.url");
			user 		= p.getProperty("jdbc.user");
			password 	= p.getProperty("jdbc.password");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driverClass);
		return DriverManager.getConnection(url, user, password);
	}
	
	public static void executeDMLByStmt(String sql){
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			stmt.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(stmt,conn);
		}
		
	}
	
	public static void executeDMLByPs(String sql,IPsWork work){
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			
			work.doWork(ps);
			
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(ps,conn);
		}
	}
	
	public static Object executeQuery(String sql,IResuleSetWork work){
		
		Object result = null;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			//处理结果集
			result = work.doWork(rs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs,stmt,conn);
		}
		
		return result;
	}
	
	
	public static void close(ResultSet rs,Statement stmt,Connection conn) {
		try {
			if(rs!=null)rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		try {
			if(stmt!=null)stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		try {
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public static void close(Statement stmt,Connection conn) {
		close(null,stmt,conn);
	}
	
	
	public static void main(String[] args) {
		System.out.println(JdbcUtils.driverClass);
		System.out.println(JdbcUtils.url);
		System.out.println(JdbcUtils.user);
		System.out.println(JdbcUtils.password);
	}
	
}
