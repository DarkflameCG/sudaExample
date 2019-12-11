package com.briup.utils;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * 标签处理类
 * @author CuiGX
 *
 */
public class BriupSupport extends SimpleTagSupport{
	
	//用来接收标签里面的count属性的值
	private int count;
	
	@Override
	public void doTag() throws JspException, IOException {
		//获取标签体里面的内容
		//准备好一个StringWriter，接收标签体内容
		StringWriter sw = new StringWriter();

		//把标签体内容写到StringWriter中
		super.getJspBody().invoke(sw);

		//从StringWriter中获取标签体的内容
		String tagBody = sw.toString();
		//循环一下
		for(int i =0;i<count;i++) {
			//标签处理方法，打印hello
			super.getJspContext().getOut().println(tagBody+"，hello"
					+ "！");
		}
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}










