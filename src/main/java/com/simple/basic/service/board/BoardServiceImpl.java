package com.simple.basic.service.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.basic.command.BoardVO;

// @Service는 annotation이 붙은 이 얘는 Bean으로 등록할거라고 선언하는 것이다. 이 방법을 제일 많이 사용한다.
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired // 인터페이스와 mapper 이름은 동일해야 한다.
	BoardMapper boardMapper;
	
	@Override
	public boolean insert(BoardVO vo) {
		
		// insert, update, delete는 return 받아야 하는 값이 true, false로 약속되어 있다.
//		boolean result = boardMapper.insert(vo);
		
		// service에서 특별하게 호출해야 하는 작업이 없으면 return에서 바로 전달되도록 설정하는 경우가 대부분이다.
		return boardMapper.insert(vo);
	}

}
