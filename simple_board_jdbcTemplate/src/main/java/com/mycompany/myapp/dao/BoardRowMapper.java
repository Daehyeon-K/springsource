package com.mycompany.myapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mycompany.myapp.dto.BoardDTO;

public class BoardRowMapper implements RowMapper<BoardDTO> {

	@Override
	public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardDTO dto = new BoardDTO();
		dto.setBno(rs.getInt("bno"));
		dto.setTitle(rs.getString("title"));
		dto.setWriter(rs.getString("writer"));
		dto.setContent(rs.getString("content"));
		dto.setRegDate(rs.getDate("regdate"));
		dto.setUpdateDate(rs.getDate("updatedate"));
		return dto;
	}

}
