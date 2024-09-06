package com.example.demo.course;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.file.Files;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseForm {
	
	@NotEmpty(message="제목이없으면 안돼요.")
	@Size(max=50)
	private String title;	
	
	@NotEmpty(message = "내용이 없으면 안돼요")
	private String mainContent;
	
	private String bannerText;
	@NotEmpty(message = "카테고리를 선택해주세요")
	private String category;
	@NotEmpty(message = "레벨을 선택해주세요")
	private String level;
	
	private String Objective;
	
	private MultipartFile file1;
	
	private MultipartFile file2;
}