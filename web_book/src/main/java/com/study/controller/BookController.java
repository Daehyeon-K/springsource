package com.study.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.dto.BookDTO;
import com.study.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/book/*")
public class BookController {
	
	@Autowired
	private BookService service;
	
	// 전체 리스트 보여주기
	@GetMapping("/list")
	public void list(Model model) {
		log.info("도서 전체 목록 요청....");
		
		// 서비스 호출
		List<BookDTO> list = service.getList();
		
		// list를 담기
		model.addAttribute("list", list);
	}
	
	// 도서 입력 폼 보여주기
	@GetMapping("/insert")
	public void insertGet() {
		log.info("도서 정보 입력 폼 보여주기....");
	}
	
	// 도서 입력 요청
	@PostMapping("/insert")
	public String insertPost(BookDTO dto, RedirectAttributes rttr) {
		log.info("도서 입력 정보 가져오기...."+dto);
		
		try {
			if(service.bookInsert(dto)) {
				log.info("입력성공");
				return "redirect:/book/list";
			}
		} catch (Exception e) {
			rttr.addFlashAttribute("error", "코드를 확인하세요");
			return "redirect:/book/insert";
		}
		
		log.info("입력실패");
		return "redirect:/book/insert";
	}
	
	// 도서 삭제 폼 보여주기
	@GetMapping("/delete")
	public void deleteGet() {
		log.info("도서 삭제 폼 보여주기....");
	}
	
	// 도서 삭제 요청
	@PostMapping("/delete")
	public String deletePost(@Param("code") int code) {
		log.info("도서 삭제...."+code);
		
		if(service.bookDelete(code)) {
			log.info("삭제성공");
			return "redirect:/book/list";
		}
		log.info("삭제실패");
		return "redirect:/book/delete";
	}
	
	// 도서 수정 페이지 보여주기
	@GetMapping("/update")
	public void updateGet() {
		log.info("도서 정보 수정 페이지 요청....");
	}
	
	// 도서 수정 요청
	@PostMapping("/update")
	public String updatePost(@Param("code") int code, @Param("price") int price) {
		log.info("도서 수정...."+code+" "+price);
		
		if(service.bookUpdate(code, price)) {
			log.info("수정성공");
			return "redirect:/book/list";
		}
		log.info("수정실패");
		return "redirect:/book/update";
	}
	
	// 도서 검색 폼 보여주기
		@GetMapping("/search")
		public void searchGet() {
			log.info("도서 정보 검색 폼 요청....");
		}
		
		// 도서 검색 요청
		@PostMapping("/search")
		public String searchPost(String criteria, String keyword, Model model) {
			log.info("도서 검색...."+criteria+" "+ keyword);
			
			List<BookDTO> list = service.getSerachList(criteria, keyword);
			
			model.addAttribute("list", list);
			
			return "/book/list";
		}
}
