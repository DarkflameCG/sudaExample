package com.briup.sevice.impl;

import com.briup.bean.EsUser;
import com.briup.dao.impl.UserDaoImpl;
import com.briup.sevice.api.IUserService;
/**
 * user service层的实现类
 * @author CuiGX
 *
 */
public class UserServiceImpl implements IUserService{
	
	//实例化一个dao层对象
	UserDaoImpl impl = new UserDaoImpl();
	
	@Override
	public EsUser userLogin(String username, String password) throws Exception {
		//判空操作
		if("".equals(username)||"".equals(password)) {
			throw new Exception("帐号或密码为空");
		}
		//如果帐号密码不为空。调用dao层方法
		return impl.findOneByUsmAndPwd(username, password);
	}

}
