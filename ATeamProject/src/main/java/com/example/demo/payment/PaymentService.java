package com.example.demo.payment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.course.NotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PaymentService {
	
	private final PaymentRepository pr;
	
	public void create(String paymentPrice, String discount, String paymentType, String phoneNumber,
			           String receiptType, Boolean seceiptyn, Boolean saveyn) {
		
		Payment p = new Payment();
//		p.setPaymentDate(LocalDateTime.now());
//		p.setPaymentPrice(paymentPrice);
////		Cart에서 가져온 course에 담길 price값 총량을 파라미터로 담아야 하는데 어떻게 담지?
//		p.setDiscount(discount);
//		p.setPaymentType(paymentType);
//		p.setPhoneNumber(phoneNumber);
//		p.setReceiptType(receiptType);
//		p.setReceiptyn(seceiptyn);
//		p.setSaveyn(saveyn);
		
		this.pr.save(p);
	}
	
	public Payment getPayment(Integer id, List<String> coursekeyList) throws NotFoundException {
		Optional<Payment> c = this.pr.findById(id);
		if(c.isPresent()) {
		return c.get();
		}
		else {
			throw new NotFoundException("데이터를 찾을 수 없습니다.");
		}
	}
	
}
