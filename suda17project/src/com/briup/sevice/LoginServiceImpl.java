package com.briup.sevice;

public class LoginServiceImpl implements IloginService{

	@Override
	public boolean userLogin(String username, String password) throws Exception {
		//1、判断用户名和密码是否为空
		if("".equals(username) || "".equals(password))
		{
			throw new Exception("帐号密码为空");
		}
		//2、帐号不正确，抛异常   ，帐号正确，判断密码
		if("tom".equals(username)) {
			if("123".equals(password)) {
				
				return true;
				
			}else {
				return false;
			}
		}else {
			//可以跳到注册页面上
			throw new Exception("用户名不存在");
		}
	}


}
