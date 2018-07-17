package com.ddt.manage.po;

public class Session {
	private Integer id;
	private String session;
	private Integer user_id;
	
	public Session() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Session(String session, Integer user_id) {
		super();
		this.session = session;
		this.user_id = user_id;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "Session [id=" + id + ", session=" + session + ", user_id=" + user_id + "]";
	}
	

}
