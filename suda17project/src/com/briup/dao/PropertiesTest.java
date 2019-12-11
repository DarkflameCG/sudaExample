package com.briup.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 用来读取properties的配置文件
 * @author CuiGX
 *
 */
public class PropertiesTest {
	public static void main(String[] args) throws IOException {
		//准备一个properties类
		Properties p = new Properties();		
		//通过类加载器来读取文件
		InputStream in = PropertiesTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
		//通过io流来读取文件
		//InputStream in1 = new FileInputStream("src/jdbc.properties");
		//把流交给properties来读取
		p.load(in);
		//获取里面的数据
		System.out.println(p.getProperty("username"));
		
	}
}
