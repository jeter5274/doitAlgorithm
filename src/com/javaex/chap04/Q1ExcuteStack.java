package com.javaex.chap04;

import java.util.Scanner;

public class Q1ExcuteStack {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			System.out.print("스택 크기(종료 0) : ");
			int capacity = sc.nextInt();
			
			if(capacity <= 0) break;
			StackPrac stack = new StackPrac(capacity);
			
			while(true) {
				System.out.println("현재 데이터 수 " + stack.size() + "/" + stack.capacity());
				System.out.print("(1)푸시 (2)팝 (3)피크 (4)덤프 (5)검색 (6)초기화 (0)종료 : ");
				
				int menu = sc.nextInt();
				
				if(menu == 0) break;
				
				switch(menu) {
				
					case 1 :
						if(stack.isFull()) System.out.println("스택이 가득 찼습니다.");
						else {
							System.out.print("데이터 : ");
							stack.push(sc.nextInt());
						}
						break;
						
					case 2 :
						if(stack.isEmpty()) System.out.println("스택이 비어 있습니다.");
						else System.out.println("팝 : " +stack.pop());
						break;
						
					case 3 :
						System.out.println("피크 : " +stack.peek());
						break;
						
					case 4 :
						System.out.print("덤프 : ");
						stack.dump();
						break;
					
					case 5 :
						System.out.print("검색 : ");
						int index = stack.indexOf(sc.nextInt());
						
						if(index == -1) System.out.println("스택에 데이터가 없습니다.");
						else {
							index = stack.size() - index;
							System.out.println("top에서 " +index+ "번 째에 데이터가 있습니다.");
						}
						
						break;
						
					case 6 :
						stack.clear();
						System.out.println("스택이 초기화 되었습니다.");
						break;
						
				}
				
				System.out.println();
				
			}
		}
		sc.close();
	}

}
