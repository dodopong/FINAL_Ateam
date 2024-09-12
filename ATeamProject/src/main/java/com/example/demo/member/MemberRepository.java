package com.example.demo.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
	//해당 유저명이 있는지 체크
	Optional<Member> findByMemberId(String username);
	Optional<Member> findByMemberKey(Integer id);
	//JpaRepository내에서 컬럼명에 언더바를 쓰면 에러가남..키워드로 인식해서 언더바 제거함
	//fingByMember_id -> findByMemberId
}
