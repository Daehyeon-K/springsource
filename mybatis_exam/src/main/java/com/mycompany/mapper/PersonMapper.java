package com.mycompany.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.mycompany.dto.PersonDTO;

public interface PersonMapper {
	// #{id},#{name} ==> ? 으로 변경됨
	// "insert into person(id, name) values(?,?)"
//	@Insert("insert into person(id, name) values(#{id},#{name})")
//	public int insertPerson(@Param("id") String id, @Param("name") String name);
	// 근데 이건 복잡한 sql 구문에선 사용이 어려움
	
	// 이래두고 config.xml에서 sql 작성해주기 경로 맞춰가며 리소스 폴더에 mapper 경로와 일치하게 폴더 만들고 거기에 매퍼 파일명과 똑같이 xml 만들기 (Mybatisxml 만들면 됨)
	public int insert(@Param("id") String id, @Param("name") String name);
	public int update(@Param("id") String id, @Param("name") String name);
	public int delete(@Param("id") String id);
	public PersonDTO select(@Param("id") String id);

}
