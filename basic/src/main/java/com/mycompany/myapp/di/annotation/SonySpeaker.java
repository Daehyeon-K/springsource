package com.mycompany.myapp.di.annotation;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker {
	
	public SonySpeaker() {
		System.out.println("SonySpeaker -- 객체 생성");
	}
	@Override
	public void volumeUp() {
		System.out.println("SonySpeaker -- Volume Up");
	}
	@Override
	public void volumeDown() {
		System.out.println("SonySpeaker --  Volume Down");
	}
}
