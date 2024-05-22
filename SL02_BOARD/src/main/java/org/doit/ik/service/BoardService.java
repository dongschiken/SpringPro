package org.doit.ik.service;

import java.util.List;

import org.doit.ik.domain.BoardVO;
import org.springframework.stereotype.Service;

public interface BoardService {
	 
	List<BoardVO> getList();
	void register(BoardVO board);
	BoardVO get(long bno);
	boolean modify(BoardVO board);
	boolean remove(long bno);

}
