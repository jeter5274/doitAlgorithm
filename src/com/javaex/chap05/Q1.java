package com.javaex.chap05;

import java.util.Scanner;

public class Q1 {

	static int factorial(int n) {
		
		for(int i = n-1; i>0; i--) {
			n *= i;
		}
		
		//0! -> 1, 곱셈은 생략
		
		return n;
		
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int x = sc.nextInt();
		
		System.out.println(x+ "! = " +factorial(x));
		
		sc.close();
	}

}
