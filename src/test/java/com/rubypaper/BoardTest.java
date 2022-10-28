package com.rubypaper;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rubypaper.board.domain.BoardVO;
import com.rubypaper.board.persistence.BoardServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTest {
	
	@Autowired
	private BoardServiceImpl boardService;
	
	//@Test
	public void boardInsert1() {
		for(int i=1; i<=5; i++) {
			BoardVO vo = new BoardVO();
			//seq는 board-mapper.xml에서 쿼리에 들어가 있기 때문에 넣지 않음
			vo.setTitle("둘리가 등록" + i);
			vo.setWriter("member");
			vo.setContent("둘리가 등록한 내용" + i + " 입니다");
			vo.setCreateDate(new Date());
			vo.setCnt(1);
			
			boardService.boardInsert(vo);
		}
		
	}
	
	@Test
	public void boardInsert2() {
		for(int i=1; i<=5; i++) {
			BoardVO vo = new BoardVO();
			//seq는 board-mapper.xml에서 쿼리에 들어가 있기 때문에 넣지 않음
			vo.setTitle("도우너가 등록" + i);
			vo.setWriter("admin");
			vo.setContent("도우너가 등록한 내용" + i + " 입니다");
			vo.setCreateDate(new Date());
			vo.setCnt(1);
			
			boardService.boardInsert(vo);
		}
		
	}
	
	//@Before
	public void boardDelete() {
		for(int i=1; i<=10; i++) {
			BoardVO vo = new BoardVO();
			vo.setSeq(1001 + i);
			boardService.boardDelete(vo);
		}
	}
	
	@Test
	public void getBoardList() {
		List<BoardVO> li = boardService.getBoardList(null);
		for(BoardVO m : li) {
			System.out.println("==>" + m.toString());
		}
	}

}
