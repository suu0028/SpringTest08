package com.rubypaper.board.security;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.rubypaper.board.domain.MemberVO;
import com.rubypaper.board.persistence.MemberDao;

@SessionAttributes("member")
@Service
public class BoardUserDetailsService implements UserDetailsService {
	
	BoardUserDetailsService(){
		System.out.println("===> BoardUserDetailsService 생성자");
	}
	
	@Autowired
	private MemberDao dao;
	
	//로그인 정보를 받아오기 위해 세션 객체 생성
	@Autowired
	private HttpSession session;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//로그인 폼에 값을 넣을 때 출력
		System.out.println("===> UserDetails loadUserByUsername 실행");
		
		//로그인 폼에서 넘어온 값
		MemberVO member = new MemberVO();
		member.setId(username);
		
		MemberVO user = dao.getMember(member);
		
		//로그인 정보 이용하기 (1)
		session.setAttribute("member", user);
		
		if(user == null) {
			throw new UsernameNotFoundException(username + "사용자 없음");
		} else {
			System.out.println("==***==> SecurityUser로 넘어감");
			return new SecurityUser(user);
		}
	}

}
