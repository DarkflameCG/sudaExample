package com.briup.dao.api;

import java.util.List;

import com.briup.bean.EsBook;

/**
 * 针对ESBOOK表做的DAO层接口
 * @author CuiGX
 *
 */
public interface IBookInterface {
	/**
	 * 获取所有的书籍
	 * @return
	 */
	public List<EsBook> findAll() throws Exception ;
}
