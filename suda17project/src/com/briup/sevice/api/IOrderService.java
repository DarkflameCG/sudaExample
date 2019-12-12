package com.briup.sevice.api;

import com.briup.bean.EsOrder;

/**
 * ESORDER表的业务逻辑接口
 * @author CuiGX
 *
 */
public interface IOrderService {
	
	/**
	 * 订单表里添加一行数据
	 * @throws Exception
	 */
	public void addOrder(EsOrder order) throws Exception;
}
