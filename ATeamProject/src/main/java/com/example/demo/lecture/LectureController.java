package com.example.demo.lecture;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller

public class LectureController {
	private final LectureService ls;
	
	@GetMapping("/create/addLecture")
	public String viewLecture() {
		return "LectureView";
	}
	
//	@PostMapping("/create/addLecuture")
	
}
