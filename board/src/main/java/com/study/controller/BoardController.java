package com.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.dto.BoardDTO;
import com.study.dto.Criteria;
import com.study.dto.PageDTO;
import com.study.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	// /board/list
	@GetMapping("/list")
	public void list(Model model,@ModelAttribute("cri") Criteria cri) {
		log.info("전체 리스트 요청");
		List<BoardDTO> list = service.getList(cri);
		
		// 전체 게시물 개수
		int total = service.getTotalCnt(cri);
		
		model.addAttribute("pageDto", new PageDTO(cri, total));
		model.addAttribute("list", list);
	}
	
	// /board/register 컨트롤러 작성
	@GetMapping("/register")
	public void register() {
		log.info("register 요청");
	}
	
	// post
	@PostMapping("/register")
	public String registerPost(BoardDTO insertDto, Criteria cri, RedirectAttributes rttr) {
		log.info("register "+insertDto);
		log.info("register -cri "+cri);
		if(service.insert(insertDto)){ //===
			log.info("등록 성공");
			rttr.addAttribute("pageNum", cri.getPageNum());
			rttr.addAttribute("amount", cri.getAmount());
			rttr.addAttribute("type", cri.getType());
			rttr.addAttribute("keyword", cri.getKeyword());
			rttr.addFlashAttribute("result", insertDto.getBno());
			return "redirect:/board/list";
		}
		log.info("등록 실패");
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		return "redirect:/board/register";
	}
	
	// /board/read + bno
	// bno에 해당하는 게시물 읽어온 후 read.jsp 보여주기
	@GetMapping({"/read", "/modify"})
	public void readGet(int bno, @ModelAttribute("cri") Criteria cri, Model model) {
		log.info("게시물 요청 "+bno);
		log.info("게시물 요청 "+cri);
		
		BoardDTO dto = service.getRow(bno);
		model.addAttribute("dto", dto);
	}
	
	// 수정 성공 시 수정된 게시물 보여주기 수정내용 /board/read로 넘기기 post해서
	@PostMapping("/modify")
	public String modify(BoardDTO dto, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("수정 요청 "+dto);
		log.info("수정 요청 -cri "+cri);
		
		if(service.update(dto)) {
			log.info("수정 성공");
			rttr.addAttribute("bno", dto.getBno());
			rttr.addAttribute("pageNum", cri.getPageNum());
			rttr.addAttribute("amount", cri.getAmount());
			rttr.addAttribute("type", cri.getType());
			rttr.addAttribute("keyword", cri.getKeyword());
			return "redirect:/board/read";
		}
		
		log.info("수정 실패");
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		return "/board/modify";
	}
	
	// /board/remove + bno
	// 성공시 list 보여주기
	@GetMapping("/remove")
	public String delete(int bno, Criteria cri, RedirectAttributes rttr) {
		log.info("게시물 삭제 요청 "+bno);
		log.info("게시물 삭제 요청 -cri "+cri);
		if(service.delete(bno)) {
			log.info("삭제 성공");
			rttr.addAttribute("pageNum", cri.getPageNum());
			rttr.addAttribute("amount", cri.getAmount());
			rttr.addAttribute("type", cri.getType());
			rttr.addAttribute("keyword", cri.getKeyword());
			rttr.addFlashAttribute("result", "success");
			return "redirect:/board/list";
		}
		log.info("삭제 실패");
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		return "/board/modify";
	}
	
	
}
