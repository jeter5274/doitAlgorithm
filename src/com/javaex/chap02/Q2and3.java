package com.javaex.chap02;

public class Q2and3 {

	public static void main(String[] args) {
		
		int a[] = {5, 10, 73, 2, -5, 42};
		
		printArray(a);
		reserve(a);
		
		System.out.println("배열의 모든 요소의 합 : " +sumOf(a));
	}
	
	static void swap(int[] arr, int idx1, int idx2) {	
		System.out.println("a[" +idx1+ "]과(와) a[" +idx2+"]를 교환합니다.");
		int t = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = t;
	}
	
	static void reserve(int[] arr) {
		
		for(int i=0; i<arr.length / 2; i++) {
			swap(arr, i, arr.length-(i+1));
			printArray(arr);
		}
		
		System.out.println("역순정렬을 마쳤습니다.");
	}
	
	static void printArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			
			System.out.print(arr[i]+ " ");
			
		}
		System.out.println("");
	}
	
	static int sumOf(int[] arr) {
		
		int result = 0;
		
		for(int i=0; i<arr.length; i++) {
			result += arr[i];
		}
		
		return result;
	}
}
