package com.simple.basic.service.board;

import java.util.List;

import com.simple.basic.command.BoardVO;

public interface BoardService {
	
	public boolean insert(BoardVO vo);
	public List<BoardVO> getList(); // 전체 목록 조회 (SQL의 SELECT문)
	public BoardVO getDetail(int bno); // 한 개의 글 선택 후 deatil 정보 가져오기
	public boolean delete(int bno); // 보통 void로 처리한다.
}
