package com.okestro.aiops.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="member") // mapping table
public class MemberVO {
	@Id // pk
	private String id;
	private String email;
	private String password;
	private String regDate;
	
	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberVO(String id, String email, String password, String regDate) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.regDate = regDate;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRegDate() {
		return regDate;
	}
	
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

}
