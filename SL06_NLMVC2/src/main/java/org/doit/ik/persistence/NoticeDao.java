package org.doit.ik.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.doit.ik.domain.NoticeVO;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDao {
	
	// 공지사항의 갯수 반환하는 메서드
	public int getCount(String field, String query) throws ClassNotFoundException, SQLException
	{
		String sql = "SELECT COUNT(*) CNT FROM NOTICES WHERE "+field+" LIKE ?";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
				"scott", "tiger");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+query+"%");

		ResultSet rs = st.executeQuery();
		rs.next();
		
		int cnt = rs.getInt("cnt");
		
		rs.close();
		st.close();
		con.close();
		
		return cnt;
	}
	
	// 공지사항의 목록을 List컬렉션으로 반환하는 메서드
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
	               + "  WHERE "+field+" LIKE ? "
	                     + "  ORDER BY REGDATE DESC "
	                     + "  ) N "
	                     + "  ) "
	                 +  " WHERE NUM BETWEEN ? AND ? ";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
				"scott", "tiger");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+query+"%");
		st.setInt(2, srow);
		st.setInt(3, erow);
		ResultSet rs = st.executeQuery();
		
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		
		while(rs.next()){
			NoticeVO notice = new NoticeVO();
			notice.setSeq(rs.getString("seq"));
			notice.setTitle(rs.getString("title"));
			notice.setWriter(rs.getString("writer"));
			notice.setRegdate(rs.getDate("regdate"));
			notice.setHit(rs.getInt("hit"));
			notice.setContent(rs.getString("content"));
			notice.setFilesrc(rs.getString("fileSrc"));
			
			list.add(notice);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list;
	}
	
	public int delete(String seq) throws ClassNotFoundException, SQLException
	{
		String sql = " DELETE notices "
				+ " WHERE SEQ = ? ";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
				"scott", "tiger");
		PreparedStatement st = con.prepareStatement(sql);	
		st.setString(1, seq);
		
		int af = st.executeUpdate();
		
		return af;
	}
	
	public int update(NoticeVO notice) throws ClassNotFoundException, SQLException{
		
		
		String sql = "UPDATE NOTICES"
				+ " SET TITLE=?, CONTENT=?, FILESRC=?"
				+ " WHERE SEQ = ? " ;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
				"scott", "tiger");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, notice.getTitle());
		st.setString(2, notice.getContent());
		st.setString(3, notice.getFilesrc());
		st.setString(4, notice.getSeq());		
		
		int af = st.executeUpdate();
		
		return af;
	}
	
	public NoticeVO getNotice(String seq) throws ClassNotFoundException, SQLException
	{
		String sql = "SELECT *"
				+ " FROM notices"
				+ " WHERE SEQ = "+seq;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
				"scott", "tiger");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		rs.next();
		
		NoticeVO notice = new NoticeVO();
		notice.setSeq(rs.getString("seq"));
		notice.setTitle(rs.getString("title"));
		notice.setWriter(rs.getString("writer"));
		notice.setRegdate(rs.getDate("regdate"));
		notice.setHit(rs.getInt("hit"));
		notice.setContent(rs.getString("content"));
		notice.setFilesrc(rs.getString("fileSrc"));
		
		rs.close();
		st.close();
		con.close();
		
		return notice;
	}
	
	// 공지사항 추가 메서드
	public int insert(NoticeVO notice) throws ClassNotFoundException, SQLException {
		String sql = " INSERT INTO NOTICES(SEQ, TITLE, CONTENT, WRITER, REGDATE, HIT, FILESRC) "
				+ " VALUES( (SELECT NVL(MAX(TO_NUMBER(SEQ)) ,0)+1 FROM NOTICES), ?, ?, 'dongs', SYSDATE, 0, ?)";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
				"scott", "tiger");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, notice.getTitle());
		st.setString(2, notice.getContent());
		st.setString(3, notice.getFilesrc());
		
		int af = st.executeUpdate();
		
		st.close();
		con.close();
		
		return af;
	}
}
