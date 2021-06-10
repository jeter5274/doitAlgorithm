package com.javaex.chap06;

import java.util.Scanner;

public class Q03 {

	public static void bubbleSorting(int[] array, int size) {
		int passCnt = 0, change=0, compare=0;
		
		for(int i=size-1; i>0; i--) {
			int passChangeCnt = 0;
			System.out.println("패스" +(++passCnt)+ ":");
			
			for(int j=0; j<i; j++) {
				
				for(int k=0; k<size; k++) System.out.print(array[k] + (k != j ? " " : array[j] > array[j+1] ? "+" : "-"));
				
				if(array[j] > array[j+1]) {
					change++;	
					passChangeCnt++;
					swap(array, j, j+1); 
				}
				compare++;
				System.out.println();
			}
			if(passChangeCnt == 0) break;
			System.out.println();
		}
		System.out.println("비교 : " +compare+ ", 교환 : "+change);
		System.out.println();
	}
	
	public static void swap(int[] array, int bigger, int smaller) {
		int temp = array[bigger];
		array[bigger] = array[smaller];
		array[smaller] = temp;
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("배열의 크기 : ");
		int capacity = sc.nextInt();
		
		int[] array = new int[capacity];
		
		System.out.println("<배열 요소 값 입력>");
		for(int i=0; i<array.length; i++) {
			System.out.print("array[" +i+ "] : ");
			array[i] = sc.nextInt();
		}
		
		bubbleSorting(array, array.length);
		
		System.out.println("배열을 오름차순으로 정렬하였습니다.");
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
		
		sc.close();
		
	}

}
