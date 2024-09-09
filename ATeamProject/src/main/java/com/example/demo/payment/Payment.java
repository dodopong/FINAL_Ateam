package com.example.demo.payment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer paymentKey;
	
//	@ManyToOne
//	private Cart cartKey;
//	
//	@NotEmpty
//	private String paymentPrice;
//	
//	@NotEmpty
//	private String discount;
//	
//	@NotEmpty
//	private String paymentType;
//	
//	@NotEmpty
//	private Boolean receiptyn;
//	
//	private String receiptType;
//	
//	private String phoneNumber;
//	
//	private Boolean saveyn;
//	
//	private LocalDateTime paymentDate;
	

}
