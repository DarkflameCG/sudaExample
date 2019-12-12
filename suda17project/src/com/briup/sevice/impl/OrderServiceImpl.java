package com.briup.sevice.impl;

import com.briup.bean.EsOrder;
import com.briup.dao.impl.OrderDaoImpl;
import com.briup.sevice.api.IOrderService;

/**
 * ESORDER表的业务逻辑实现类
 * @author CuiGX
 *
 */
public class OrderServiceImpl implements IOrderService{
	//准备一个order表中dao对象
	private OrderDaoImpl impl;
	
	@Override
	public void addOrder(EsOrder order) throws Exception {
		impl = new OrderDaoImpl();
		impl.add(order);
	}

}
