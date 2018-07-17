package com.ddt.manage.mapper;

import java.util.Map;

import com.ddt.manage.po.User;

/**   
 * @Title: UserManageMapper
 * @Description: 
 * @Company: 
 * @author 李斌
 * @date 2018年6月8日 下午5:12:32 
 * @version 1.0   
 */
public interface UserManageMapper {
	
	/**
	 * 
	 * @Description: 根据用户名查询用户
	 * @param reqMap
	 * @return
	 * @throws Exception
	 */
	public User getUserByUsername(Map<String, String> reqMap) throws Exception;

}
