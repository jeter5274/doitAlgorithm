package com.javaex.chap06;

public class Q8 {

	private int[] array;
	
	public Q8(int capacity) {
		array = new int[capacity];
	}
	
	public void set() {
		
		for(int i=0; i<array.length; i++) {
			array[i] = (int)(Math.random()*100);
			
			for(int j=0; j<i; j++) {
				if(array[i] == array[j]) i--;
			}
		}
		System.out.println("길이가 " +array.length+ "인 배열을 생성했습니다.");
		print();
	}
	
	public void print() {
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+ " ");
		}
		System.out.println();
	}
	
	
	public void insertSortBinary() {
		
		for(int i=1; i<array.length; i++) {
			int pf=0, pr=i-1, pc=0, key=array[i], insertPoint;
			
			do {
				pc = (pf + pr) /2;
				
				if(pc == key) break;
				else if(array[pc] < key) pf = pc+1;
				else pr = pc-1;
				
			}while(pf <= pr);
			
			insertPoint = pf <= pr ? pc+1 : pr+1;
			
			for(int j=i; j>insertPoint;j--) {
				array[j] = array[j-1];
			}
			
			array[insertPoint] = key;
			print();
		}
		
	}
	
	public static void main(String[] args) {
		
		Q8 jss = new Q8((int)(Math.random()*7)+3);
		
		jss.set();
		System.out.println();
		
		jss.insertSortBinary();
		System.out.println();
		
		System.out.println("정렬 결과");
		jss.print();		
	}
}
