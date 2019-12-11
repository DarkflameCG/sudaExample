package com.briup.web.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * 测试属性更改的监听器
 * 以session为例
 */
//@WebListener
public class Test2Listener implements HttpSessionAttributeListener {
    public void attributeAdded(HttpSessionBindingEvent se)  { 
         // 属性添加
    	//获得session
    	HttpSession session = se.getSession();
    	System.out.println(session.getId().substring(0,4)+"添加了一个名字叫"+
    					   se.getName()+"的属性，值为"+
    			           se.getValue());
    }

    public void attributeRemoved(HttpSessionBindingEvent se)  { 
         // 属性移除
    	HttpSession session = se.getSession();
    	System.out.println(session.getId().substring(0,4)+"移除了一个名字叫"+
    					   se.getName()+"的属性，值为"+
    			           se.getValue());
    	
    }
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
         // 属性修改
    	HttpSession session = se.getSession();
    	//获取键值
    	String keystr = se.getName();
    	//获取旧值
    	Object oldvalue = se.getValue();
    	//获取新值
    	Object newvalue = session.getAttribute(keystr);
    	//打印
    	System.out.println(session.getId().substring(0,4)+"修改了一个名字叫"+
    					   keystr+"的属性，旧值为："+
    			           oldvalue+"，新值为："+newvalue);
    	
    	
    }
	
}
