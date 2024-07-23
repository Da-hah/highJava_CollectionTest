package kr.or.ddit.basic.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public  class Student{
	public static void main(String[] args) {
		List<StudentVo> list = new ArrayList<StudentVo>();
		
		list.add(new StudentVo("2번","변학도", 89, 100, 96));
		list.add(new StudentVo("3번","성춘향", 100, 65, 80));
		list.add(new StudentVo("7번","홍길동", 70, 88, 95));
		list.add(new StudentVo("1번","김다희", 90, 80, 75));
		list.add(new StudentVo("4번","이수빈", 100, 00, 100));
		list.add(new StudentVo("6번","김승민", 0, 0, 0));
		list.add(new StudentVo("7번","이미숙", 50, 80, 80));
		System.out.println("정렬전 : ");
		
		for (int i = 0; i < list.size(); i++) {
			StudentVo studentVo1 = list.get(i); 
			int cnt = 1;
			int f1 = studentVo1.getSum();
			
			for (int j = 0; j < list.size(); j++) {
				StudentVo studentVo2 = list.get(j); 
				int f2 = studentVo2.getSum();
				if(i != j) {
					if(f1 < f2 ) {
						cnt++;
					}
				}
				studentVo1.setRank(cnt);
			}
			System.out.println(studentVo1);
		}
		
		System.out.println();
		Collections.sort(list);
		System.out.println("학번으로 정렬후 : ");
		
		for (int i = 0; i < list.size(); i++) {
			StudentVo studentVo1 = list.get(i); 
			int cnt = 1;
			int f1 = studentVo1.getSum();
			
			for (int j = 0; j < list.size(); j++) {
				StudentVo studentVo2 = list.get(j); 
				int f2 = studentVo2.getSum();
				if(i != j) {
					if(f1 < f2 ) {
						cnt++;
					}
				}
				studentVo1.setRank(cnt);
			}
			System.out.println(studentVo1);
		}
		
		System.out.println();
		Collections.sort(list, new SumSort());
		System.out.println("총점으로 정렬후 : ");
		
		for (int i = 0; i < list.size(); i++) {
			StudentVo studentVo1 = list.get(i); 
			int cnt = 1;
			int f1 = studentVo1.getSum();
			
			for (int j = 0; j < list.size(); j++) {
				StudentVo studentVo2 = list.get(j); 
				int f2 = studentVo2.getSum();
				if(i != j) {
					if(f1 < f2 ) {
						cnt++;
					}
				}
				studentVo1.setRank(cnt);
			}
			System.out.println(studentVo1);
		}
		
	}
}


class SumSort implements Comparator<StudentVo>{
	@Override
	public int compare(StudentVo st1, StudentVo st2) {
		if(st1.getSum() < st2.getSum()) {
			return 1;
		}
		else if(st1.getSum() == st2.getSum()) {
			return st1.getStNo().compareTo(st2.getStNo())*-1;
		}else {
			return -1;
		}
	}
}

class StudentVo implements Comparable<StudentVo>{
	//학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수
	private String stNo;
	private String stName;
	private int kor;
	private int eng;
	private int mat;
	private int sum;
	private int rank;
	
	public StudentVo(String stNo, String stName, int kor, int eng, int mat) {
		this.stNo = stNo;
		this.stName = stName;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.sum = kor+eng+mat;
	}

	public String getStNo() {
		return stNo;
	}

	public void setStNo(String stNo) {
		this.stNo = stNo;
	}

	public String getStName() {
		return stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getSum() {
		return kor+mat+eng;
	}
	
	public void setSum(int sum) {//총합
		this.sum = sum;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	
	@Override
	public String toString() {
		return "학번 : " + stNo + ", 이름 : " + stName + ", 국어 : " + kor + ", 영어 : " + eng + ", 수학 : " + mat
				+ ", 총점 : " + sum + ", 등수 : " + rank;
	}

	@Override
	public int compareTo(StudentVo st) {
		return getStNo().compareTo(st.getStNo());
	}
}
