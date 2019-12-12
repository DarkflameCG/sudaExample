package com.briup.dao.impl;

import org.apache.commons.dbutils.QueryRunner;

import com.briup.bean.EsOrder;
import com.briup.dao.api.IOrderInterface;
import com.briup.utils.JDCPUtils;
/**
 * ESORDER表dao层接口的实现类
 * @author CuiGX
 *
 */
public class OrderDaoImpl implements IOrderInterface{

	@Override
	public void add(EsOrder order) throws Exception {
		//第一次获得数据源
		QueryRunner qr = new QueryRunner(JDCPUtils.getDataSource());
		//如果使用的是oracle必须传id。 序列
		//如果使用的是mysql，这个id可以不用传。mysql中有主键自增
		String sql = "insert into esorder(userid,bookid) values(?,?)";
		//参数列表
		Object[] params= {order.getUserid(),order.getBookid()};
		qr.update(sql,params);
		
	}

}
