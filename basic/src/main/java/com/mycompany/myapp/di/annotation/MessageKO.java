package com.mycompany.myapp.di.annotation;

public class MessageKO implements Message {

	@Override
	public void sayHello(String name) {
		System.out.println("안녕하세요 "+name+"님");

	}

}
