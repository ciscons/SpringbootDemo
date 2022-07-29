package com.simple.basic.service.memo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.basic.command.MemoVO;

@Service
public class MemoServiceImpl implements MemoService {

	@Autowired
	MemoMapper memoMapper;
	
	@Override
	public List<MemoVO> getList() {
		
		return memoMapper.getList();
	}

	@Override
	public boolean insert(MemoVO vo) {
		return memoMapper.insert(vo);
	}

	@Override
	public MemoVO getDetail(int mno) {
		return memoMapper.getDetail(mno);
	}

	@Override
	public boolean delete(int bno) {
		return memoMapper.delete(bno);
	}

	



}
