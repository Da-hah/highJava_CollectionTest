package kr.or.ddit.basic.homework;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Lotto {
/*
 * ==========================
         Lotto 프로그램
	--------------------------
	 1. Lotto 구입
	  2. 프로그램 종료
	==========================		 
	메뉴선택 : 1  <-- 입력
			
	 Lotto 구입 시작
		 
	(1000원에 로또번호 하나입니다.)
	금액 입력 : 2500  <-- 입력
			
	행운의 로또번호는 아래와 같습니다.
	로또번호1 : 2,3,4,5,6,7
	로또번호2 : 20,21,22,23,24,25
			
	받은 금액은 2500원이고 거스름돈은 500원입니다.
			
   	 ==========================
         Lotto 프로그램
	--------------------------
	  1. Lotto 구입
	  2. 프로그램 종료
	==========================		 
	메뉴선택 : 2  <-- 입력
		
	감사합니다
 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("==========================");
			System.out.println("      Lotto 프로그램");
			System.out.println("--------------------------");
			System.out.println(" 1. Lotto 구입");
			System.out.println(" 2. 프로그램 종료");
			System.out.println("==========================");
			System.out.print("메뉴 선택 : ");
			
			int sel = sc.nextInt(); 
			
			if(sel == 1) {
				System.out.println("(1000원에 로또번호 하나입니다.)");
				int money = sc.nextInt();
				int lottoChance = money/1000;
				int moneyChg = money%1000;
				
				for(int i = 0 ; i < lottoChance; i++) {
					Set<Integer> lotto = new HashSet<Integer>();
					while(lotto.size()<6) {
						int lottoNum = (int)(Math.random()*45)+1;
						lotto.add(lottoNum);
					}
					System.out.println("로또"+(i+1)+" : "+lotto);
				}
				
				System.out.println("받은 돈은 "+money+"원 이고 거스름 돈은 "+moneyChg+"입니다.");
				
			}else {
				System.out.println("시스템 종료");
				break;
			}
			
		}
		
		
		
	}
}
