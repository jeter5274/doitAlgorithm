package com.javaex.chap05;

import java.util.Scanner;

public class Q3 {

	static int gcd(int x, int y) {
		
		if(y == 0) return x;
		else return gcd(y, x%y);
		
		
	}
	
	static int gcdArray(int[] a, int start, int num) {
		if(num == 1) return a[start];
		else if(num == 2) return gcd(a[start], a[start+1]);
		else return gcd(a[start], gcdArray(a, start+1, num-1));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("배열의 모든요소의 최대공약수를 구합니다.");
		
		System.out.print("배열의 크기를 입력하세요 : ");
		int num = sc.nextInt();
		
		int[] arry = new int[num];
		
		for(int i = 0; i<num; i++) {
			System.out.print("정수를 입력하세요 : ");
			arry[i] = sc.nextInt();
		}
		
		System.out.println("최대공약수 : " +gcdArray(arry,0,num) );
		
		sc.close();
	}

}
