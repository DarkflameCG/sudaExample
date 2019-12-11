package com.briup.utils;



import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class JDCPUtils {
	//创建BasicDataSource类对象
		private static BasicDataSource datasource = new BasicDataSource();
		
		//静态代码块，对象BasicDataSource对象中的配置
		static{
			//数据库连接信息（必须）
			//mysql
//			datasource.setDriverClassName("com.mysql.jdbc.Driver");
//			datasource.setUrl("jdbc:mysql://localhost:3306/mybase");
//			datasource.setUsername("root");
//			datasource.setPassword("root");
			//oracle
			datasource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			datasource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:XE");
			datasource.setUsername("estoreu");
			datasource.setPassword("estoreu");
			//连接池中的连接数量配置（可选）
			datasource.setInitialSize(10);//初始化的连接数
			datasource.setMaxTotal(8);//最大连接数
			datasource.setMaxIdle(5);//最大空闲连接
			datasource.setMinIdle(1);//最小空闲连接
		}
		//定义静态方法，返回BasicDataSource对象
		public static DataSource getDataSource(){
			return datasource;	
		}
}
