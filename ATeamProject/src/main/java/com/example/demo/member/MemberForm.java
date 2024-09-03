package com.example.demo.member;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class MemberForm {
	@NotEmpty(message = "아이디를 입력해주세요.")
	@Size(max = 20)
	private String memberId;
	
	@NotEmpty(message = "비밀번호는 필수항목 입니다.")
	private String password1;
	
	@NotEmpty(message = "비밀번호 확인은 필수항목 입니다.")
	private String password2;
	
	@NotEmpty(message = "전화번호를 입력해주세요.")
	private String tel_no;
	
	@NotEmpty(message = "생년월일을 입력해주세요.")
	private String birth;
	
	private String profile_img;
	
	@NotEmpty(message = "카테고리를 선택해주세요")
	private String category;
	
	@NotEmpty(message = "강사여부를 선택해주세요.")
	private String instructor_yn;
}
