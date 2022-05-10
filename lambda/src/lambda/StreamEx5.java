package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamEx5 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("바둑","바나나","포도","딸기","바질","강아지");
		
		// '바'로 시작하는 단어만 출력 - 기존
		for(String s:list) {
			if(s.startsWith("바")) {
				System.out.println(s);
			}
		}
		
		// stream 이용
		// list.stream().filter(s -> s.startsWith("바")).forEach(s -> System.out.println(s));
		list.stream().filter(s -> s.startsWith("바")).forEach(System.out::println);
		
		
		
		List<Student> stuList = new ArrayList<Student>();
		stuList.add(new Student("홍길동", 70));
		stuList.add(new Student("송강", 75));
		stuList.add(new Student("을지문덕", 88));
		stuList.add(new Student("송석영", 90));
		stuList.add(new Student("척준경", 98));
		
		// 송으로 시작하는 학생 이름 출력 - 기존
		for(Student s:stuList) {
			if(s.getName().startsWith("송")) {
				System.out.println(s.getName());
			}
		}
		
		// stream 이용
		//stuList.stream().filter(s -> s.getName().startsWith("송")).forEach(s -> System.out.println(s.getName())); // 그리고 스트림은 두번은 못써서 막아줘야 아래거 확인 가능
		//stuList.stream().map(s -> s.getName()).filter(s -> s.startsWith("송")).forEach(s -> System.out.println(s));
		
		// stream으로 점수 모아서 80점 이상만 출력
		stuList.stream().map(s -> s.getJumsu()).filter(s -> s>=80).forEach(s -> System.out.println(s));
	}
}
