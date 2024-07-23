package kr.or.ddit.basic.homework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Hotel {
/*
 * 문제)

		호텔 운영을 관리하는 프로그램 작성.(Map이용)
		 - 키값은 방번호 
		 
		실행 예시)
		
		**************************
		호텔 문을 열었습니다.
		**************************
		
		*******************************************
		어떤 업무를 하시겠습니까?
		1.체크인  2.체크아웃 3.객실상태 4.업무종료
		*******************************************
		메뉴선택 => 1 <-- 입력
		
		어느방에 체크인 하시겠습니까?
		방번호 입력 => 101 <-- 입력
		
		누구를 체크인 하시겠습니까?
		이름 입력 => 홍길동 <-- 입력
		체크인 되었습니다.
		
		*******************************************
		어떤 업무를 하시겠습니까?
		1.체크인  2.체크아웃 3.객실상태 4.업무종료
		*******************************************
		메뉴선택 => 1 <-- 입력
		
		어느방에 체크인 하시겠습니까?
		방번호 입력 => 102 <-- 입력
		
		누구를 체크인 하시겠습니까?
		이름 입력 => 성춘향 <-- 입력
		체크인 되었습니다
		
		*******************************************
		어떤 업무를 하시겠습니까?
		1.체크인  2.체크아웃 3.객실상태 4.업무종료
		*******************************************
		메뉴선택 => 3 <-- 입력
		
		방번호 : 102, 투숙객 : 성춘향
		방번호 : 101, 투숙객 : 홍길동
		
		*******************************************
		어떤 업무를 하시겠습니까?
		1.체크인  2.체크아웃 3.객실상태 4.업무종료
		*******************************************
		메뉴선택 => 2 <-- 입력
		
		어느방을 체크아웃 하시겠습니까?
		방번호 입력 => 101 <-- 입력
		체크아웃 되었습니다.
		
		*******************************************
		어떤 업무를 하시겠습니까?
		1.체크인  2.체크아웃 3.객실상태 4.업무종료
		*******************************************
		메뉴선택 => 1 <-- 입력
		
		어느방에 체크인 하시겠습니까?
		방번호 입력 => 102 <-- 입력
		
		누구를 체크인 하시겠습니까?
		이름 입력 => 허준 <-- 입력
		102방에는 이미 사람이 있습니다.
		
		*******************************************
		어떤 업무를 하시겠습니까?
		1.체크인  2.체크아웃 3.객실상태 4.업무종료
		*******************************************
		메뉴선택 => 2 <-- 입력
		
		어느방을 체크아웃 하시겠습니까?
		방번호 입력 => 101 <-- 입력
		101방에는 체크인한 사람이 없습니다.
		
		*******************************************
		어떤 업무를 하시겠습니까?
		1.체크인  2.체크아웃 3.객실상태 4.업무종료
		*******************************************
		메뉴선택 => 3 <-- 입력
		
		방번호 : 102, 투숙객 : 성춘향
		
		*******************************************
		어떤 업무를 하시겠습니까?
		1.체크인  2.체크아웃 3.객실상태 4.업무종료
		*******************************************
		메뉴선택 => 4 <-- 입력
		
		**************************
		호텔 문을 닫았습니다.
		**************************
 */
	Scanner sc = new Scanner(System.in);
	private Map<String, HotelVo> hotelMap = new HashMap<String, HotelVo>(); 
	
	public static void main(String[] args) {
		Hotel hotel = new Hotel();
		hotel.start();
	}
	
	public void start() {
		/*
		 * 
		**************************
		호텔 문을 열었습니다.
		**************************
		
		*******************************************
		어떤 업무를 하시겠습니까?
		1.체크인  2.체크아웃 3.객실상태 4.업무종료
		*******************************************
		 */
		
		System.out.println("**************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("**************************");
		
		while(true) {
			System.out.println();
			System.out.println("*******************************************");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1.체크인  2.체크아웃 3.객실상태 4.업무종료");
			System.out.println("*******************************************");
			
			int sel = sc.nextInt();
			
			switch (sel) {
			case 1:
				checkIn();
				break;
			case 2:
				checkOut();
				break;
			case 3:
				roomState();
				break;
			case 4:
				System.out.println("**************************");
				System.out.println("호텔 문을 닫았습니다.");
				System.out.println("**************************");
				return;

			default:
				break;
			}
		}
	}

	private void roomState(){
		/*
		 * 메뉴선택 => 3 <-- 입력
		
			방번호 : 102, 투숙객 : 성춘향
			방번호 : 101, 투숙객 : 홍길동
		 */
		
		Set<String> keySet = hotelMap.keySet();
		
		if(keySet.size() == 0) {
			System.out.println("투숙객이 없습니다.");
			return;
		}
		
		Iterator<String> it = keySet.iterator();
		
		while(it.hasNext()) {
			String room = it.next();
			HotelVo h = hotelMap.get(room);
			System.out.println("방번호 : "+ h.getRoom() + "\t투숙객 : "+ h.getName());
		}
		
	}

	private void checkOut() {
		/*
		 * *******************************************
			어떤 업무를 하시겠습니까?
			1.체크인  2.체크아웃 3.객실상태 4.업무종료
			*******************************************
			메뉴선택 => 2 <-- 입력
			
			어느방을 체크아웃 하시겠습니까?
			방번호 입력 => 101 <-- 입력
			체크아웃 되었습니다.
		 */
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		System.out.println("방 번호 입력 =>");
		String room = sc.next();
		if(!hotelMap.containsKey(room)) {
			System.out.println(room+" 번 방에는 체크인 한 사람이 없습니다.");
			return;
		}
		hotelMap.remove(room);
		System.out.println(room + "번 방 체크아웃 되었습니다.");
		
	}

	private void checkIn() {
		/*
		 * 어느방에 체크인 하시겠습니까?
			방번호 입력 => 102 <-- 입력
			
			누구를 체크인 하시겠습니까?
			이름 입력 => 성춘향 <-- 입력
			체크인 되었습니다
		 */
		System.out.println("방번호 입력 => ");
		String room = sc.next();
		
		if(hotelMap.containsKey(room)) {
			System.out.println(room+"번 방에는 이미 사람이 있습니다.");
			return;
		}
		
		System.out.println("이름 입력 => ");
		String name = sc.next();
		
		hotelMap.put(room, new HotelVo(room, name));
		System.out.println("체크인 되었습니다.");
		
	}
	
}

class HotelVo{
	private String room;
	private String name;
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HotelVo(String room, String name) {
		super();
		this.room = room;
		this.name = name;
	}
	@Override
	public String toString() {
		return "HotelVo [room=" + room + ", name=" + name + "]";
	}
}
