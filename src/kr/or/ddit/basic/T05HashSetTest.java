package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class T05HashSetTest {
	public static void main(String[] args) {
		 
		Set hs1 = new HashSet();
		
		hs1.add("DD");
		hs1.add("AA");
		hs1.add(2);
		hs1.add("CC");
		hs1.add("BB");
		hs1.add(1);
		hs1.add(3);
		
		System.out.println("Set 데이터 : " + hs1);
		System.out.println();
		// Set은 데이터 중복을 허용하지 않는다. 그래서 이미 존재하는 데이터를 또 다시 추가하면
		// false를 반환하고, 데이터는 추가되지 않는다. >> 내부적으로 중복체크가 일어난다
		
		
		boolean isAdded = hs1.add("FF");
		System.out.println("중복되지 않을 때 " + isAdded); //true 리턴 
		System.out.println("Set 데이터 : " + hs1);
		System.out.println();
		
		isAdded = hs1.add("CC");
		System.out.println("중복 될 때 : "+ isAdded);
		System.out.println("Set 데이터 : "+ hs1);
		System.out.println();
		
		// Set의 데이터를 수정하려면 수정하는 메서드가 따로 존재하지 않기 때문에 
		// 해당 데이터를 삭제 후 새로운 데이터를 추가해 주면 된다. 
		
		// 데이터 삭제하기
		// 1) clear() => 모든 데이터 삭제 
		// 2) remove(삭제할 데이터) => 해당 데이터 삭제
		
		// 'FF'를 'EE'로 수정하기
		hs1.remove("FF"); // FF를 삭제하기 
		System.out.println("FF 삭제 후 Set 데이터 : " + hs1);
		System.out.println();
		
		hs1.add("EE");
		System.out.println("EE 추가 후 Set 데이터 : " + hs1);
		System.out.println();
		
//		hs1.clear(); // 전체 데이터 삭제
//		System.out.println("clear() 후 Set 데이터 : "+ hs1);
//		
//		System.out.println("Set 의 데이터 개수 : " + hs1.size());
//		System.out.println();
		
		// Set 은 인덱스 개념이 존재하지 않기 떄문에 List 처럼 인덱스로 데이터를 하나씩 불러올 수 없다.
		// 그래서 데이터를 접근하기 위해서 Iterator 객체를 사용해야한다.
		
		Iterator it = hs1.iterator();
		//
		
		// 데이터 개수만큼 반복하기
		while(it.hasNext()){ // 다음 데이터가 있는지 확인
			System.out.println(it.next()); // 다음 데이터 가져오기 
		}
		
		// 1~100 사이의 중복되지 않는 정수 5개 만들기
		Set<Integer> intRnd = new HashSet<Integer>();
		
		while(intRnd.size() < 5) {
			int num = (int) (Math.random()*100+1); //중복된 숫자가 나오더라도 set에는 중복된 값이 들어가지 않는다
			intRnd.add(num); 
		}
		
		System.out.println("생성된 난수들 : " + intRnd);
		
		// Collection 유형의 객체들은 서로 다른 자료 구조로 쉽게 변경해서 사용할 수 있다.
		// 다른 유형의 객체를 생성할 때 생성자에 해당 데이터를 넣어주면 된다. 
		List<Integer> intRndList = new ArrayList<Integer>(intRnd);
		
		System.out.println("intRndList 데이터 출력 : ");
		
		for (Integer num : intRndList) {
			System.out.print(num + " ");
		}
		
		System.out.println();
	}
}
