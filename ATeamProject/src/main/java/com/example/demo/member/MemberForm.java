package com.example.demo.member;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.file.Files;

import jakarta.persistence.Convert;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class MemberForm {
//	@NotEmpty(message = "아이디를 입력해주세요.")
//	private String memberId;
	
	@NotEmpty(message = "이메일(ID)를 입력해주세요.")
	private String email1; //
	
	@NotEmpty(message = "이메일(ID) 도메인주소를 입력해주세요.")
	private String email2; //도메인
	
	@NotEmpty(message = "비밀번호를 입력해주세요.")
	private String password1;
	
	@NotEmpty(message = "비밀번호 확인을 입력해주세요.")
	private String password2;
	
	@NotEmpty(message = "이름을 입력해주세요.")
	private String mname;
	
	@Length(min = 11, message = "전화번호 11자리를 입력해주세요.")
	@NotEmpty(message = "")
	private String telNo;
	
	@NotEmpty(message = "생년월일을 입력해주세요.")
	private String birth;
	
	//@Size(max = 10) html에서 maxlength = 10 설정해서 필요없을듯?
	@NotEmpty(message = "닉네임을 입력해주세요.")
	private String nickname;
	
	private MultipartFile profileImg;
	
	//@NotEmpty(message = "카테고리를 선택해주세요")
	private String category;
	
	@NotEmpty(message = "강사여부를 선택해주세요.")
	private String instructorYn;
}
