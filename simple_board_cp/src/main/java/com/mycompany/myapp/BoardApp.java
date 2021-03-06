package com.mycompany.myapp;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mycompany.myapp.dto.BoardDTO;
import com.mycompany.myapp.service.BoardService;

public class BoardApp {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		BoardService service = (BoardService) ctx.getBean("service");
		
//		//게시글 등록
//		BoardDTO insertDto = new BoardDTO();
//		insertDto.setTitle("스프링 게시판");
//		insertDto.setContent("스프링 게시판 작성하기");
//		insertDto.setWriter("홍길동");
//		System.out.println(service.boardInsert(insertDto)?"삽입성공":"삽입실패");
		
//		// 게시글 업데이트 하기
//		BoardDTO updateDto = new BoardDTO();
//		updateDto.setBno(1);
//		updateDto.setTitle("수정된 스프링 게시판");
//		updateDto.setContent("수정된 스프링 게시판 작성하기");
//		System.out.println(service.boardUpdate(updateDto)?"수정성공":"수정실패");
		
//		// 게시글 삭제 하기
//		System.out.println(service.boardDelete(3)?"삭제성공":"삭제실패");
		
		// 게시글 하나 가져오기
		System.out.println(service.getRow(2));
		
		// 게시글 전체 목록 가져오기
		List<BoardDTO> list = service.getList();
		for(BoardDTO dto:list) {
			System.out.println(dto);
		}

	}

}
