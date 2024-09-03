package com.example.demo.member;

import lombok.Getter;

@Getter
public enum MemberRole {
	
	ADMIN("ROLE_ADMIN"), //ADMIN 관리자
	USER("ROLE_USER");   //USER  사용자

	private String value;
	
	MemberRole(String value) {
		this.value = value;
	}
}
