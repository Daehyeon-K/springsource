package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.dto.NumDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/calc")
public class AddController {
	
	@GetMapping("/add")
	public void addGet() {
		log.info("add.jsp 페이지 요청요청....");
	}
	
//	@PostMapping("/add")
//	public void addPost(@RequestParam("num1") int op1, @RequestParam("num2") int op2) { // 이거 이름을 op1 op2 등 jsp의 name/id와 다르면 에러남
//											  // => @RequestParam("이름")으로 해결
//		log.info("덧셈 요청요청....");
//		log.info("num1 + num2 ="+(num1+num2));
//	}
	
//	@PostMapping("/add")
//	// 필수 해제하고 기본값 줘서 공란 500에러 막기
//	public void addPost(@RequestParam(value = "num1", required=false, defaultValue="0") int num1, @RequestParam(value="num2", required=false, defaultValue="0") int num2) {
//		log.info("덧셈 요청요청....");
//		log.info("num1 + num2 ="+(num1+num2));
//		
//		// 어느 jsp 갈 것인가?
//	}
	
	@PostMapping("/add")
	// @ModelAttribute("이름")=> 이름 지정 => 바인딩 객체의 이름 변경, 혹은 Model 객체에 값을 담는 것과 같은 기능 제공
	public void addPost(@ModelAttribute("dto") NumDTO dto, Model model) { // 객체 사용하면 jsp에서 불러서 쓰기까지 가능. 변수로는 그렇게 안됨
		log.info("덧셈 요청요청....");
		log.info("num1 + num2 ="+(dto.getNum1()+dto.getNum2()));
		
		int result = dto.getNum1()+dto.getNum2();
		// result 값을 add.jsp에서 보여주기 : Model 객체(request.setAttribute()와 같은 개념) => 위 인자나 여기나 모델에 담아주는 개념
		model.addAttribute("result", result);
		
	}
	
}
