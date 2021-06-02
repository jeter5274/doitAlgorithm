package com.javaex.chap06;

import java.util.Scanner;

public class Q2 {

	public static void bubbleSorting(int[] array, int size) {
		int passCnt = 1;
		System.out.println("패스" +(passCnt++)+ ":");
		for(int i=size-1; i>0; i--) {
			System.out.print(array[i]);
			for(int j=0; j<i; j++) {
				if(array[j] > array[j+1]) {
					System.out.print("+");
					swap(array, j, j+1); 
				}
			}
			System.out.print(" ");
		}
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
			System.out.println("array[" +i+ "] : " +array[i]);
		}
		
		sc.close();
		
	}

}
