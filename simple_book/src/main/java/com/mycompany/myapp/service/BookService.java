package com.mycompany.myapp.service;

import java.util.List;

import com.mycompany.myapp.dto.BookDTO;

public interface BookService {
	public List<BookDTO> getList();
	public boolean bookInsert(BookDTO insertDto);
}
