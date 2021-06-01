package com.javaex.chap01;

import java.util.Scanner;

public class Q11 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num = 0;
		int numLength = 0;
		
		while(true) {
			System.out.print("양의 정수를 입력하세요 : ");
			num = sc.nextInt();
			
			if(num > 0) break;
			else System.out.println("양의 정수가 아닙니다.");
		}
		
		while(num > 0) {
			num /= 10;
			numLength++;
		}
		
		System.out.println("그 수는 " +numLength+ "자리 입니다.");
		
		sc.close();

	}

}
