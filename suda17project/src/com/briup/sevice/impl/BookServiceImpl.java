package com.briup.sevice.impl;

import java.util.List;

import com.briup.bean.EsBook;
import com.briup.dao.api.IBookInterface;
import com.briup.dao.impl.BookDaoImpl;
import com.briup.sevice.api.IBookService;
/**
 * ESBOOK表
 * 业务接口的实现类
 * @author CuiGX
 *
 */
public class BookServiceImpl implements IBookService{

	//new一个dao层对象
	BookDaoImpl impl = new BookDaoImpl();
	
	@Override
	public List<EsBook> findAllBooks() throws Exception {
		List<EsBook> booklist = impl.findAll();
		if(booklist==null||booklist.size()==0) {
			throw new Exception("当前没有书籍");
		}
		return booklist;
	}

}
