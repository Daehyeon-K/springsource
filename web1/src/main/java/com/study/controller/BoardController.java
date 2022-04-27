package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/board/*")
public class BoardController {
	
	// 앞쪽 고정 : /WEB-INF/views
	// 뒤쪽 고정 : .jsp
	
	@GetMapping("/insert")
	public void insert() {
		log.info("board insert 요청요청");
	}
	
//	@GetMapping("/modify")
//	public void modify() {
//		log.info("board modify 요청요청");
//	}
//	
//	@GetMapping("/read")
//	public void read() {
//		log.info("board read 요청요청");
//	}
	
	@GetMapping(path= {"/modify","/read"})
	public void readOrModify() {
		log.info("board read or modify 요청요청");
	}
	
	@GetMapping("/list")
	public void list() {
		log.info("board list 요청요청");
	}
	
}
