package com.example.demo.career;


import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CareerForm {

	@NotEmpty(message = "내용이 없으면 안돼요")
	private String careerText;
	
	private String year;
}
