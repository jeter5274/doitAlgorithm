package com.javaex.chap06;

import java.util.Scanner;

public class BubbleSortReview {

	private int[] array;
	
	public BubbleSortReview(int capacity) {
		array = new int[capacity];
	}
	
	public void sorting() {
		for(int i=0; i<array.length-1; i++) {
			for(int j=array.length-1; j>i; j--) {
				if(array[j] < array[j-1]) swap(j, j-1);
			}
		}
	}
	
	public void sortingFront() {
		for(int i=array.length-1; i>0; i--) {
			for(int j=0; j<i; j++) {
				if(array[j] > array[j+1]) swap(j, j+1);
			}
		}
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
		System.out.println("배열을 오름차순으로 정렬합니다.");
		int compare = 0, change = 0, pass=0;
		
		for(int i=array.length-1; i>0; i--) {
			
			int passChange = 0;
			
			System.out.println("패스" +(++pass)+ ":");
	
			for(int j=0; j<i; j++) {
				compare++;
				
				for(int k=0; k<array.length; k++) {
					System.out.print(array[k] + (k != j ? " " : (array[j] > array[j+1] ? "+" : "-")));
					
				}
				
				if(array[j] > array[j+1]) {
					change++;
					passChange++;
					swap(j, j+1);
				}
				
				System.out.println();
			}
			System.out.println();
			if(passChange == 0) break;
		}
		
		System.out.println("정렬을 완료했습니다. 비교 : " +compare+ ", 교환 : " +change);
		print();
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//System.out.print("배열의 크기를 입력하시오. : ");
		//BubbleSort bs = new BubbleSort(sc.nextInt());
		int capacity = (int)(Math.random()*7) +3 ;
		BubbleSortReview bs = new BubbleSortReview(capacity);
		
		bs.set();
		
		System.out.println();
		System.out.print("크기가 " +capacity+ "인 ");
		System.out.println("배열이 생성되었습니다.");
		bs.print();
		
		System.out.println();
		bs.sortingPrintProcess();
		//System.out.println("배열이 오름차순으로 정렬되었습니다.");
		//bs.print();
		
		sc.close();
	}

}
