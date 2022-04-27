package com.study.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.study.dto.UserDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {
	
	// @RequestMapping(path = "/login", method = RequestMethod.GET) // http://localhost:9090/login
		@GetMapping("/login")
		public String login() {
			log.info("login...."); // /WEB-INF/views/sample/login.jsp
			return "sample/login";
		}
		
		// Controller 파라미터 수집
		
		// <1.> 변수명 사용하기 
		
		// @RequestMapping(path = "/login", method = RequestMethod.POST) // http://localhost:9090/login
//		@PostMapping("/login")
//		public void loginPost(String userid, String password, String addr, int age) {
//			log.info("login POST...."+userid+" "+password+" "+addr+" "+age); // /WEB-INF/views/sample/login.jsp
//		}
		
		// <2.> DTO 사용하기
		
		@PostMapping("/login")
		public String loginPost(@ModelAttribute("user") UserDTO userDto) {
			log.info("login POST...."+userDto.getUserid()+" "+userDto.getPassword()/*+" "+userDto.getAddr()+" "+userDto.getAge()*/); // /WEB-INF/views/sample/login.jsp

			return "sample/logout";
			
//			return "home"; // forward
//			return "redirect:~~"; // sendRedirect
//			return "redirect:/"; // 가야 할 경로 지정
		}
		
		// <3.> HttpServletRequest 객체 사용 (불편해서 필요한 경우 아니면 잘 사용 안함)
//		@PostMapping("/login")
//		public void loginPost(HttpServletRequest request) {
//			String userid = request.getParameter("userid");
//			String password = request.getParameter("password");
//			String addr = request.getParameter("addr");
//			int age = Integer.parseInt(request.getParameter("userid"));
//			log.info("login POST...."+userid+" "+password+" "+addr+" "+age); // /WEB-INF/views/sample/login.jsp
//		}
}
