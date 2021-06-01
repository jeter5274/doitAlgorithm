package com.javaex.chap04;

import java.util.Scanner;

public class ExcuteStack {

	public static void main(String[] args) {

		StackPrac stack = new StackPrac(64);
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("현재 데이터 수 " + stack.size() + "/" + stack.capacity());
			System.out.print("(1)푸시 (2)팝 (3)피크 (4)덤프 (0)종료 : ");
			
			int menu = sc.nextInt();
			
			if(menu == 0) break;
			
			switch(menu) {
			
				case 1 :
					System.out.print("데이터 : ");
					try{
						stack.push(sc.nextInt());
					}catch(StackPrac.OverflowInStackException e) {
						System.out.println("스택이 가득 찼습니다.");
					}
					break;
					
				case 2 :
					try{
						System.out.println("팝 : " +stack.pop());
					}catch(StackPrac.EmptyInStackException e) {
						System.out.println("스택이 비어 있습니다.");
					}
					break;
					
				case 3 :
					System.out.println("피크 : " +stack.peek());
					break;
					
				case 4 :
					System.out.print("덤프 : ");
					stack.dump();
					break;
			}
			
			System.out.println();
			
		}
		
		sc.close();
	}

}
