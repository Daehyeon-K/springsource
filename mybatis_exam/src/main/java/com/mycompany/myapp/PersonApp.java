package com.mycompany.myapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mycompany.service.PersonService;

// org.apache.ibatis.binding.BindingException
// :Parameter 'id' not found. Available parameters are [arg1, arg0, param1, param2]
// 바인딩 : sql문에서 ? 로 해놓고 뒤에 연결하는 것

public class PersonApp {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		PersonService service = (PersonService) ctx.getBean("person");
		// 삽입
//		System.out.println(service.insertPerson("kang456", "강민섭"));
		
		// 출력
//		System.out.println(service.selectPerson("kang456"));

		// 수정
//		System.out.println(service.updatePerson("hong123", "홍동길길이")?"수정성공":"수정실패");
//		System.out.println(service.selectPerson("hong123"));
		// 삭제
//		System.out.println(service.deletePerson("hong123")?"삭제성공":"삭제실패");
//		System.out.println(service.selectPerson("hong123"));
	}
}
