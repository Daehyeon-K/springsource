package com.mycompany.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mycompany.dto.ItemDTO;

public interface ItemMapper {
	public List<ItemDTO> selectAll();
	public int insert(ItemDTO dto);
	public int update(@Param("num") int num, @Param("psize") String psize, @Param("price") int price);
	public int delete(int num);
	public ItemDTO selectOne(int num);
}
