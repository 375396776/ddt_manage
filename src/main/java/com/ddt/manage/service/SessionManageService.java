package com.ddt.manage.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddt.manage.mapper.SessionManageMapper;
import com.ddt.manage.po.Session;
@Service
public class SessionManageService implements SessionManageMapper {
	
	@Autowired
	SessionManageMapper sessionMangeMapper;

	@Override
	public Session getSessionByUserId(Map<String, String> reqMap) throws Exception {
		Session sessionByUserId = sessionMangeMapper.getSessionByUserId(reqMap);
		return sessionByUserId;
	}

	@Override
	public boolean insertSession(Session session) throws Exception {
		return sessionMangeMapper.insertSession(session);
	}

	@Override
	public boolean updateSession(Session session) throws Exception {
		boolean updateSession = sessionMangeMapper.updateSession(session);
		return updateSession;
	}

}
