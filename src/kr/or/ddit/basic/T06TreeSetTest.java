package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class T06TreeSetTest {
	public static void main(String[] args) {
		
		// TreeSet 은 데이터 저장시에 자동정렬 기능이 들어가 있다. 
		TreeSet<String> ts = new TreeSet<String>();
		
		List<String> abcList = new ArrayList<String>();
		
		// 영어 대문자를 문자열로 변환하여 List에 저장
		for(char ch = 'A'; ch <= 'Z'; ch++) {
			String temp = String.valueOf(ch);
			abcList.add(temp);
		}
		
		Collections.shuffle(abcList);
		
		System.out.println("섞은 후  abcList : "+ abcList);
		
		for(String str : abcList) {
			ts.add(str);
		}
		
		System.out.println("TreeSet 데이터 : " + ts);
		System.out.println();
		
		for(String str : ts) {
			System.out.print(str + " ");
		}
		System.out.println();
		
		// TreeSet 에 저장된 자료중 특정한 값보다 작은 자료를 찾아서 SortedSet으로 반환해주는 메서드
		// => headSet(기준값) : 기본적으로 '기준값'은 포함시키지 않는다. 
		// => headSet(기준값, 논리값) : '논리값'이 true이면 '기준값'을 포함시킨다.
		SortedSet<String> ss1 = ts.headSet("K");
		System.out.println("K 이 전 자료 : " + ss1);
		System.out.println("K 이 전 자료(기준값 포함) : " + ts.headSet("K", true));
		
		// '기준값'보다 큰 자료를 찾아 SortedSet으로 반환해주는 메서드
		// tailSet(기준값) : 기본적으로 '기준값'을 포함시킨다.
		// tailSet(기준값, 논리값) : 논리값이 false이면 기준값을 포함시키지 않는다.
		SortedSet<String> ss2 = ts.tailSet("K");
		System.out.println("K 이 후 자료 : " + ss2);
		System.out.println("K 이 후 자료 (기준값 미 포함): "+ ts.tailSet("K", false));
		
		// subSet(기준값1, 기준값2) : 기준값1 ~ 기준값2 사이의 값을 가져온다. ('기준값1' 포함, '기준값2' 미포함)
		// subSet(기준값1, 논리값1, 기준값2, 논리값2) : 각 기준값 포함 여부를 각 논리값으로 결정한다.
		System.out.println("K(포함)부터 N(미포함)까지 : " +ts.subSet("K", "N"));
		System.out.println("K(포함)부터 N(포함)까지 : " +ts.subSet("K", true, "N", true));
		System.out.println("K(미포함)부터 N(미포함)까지 : " +ts.subSet("K", false, "N", false));
		System.out.println("K(미포함)부터 N(포함)까지 : " +ts.subSet("K", false, "N", true));
	}
}
