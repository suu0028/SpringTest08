package com.rubypaper.board.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.rubypaper.board.domain.MemberVO;

public class SecurityUser extends User {

	public SecurityUser(MemberVO member) {
		super(member.getId(), member.getPassword(), 
				AuthorityUtils.createAuthorityList(member.getRole().toString()));
		
		//데이터베이스 리턴값
		System.out.println("===> SecurityUser 생성자");
		System.out.println("===> SecurityUser 확인: " + member.getId() + ", " + member.getPassword() + ", " + member.getName() + ", " + member.getRole() + ", " + member.getEnabled());
	}

}
