package com.javaex.chap05;

import com.javaex.chap04.StackPrac;

public class Q5 {
	
	static void recur3(int n) {
		/*
		//비재귀로 변경
		if(n>0) {
			recur3(n-1);
			//recur3(n-2);
			System.out.println(n);
		}
		*/
		
		StackPrac s = new StackPrac(n*2);
		StackPrac s2 = new StackPrac(n*2);
		
		while(true) {
			if(n > 0) {
				s.push(n);
				n -= 1;
				continue;
			}
			
			if(!s.isEmpty()) {
				n = s.pop();
				
				if(n>0) {
					s2.push(n);
					n -=2;
					continue;
				}
				
				if(!s2.isEmpty()) {
					System.out.println(s.pop());
					continue;
				}
				
			}
			
			
		}
	}
	
	public static void main(String[] args) {
		recur3(4);
	}
}
