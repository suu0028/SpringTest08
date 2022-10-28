package com.rubypaper.board.persistence;

import java.util.List;

import com.rubypaper.board.domain.BoardVO;

public interface BoardService {
	
	void boardInsert(BoardVO vo);
	void boardUpdate(BoardVO vo);
	void boardDelete(BoardVO vo);
	BoardVO getBoard(BoardVO vo);
	List<BoardVO> getBoardList(BoardVO vo);
	void boardCnt(BoardVO vo);
	
	void boardWriterDelete(BoardVO vo);
	
}
