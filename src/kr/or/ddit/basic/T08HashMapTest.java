package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class T08HashMapTest {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		
		//데이터 추가하기 
		map.put("name", "홍길동");
		map.put("addr", "대전");
		map.put("tel", "010-1234-1234");
		
		System.out.println("map => "+map);
		
		//데이터 수정하기 
		// => 데이터를 저장할 때 key 값이 같으면 나중에 입력한 값이 저장된다.
		map.put("addr", "서울");
		System.out.println("map => "+map);
		
		//데이터 삭제하기
		map.remove("name");
		System.out.println("map => "+map);
		
		//데이터 읽어오기
		System.out.println("addr = "+ map.get("addr"));
		System.out.println("===============================================");
		
		//key 값들을 읽어와 데이터를 가져오는 방법
		
		// 방법 1 => keySet() 메서드 이용하기
		Set<String> keySet = map.keySet();
		
		System.out.println("Iterator를 이용하는 방법 ");
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key+" : "+map.get(key));
		}
		System.out.println("---------------------------------------");
		
		// 방법 2 => Set형의 데이터를 '향상된 for문(forEach문)'으로 처리하려면 Iterator를 사용하지 않아도 된다.
		System.out.println("향상된 for문(forEach문)을 이용한 방법");
		for(String key : keySet) {
			System.out.println(key + " : " + map.get(key));
		}
		System.out.println("-----------------------------------------------------");
		
		// 방법 3 => value 값만 읽어와 가져오기 
		System.out.println("values() 메서드 이용한 방법");
		for(String value : map.values()) {
			System.out.println(value);
		}
		System.out.println("-----------------------------------------------------");
		
		// 방법 4 => Entry 객체를 가져와 처리하는 방법
		System.out.println("entrySet()을 이용한 방법");
		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		
		Iterator<Map.Entry<String, String>> entryIt = entrySet.iterator();
		
		while(entryIt.hasNext()) {
			Map.Entry<String, String> entry = entryIt.next();
			System.out.println("key 값: "+ entry.getKey());
			System.out.println("value 값: "+ entry.getValue());
			System.out.println();
		}
	}
}
