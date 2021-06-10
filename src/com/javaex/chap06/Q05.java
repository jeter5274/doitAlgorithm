package com.javaex.chap06;

import java.util.Scanner;

public class Q05 {

	private int[] array;
	
	public Q05(int capacity) {
		array = new int[capacity];
	}
	
	public void swap(int bigger, int smaller) {
		int temp = array[bigger];
		array[bigger] = array[smaller];
		array[smaller] = temp;
	}
	
	public void set() {
		for(int i=0; i<array.length; i++) {
			array[i] = (int) (Math.random()*100);
		}
	}
	
	public void print() {
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+ " ");
		}
		System.out.println();
	}
	
	public void sortingPrintProcess() {

		int front=0, rear=array.length-1, index=0, passCnt=0;

		System.out.println("배열을 오름차순으로 정렬합니다.");
		
		for(int i=0; i<array.length; i++) {
			
			switch(i%2) {
			
			case 0:	
				int min=Integer.MAX_VALUE;
				for(int j=front; j<=rear; j++) {
					if(min > array[j]) {
						min = array[j];
						index = j;
					}
				}
				
				if(index == front) continue;
				
				for(int j=index; j>front; j--) {
					array[j] = array[j-1];
				}
				array[front++] = min;
				break;
				
			case 1:
				int max=0;
				
				for(int j=front; j<=rear; j++) {
					if(max < array[j]) {
						max = array[j];
						index = j;
					}
				}
				
				if(index == rear) continue;
				
				for(int j=index; j<rear; j++) {
					array[j] = array[j+1];
				}
				array[rear--] = max;
				
				break;
			}
			
			System.out.println("패스" +(++passCnt));
			print();
			
		}
	}
	
	public void shakerSort() {
		int left = 0;
		int right = array.length-1;
		int last = right;
		int passCnt=0;

		while (left < right) {
			
			for (int j = right; j > left; j--) {
				if (array[j - 1] > array[j]) {
					swap(j - 1, j);
					last = j;
				}
			}
			left = last;
			System.out.println("패스" +(++passCnt));
			print();

			for (int j = left; j < right; j++) {
				if (array[j] > array[j + 1]) {
					swap(j, j + 1);
					last = j;
				}
			}
			right = last;
			System.out.println("패스" +(++passCnt));
			print();
		}	
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//System.out.print("배열의 크기를 입력하시오. : ");
		//BubbleSort bs = new BubbleSort(sc.nextInt());
		int capacity = (int)(Math.random()*7) +3 ;
		Q05 bs = new Q05(capacity);
		
		bs.set();
		System.out.println();
		
		System.out.print("크기가 " +capacity+ "인 ");
		System.out.println("배열이 생성되었습니다.");
		bs.print();
		System.out.println();
		
		bs.shakerSort();
		System.out.println();
		
		System.out.println("배열이 오름차순으로 정렬되었습니다.");
		bs.print();
		
		sc.close();
	}

}
