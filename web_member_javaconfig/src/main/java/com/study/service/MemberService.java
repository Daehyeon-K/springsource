package com.study.service;

import com.study.dto.AuthDTO;
import com.study.dto.ChangeDTO;
import com.study.dto.MemberDTO;

public interface MemberService {
	// 회원가입
	public boolean register(MemberDTO register);
	
	// 로그인
	public AuthDTO login(String userid, String password);
	
	// 비밀번호 변경
	public boolean update(ChangeDTO changeDto);
	
	// 탈퇴
	public boolean delete(String userid, String current_password);
	
	// 아이디 중복
	public String dupId(String userid);
}
