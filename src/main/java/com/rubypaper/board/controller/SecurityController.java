package com.rubypaper.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class SecurityController {
	
	@RequestMapping("/system/login.do")
	public void login() {
		System.out.println("login 확인");
	}
	
	@RequestMapping("/system/accessDenied.do")
	public void accessDenied() {
		System.out.println("accessDenied 확인");
	}
	
	@RequestMapping("/admin/adminPage.do")
	public void forAdmin() {
		System.out.println("Admin 요청합니다.");
	}
	
	@RequestMapping("/system/logout.do")
	public String logout(SessionStatus status) {
		status.setComplete();         //세션 강제 종료
		return "redirect:/index.html"; //세션 종료 후 인덱스 화면으로 이동
	}
	
}
