package com.rubypaper.board.persistence;

import java.util.List;

import com.rubypaper.board.domain.MemberVO;

public interface MemberService {
	
	void memberInsert(MemberVO vo);
	void memberDelete(MemberVO vo);
	List<MemberVO> getMemberList(MemberVO vo);
	MemberVO getMember(MemberVO vo);

}
