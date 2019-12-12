package com.briup.bean;

import java.io.Serializable;

/**
 * ESORDER的实体类
 * 订单表
 * @author CuiGX
 *
 */
public class EsOrder implements Serializable{
	private static final long serialVersionUID = 1L;
	private long id;
	private long userid;
	private long bookid;
	public EsOrder() {
		super();
	}
	public EsOrder(long id, long userid, long bookid) {
		super();
		this.id = id;
		this.userid = userid;
		this.bookid = bookid;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public long getBookid() {
		return bookid;
	}
	public void setBookid(long bookid) {
		this.bookid = bookid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "EsOrder [id=" + id + ", userid=" + userid + ", bookid=" + bookid + "]";
	}
	
	
	
}
