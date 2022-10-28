package com.rubypaper.board.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubypaper.board.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao dao;

	@Override
	public void boardInsert(BoardVO vo) {
		dao.boardInsert(vo);
		
	}

	@Override
	public void boardUpdate(BoardVO vo) {
		dao.boardUpdate(vo);
		
	}

	@Override
	public void boardDelete(BoardVO vo) {
		dao.boardDelete(vo);
		
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		
		return dao.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		
		return dao.getBoardList(vo);
	}

	@Override
	public void boardCnt(BoardVO vo) {
		dao.boardCnt(vo);
		
	}

	@Override
	public void boardWriterDelete(BoardVO vo) {
		dao.boardWriterDelete(vo);
		
	}

}
