package com.ddt.manage.mapper;

import java.util.Map;

import com.ddt.manage.po.Session;

public interface SessionManageMapper {
	
	public Session getSessionByUserId(Map<String, String> reqMap) throws Exception;
	public boolean insertSession(Session session) throws Exception;
	public boolean updateSession(Session session) throws Exception;

}
