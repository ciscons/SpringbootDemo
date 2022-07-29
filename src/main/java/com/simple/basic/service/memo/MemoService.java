package com.simple.basic.service.memo;

import java.util.List;

import com.simple.basic.command.MemoVO;

public interface MemoService {
	
	public boolean insert(MemoVO vo);
	public List<MemoVO> getList(); // 전체 목록 조회 (SQL의 SELECT문)
	public MemoVO getDetail(int mno);
	public boolean delete(int bno);
}
