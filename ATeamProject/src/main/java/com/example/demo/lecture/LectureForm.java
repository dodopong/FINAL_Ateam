package com.example.demo.lecture;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LectureForm {
	
	@NotEmpty(message="제목이없으면 안돼요.")
	@Size(max=50)
	private String title;
	
	
	private String objective;
	
	private MultipartFile file;
	
	//private String videoSrc;
	
}
