package com.simple.basic.service.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.simple.basic.command.BoardVO;

@Mapper // Spring boot에서는 mapper로 사용할 인터페이스에 반드시 붙여야 한다!
public interface BoardMapper {
//	public boolean insert(int a); #{a}
//	public boolean insert(Map<String, Object> map); //#{key}
//	public String getTime();
	public boolean insert(BoardVO vo);
	public List<BoardVO> getList(); // 전체 목록 조회 (SQL의 SELECT문)
	public BoardVO getDetail(int bno); // 한 개의 글 선택 후 deatil 정보 가져오기
	public boolean delete(int bno); // 보통 void로 처리한다.
}
