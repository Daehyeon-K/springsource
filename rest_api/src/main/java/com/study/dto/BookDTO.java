package com.study.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// spring이 관리하지 않음

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class BookDTO {
	private int code, price;
	private String title, writer;	
}
