package com.mycompany.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.dao.BookDAO;
import com.mycompany.myapp.dto.BookDTO;

@Service("service") // 객체 생성
public class BookServiceImpl implements BookService {
	
	@Autowired // 객체 주입
	private BookDAO dao; // => 객체 생성 필요
	
	@Override
	public List<BookDTO> getList() {
		
		return dao.select();
	}

	@Override
	public boolean bookInsert(BookDTO insertDto) {
		
		return dao.insert(insertDto)>0?true:false;
	}
	
	

}
