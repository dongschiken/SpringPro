package org.doit.ik.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.doit.ik.domain.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao{
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public MemberVO getMember(String id) throws ClassNotFoundException, SQLException
	{
		String sql = "SELECT * "
				+ " FROM MEMBER "
				+ " WHERE ID = ? ";
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("id", id);
		return namedParameterJdbcTemplate.queryForObject(sql, 
				parameterSource, new BeanPropertyRowMapper<MemberVO>(MemberVO.class));
	}
	
	@Override
	public int insert(MemberVO memberVO) throws ClassNotFoundException, SQLException
	{
		String sql = "INSERT INTO MEMBER"
				+ " (id, pwd, name, gender, birth, is_lunar, cphone, email, habit, regdate) "
				+ " VALUES( :id, :pwd, :name, :gender, :birth, :is_lunar, :cphone, :email, :habit, SYSDATE) ";
		
		SqlParameterSource parameterSource= new BeanPropertySqlParameterSource(memberVO);
	      
	    return this.namedParameterJdbcTemplate.update(sql,  parameterSource);
		

	}
}
