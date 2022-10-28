package com.rubypaper.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rubypaper.board.domain.BoardVO;
import com.rubypaper.board.domain.MemberVO;
import com.rubypaper.board.persistence.BoardServiceImpl;
import com.rubypaper.board.persistence.MemberServiceImpl;

@Controller
@RequestMapping("/board/")
public class MemberController {
	
	@Autowired
	private MemberServiceImpl memberService;
	
	@Autowired
	private BoardServiceImpl boardService;
	
	
	@RequestMapping("/getMemberList.do")
	public String getMemberList(Model model, MemberVO vo) {
		model.addAttribute("memberList", memberService.getMemberList(vo));
		return "board/getMemberList.html";
		
	}
	
	@RequestMapping("/memberDelete.do")       //회원 삭제 시 회원이 쓴 글도 함께 삭제
	public String memberDelete(MemberVO vo1, BoardVO vo2, Model model) {
		memberService.memberDelete(vo1);
		boardService.boardWriterDelete(vo2);
		return "redirect:getMemberList.do";
	}

}
