package org.doit.ik.persistence;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.doit.ik.domain.NoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDaoImpl implements NoticeDao {
	
	@Autowired
	private NamedParameterJdbcTemplate npJdbcTemplate;
	
	// 공지사항의 갯수 반환하는 메서드
	@Override
	public int getCount(String field, String query) throws ClassNotFoundException, SQLException
	{
		String sql = "SELECT COUNT(*) CNT FROM NOTICES WHERE "+field+" LIKE :query";
		
		//return this.jdbcTemplate.queryForObject(sql, Integer.class, "%"+query+"%");
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("query", query);
		return this.npJdbcTemplate.queryForObject(sql, parameterSource, Integer.class);
	}
	
	// 공지사항의 목록을 List컬렉션으로 반환하는 메서드
	@Override
	public List<NoticeVO> getNotices(int page, String field, String query) throws ClassNotFoundException, SQLException
	{								// 현재 페이지    // 검색 조건    // 검색어
		
		int srow = 1 + (page-1)*15; // 1, 16, 31, 46, 61, ... an = a1 + (n-1)*d
		int erow = 15 + (page-1)*15; //15, 30, 45, 60, 75, ...
		
		String sql = " SELECT * "
	               + "  FROM ( "
	               + "  SELECT ROWNUM NUM, N.* "
	               + "  FROM ("
	               + "  SELECT * "
	               + "  FROM NOTICES "
	               + "  WHERE "+field+" LIKE :query "
	               + "  ORDER BY REGDATE DESC "
	               + "  ) N "
	               + "  ) "
	               +  " WHERE NUM BETWEEN :srow AND :erow ";
		
		//return this.jdbcTemplate.query(sql, new Object[] {"%"+query+"%", srow, erow}, new BeanPropertyRowMapper<NoticeVO>(NoticeVO.class) );
		
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("query", "%"+query+"%");
		paramMap.put("srow", srow);
		paramMap.put("erow", erow);
		return this.npJdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<NoticeVO>(NoticeVO.class)  );
	}
	
	@Override
	public int delete(String seq) throws ClassNotFoundException, SQLException
	{
		String sql = " DELETE notices "
				+ " WHERE SEQ = :seq ";
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("seq", seq);
		return this.npJdbcTemplate.update(sql, parameterSource);
	}
	
	@Override
	public int update(NoticeVO notice) throws ClassNotFoundException, SQLException{
		
		
		String sql = "UPDATE NOTICES"
				+ " SET TITLE= :title, CONTENT= :content , FILESRC= :filesrc"
				+ " WHERE SEQ = :seq " ;
		
		//return this.jdbcTemplate.update(sql, notice.getTitle(), notice.getContent(), notice.getFilesrc(), notice.getSeq());	

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(notice); // notice 객체를 담아준다.
//		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
//		parameterSource.addValue("title", notice.getTitle());
//		parameterSource.addValue("content", notice.getContent());
//		parameterSource.addValue("filesrc", notice.getFilesrc());
//		parameterSource.addValue("seq", notice.getSeq());

		return this.npJdbcTemplate.update(sql, parameterSource);
	}
	
	@Override
	public NoticeVO getNotice(String seq) throws ClassNotFoundException, SQLException
	{
		String sql = "SELECT *"
				+ " FROM notices"
				+ " WHERE SEQ = :seq";
		
//		return this.jdbcTemplate.queryForObject(sql, new Object[] {seq}
//		, new BeanPropertyRowMapper<NoticeVO>(NoticeVO.class));
		
	
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
	      parameterSource.addValue("seq", seq );
	      
	      return this.npJdbcTemplate.queryForObject(sql
	            , parameterSource
	            , new BeanPropertyRowMapper<NoticeVO>(NoticeVO.class));
		
	}
	
	// 공지사항 추가 메서드
	@Override
	public int insert(NoticeVO notice) throws ClassNotFoundException, SQLException {
		String sql = " INSERT INTO NOTICES(SEQ, TITLE, CONTENT, WRITER, REGDATE, HIT, FILESRC) "
				+ " VALUES( (SELECT NVL(MAX(TO_NUMBER(SEQ)) ,0)+1 FROM NOTICES), :title , :content , 'dongs', SYSDATE, 0, :filesrc)";
		
		SqlParameterSource parameterSource= new BeanPropertySqlParameterSource(notice);
	      
	    return this.npJdbcTemplate.update(sql,  parameterSource);
	}
}
