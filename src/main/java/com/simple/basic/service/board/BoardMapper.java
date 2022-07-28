package com.simple.basic.service.board;

import org.apache.ibatis.annotations.Mapper;

import com.simple.basic.command.BoardVO;

@Mapper // Spring boot에서는 mapper로 사용할 인터페이스에 반드시 붙여야 한다!
public interface BoardMapper {
//	public String getTime();
	public boolean insert(BoardVO vo);
}
