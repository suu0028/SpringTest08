package com.rubypaper;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.rubypaper.board.domain.MemberVO;
import com.rubypaper.board.domain.Role;
import com.rubypaper.board.persistence.MemberServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberTest {
	
	@Autowired
	private MemberServiceImpl memberService;
	
	@Autowired
	private PasswordEncoder encoder;
	
	//@Before
	public void memberInsert1() {
		MemberVO vo = new MemberVO();
		vo.setId("admin");
		vo.setPassword(encoder.encode("admin123"));
		vo.setName("도우너");
		vo.setRole(Role.ROLE_ADMIN);
		vo.setEnabled("TRUE");
			
		memberService.memberInsert(vo);
		
	}
	
	@Before
	public void memberInsert2() {
		MemberVO vo = new MemberVO();
		vo.setId("member");
		vo.setPassword(encoder.encode("member123"));
		vo.setName("둘리");
		vo.setRole(Role.ROLE_MEMBER);
		vo.setEnabled("TRUE");
			
		memberService.memberInsert(vo);
		
	}
	
	
	@Test
	public void getMemberList() {
		List<MemberVO> li = memberService.getMemberList(null);
		for(MemberVO m : li) {
			System.out.println("==>" + m.toString());
		}
	}

}
