package com.briup.sevice.api;

import java.util.List;

import com.briup.bean.EsBook;
/**
 * ESBOOK表的业务接口
 * @author CuiGX
 *
 */
public interface IBookService {
	
	/**
	 * 查询所有书籍
	 * @return 书籍列表
	 */
	public List<EsBook> findAllBooks() throws Exception;
}
