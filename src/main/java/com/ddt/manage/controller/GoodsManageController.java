package com.ddt.manage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ddt.manage.po.GoodsItems;
import com.ddt.manage.service.GoodsManageService;

@Controller
@RequestMapping(value="/goods")
public class GoodsManageController {
	@Autowired
	GoodsManageService goodsManageService;
	
	@RequestMapping("/queryGoodsItems")
	public ModelAndView queryItems(@RequestParam(value="id", required=false) String inputStr, HttpServletRequest request ) throws Exception {
		System.out.println(inputStr);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", inputStr);
		List<GoodsItems> allGoods = goodsManageService.getAllGoods(map);
		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当 于request的setAttribut，在jsp页面中通过itemsList取数据
		modelAndView.addObject("itemsList", allGoods);

		// 指定视图
		modelAndView.setViewName("goodsItemsList");

		return modelAndView;
	}
}
