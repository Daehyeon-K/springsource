package com.mycompany.calc;

import org.springframework.stereotype.Component;

// 재귀호출로 factorial 구현
// 재귀호출 : 메소드 안에서 자신의 메소드 다시 호출
// 			기본 단계와 재귀 단계로 나뉨

@Component("rec")
public class RecCalc implements Calc{

	@Override
	public long factorial(long num) {
		return num==0?1:num*factorial(num-1);
	}
	
//	void countdown(int i) {
//		
//		if(i>=0) {
//			// 기본단계 (없으면 무한루프 가능)
//			return;
//		}else {
//			// 재귀단계
//			countdown(i-1);
//		}
//	}

}
