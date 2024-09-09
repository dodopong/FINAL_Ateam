package com.example.demo.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MembersecurityService implements UserDetailsService{
//
	private final MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	 
		
		Optional<Member> _member = this.memberRepository.findByMemberId(username);
		if(_member.isEmpty()) { //사용자(member_id)를 찾을 수 없을 때
			throw new UsernameNotFoundException("사용자가 없어요");
		}
		
		Member member = _member.get();
		
		List<GrantedAuthority> auth = new ArrayList<>();
		if("admin".equals(username)) {
			auth.add(new SimpleGrantedAuthority(MemberRole.ADMIN.getValue()));
		}else {
			auth.add(new SimpleGrantedAuthority(MemberRole.USER.getValue()));
		}
		
		return new User(member.getMemberId(), member.getPassword(), auth);
		
	}

}
