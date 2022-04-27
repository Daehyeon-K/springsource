package com.mycompany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.dto.ItemDTO;
import com.mycompany.mapper.ItemMapper;

@Service("service")
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemMapper mapper;
	
	@Override
	public List<ItemDTO> selectAll() {
		return mapper.selectAll();
	}

	@Override
	public boolean insert(ItemDTO dto) {
		return mapper.insert(dto)==1?true:false;
	}

	@Override
	public boolean update(int num, String psize, int price) {
		return mapper.update(num, psize, price)==1?true:false;
	}

	@Override
	public boolean delete(int num) {
		return mapper.delete(num)==1?true:false;
	}

	@Override
	public ItemDTO selectOne(int num) {
		return mapper.selectOne(num);
	}

}
