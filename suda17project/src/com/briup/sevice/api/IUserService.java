package com.briup.sevice.api;
/**
 * ESUSER表里的业务接口
 * @author CuiGX
 *
 */

import com.briup.bean.EsUser;

public interface IUserService {
	
	/**
	 * 登录功能
	 * @param username  帐号
	 * @param password  密码
	 * @return 登陆成功后的对象 
	 */
	public EsUser userLogin(String username,String password) throws Exception ;
}
