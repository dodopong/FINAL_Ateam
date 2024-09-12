package com.example.demo.cart;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.member.Member;

public interface CartRepository extends JpaRepository<Cart, Integer>{
	@Query(value = "SELECT * " +
            "FROM cart " +
            "WHERE " +
            "   member_member_key = :mk" +
            "   and course_course_key = :ck", nativeQuery = true)
	Optional<Cart> findByMemeberCourse(@Param("mk")Integer mk,@Param("ck")Integer ck);
}
