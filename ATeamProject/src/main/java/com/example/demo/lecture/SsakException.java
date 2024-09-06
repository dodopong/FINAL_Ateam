package com.example.demo.lecture;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "객체 없음")
public class SsakException extends Exception{
	public SsakException(String msg) {
		super(msg);
	}

}
