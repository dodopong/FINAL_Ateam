package com.example.demo.cart;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.demo.course.Course;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CartService {
	
	private final CartRepository car;
	
	
	public void create(Course course) {
		Cart cart = new Cart();
//		cart.setCourseList();
		cart.setUpdate_date(LocalDateTime.now());
		this.car.save(cart);
	}
	
	public Cart getCart(Integer id) {
		Optional<Cart> c2 = this.car.findById(id);
		return c2.get();

	}

	
}
