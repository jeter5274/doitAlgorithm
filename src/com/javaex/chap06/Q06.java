package com.javaex.chap06;

public class Q06 {

	private int[] array;
	
	public Q06(int capacity) {
		array = new int[capacity];
	}
	
	public void set() {
		for(int i=0; i<array.length; i++) {
			array[i] = (int)(Math.random()*10);
			
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
	
	public void printPoint(int frontIdx, int minIdx) {
		for(int i=0; i<array.length; i++) {
			
			if(i == frontIdx) System.out.print("*");
			else if(i == minIdx) System.out.print("+");
			else System.out.print(" ");
			
			System.out.print(" ");
		}
		System.out.println();
	}
	
	public void swap(int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	public void justSelectionSort() {
		for(int i=0; i<array.length-1; i++) {
			int min=i;
			for(int j=i+1; j<array.length; j++) {
				if(array[j] < array[min]) min = j;
			}

			printPoint(i,min);
			print();
			
			swap(i, min);
		}
	}
	
	public static void main(String[] args) {
		
		Q06 jss = new Q06((int)(Math.random()*2)+3);
		
		jss.set();
		System.out.println();
		
		jss.justSelectionSort();
		System.out.println();
		
		System.out.println("정렬 결과");
		jss.print();
		
	}
}
