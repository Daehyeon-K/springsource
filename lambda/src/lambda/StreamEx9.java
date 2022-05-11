package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* 스트림 최종 연산
 * forEach()
 * collect() : 요소 그룹화, 분할한 결과를 컬렉션에 담아 변환하는 데 사용
 * count()
 * sum()
 * average()
 * max()
 * min()
 * findFirst()
 */

public class StreamEx9 {
	public static void main(String[] args) {
		List<Student> stuList = new ArrayList<Student>();
		stuList.add(new Student("홍길동", 70));
		stuList.add(new Student("송강", 75));
		stuList.add(new Student("을지문덕", 88));
		stuList.add(new Student("송석영", 90));
		stuList.add(new Student("척준경", 98));
		
		// 기존 방식
		List<Integer> stuNum = new ArrayList<Integer>();
		for(Student stu:stuList) {
			stuNum.add(stu.getJumsu());
		}
		
		// 스트림 - 학생들 점수만 모아서 새로운 리스트로 생성
		//Stream<Student> stream = stuList.stream();
		List<Integer> jumsu = stuList.stream().map(s -> s.getJumsu()).collect(Collectors.toList());
		

	}
}
