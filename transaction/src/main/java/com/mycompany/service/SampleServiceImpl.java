package com.mycompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.mapper.SampleMapper1;
import com.mycompany.mapper.SampleMapper2;

@Service("service")
public class SampleServiceImpl implements SampleService {
	
	@Autowired
	private SampleMapper1 mapper1;
	
	@Autowired
	private SampleMapper2 mapper2;
	
	@Transactional
	@Override
	public void addData(String data) {
		// 아래 두 개를 transaction 처리
		mapper1.insertCol1(data);
		mapper2.insertCol2(data);
	}

}
