package com.example.demo.career;

import org.springframework.stereotype.Service;

import com.example.demo.member.Member;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CareerService {
	private final CareerRepository cr;
	
	public void create(String careerText, String year, Member m) {
		Career c = new Career();
		c.setCareerText(careerText);
		c.setYear(year);
		c.setMember(m);
		this.cr.save(c);
	}
}
