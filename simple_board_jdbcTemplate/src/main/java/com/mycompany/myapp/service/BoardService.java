package com.mycompany.myapp.service;

import java.util.List;

import com.mycompany.myapp.dto.BoardDTO;

public interface BoardService {
	//CRUD 호출
	public List<BoardDTO> getList();
	public BoardDTO getRow(int bno);
	public boolean boardInsert(BoardDTO insertDto);
	public int boardUpdate(BoardDTO updateDto);
	public boolean boardDelete(int bno);
}
