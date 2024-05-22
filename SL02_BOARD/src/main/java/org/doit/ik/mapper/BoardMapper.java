package org.doit.ik.mapper;

import java.util.List;
import org.doit.ik.domain.BoardVO;

public interface BoardMapper {
	
	List<BoardVO> getList();
	void insert(BoardVO boardVO); // 새글 쓰기
	void insertSelectKey(BoardVO boardVO); // 새글 쓰기 + PK 가져오기 
	BoardVO read(long bno);
	int update(BoardVO boardVO);
	int delete(long bno);
	
}
