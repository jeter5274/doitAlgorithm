package com.javaex.chap06;

public class Q7 {

	private int[] array;
	
	public Q7(int capacity) {
		array = new int[capacity+1];
	}
	
	public void set() {
		
		for(int i=1; i<array.length; i++) {
			array[i] = (int)(Math.random()*100);
			
			for(int j=0; j<i; j++) {
				if(array[i] == array[j]) i--;
			}
		}
		System.out.println("길이가 " +(array.length-1)+ "인 배열을 생성했습니다.");
		print();
	}
	
	public void print() {
		for(int i=1; i<array.length; i++) {
			System.out.print(array[i]+ " ");
		}
		System.out.println();
	}
	
	
	public void insertSortCentinel() {
		
		for(int i=2; i<array.length; i++) {
			array[0] = array[i];
			
			int j=i;
			
			while(array[j-1] > array[0]) {
				array[j] = array[j-1];
				j--;
			}
			
			array[j] = array[0];

			print();
			
		}
	}
	
	public static void main(String[] args) {
		
		Q7 jss = new Q7((int)(Math.random()*7)+3);
		
		jss.set();
		System.out.println();
		
		jss.insertSortCentinel();
		System.out.println();
		
		System.out.println("정렬 결과");
		jss.print();		
	}
}
