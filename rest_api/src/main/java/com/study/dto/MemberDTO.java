package com.study.dto;

import lombok.Data;

@Data

public class MemberDTO {
	private String userid;
	private String password;
	private String confirmPassword;
	private String name;
	private String gender;
	private String email;
	
}
