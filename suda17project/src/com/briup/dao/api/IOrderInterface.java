package com.briup.dao.api;

import com.briup.bean.EsOrder;

/**
 * ESORDER表的dao层接口
 * @author CuiGX
 *
 */
public interface IOrderInterface {
	/**
	 * 在数据库中添加一行数据
	 * @param order
	 */
	public void add(EsOrder order) throws Exception;
}
