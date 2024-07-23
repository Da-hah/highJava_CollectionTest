package kr.or.ddit.basic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class T10PropertiesTest {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		/*
	 		Properties 는 Map보다 축소된 기능의 객체라고 할 수 있다.
	 		Map은 모든 타입의 객체를 key와 value로 사용할 수 있지만, 
	 		properties객체는 key와 value값으로 String 만 사용할 수 있다.
		 */
		Properties prop = new Properties();
		
		prop.setProperty("name", "홍길동");
		prop.setProperty("tel", "010-1234-1234");
		prop.setProperty("addr", "대전");
		
		String name = prop.getProperty("name");
		String tel = prop.getProperty("tel");
		
		System.out.println("이름 : "+ name);
		System.out.println("전화 : "+ tel);
		System.out.println("주소 : " +  prop.getProperty("addr"));
		
		// 데이터를 파일로 저장하기 
		//prop.store(new FileOutputStream("./src/kr/or/ddit/basic/test.properties"), "코멘트(comment)입니다.");
		
		//파일로부터 데이터 읽어오기
		prop.load(new FileReader("./src/kr/or/ddit/basic/test.properties"));
		
		System.out.println("읽어온 데이터... ");
		System.out.println("friut => " + prop.getProperty("friut"));
	}
}
