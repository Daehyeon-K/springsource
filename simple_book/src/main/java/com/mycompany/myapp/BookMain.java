package com.mycompany.myapp;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mycompany.myapp.dto.BookDTO;
import com.mycompany.myapp.service.BookService;

public class BookMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		BookService service = (BookService) ctx.getBean("service");
		
		// 자바 코드
//		BookService service = new BookServiceImpl();
		
		// 도서 정보 삽입
		BookDTO insertDto = new BookDTO(2000, 28000, "jQuery 입문", "유광열");
		System.out.println(service.bookInsert(insertDto)?"삽입성공":"삽입실패");
		
		List<BookDTO> list = service.getList();
		for(BookDTO dto : list) {
			System.out.println(dto);
		}
	}

}
