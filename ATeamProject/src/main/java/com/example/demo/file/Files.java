package com.example.demo.file;

import com.example.demo.course.Course;
import com.example.demo.lecture.Lecture;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Files {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fno;
	
	private String filename;
	private String fileOriName;
	private String fileurl;
	
	@ManyToOne
	private Course course;
	@OneToOne
	private Lecture lecture;
	

}
