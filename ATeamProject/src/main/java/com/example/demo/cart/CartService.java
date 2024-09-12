package com.example.demo.cart;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.demo.course.Course;
import com.example.demo.course.NotFoundException;
import com.example.demo.member.Member;
import com.example.demo.member.MemberRepository;
import com.example.demo.member.nosignException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CartService {
	
	private final CartRepository car;
	private final MemberRepository mer;
	
	public void addCart(Course courseKey, Member memberKey) {
		Cart cart = new Cart();
		cart.setCourseKey(courseKey);
		cart.setMemberKey(memberKey);
		cart.setUpdateDate(LocalDateTime.now());
		this.car.save(cart);
		
		
	}
	
	public Cart getCart(Integer id) throws NotFoundException {
		Optional<Cart> c = this.car.findById(id);
		if(c.isPresent()) {
		return c.get();
		}
		else {
			throw new NotFoundException("데이터를 찾을 수 없습니다.");
		}
	}
	
	
	
	
	

	
}
