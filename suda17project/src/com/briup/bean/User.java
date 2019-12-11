package com.briup.bean;

import java.io.Serializable;

import javax.print.attribute.standard.Severity;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * 描述登录的用户信息
 * @author CuiGX
 *
 */
public class User implements HttpSessionBindingListener
/* ,HttpSessionActivationListener,Serializable */{
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private boolean gender;
	private Address address;
	
	public Address getAddress() {
		return new Address("中国", "苏州", "大学路");
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public String getSexStr() {
		if(this.gender) {
			return "小哥哥";
		}
		return "小姐姐";
		
	}
	
	public User() {
		super();
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", gender=" +getSexStr() + "]";
	}
	//监听器接口的方法
//	@Override
//	public void sessionWillPassivate(HttpSessionEvent se) {
//		// 即将持久化到硬盘里时
//		HttpSession session = se.getSession();
//		System.out.println("即将保存在硬盘里，sessionid："+session.getId());
//	}
//	@Override
//	public void sessionDidActivate(HttpSessionEvent se) {
//		// 从硬盘里加载时
//		HttpSession session = se.getSession();
//		System.out.println("即将从硬盘里取出，sessionid："+session.getId());
//	}
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		// 对象放进session里时调用
		HttpSession session = event.getSession();
		System.out.println(session.getId()+"上绑定了一个"+
						   event.getName()+"的属性，值为："+
						   event.getValue());
		
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		// 对象从session里移除时调用
		HttpSession session = event.getSession();
		System.out.println(session.getId()+"上移除了"+
						   event.getName()+"的属性");
	}
	
}
