package com.ddt.manage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ddt.manage.service.PhoneManageSercive;

@Controller
@RequestMapping(value = "/phone")
public class PhoneManageController {
	@Autowired
	PhoneManageSercive phoneManageService;

	@RequestMapping("/getPhone")
	public ModelAndView getPhone(@RequestParam(value = "id", required = false) String inputStr,
			HttpServletRequest request) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", inputStr);
		List<Map<String, Object>> phone = phoneManageService.getPhone(map);
		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当 于request的setAttribut，在jsp页面中通过itemsList取数据
		modelAndView.addObject("phone", phone);

		// 指定视图
		modelAndView.setViewName("phone/phone");

		return modelAndView;
	}

	@RequestMapping("/getPhone_ajax")
	@ResponseBody
	public List<Map<String, Object>> getPhone_ajax(@RequestBody Map<String, Object> requestMap) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", requestMap.get("phone_type"));

		List<Map<String, Object>> phoneList = phoneManageService.getPhone(map);
		// Map<String, Object> resultMap = new HashMap<String, Object>();
		// resultMap.put("map", phone);
		return phoneList;
	}

//	@RequestMapping("/login")
//	public String login() throws Exception{
//		String userName = user.getUserName();  
//		String sessionid = SessionListener.userMap.get(userName);    
//		System.out.println("sessionid  "+sessionid);  
//		if(sessionid != null&&!sessionid.equals("")){  
//		   //注销在线用户,如果session id 相同，不销毁。    
//		System.out.println("sessionid不为空");  
//		System.out.println("request.getSession().getId() "+request.getSession().getId());  
//		   /*if(!sessionid.equals(request.getSession().getId())){   
//		       SessionListener.sessionMap.get(sessionid).invalidate();   
//		       SessionListener.userMap.put(userName,request.getSession().getId());   
//		       SessionListener.sessionMap.put(request.getSession().getId(),request.getSession());   
//		   }*/    
//		String message="此账号已经登录";  
//		model.addAttribute("message", message);  
//		return "redirect:/login.do";  
//		}else{   
//		System.out.println("sessionid为空");  
//		   if(SessionListener.sessionMap.containsKey(request.getSession().getId())){  
//		    System.out.println("执行删除sessionMap");  
//		       SessionListener.sessionMap.remove(request.getSession().getId());    
//		       for(String key : SessionListener.userMap.keySet()){    
//		           if(SessionListener.userMap.get(key).equals(request.getSession().getId())){  
//		            System.out.println("执行删除userMap");  
//		               SessionListener.userMap.remove(key);    
//		           }    
//		       }    
//		   }    
//		   SessionListener.userMap.put(userName,request.getSession().getId());    
//		   SessionListener.sessionMap.put(request.getSession().getId(),request.getSession());  
//		   queryList();  
//		   return "redirect:/main.do"; 
//	}

}
