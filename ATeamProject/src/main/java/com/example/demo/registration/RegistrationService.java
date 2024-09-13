package com.example.demo.registration;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.course.Course;
import com.example.demo.member.Member;
import com.example.demo.member.nosignException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RegistrationService {
	
	private final RegistrationRepository rr;
	public void create(Member m, Course c) {
		Registration r = new Registration();
		r.setCourse(c);
		r.setMember(m);
		
		this.rr.save(r);
	}
	public Registration getRegistration(Integer mk, Integer ck) throws Exception {
		Optional<Registration> r = this.rr.findByMemeberCourse(mk, ck);
		if(r.isPresent()) {
			return r.get();
		}
		else {
			throw new Exception("존재하지 않는 요청입니다");
		}
	}
}
