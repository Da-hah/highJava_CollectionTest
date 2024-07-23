package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T01ArrayListTest {
	public static void main(String[] args) {

		// Default Capacity = 10
		List list1 = new ArrayList();

		// add() 메서드를 이용하여 데이터를 추가한다
		list1.add("aaa");
		list1.add("bbb");
		list1.add(111);
		// list1.add(new Integer(111)); //원래는 이렇게 써야하는걸 간략하게 작성 가능하다.
		list1.add('k');
		list1.add(true);
		list1.add(12.34);

		// size() = > 데이터 개수

		System.out.println("size =>" + list1.size());
		System.out.println("list1 =>" + list1);

		// get()이용하여 데이터 가져오기
		System.out.println("1번째 자료 : " + list1.get(0));

		// 데이터 끼워넣기
		list1.add(0, "zzz"); // 인덱스 값을 지정해주면 특정한 위치에 넣어준다.
		System.out.println("zzz 추가후 ... list1 => " + list1);

		// 데이터 변경하기
		String temp = (String) list1.set(0, "yyy"); // 바꾸기 전의 값을 리턴해준다. : "zzz"
		System.out.println("temp =>" + temp);
		System.out.println("list1 => " + list1);

		// 데이터 삭제하기
		list1.remove(0);
		System.out.println("첫번째 데이터 삭제후 =>" + list1);

		list1.remove("bbb");
		System.out.println("bbb 삭제후 =>" + list1);
		System.out.println("=====================================");

//		list1.remove(1); //인덱스 위치를 지정해 지우기 
//		list1.remove(111); //>> IndexOutOfBoundsException 발생  
		list1.remove(new Integer(111));
		System.out.println("111 삭제후 list1" + list1);
		System.out.println("=====================================");
		
		//제너릭 이용하여 선언하기
		List<String > list2 = new ArrayList<String>();
		list2.add("AAA");
		list2.add("BBB");
		list2.add("CCC");
		list2.add("DDD");
		list2.add("EEE");
//		list2.add(1111); <String> 으로 선언했기 때문에 문자열 값만 들어갈 수 있다. 
		
		// contains(비교객체) => 리스트에 '비교객체'가 있으면 true, 없으면 false 반환됨
		System.out.println(list2.contains("DDD"));
		System.out.println(list2.contains("ZZZ"));
		
		//indexOf(비교객체) => 리스트 에서 '비교객체' 가 존재하는 index정보를 반환한다, 존재하지 않으면 -1 반환됨
		System.out.println("DDD의 index값 : "+ list2.indexOf("DDD"));
		System.out.println("ZZZ의 index값 : "+ list2.indexOf("ZZZ"));
		System.out.println("--------------------------------------------");
		
		//ArrayList 삭제 처리에 대하여
		for(int i = 0; i < list2.size(); i++) {
			list2.remove(i);
		}
		System.out.println("삭제처리 후 list2 =>"+list2); //[BBB, DDD] 앞의 값이 지워진 후 인덱스를 땡겨 채우기 때문에 다 지워지지 않는다. 
		
	}

}
