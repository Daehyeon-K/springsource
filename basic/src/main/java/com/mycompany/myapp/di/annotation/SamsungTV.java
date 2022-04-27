package com.mycompany.myapp.di.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("samsung")

public class SamsungTV implements TV {
	
	// private SonySpeaker speaker; // 초기화(생성자, setter 메소드)
	// private AppleSpeaker speaker;
	
	@Autowired
	@Qualifier("apple")
	
	private Speaker speaker;
	
//	public SamsungTV() {
//		
//	}
//
//	public SamsungTV(Speaker speaker) {
//		super();
//		this.speaker = speaker;
//	}
//
//	// 초기화, 변경
//	public void setSpeaker(Speaker speaker) {
//		this.speaker = speaker;
//	}
	

	@Override
	public void powerOn() {
		System.out.println("SamsungTV 전원 On");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV 전원 Off");
	}

	@Override
	public void volumeUp() {
		//System.out.println("SamsungTV Volume Up");
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		//System.out.println("SamsungTV Volume Down");
		speaker.volumeDown();
	}

}
