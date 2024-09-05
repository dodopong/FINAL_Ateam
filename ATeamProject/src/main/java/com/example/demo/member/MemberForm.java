package com.example.demo.member;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class MemberForm {
//	@NotEmpty(message = "아이디를 입력해주세요.")
//	private String memberId;
	
	@NotEmpty(message = "아이디를 입력해주세요.")
	@Size(max = 15, min = 1)
	private String email1; //
	
	@NotEmpty(message = "아이디를 입력해주세요.")
	private String email2; //도메인
	
	@NotEmpty(message = "비밀번호는 필수항목 입니다.")
	private String password1;
	
	@NotEmpty(message = "비밀번호 확인은 필수항목 입니다.")
	private String password2;
	
	@NotEmpty(message = "이름를 입력해주세요.")
	private String mname;
	
	@NotEmpty(message = "전화번호를 입력해주세요.")
	private String telNo;
	
	@NotEmpty(message = "생년월일을 입력해주세요.")
	private String birth;
	
	@Size(max = 10)
	@NotEmpty(message = "닉네임을 입력해주세요.")
	private String nickname;
	
	private String profileImg;
	
	@NotEmpty(message = "카테고리를 선택해주세요")
	private String category;
	
	@NotEmpty(message = "강사여부를 선택해주세요.")
	private String instructorYn;
}
