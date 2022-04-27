package com.mycompany.myapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mycompany.dto.ItemDTO;
import com.mycompany.service.ItemService;

import java.util.List;
import java.util.Scanner;

public class ItemApp {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		ItemService service = (ItemService) ctx.getBean("service");
		
		boolean flag = true;
		
		Scanner sc = new Scanner(System.in);
		
		while(flag) {
			System.out.println("--------------------------------");
			System.out.println("1. 아이템 추가");
			System.out.println("2. 아이템 조회");
			System.out.println("3. 아이템 삭제");
			System.out.println("4. 아이템 수정");
			System.out.println("5. 아이템 전체 조회");
			System.out.println("6. 종료");
			System.out.println("--------------------------------");
			
			int no = Integer.parseInt(sc.nextLine());
			
			switch (no) {
			case 1:
				ItemDTO insertDto = new ItemDTO();
				System.out.println("--------------------------------");
				System.out.println("<<1. 아이템 추가>>");
				System.out.println("CATEGORY");
				System.out.print(">> ");
				insertDto.setCategory(sc.nextLine());
				System.out.println("NAME");
				System.out.print(">> ");
				insertDto.setName(sc.nextLine());
				System.out.println("CONTENT");
				System.out.print(">> ");
				insertDto.setContent(sc.nextLine());
				System.out.println("SIZE");
				System.out.print(">> ");
				insertDto.setPsize(sc.nextLine());
				System.out.println("PRICE");
				System.out.print(">> ");
				insertDto.setPrice(Integer.parseInt(sc.nextLine()));
				System.out.println(service.insert(insertDto)?"<<삽입성공>>":"<<삽입실패>>");
				System.out.println("--------------------------------");
				break;
			case 2:
				System.out.println("--------------------------------");
				System.out.println("<<2. 아이템 조회>>");
				System.out.println("NUM");
				System.out.print(">> ");
				int searchNum = Integer.parseInt(sc.nextLine());
				ItemDTO item = service.selectOne(searchNum);
				System.out.println(item);
				System.out.println("--------------------------------");
				break;
			case 3:
				System.out.println("--------------------------------");
				System.out.println("<<3. 아이템 삭제>>");
				System.out.println("NUM");
				System.out.print(">> ");
				int deleteNum = Integer.parseInt(sc.nextLine());
				System.out.println(service.delete(deleteNum)?"<<삭제성공>>":"<<삭제실패>>");
				System.out.println("--------------------------------");
				break;
			case 4:
				System.out.println("--------------------------------");
				System.out.println("<<4. 아이템 수정>>");
				System.out.println("NUM");
				System.out.print(">> ");
				int updateNum = Integer.parseInt(sc.nextLine());
				System.out.println("SIZE");
				System.out.print(">> ");
				String psize = sc.nextLine();
				System.out.println("PRICE");
				System.out.print(">> ");
				int price = Integer.parseInt(sc.nextLine());
				System.out.println(service.update(updateNum, psize, price)?"<<수정성공>>":"<<수정실패>>");
				System.out.println("--------------------------------");
				break;
			case 5:
				System.out.println("--------------------------------");
				System.out.println("<<5. 아이템 전체 조회>>");
				List<ItemDTO> list = service.selectAll();
				for (ItemDTO dto : list) {
					System.out.println(dto);
				}
				System.out.println("--------------------------------");
				break;
			case 6:
				System.out.println("--------------------------------");
				System.out.println("<<6. 종료>>");
				System.out.println("<<시스템을 종료합니다.>>");
				System.out.println("--------------------------------");
				flag=false;
				break;
			default:
				System.out.println("<<잘못된 입력입니다. 입력을 확인해 주세요.>>");
				break;
			
			}
		}

	}
}
