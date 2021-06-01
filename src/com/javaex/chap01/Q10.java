package com.javaex.chap01;

import java.util.Scanner;

public class Q10 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("a입력 : ");
		int a = sc.nextInt();
		int b = 0;
		while(true) {
			System.out.print("b입력 : ");
			b = sc.nextInt();
			
			if(b <= a) System.out.println("a보다 큰 수를 입력하세요");
			else break;
		}
		
		System.out.println("b-a는 " + (b-a) + "입니다.");
		
		sc.close();
		
	}

}
