package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Set;

public class T07EqualsHashCodeTest {
/*
 		해시함수(Hash function)는 임의의 길이의 데이터를 고정된 길이의 데이터로 매핑해주는 함수이다.
 		해시함수에 의해 얻어지는 값은 해시값, 해시코드 등으로 부른다. 
 		
 		HshSet, HashMap, Hashtable과 같은 객체들을 사용할 경우
 		추가하는 객체가 서로 같은지를 비교하기 위해 equals()와 hashCode()를 사용한다. 
 		그래서 객체가 서로 같은지 여부를 결정하려면 두 메서드를 적절하게 재정의 해주어야한다.
 		
 		 - equals() : 두 객체의 내용(값)이 같은지 비교하는 메서드
 		 - hashCode() : 객체에 대한 해시코드값을 반환하는 메서드 => 해시테이블 생성시 사용됨 
 		 
 		 - equals() 메서드와 hashCode() 메서드 작성에 관련된 규칙(Convention)
 		 1. 두 객체가 같으면 반드시 같은 hashCode를 가져야한다.
 		 2. 두 객체가 같으면 equals()를 호출했을 때 true를 반환해야한다.
 		 	즉, 객체 a, b가 같다면 a.equals(b)와 b.equals(a) 둘 다 true이어야 한다.
 		 3. 두 객체의 hashCode()가 같다고 해서 두 객체가 반드시 같은 객체는 아니다.
 		 	하지만, 두 객체가 같으면 반드시 hashCode()가 같아야한다.
 		 4. equals()를 재정의(override)해야 한다면 반드시 hashCode()도 재정의 해주어야 한다.
 		 5. hashCode()는 기본적으로 Heap 메모리에 있는 각 객체에 대한 메모리 주소값을 기반으로 한 정수값을 반환한다.
 		 	그러므로 클래스에서 hashCode()메서드를 재정의 하지 않으면 절대로 두 객체가 같은 것으로 간주될 수 없다. 
 */
	public static void main(String[] args) {
		String str1 = "Aa";
		String str2 = "BB";
		
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		
		//System.out.println(str1.equals(str1)); //두 객체가 같은 객체면 true 반환
		
		Person p1 = new Person(1, "홍길동");
		Person p2 = new Person(1, "홍길동");
		Person p3 = new Person(1, "이순신");
		
		System.out.println("p1 == p2 : " + (p1 == p2)); // 주소값 비교
		System.out.println("p1.equals(p2) : "+ (p1.equals(p2))); // 두 객체가 같은 의미인지 비교할 때 사용하지만 따로 재정의를 하지 않으면 주소값 비교
		System.out.println();
		
		Set<Person> pSet = new HashSet<Person>();
		
		boolean isAdded = pSet.add(p1);
		System.out.println("p1 추가 : " + isAdded);
		
		isAdded = pSet.add(p2);
		System.out.println("p2 추가 : " + isAdded);

		isAdded = pSet.add(p3);
		System.out.println("p3 추가 : " + isAdded);
		System.out.println();
		
		System.out.println("pSet 데이터 : "+ pSet);
		
		// Person 클래스에서 hashCode를 재정의 하지 않았다면 중복값을 체크하지 못하고 모두 true, 값이 들어간다.
	}
}


class Person{
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
//	@Override
//	public boolean equals(Object obj) { // equals 재정의 >> id, name이 모두 같으면 true 반환
//		
//		Person p = (Person)obj;
//		
//		return (this.getId() == p.getId()) && this.getName().equals(p.getName());
//	}
	
	
}