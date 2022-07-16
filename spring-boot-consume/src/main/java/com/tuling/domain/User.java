package com.tuling.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private String uid;
	private String username;
}
