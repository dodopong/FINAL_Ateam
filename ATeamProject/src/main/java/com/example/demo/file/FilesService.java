package com.example.demo.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.course.Course;
import com.example.demo.lecture.Lecture;

@Service
public class FilesService {
	@Autowired
	FilesRepository filesRepository;
	
	public void save(Files files, Course c) {
		Files f = new Files();
		f.setFilename(files.getFilename());
		f.setFileOriName(files.getFileOriName());
		f.setCourse(c);
		f.setFileurl(files.getFileurl());
		
		filesRepository.save(f);
	}
	public void save(Files files, Lecture l) {
		Files f = new Files();
		f.setFilename(files.getFilename());
		f.setFileOriName(files.getFileOriName());
		f.setLecture(l);
		f.setFileurl(files.getFileurl());
		
		filesRepository.save(f);
	}


}
