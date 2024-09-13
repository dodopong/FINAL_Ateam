package com.example.demo.registration;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface RegistrationRepository extends JpaRepository<Registration,Integer> {
	@Query(value = "SELECT * " +
            "FROM registration " +
            "WHERE " +
            "   member_member_key = :mk" +
            "   and course_course_key = :ck", nativeQuery = true)
	Optional<Registration> findByMemeberCourse(@Param("mk")Integer mk,@Param("ck")Integer ck);
}
