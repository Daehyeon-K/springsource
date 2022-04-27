package com.mycompany.myapp.mapper;

import java.util.List;

import com.mycompany.myapp.dto.BoardDTO;

public interface BoardMapper {
	public int insert(BoardDTO insertDto);
	public List<BoardDTO> select();
	public int update(BoardDTO updateDto);
	public int delete(int bno);
	public BoardDTO selectOne(int bno);
	
	
}
