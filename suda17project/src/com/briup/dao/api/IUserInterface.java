package com.briup.dao.api;

import com.briup.bean.EsUser;

/**
 * ESUSER表的增删改查接口
 * @author CuiGX
 *
 */

public interface IUserInterface {

	/**
	 * 根据帐号密码来查出一个用户
	 * @param username 用户名
	 * @param password 密码
	 * @return EsUser
	 */
	public EsUser findOneByUsmAndPwd(String username,String password) throws Exception;
}
