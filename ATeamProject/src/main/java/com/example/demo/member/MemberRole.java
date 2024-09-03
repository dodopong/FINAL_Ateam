package com.example.demo.member;

import lombok.Getter;

@Getter
public enum MemberRole { //관리자 권한을 주기 위해 관리자와 사용자 구분
	
	ADMIN("ROLE_ADMIN"), //ADMIN 관리자
	USER("ROLE_USER");   //USER  사용자

	private String value;
	
	MemberRole(String value) {
		this.value = value;
	}
}
