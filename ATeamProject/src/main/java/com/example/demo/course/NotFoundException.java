package com.example.demo.course;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "객체 없음")
public class NotFoundException extends Exception{
	
	public NotFoundException(String msg) {
		super(msg);
	}
	
	

}
