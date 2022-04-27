package com.mycompany.service;

import java.util.List;

import com.mycompany.dto.ItemDTO;

public interface ItemService {
	public List<ItemDTO> selectAll();
	public boolean insert(ItemDTO dto);
	public boolean update(int num, String psize, int price);
	public boolean delete(int num);
	public ItemDTO selectOne(int num);
}
