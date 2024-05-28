package org.doit.ik.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.doit.ik.domain.MemberVO;

public class MemberDao {
	public MemberVO getMember(String id) throws ClassNotFoundException, SQLException
	{
		String sql = "SELECT * "
				+ " FROM MEMBER "
				+ " WHERE ID = ? ";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
				"scott", "tiger");
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		ResultSet rs = st.executeQuery();
		
		MemberVO memberVO = null;
		
		if(rs.next())
		{
			memberVO = new MemberVO();
			memberVO.setId(rs.getString("id"));
			memberVO.setPwd(rs.getString("pwd"));
			memberVO.setName(rs.getString("name"));
			memberVO.setGender(rs.getString("gender"));
			memberVO.setBirth(rs.getString("birth"));
			memberVO.setIs_lunar(rs.getString("is_lunar"));
			memberVO.setCphone(rs.getString("cphone"));
			memberVO.setEmail(rs.getString("email"));
			memberVO.setHabit(rs.getString("habit"));
			memberVO.setRegdate(rs.getDate("regdate"));
		}
		
		rs.close();
		st.close();
		con.close();
		
		return memberVO;
	}
	
	public int insert(MemberVO memberVO) throws ClassNotFoundException, SQLException
	{
		String sql = "INSERT INTO MEMBER"
				+ " (id, pwd, name, gender, birth, is_lunar, cphone, email, habit, regdate) "
				+ " VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE) ";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
				"scott", "tiger");
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, memberVO.getId());
		st.setString(2, memberVO.getPwd());
		st.setString(3, memberVO.getName());
		st.setString(4, memberVO.getGender());
		st.setString(5, memberVO.getBirth());
		st.setString(6, memberVO.getIs_lunar());
		st.setString(7, memberVO.getCphone());
		st.setString(8, memberVO.getEmail());
		st.setString(9, memberVO.getHabit());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
}
