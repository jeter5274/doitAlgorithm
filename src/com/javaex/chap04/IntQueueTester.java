package com.javaex.chap04;

import java.util.Scanner;

public class IntQueueTester {

	public static void main(String[] args) {

		IntQueue que = new IntQueue(64);
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("현재 데이터 수 " + que.size() + "/" + que.capacity());
			System.out.print("(1)인큐 (2)디큐 (3)피크 (4)덤프 (0)종료 : ");
			
			int menu = sc.nextInt();
			
			if(menu == 0) break;
			
			switch(menu) {
			
				case 1 :
					System.out.print("데이터 : ");
					try{
						que.enque(sc.nextInt());
					}catch(IntQueue.OverflowIntQueueException e) {
						System.out.println("큐가 가득 찼습니다.");
					}
					break;
					
				case 2 :
					try{
						System.out.println("디큐 : " +que.deque());
					}catch(IntQueue.EmptyIntQueueException e) {
						System.out.println("큐가 비어 있습니다.");
					}
					break;
					
				case 3 :
					System.out.println("피크 : " +que.peek());
					break;
					
				case 4 :
					System.out.print("덤프 : ");
					que.dump();
					break;
			}
			
			System.out.println();
			
		}
		
		sc.close();
	}

}
