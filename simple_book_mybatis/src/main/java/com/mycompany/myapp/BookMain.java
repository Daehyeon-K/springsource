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
//		BookDTO insertDto = new BookDTO(2003, 18000, "모두의 알고리즘", "이승한");
//		System.out.println(service.bookInsert(insertDto)?"삽입성공":"삽입실패");
		
		// 도서 정보 수정
//		System.out.println(service.bookUpdate(2003, 32000)?"수정성공":"수정실패");
		
		// 도서 정보 삭제
//		System.out.println(service.bookDelete(2003)?"삭제성공":"삭제실패");
		
		// 전체 조회
//		List<BookDTO> list = service.getList();
//		for(BookDTO dto : list) {
//			System.out.println(dto);
//		}
		
		// 검색
		List<BookDTO> list = service.searchList("code", "2002");
		for(BookDTO dto : list) {
			System.out.println(dto);
		}
	}

}
