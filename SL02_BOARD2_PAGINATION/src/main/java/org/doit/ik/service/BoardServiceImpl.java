package org.doit.ik.service;

import java.util.List;

import org.doit.ik.domain.BoardVO;
import org.doit.ik.domain.Criteria;
import org.doit.ik.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor // 스프링 4.3부터는 AllArgsConstructor를 사용하면 Autowired를 사용안해도 연결짓는것이 가능하다.
public class BoardServiceImpl implements BoardService{

	//@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardVO> getList() {
		log.info("BoardServiceImpl getList()...");
		return this.boardMapper.getList();
	}

	@Override
	public void register(BoardVO boardVO) {
		log.info("BoardServiceImpl register()...");
		//this.boardMapper.insert(boardVO);
		this.boardMapper.insertSelectKey(boardVO);
	}

	@Override
	public BoardVO get(long bno) {
		log.info("BoardServiceImpl get()...");
		return this.boardMapper.read(bno);	
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("BoardServiceImpl modify()....");
		return this.boardMapper.update(board) == 1;
	}

	@Override
	public boolean remove(long bno) {
		log.info("BoardServiceImpl remove()...");
		return this.boardMapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getListWithPaging(Criteria criteria) {
		log.info(">> BoardServiceImpl getListWithPaging()...");
		return this.boardMapper.getListWithPaging(criteria);		
	}

	@Override
	public int getTotal(Criteria criteria) {
		log.info("BoardServiceImpl getTotal()...");
		return this.boardMapper.getTotalCount(criteria);
	}
	
}
