package com.example.demo.lecture;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller

public class LectureController {
	private final LectureService ls;
	
	@GetMapping("/course/lecture")
	public String viewLecture() {
		return "LectureView";
	}	
}
