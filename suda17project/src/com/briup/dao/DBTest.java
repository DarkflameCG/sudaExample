package com.briup.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import oracle.jdbc.driver.OracleDriver;

/**
 * JDBC六大步骤
 * @author CuiGX
 *
 */
public class DBTest {
	
	private final static String driverName="oracle.jdbc.driver.OracleDriver";
	private final static String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private final static String username = "suda";
	private final static String password = "suda";
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1、注册驱动
		//使用类加载器
		Class.forName(driverName);
		//使用new的形式
//		Driver diver = new OracleDriver();
//		DriverManager.registerDriver(diver);
		//使用系统配置
//		System.setProperty("jdbc.drivers", driverName);
		
		//2、建立连接
		Connection conn = DriverManager.getConnection(url, username, password);
		//证明是否建立了和数据库的连接
		System.out.println(conn);
		
		//3、使用statement对象
		Statement st = conn.createStatement();
		
		//4、执行sql语句
		String sql = "create table esuser("
				+ "id number(11) primary key,"
				+ "name varchar2(20) not null,"
				+ "age number(3),"
				+ "password varchar2(20),"
				+ "gender varchar2(20),"
				+ "telephone number(11))";//写sql语句
		st.execute(sql);
		
		//5、处理结果集（如果有的话）
		//6、关闭资源
		st.close();
		conn.close();
		
		
	}
	
	
	//增
	@Test
	public void add() throws Exception{
		
		Class.forName(driverName);
		Connection conn = DriverManager.getConnection(url, username, password);
		Statement st =conn.createStatement();
		String sql = "insert into esuser values("
				+ "3,'mint',22,'123','女',13333333333)";
		st.execute(sql);
		st.close();
		conn.close();
		
	}
	
	//删
	@Test
	public void delete() throws Exception{
		
		Class.forName(driverName);
		Connection conn = DriverManager.getConnection(url, username, password);
		Statement st =conn.createStatement();
		String sql = "delete from esuser where id = 2";
		st.execute(sql);
		st.close();
		conn.close();
		
	}
	
	//改
	@Test
	public void update() throws Exception{
		
		Class.forName(driverName);
		Connection conn = DriverManager.getConnection(url, username, password);
		Statement st =conn.createStatement();
		String sql = "update esuser set age =30 where id = 3";
		st.execute(sql);
		st.close();
		conn.close();
		
	}
	
	//查
	@Test
	public void select() throws Exception{
		
		Class.forName(driverName);
		Connection conn = DriverManager.getConnection(url, username, password);
		Statement st =conn.createStatement();
		String sql = "select * from esuser";
		
		//日常所说的第五步，获得查询的结果集
		ResultSet rs = st.executeQuery(sql);
		//如果有下一个结果集，遍历循环
		while(rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			int age = rs.getInt(3);
			String password = rs.getString(4);
			String gender = rs.getString(5);
			Long telephone = rs.getLong(6);
			System.out.println(id+"-"+name+"-"+age+"-"+password+"-"+gender+"-"+telephone);
		}
		
		//关闭资源
		rs.close();
		st.close();
		conn.close();
		
	}
	
	
	
	
	
	
	
}
