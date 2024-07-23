package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T04ListSortTest {
	public static void main(String[] args) {
		
		List<Member> memList = new ArrayList<Member>();
		
		memList.add(new Member(1, "홍길동", "010-1111-1111"));
		memList.add(new Member(5, "변학도", "010-2222-1111"));
		memList.add(new Member(9, "성춘향", "010-3333-1111"));
		memList.add(new Member(3, "이순신", "010-4444-1111"));
		memList.add(new Member(6, "강감찬", "010-5555-1111"));
		memList.add(new Member(2, "일지매", "010-6666-1111"));
		
		System.out.println("정렬 전 : ");
		for(Member m: memList) {
			System.out.println(m);
		}
		
		System.out.println("-----------------------------------");
		Collections.sort(memList); // 정렬하기
		// 모든 리스트 타입을 정렬 할 수 있는게 아니라 , Comparable를 상속받은 형태의 list를 정렬가능함 
		System.out.println("정렬 후 : ");
		for(Member m: memList) {
			System.out.println(m);
		}
		
		System.out.println("------------------------------------");
		Collections.shuffle(memList); //회원정보 섞기
		
		System.out.println("섞은 후 : ");
		for(Member m: memList) {
			System.out.println(m);
		}
		
		System.out.println("------------------------------------");
		Collections.sort(memList, new sortNumDesc());
		
		System.out.println("회원 번호 내림차순 정렬 후 : ");
		for(Member m: memList) {
			System.out.println(m);
		}
	}
}

// 회원번호의 내림차순으로 정렬되도록 외부정렬자 클래스 구현 
class sortNumDesc implements Comparator<Member>{
	@Override
	public int compare(Member mem1, Member mem2) {
		/*
		if(mem1.getNum() > mem2.getNum()) {
			return -1;
		}else if(mem1.getNum() == mem2.getNum()) {
			return 0;
		}else {
			return 1;
		}
		*/
		
		//return new Integer(mem1.getNum()).compareTo(mem2.getNum())*-1; 
		//객체를 생성하면 객체클래스 내부의 인스턴스 호출가능
		
		return Integer.compare(mem1.getNum(), mem2.getNum());
		// 스태틱 매서드는 객체 생성 없이 사용가능 
		// Integer 클래스 내부의 정적 메소드 > compare 사용해서 정렬가능
	}
}



// 회원 이름을 기준으로 오름차순 정렬이 되도록 구현하기 
// 메서드 자체에 정렬기능을 넣고 싶으면 Comparable 사용 
class Member implements Comparable<Member>{ //Vo
	private int num;
	private String name;
	private String tel;
	
	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}

	@Override
	public int compareTo(Member mem) {
		return this.getName().compareTo(mem.getName());
	}
}