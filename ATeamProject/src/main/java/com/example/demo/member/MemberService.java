package com.example.demo.member;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService { //회원정보를 저장
	private final MemberRepository mr;
	private final PasswordEncoder passwordEncoder;
	
	public void create(String email1, String email2, String password, String mname 
			, String telno, String nickname, String birth 
			, String category
			, String instructoryn) {
		
		
		Member m = new Member();
		m.setMemberId(email1+'@'+email2);
		m.setPassword(passwordEncoder.encode(password));
		m.setMname(mname);
		m.setTelNo(telno);
		m.setBirth(birth);
		m.setNickname(nickname);
		m.setCreateDate(LocalDateTime.now());
		m.setCategory(category);
		m.setInstructorYn(instructoryn);
		m.setLastUpdateDate(LocalDateTime.now());
		
		this.mr.save(m);
	}
	
	public void modify(Member m, String nickname) {
		
		
		m.setNickname(nickname);
		m.setLastUpdateDate(LocalDateTime.now());
		
		this.mr.save(m);
	}
	
	public Member returncreate(String email1, String email2, String password, String mname 
			, String telno, String nickname, String birth 
			, String category
			, String instructoryn) {
		
		
		Member m = new Member();
		m.setMemberId(email1+'@'+email2);
		m.setPassword(passwordEncoder.encode(password));
		m.setMname(mname);
		m.setTelNo(telno);
		m.setBirth(birth);
		m.setNickname(nickname);
		m.setCreateDate(LocalDateTime.now());
		m.setCategory(category);
		m.setInstructorYn(instructoryn);
		m.setLastUpdateDate(LocalDateTime.now());
		
		this.mr.save(m);
		
		return m;
	}
	
	//예외처리 : 존재하지 않는 유저
	public Member getUser(String memberid) throws nosignException {
		Optional<Member> member = this.mr.findByMemberId(memberid);
		if(member.isPresent()) {
			return member.get();
		}
		else {
			throw new nosignException("존재하지 않는 유저입니다");
		}
	}
	

	
}
