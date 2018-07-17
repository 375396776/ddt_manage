package com.ddt.manage.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ddt.manage.mapper.GoodsManageMapper;
import com.ddt.manage.po.GoodsItems;

@Service
public class GoodsManageService {

	@Autowired
	GoodsManageMapper goodsManageMapper;
	@Transactional
	public List<GoodsItems> getAllGoods(Map<String, Object> reqMap) throws Exception{
		
		return goodsManageMapper.getAllGoods(reqMap);
	}
}
