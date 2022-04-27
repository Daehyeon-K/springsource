package com.study.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.dto.RegisterDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "home"; // 컨트롤러에서 스트링 값만 남으면 리턴 값 만으로 jsp 페이지 찾음
					   // => /WEB-INF/views/home.jsp
	}
	
	// redirect 방식으로 움직일 때 값을 전송하는 방법
	// 1. RedirectAttibutes의 addAttribute( , ) 사용. 주소줄에 첫 인자 이름으로 둘째 인자 값 보내는 방식
	//    http://~~~~~~~~~~?age=10 처럼 들어감
	//    path += "?page="+page+.... 이거랑 같은 개념임
	// 2. RedirectAttibutes의 addFlashAttribute( , ) 사용. 주소줄에 딸려가지 않음
	//    세션 객체(일회성)에 담는 방식
	
	@GetMapping("/doB")
	public String doB(RedirectAttributes rttr) {
		rttr.addAttribute("age", 10);
		rttr.addAttribute("addr", "서울");
		rttr.addAttribute("name", "홍길동");
		
		rttr.addFlashAttribute("num", "15");
		return "redirect:/";
	}
	
	// 예전 방식
	@GetMapping("/doC")
	public ModelAndView doC() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		mav.addObject("num", 35); // request.setAttribute()와 같은 개념
		return mav;
	}
	
//	@GetMapping("doD")
//	public RegisterDTO regist() {
//		return new RegisterDTO();
//	}
}
