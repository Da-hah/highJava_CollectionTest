package kr.or.ddit.basic;

import java.util.LinkedList;

public class T02LinkedListTest {
	public static void main(String[] args) {
		/*
		 * Stack => 후입선출(LIFO)의 자료구조
		 * Queue => 선입선출(FIFO)의 자료구조
		 */
		LinkedList<String> stack = new LinkedList<String>();
		
		/*
		 * Stack 방식으로 처리하기 위한 매서드
		 * 1) 데이터 추가 : push(저장할값)
		 * 2) 데이터 꺼내기 : pop() => 데이터를 꺼내온 후 해당 데이터를 삭제한다.
		 */
		stack.push("홍길동");
		stack.push("일지매");
		stack.push("변학도");
		stack.push("강감찬");
		
		System.out.println("현재 stack 값들 : "+ stack);
		
		String data = stack.pop();
		System.out.println("꺼내온 데이터 : "+ data);
		System.out.println("꺼내온 데이터 : "+ stack.pop());
		System.out.println("현재 stack 값들 : "+ stack);
		
		stack.push("성춘향");
		System.out.println("현재 stack값들 : "+ stack);
		System.out.println("꺼내온 데이터 : "+ stack.pop());
		
		System.out.println("======================================");
		System.out.println();
		
		LinkedList<String> queue = new LinkedList<String>();
		
		/*
		 		Queue 방식으로 동작하게 하기 위한 메서드
		 		1) 데이터 추가 : offer(저장할값)
		 		2) 데이터 꺼내기 : poll => 데이터를 꺼내온 후 데이터는 삭제된다.
		 		
		 */
		queue.offer("홍길동");
		queue.offer("일지매");
		queue.offer("변학도");
		queue.offer("강감찬");
		
		System.out.println("현재 queue 값들 : "+ queue);
		
		String temp = queue.poll();
		System.out.println("꺼내온 데이터 : " + temp);
		System.out.println("꺼내온 데이터 : " + queue.poll());
		System.out.println("현재 queue 값들 : " + queue);
		
		if(queue.offer("성춘향")) {
			System.out.println("신규등록 데이터 : 성춘향");
		}
		System.out.println("현재 queue 값들 : "+ queue);
		System.out.println("꺼내온 데이터 : "+ queue.poll());
	}
}
