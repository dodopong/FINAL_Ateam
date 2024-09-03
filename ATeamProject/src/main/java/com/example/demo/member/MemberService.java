package com.example.demo.member;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService { //회원정보를 저장
	private final MemberRepository mr;

	
	public void create(String member_id, String password, String tel_no, String birth
			, String profile_img, String category, String instructor_yn) {
		
		Member m = new Member();
		m.setMemberId(member_id);
		m.setPassword(password);
		m.setTel_no(tel_no);
		m.setBirth(birth);
		m.setCreate_date(LocalDateTime.now());
		m.setProfile_img(profile_img);
		m.setCategory(category);
		m.setInstructor_yn(instructor_yn);
		m.setLast_update_date(LocalDateTime.now());
		
		this.mr.save(m);
	}
	
	//예외처리 : 존재하지 않는 유저
	public Member getUser(String member_id) throws nosignException {
		Optional<Member> member = this.mr.findByMemberId(member_id);
		if(member.isPresent()) {
			return member.get();
		}
		else {
			throw new nosignException("존재하지 않는 유저입니다");
		}
	}
	


	
	
	
}
