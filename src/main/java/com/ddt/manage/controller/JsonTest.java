package com.ddt.manage.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * <p>Title: JsonTest</p>
 * <p>Description: json交互测试</p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2015-4-14下午3:54:32
 * @version 1.0
 */
@Controller
public class JsonTest {
	
	//请求json串(商品信息)，输出json(商品信息)
	//@RequestBody将请求的商品信息的json串转成itemsCustom对象
	//@ResponseBody将itemsCustom转成json输出
	@RequestMapping("/requestJson")
	public @ResponseBody Map<String, Object> requestJson(@RequestBody Map<String, Object> requestMap){
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("name", requestMap.get("name"));
		return resultMap;
		//@ResponseBody将itemsCustom转成json输出
//		return itemsCustom;
	}
	
	//请求key/value，输出json
	@RequestMapping("/responseJson")
	public @ResponseBody Map<String, Object> responseJson(Map<String, Object> requestMap){
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("name", requestMap.get("name"));
		return resultMap;
		//@ResponseBody将itemsCustom转成json输出
//		return itemsCustom;
	}

}
