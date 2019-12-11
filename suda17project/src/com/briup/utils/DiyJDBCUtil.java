package com.briup.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

/**
 * jdbc最简单功能封装
 * 工厂类
 * @author CuiGX
 *
 */
public class DiyJDBCUtil {
	
	private static String driverName;
	private static String url;
	private static String username;
	private static String password;
	
	//使用静态代码块来加载数据
	static {
		Properties p = new Properties();
		InputStream in = DiyJDBCUtil.class.getResourceAsStream("/jdbc.properties");
		try {
			p.load(in);			
			driverName = p.getProperty("jdbc.driverClass");
			url = p.getProperty("jdbc.url");
			username = p.getProperty("jdbc.user");
			password = p.getProperty("jdbc.password");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//生产产品的方法1
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(driverName);
		return DriverManager.getConnection(url,username,password);
	}
	//生产产品的方法2  取消自动提交
	public static Connection getConnection(boolean flag) throws SQLException, ClassNotFoundException {
		Connection conn1 = null;
		conn1 = getConnection();
		if(flag) {
			//不做操作
		}else {
			conn1.setAutoCommit(flag);
		}
		return conn1;
	}

}
