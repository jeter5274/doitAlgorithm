package com.javaex.chap06;

public class Q09Ver2 {

private int[] array;
	
	public Q09Ver2(int capacity) {
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
	
	
	public void shellSort() {
		int changeCnt = 0;
		int h=1;
		
		while(h < array.length / 9) {
			h = h*3 + 1;
		}
		
		System.out.println(h);
		
		while( h>0) {
			for(int i=h; i<array.length; i++) {
				int j;
				int temp = array[i];
				for(j = i-h; j >= 0 && array[j] > temp; j -= h) {
					array[j + h] = array[j];
					changeCnt++;
				}
				array[j+h] = temp;
			}
			h /= 2;
		}
		
		System.out.println("요소의 이동횟수 : " +changeCnt);
	}
	
	public static void main(String[] args) {
		
		int maxArrayLength = 100;
		int minArrayLength = 3;
		
		Q09Ver2 sort = new Q09Ver2((int)(Math.random()*(maxArrayLength - minArrayLength))+minArrayLength);
		
		sort.set();
		System.out.println();
		
		sort.shellSort();
		System.out.println();
		
		System.out.println("정렬 결과");
		sort.print();		
	}
}
