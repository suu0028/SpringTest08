package com.rubypaper.board.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubypaper.board.domain.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao dao;

	@Override
	public void memberInsert(MemberVO vo) {
		dao.memberInsert(vo);
		
	}
	
	@Override
	public void memberDelete(MemberVO vo) {
		dao.memberDelete(vo);
		
	}

	@Override
	public List<MemberVO> getMemberList(MemberVO vo) {
		
		return dao.getMemberList(vo);
	}

	@Override
	public MemberVO getMember(MemberVO vo) {
		
		return dao.getMember(vo);
	}

}
