package com.ddt.manage.config.listener;

import java.util.HashMap;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener {

	public static HashMap<String, String> userMap = new HashMap<String, String>();

	public static HashMap<String, HttpSession> sessionMap = new HashMap<String, HttpSession>();

	/**
	 * Default constructor.
	 */
	public SessionListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		HttpSession session = se.getSession();
		String sessionId = session.getId();
		sessionMap.remove(sessionId);
		for (String key : userMap.keySet()) {
			if (userMap.get(key).equals(sessionId)) {
				userMap.remove(key);
			}
		}
	}

}
