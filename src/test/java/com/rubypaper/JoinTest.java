package com.rubypaper;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rubypaper.board.domain.JoinVO;
import com.rubypaper.board.domain.MemberVO;
import com.rubypaper.board.domain.Role;
import com.rubypaper.board.persistence.JoinServiceImpl;
import com.rubypaper.board.persistence.MemberServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JoinTest {
	
	@Autowired
	private JoinServiceImpl joinService;
	
	
	@Test
	public void join2() {
		JoinVO vo = new JoinVO();
		vo.setId("member");
		List<JoinVO> li = joinService.join2(vo);
		for(JoinVO m : li) {
			System.out.println("==>" + m.toString());
		}
	}
	
	//@Test
	public void join3() {
		JoinVO vo = new JoinVO();
		vo.setSeq(1013);
		JoinVO m = joinService.join3(vo);
		System.out.println("==>" + m.toString());
	}

}
