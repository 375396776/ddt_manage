package com.ddt.manage.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ddt.manage.po.Session;
import com.ddt.manage.po.User;
import com.ddt.manage.service.SessionManageService;
import com.ddt.manage.service.UserManageService;

@Controller
public class UserLoginController {

	@Autowired
	UserManageService userManageService;
	@Autowired
	SessionManageService sessionManageService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		// 获取Cookie
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			Map<String, String> sessionMap = new HashMap<String, String>();
			sessionMap.put("session", cookie.getValue());
			Session session = sessionManageService.getSessionByUserId(sessionMap);
			if (session != null) {
				model.addAttribute("JSESSIONID", cookie.getValue());
				return "success";
			}
		}
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPOST(@RequestParam String username, @RequestParam String password, HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception {

		Map<String, String> userLoginMap = new HashMap<String, String>();
		userLoginMap.put("username", username);
		userLoginMap.put("password", password);
		// 先从数据库查找该账号信息
		User user = userManageService.getUserByUsername(userLoginMap);
		if (user == null) {
			model.addAttribute("message", "不存在的用户！！！");
		} else {
			// 匹配密码
			if (user.getPassword().equals(password)) {
				// 登录成功，保存session
				HttpSession httpSession = request.getSession();
				String id2 = httpSession.getId();
				httpSession.setAttribute("user", user);
				String id = httpSession.getId();

				// 保存cookie
				Cookie[] cookies = request.getCookies();
				Cookie cookie = cookies[0];// 获得最新的那个cookie
				String value = cookie.getValue();

				Map<String, String> sessionMap = new HashMap<String, String>();
				sessionMap.put("user_id", user.getId().toString());
				Session isSession = sessionManageService.getSessionByUserId(sessionMap);
				// 没有session，就添加
				if (isSession == null) {
					Session session = new Session();
					session.setSession(cookie.getValue());
					session.setUser_id(user.getId());
					System.out.println("cookie>>" + cookie.getValue());
					sessionManageService.insertSession(session);
					System.out.println("==添加session==");
				} else {
					// 如果已经有session，就更新
					isSession.setSession(cookie.getValue());
					sessionManageService.updateSession(isSession);
					System.out.println("==更新session==");
				}

				model.addAttribute("user", user);
				return "success";
			} else {
				model.addAttribute("message", "Wrong password");
			}
		}
		return "success";
	}

	@RequestMapping("/success")
	public String toSuccess(HttpServletRequest request, Model model) throws Exception {
		Object userSession = request.getSession().getAttribute("user");
		model.addAttribute("user", userSession);
		return "success";
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, Model model) throws Exception {
		// false代表：不创建session对象，只是从request中获取。
		HttpSession session = request.getSession(false);
		session.removeAttribute("user");
		// 从定向到index.jsp
		return "login";
	}

}
