package com.example.demo.lecture;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.course.Course;
import com.example.demo.course.NotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LectureService {
	private final LectureRepository lr;
	
	public List<Lecture> getLectureAll(){
		return this.lr.findAll();
	}
	
	public Lecture getLecture(long lectureKey) throws SsakException {
		Optional<Lecture> l1 = this.lr.findById( (int) lectureKey);
		if(l1.isPresent()) {
			return l1.get();
		}
		else {
			throw new SsakException("데이터를 찾을 수 없습니다.");
		}
	}
	
	
	public  void create(Course c, String title, String objective) {
		Lecture l = new Lecture();
		l.setCourse(c);
		l.setTitle(title);
		l.setObjective(objective);
		l.setLastUpdateDate(LocalDateTime.now());
		this.lr.save(l);
	}
	
	public  Lecture returncreate(Course c, String title, String objective) {
		Lecture l = new Lecture();
		l.setCourse(c);
		l.setTitle(title);
		l.setObjective(objective);
		l.setLastUpdateDate(LocalDateTime.now());
		this.lr.save(l);
		return l;
	}
	
	

}
