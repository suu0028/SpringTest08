package com.rubypaper.board.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.rubypaper.board.domain.MemberVO;

@Mapper
public interface MemberDao {
	
	void memberInsert(MemberVO vo);
	void memberDelete(MemberVO vo);
	List<MemberVO> getMemberList(MemberVO vo);
	MemberVO getMember(MemberVO vo);

}
