package com.briup.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.briup.utils.DBCPUtils;
import com.briup.utils.DiyJDBCUtil;
import com.briup.utils.JDCPUtils;

/**
 * 使用DBUtils进行增删改查
 * @author CuiGX
 *
 */
public class DB3Test {
	
	//增
	@Test
	public void add() throws ClassNotFoundException, SQLException {
		//新建一个queryRunner对象
		QueryRunner qr = new QueryRunner();
		//需要准备三个东西
		//连接对象
		Connection conn = DiyJDBCUtil.getConnection();
		//sql语句
		String sql = "insert into esuser values(?,?,?,?,?,?)";
		//参数列表   数组
		Object[] params = {6,"王五",30,"6666","男",18976548932L};
		//执行操作
		qr.update(conn,sql,params);
	}
	
	//删
	@Test
	public void delete() throws ClassNotFoundException, SQLException {
		//新建一个queryRunner对象
		QueryRunner qr = new QueryRunner();
		//需要准备三个东西
		//连接对象
		Connection conn = DiyJDBCUtil.getConnection();
		//sql语句
		String sql = "delete from esuser where id = ?";
		//执行操作
		qr.update(conn,sql,5);
	}
	
	//改
	@Test
	public void update() throws ClassNotFoundException, SQLException {
		//新建一个queryRunner对象
		QueryRunner qr = new QueryRunner();
		//需要准备三个东西
		//连接对象
		Connection conn = DiyJDBCUtil.getConnection();
		//sql语句
		String sql = "update esuser set id = ? where id = ?";
		//如果问号多于两个，就需要参数列表
		Object[] params = {4,5};
		//执行操作
		qr.update(conn,sql,params);
	}
	
	//查（需要返回结果集的） 作业  ResultHandle
	
	
}
