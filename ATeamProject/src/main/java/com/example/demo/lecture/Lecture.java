package com.example.demo.lecture;
import com.example.demo.course.Course;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Lecture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long lecture_key;
	
	@Column(length = 200)
	private String title;
	
	private Integer lectureTurn;
	
	@Column(columnDefinition = "TEXT")
	private String objective;
	
	private String video_src;
	
	private LocalDateTime last_update_date;
	
	@ManyToOne
	private Course course;
}
