package org.doit.ik.mapper;

import java.sql.SQLException;
import java.util.List;

import org.doit.ik.domain.NoticeVO;

public interface NoticeMapper {
	
	public int getCount(String field, String query) throws ClassNotFoundException, SQLException;

	public List<NoticeVO> getNotices(
			int page			// 현재 페이지 번호
			, String field		// 검색조건
			, String query		// 검색어
			) throws ClassNotFoundException, SQLException;

	public int delete(String seq) throws ClassNotFoundException, SQLException;

	public int update(NoticeVO notice) throws ClassNotFoundException, SQLException;

	public NoticeVO getNotice(String seq) throws ClassNotFoundException, SQLException;

	public int insert(NoticeVO notice) throws ClassNotFoundException, SQLException;

	//트랜잭션 처리를 위한 메서드 추가
	//public void insertAndPointUpOfMember(NoticeVO notice, String id) throws ClassNotFoundException, SQLException;

	public void hitUp(String seq) throws ClassNotFoundException, SQLException;

	public int getHit(String seq) throws ClassNotFoundException, SQLException;
}
