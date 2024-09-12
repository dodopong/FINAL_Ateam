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
	
	
	
	//////////////승래 추가 코드/////////////////////
	
	public void createCart(Member member, Course course) {
		Cart cart = new Cart();
		cart.setMember(member);
		cart.setCourse(course);
		this.car.save(cart);
	}
	
	public Cart getCart(Integer cartkey) throws Exception {
		Optional<Cart> cart = this.car.findById(cartkey);
		if(cart.isPresent()) {
			return cart.get();
		}
		else {
			throw new nosignException("존재하지 않는 카트입니다");
		}
	}
	
	public Cart getCart(Integer mk, Integer ck) throws Exception {
		Optional<Cart> cart = this.car.findByMemeberCourse(mk, ck);
		if(cart.isPresent()) {
			return cart.get();
		}
		else {
			throw new nosignException("존재하지 않는 카트입니다");
		}
	}
	
	public void delete(Cart cart) {
		this.car.delete(cart);
	}
	////////////////////////////////////////
//	public void addCart(Course courseKey, Member member) {
//		Cart cart = new Cart();
//		cart.setCourseKey(courseKey);
//		cart.setMemberKey(member);
//		cart.setUpdateDate(LocalDateTime.now());
//		this.car.save(cart);
//	}
//	
//	public Cart getCart(Integer id) throws NotFoundException {
//		Optional<Cart> c = this.car.findById(id);
//		if(c.isPresent()) {
//		return c.get();
//		}
//		else {
//			throw new NotFoundException("데이터를 찾을 수 없습니다.");
//		}
//	}
//	
	
	
	
	

	
}
