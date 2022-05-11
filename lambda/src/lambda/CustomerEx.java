package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CustomerEx {
	public static void main(String[] args) {
		List<Customer> customerList = new ArrayList<Customer>();
		customerList.add(new Customer(("이순신"),40,100));
		customerList.add(new Customer(("김유신"),20,100));
		customerList.add(new Customer(("홍길동"),13,50));
		customerList.add(new Customer(("성춘향"),18,70));
		
		// 고객 명단 출력
		customerList.stream().map(s -> s.getName()).forEach(s -> System.out.println(s)); 
		
		// 총 여행 경비 계산
		long total = customerList.stream().mapToInt(s -> s.getPrice()).sum();
		System.out.println("총 여행 경비 : "+total);
		
		// 고객 중 20세 이상인 사람의 이름 정렬해 출력
		System.out.println("<<고객 중 20세 이상인 사람>>");
		customerList.stream().filter(c -> c.getAge() >= 20).map(c -> c.getName()).sorted().forEach(c -> System.out.println(c));
		
		

	}
}
