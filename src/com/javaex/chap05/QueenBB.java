package com.javaex.chap05;

public class QueenBB {

	static boolean[] flag_col = new boolean[8];
	static boolean[] flag_slash = new boolean[15];
	static boolean[] flag_backslash = new boolean[15];
	static int num = 1;
	static int[] pos = new int[8];
	
	static void print() {
		System.out.print((num++)+ ". ");
		for(int i=0; i<8; i++) {
			System.out.printf("%2d", pos[i]);
		}
		System.out.println();
	}
	
	static void set(int i) {
		for(int j=0; j<8; j++) {
			
			if(flag_col[j] == false && flag_slash[i+j] == false && flag_backslash[i-j+7]==false) {
			
				pos[i] = j;
				
				if(i == 7) print();
				else {
					flag_col[j] = flag_slash[i+j] = flag_backslash[i-j+7] = true;
					set(i+1);
					flag_col[j] = flag_slash[i+j] = flag_backslash[i-j+7] = false;
				}
				
			}
			
		}
	}
	public static void main(String[] args) {
		set(0);
		// TODO Auto-generated method stub

	}

}
