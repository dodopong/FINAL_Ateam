package com.example.demo.lecture;
import com.example.demo.course.Course;
import com.example.demo.file.Files;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Lecture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long lectureKey;
	
	@Column(length = 200)
	private String title;
	
	private Integer lectureTurn;
	
	@Column(columnDefinition = "TEXT")
	private String objective;
	
	
	private String videoSrc;
	
	private LocalDateTime lastUpdateDate;
	
	@ManyToOne
	private Course course;
	
	@OneToOne(mappedBy = "lecture", cascade = CascadeType.ALL)
	private Files file;
}
