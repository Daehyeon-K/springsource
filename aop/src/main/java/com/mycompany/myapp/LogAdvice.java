package com.mycompany.myapp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component("log")
public class LogAdvice {
	
//	@Before(value="execution(* com.mycompany.myapp.Product.getInfo())")
//	public void beforeLog() {
//		System.out.println("[공통로그] 비즈니스 로직 수행 전 호출");
//	}
	
//	@After(value="execution(* com.mycompany.myapp.Product.getInfo())")
//	public void afterLog() {
//		System.out.println("[공통로그] 익셉션 여부 관계 없이 비즈니스 로직 수행 후 호출");
//	}
	
//	@AfterReturning(value="execution(* com.mycompany.myapp.Product.getInfo())")
//	public void afterReturnLog() {
//		System.out.println("[공통로그] 비즈니스 로직 익셉션 없이 수행 후 호출");
//	}
	
//	@AfterThrowing(value="execution(* com.mycompany.myapp.Product.getInfo())")
//	public void afterThrowLog() {
//		System.out.println("[공통로그] 비즈니스 로직 수행 중 익셉션 발생 후 호출");
//	}
	
	@Around(value="execution(* com.mycompany.myapp.Product.getInfo())")
	public void aroundLog(ProceedingJoinPoint pjp) {
		System.out.println("[공통로그] 비즈니스 로직 수행 전, 전 호출");
		
		try {
			// 비즈니스 메소드 호출
			pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		System.out.println("[공통로그] 비즈니스 로직 수행 전, 후 호출");
	}
}
