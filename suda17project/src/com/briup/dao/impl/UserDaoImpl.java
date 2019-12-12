package com.briup.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.briup.bean.EsUser;
import com.briup.dao.api.IUserInterface;
import com.briup.utils.JdbcUtils;

public class UserDaoImpl implements IUserInterface{

	@Override
	public EsUser findOneByUsmAndPwd(String username, String password) throws Exception{
		// 使用sql语句来查询
		QueryRunner qr = new QueryRunner();
		Connection conn = JdbcUtils.getConnection();
		String sql = "select * from esuser where name=? and password=?";
		Object[] params= {username,password};
		EsUser user = qr.query(conn, sql, new BeanHandler<EsUser>(EsUser.class), params);
		System.out.println("当前登录的用户"+user);
		return user;
	}
	
}
