package com.mycompany.myapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.dto.BoardDTO;

import static com.mycompany.myapp.dao.JdbcUtil.*;

@Repository
public class BoardDAO {
	
	private DataSource ds;
	
	public int insert(BoardDTO insertDto) {
		PreparedStatement pstmt = null;
		Connection con = null;
		String sql ="insert into spring_board(bno, title, content, writer) values(seq_board.nextval,?,?,?)";
		int result = 0;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, insertDto.getTitle());
			pstmt.setString(2, insertDto.getContent());
			pstmt.setString(3, insertDto.getWriter());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public List<BoardDTO> select(){
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		String sql = "select * from spring_board";
		
		try {
			con=ds.getConnection();
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setContent(rs.getString("content"));
				dto.setRegDate(rs.getDate("regdate"));
				dto.setUpdateDate(rs.getDate("updatedate"));
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}
	
	//update - bno 일치하면 title, content 변경, updatedate 수정
	public boolean update(BoardDTO updateDto) {
		boolean flag=false;
		PreparedStatement pstmt = null;
		Connection con = null;
		String sql = "update spring_board set title=?, content=?, updatedate=sysdate where bno = ?";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, updateDto.getTitle());
			pstmt.setString(2, updateDto.getContent());
			pstmt.setInt(3, updateDto.getBno());
			
			flag = pstmt.executeUpdate()==1?true:false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return flag;
		
	}
	
	// delete - bno 일치하면 삭제
	public int delete(int bno) {
		PreparedStatement pstmt = null;
		Connection con = null;
		String sql = "delete from spring_board where bno = ?";
		int result = 0;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
	}
	
	// 하나 가져오기
	public BoardDTO selectOne(int bno) {
		BoardDTO dto = new BoardDTO();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		String sql = "select * from spring_board where bno = ?";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setBno(bno);
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setRegDate(rs.getDate("regdate"));
				dto.setUpdateDate(rs.getDate("updatedate"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return dto;
	}
}
