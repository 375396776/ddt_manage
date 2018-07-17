package com.ddt.manage.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddt.manage.mapper.UserManageMapper;
import com.ddt.manage.po.User;

@Service
public class UserManageService implements UserManageMapper {

	@Autowired
	UserManageMapper userManageMapper;
	@Override
	public User getUserByUsername(Map<String, String> reqMap) throws Exception {
		
		return userManageMapper.getUserByUsername(reqMap);
	}

}
