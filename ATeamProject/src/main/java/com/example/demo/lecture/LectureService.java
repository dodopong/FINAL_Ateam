package com.example.demo.lecture;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class LectureService {
	private final LectureRepository lr;
	
	public void create(String title, Integer lectureTurn, String objective, String video_src) {
		Lecture l = new Lecture();
		l.setTitle(title);
		l.setLectureTurn(lectureTurn);
		l.setObjective(objective);
		l.setVideoSrc(video_src);
		l.setLastUpdateDate(LocalDateTime.now());
		this.lr.save(l);
	}

}
