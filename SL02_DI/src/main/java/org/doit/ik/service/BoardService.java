package org.doit.ik.service;

import java.util.List;

import org.doit.ik.domain.BoardVO;
import org.doit.ik.domain.Criteria;
import org.springframework.stereotype.Service;

public interface BoardService {
	 
	List<BoardVO> getList();
	void register(BoardVO board);
	BoardVO get(long bno);
	boolean modify(BoardVO board);
	boolean remove(long bno);
	
	// 페이징 처리해서 목록 가져오는 메서드
	List<BoardVO> getListWithPaging(Criteria criteria);
	int getTotal(Criteria criteria);

}
