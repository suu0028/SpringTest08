package com.rubypaper.board.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rubypaper.board.domain.BoardVO;
import com.rubypaper.board.domain.JoinVO;
import com.rubypaper.board.persistence.BoardServiceImpl;
import com.rubypaper.board.persistence.JoinServiceImpl;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	@Autowired
	private JoinServiceImpl joinService;
	
	@Autowired
	private BoardServiceImpl boardService;
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(Model model, JoinVO vo){
		model.addAttribute("boardList", joinService.join1(vo));
		return "board/getBoardList.html";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(Model model, JoinVO vo, BoardVO vo2){
		boardService.boardCnt(vo2);  //게시글 상세보기 클릭 시 조회수 증가
		model.addAttribute("board", joinService.join3(vo));
		return "board/getBoard.html";
	}
	
	@RequestMapping("/boardInsertForm.do")    //글쓰기 폼으로 이동
	public String boardInsertForm(BoardVO vo) {
		return "/board/boardInsert.html";
	}
	
	@RequestMapping("/boardInsert.do")       //글등록 버튼 활성화
	public String boardInsert(BoardVO vo) {
		vo.setCreateDate(new Date());  //날짜에 오늘날짜 셋팅
		vo.setCnt(1);   //조회수 기본값 1 셋팅
		boardService.boardInsert(vo);
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping("/boardUpdate.do")       //글 수정
	public String boardUpdate(BoardVO vo) {
		boardService.boardUpdate(vo);
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping("/boardDelete.do")       //글 삭제
	public String boardDelete(BoardVO vo) {
		boardService.boardDelete(vo);
		return "redirect:getBoardList.do";
	}

}
