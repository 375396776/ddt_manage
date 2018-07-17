package com.ddt.manage.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ddt.manage.mapper.PhoneManageMapper;

@Service
public class PhoneManageSercive {
	@Autowired
	PhoneManageMapper phoneManageMapper;
	
	@Transactional
	public List<Map<String, Object>> getPhone(Map<String, Object> reqMap) throws Exception{
		return phoneManageMapper.getPhone(reqMap);
	}
	@Transactional
	public void insertPhone(Map<String, Object> reqMap) throws Exception{
		phoneManageMapper.insertPhone(reqMap);
	}

}
