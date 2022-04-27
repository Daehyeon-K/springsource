package com.mycompany.myapp.di.annotation;

public class MessageEN implements Message {

	@Override
	public void sayHello(String name) {
		System.out.println("Hello "+name+"!!");

	}

}
