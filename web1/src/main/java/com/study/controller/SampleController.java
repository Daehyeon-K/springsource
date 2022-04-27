package com.study.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.dto.UserDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/sample/*") // http://localhost:9090/sample/** 고정하고 그 뒤부터 들어오는 거 여기서 처리 하겠다는 것.
public class SampleController {
	
	// 앞쪽 고정 : /WEB-INF/views
	// 뒤쪽 고정 : .jsp
	
	
	// 컨트롤러의 리턴 타입이 void인 경우 기본 localhost:port 경로 다음 부분들이 jsp 페이지를 찾는 데 사용 됨
	
	// @RequestMapping(path = "/basic", method = RequestMethod.GET) // http://localhost:9090/sample/basic으로 들어오는 개념
	@GetMapping("/basic") // 최근 버전에선 이걸로 간단히 됨. 위랑 이거 둘 다 알고 있어야 함.
	public void basic(int page, Model model) {
		log.info("basic...."); // /WEB-INF/views/sample/basic.jsp
		
		// page 변수값을 jsp에서 보여주기
		model.addAttribute("page", page); // 하려면 인자에 Model model 만들어줘야 함. 아니면 int page 앞에 @ModelAttribute("page") 달아주기
	}
	
	// @RequestMapping("/login") : GET + POST 둘 다 허용
	// @RequestMapping(path = "/login", method = RequestMethod.GET) : GET만 허용
	// @RequestMapping(path = "/login", method = RequestMethod.POST) : POST만 허용
	// 허용 안되는 거 하면 405 뜸
	// @RequestMapping(path = "/login", method = RequestMethod.GET) // http://localhost:9090/sample/login
	@GetMapping("/login")
	public void login() {
		log.info("login...."); // /WEB-INF/views/sample/login.jsp
	}
	
	
	// Controller 파라미터 수집
	
	// <1.> 변수명 사용하기 
	
	// @RequestMapping(path = "/login", method = RequestMethod.POST) // http://localhost:9090/sample/login
//	@PostMapping("/login")
//	public void loginPost(String userid, String password, String addr, int age) {
//		log.info("login POST...."+userid+" "+password+" "+addr+" "+age); // /WEB-INF/views/sample/login.jsp
//	}
	
	// <2.> DTO 사용하기
	
//	@PostMapping("/login")
//	public void loginPost(UserDTO userDto) {
//		log.info("login POST...."+userDto.getUserid()+" "+userDto.getPassword()+" "+userDto.getAddr()+" "+userDto.getAge()); // /WEB-INF/views/sample/login.jsp
//	}
	
	// <3.> HttpServletRequest 객체 사용 (불편해서 필요한 경우 아니면 잘 사용 안함)
//	@PostMapping("/login")
//	public void loginPost(HttpServletRequest request) {
//		String userid = request.getParameter("userid");
//		String password = request.getParameter("password");
////		String addr = request.getParameter("addr");
////		int age = Integer.parseInt(request.getParameter("age"));
//		log.info("login POST...."+userid+" "+password/*+" "+addr+" "+age*/); // /WEB-INF/views/sample/login.jsp
//	}
	
	
	// @RequestMapping(path = "/doA", method = RequestMethod.GET) // http://localhost:9090/sample/doA
	@GetMapping("/doA")
	public void doA(String userid) {
		log.info("doA...."+userid); // /WEB-INF/views/sample/doA.jsp
	}
	
	
	// 컨트롤러의 리턴 타입이 String인 경우 return 값만을 가지고 jsp 페이지 찾음
	
	// @RequestParam("이름") : 파라미터로 사용된 변수의 이름과 전달되는 파라미터의 이름이 다른 경우 사용
	
	// @RequestMapping(value = "/insert", method=RequestMethod.GET) // http://localhost:9090/sample/insert (path랑 value 같은 의미. 버전 차이)
	@GetMapping("/insert")
	public String insert(@RequestParam("ids") ArrayList<String> ids) {
		log.info("insert...."+ids); // /WEB-INF/views/insert.jsp
		return "insert";
	}
}
