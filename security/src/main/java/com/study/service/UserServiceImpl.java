package com.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.dto.SpUser;
import com.study.dto.SpUserAuthority;
import com.study.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;
	
	@Autowired
	private BCryptPasswordEncoder encoder; // 암호화 위해 사용하는 클래스
	
	@Transactional
	@Override
	public boolean register(SpUser user) {
		// 사용자가 입력한 비밀번호 암호화
		user.setPassword(encoder.encode(user.getPassword())); // 단방향 암호화
		
		// 회원가입
		boolean result = mapper.register(user)==1;
		
		// 권한부여
		SpUserAuthority auth = new SpUserAuthority(user.getUserid(),"ROLE_USER");
		mapper.registerAuth(auth);
		
		auth = new SpUserAuthority(user.getUserid(),"ROLE_ADMIN");
		mapper.registerAuth(auth);
		
		return result;
	}

}
