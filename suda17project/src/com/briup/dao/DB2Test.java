package com.briup.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.briup.utils.DiyJDBCUtil;

/**
 * 体验一下jdbc的简单封装
 * @author CuiGX
 *
 */
public class DB2Test {
	
	private static Connection conn;
	//处理异构的sql语句
	private static Statement st;
	private static ResultSet rs;
	//预编译的sql语句，处理同构的sql语句
	private static PreparedStatement pst;
	//连接信息
	private final static String driverName="oracle.jdbc.driver.OracleDriver";
	private final static String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private final static String username = "suda";
	private final static String password = "suda";
	
	
	public static void main(String[] args) {
		
		try {
			batchInsert(3456);
			System.out.println("批处理插入成功");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		//提供一个conn对象
//		try {
////			Class.forName(driverName);
////			conn = DriverManager.getConnection(url, username, password);
//			conn = DiyJDBCUtil.getConnection();
//			String sql = "insert into esuser(id,name,password) values(?,?,?)";
//			st = conn.createStatement();
//			pst = conn.prepareStatement(sql);
//			pst.setInt(1, 5);
//			pst.setString(2, "李四");
//			pst.setString(3, "123");
//			pst.execute();
//			
//			closeSource();
//			System.out.println("插入成功");
//		
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	
	//插入语句
		//同构的sql
		//异构的sql
	
	//批处理插入
	public static void batchInsert(int count) throws ClassNotFoundException, SQLException {
		conn = DiyJDBCUtil.getConnection();
		String sql = "insert into esuser(id,name,password) values(?,?,?)";
		pst = conn.prepareStatement(sql);
		for(int i=0;i<count;i++) {
			pst.setInt(1, 6+i);
			pst.setString(2, "李四"+i);
			pst.setString(3, "123");
			pst.addBatch();
			if(i%1000==0) {
				pst.executeBatch();
				pst.clearBatch();
			}
		}
		pst.executeBatch();
		pst.clearBatch();
	}
	
	//sql： delete from esuser where id between 6 and 3000;
	
	
	//关闭资源的方法
	public static void closeSource() throws SQLException {
		if(conn != null) {
			conn.close();
		}
		if(st != null) {
			st.close();
		}
		if(rs != null) {
			rs.close();
		}
		if(pst != null) {
			pst.close();
		}
	}
	
}
