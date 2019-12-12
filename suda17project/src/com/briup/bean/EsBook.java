package com.briup.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * ESBOOK表的实体类
 * @author CuiGX
 *
 */
public class EsBook implements Serializable{
	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private double price;
	private String desc;
	private String author;
	private String publish;
	private Date publishdate;
	public EsBook() {
		super();
	}
	public EsBook(long id, String name, double price, String desc, String author, String publish, Date publishdate) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.desc = desc;
		this.author = author;
		this.publish = publish;
		this.publishdate = publishdate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public Date getPublishdate() {
		return publishdate;
	}
	public void setPublishdate(Date publishdate) {
		this.publishdate = publishdate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "EsBook [id=" + id + ", name=" + name + ", price=" + price + ", desc=" + desc + ", author=" + author
				+ ", publish=" + publish + ", publishdate=" + publishdate + "]";
	}
	
	
	
}
