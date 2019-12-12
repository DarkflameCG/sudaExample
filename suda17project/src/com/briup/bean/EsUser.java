package com.briup.bean;

import java.io.Serializable;

/**
 * ESUSER表的实体类
 * 了解一个框架lombok
 * @author CuiGX
 *
 */
public class EsUser implements Serializable{
	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private String password;
	private int role;
	private String telephone;
	public EsUser() {
		super();
	}
	public EsUser(long id, String name, String password, int role, String telephone) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.role = role;
		this.telephone = telephone;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "EsUser [id=" + id + ", name=" + name + ", password=" + password + ", role=" + role + ", telephone="
				+ telephone + "]";
	}
	
	
	
}
