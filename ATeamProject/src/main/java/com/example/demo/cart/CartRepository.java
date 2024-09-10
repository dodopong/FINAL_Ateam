package com.example.demo.cart;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.member.Member;

public interface CartRepository extends JpaRepository<Cart, Integer>{
	
	List<Cart> findByCartKey(Integer cartKey);
	List<Cart> findByMemberKey(Member memberKey);
}
