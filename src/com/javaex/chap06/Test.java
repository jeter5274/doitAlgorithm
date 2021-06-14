package com.javaex.chap06;

public class Test {

	public static void main(String[] args) {

		for(int i=0; i < 10; i++) {
			System.out.print(i +" / ");
			System.out.print(((i-1)/2) +" / ");
			System.out.println( ((i-1)/2) +": " +((i*2)+1)+ ", " +((i*2)+2));
		}
	}

}
