package com.briup.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.briup.bean.EsBook;
import com.briup.dao.api.IBookInterface;
import com.briup.utils.DBCPUtils;
import com.briup.utils.JDCPUtils;
import com.briup.utils.JdbcUtils;

import jdk.nashorn.internal.runtime.ECMAErrors;

/**
 * 针对ESBOOK表
 * DAO层的实现类
 * @author CuiGX
 *
 */
public class BookDaoImpl implements IBookInterface{

	@Override
	public List<EsBook> findAll() throws Exception {
		QueryRunner qr = new QueryRunner(JDCPUtils.getDataSource());
		String sql = "select * from esbook";
		List<EsBook> list = qr.query(sql, new BeanListHandler<EsBook>(EsBook.class));
		return list;
	}

}
