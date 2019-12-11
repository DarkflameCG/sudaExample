package com.briup.sevice;
/**
 * 定义登录的相关方法
 * @author CuiGX
 *
 */
public interface IloginService {

	//用户登录
	//输入：需要传递的参数 帐号、密码
	//输出：返回有没有这个用户
	//完整逻辑
	boolean userLogin(String username,String password) throws Exception;
}
