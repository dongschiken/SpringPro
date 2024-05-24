package org.doit.ik.mapper;

import java.util.List;
import org.doit.ik.domain.BoardVO;
import org.doit.ik.domain.Criteria;

public interface BoardMapper {
	
	List<BoardVO> getList(); // 페이징 처리가 안되어있는 함수
	List<BoardVO> getListWithPaging(Criteria criteria);
	int getTotalCount(Criteria criteria);
	void insert(BoardVO boardVO); // 새글 쓰기
	void insertSelectKey(BoardVO boardVO); // 새글 쓰기 + PK 가져오기 
	BoardVO read(long bno);
	int update(BoardVO boardVO);
	int delete(long bno);
	
}
