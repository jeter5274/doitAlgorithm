package com.javaex.chap02;

public class Q4and5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {0,0,0,0,0}, b= {1,2,3,4,5}, c= {1,2,3,4,5,6,7,8,9,10};
		
		System.out.print("a :");
		printArray(a);
		System.out.print("b :");
		printArray(b);
		System.out.print("c :");
		printArray(c);
		
		System.out.println("");
		
		
		copy(a,b);
		System.out.print("a :");
		printArray(a);
		System.out.print("b :");
		printArray(b);
		
		System.out.println("");
		
		rcopy(a,c);
		System.out.print("a :");
		printArray(a);
		System.out.print("c :");
		printArray(c);
		
		System.out.println("");
		
		copy(b,a);
		System.out.print("b :");
		printArray(b);
		System.out.print("a :");
		printArray(a);
				
		System.out.println("");
		
		copy(b,c);
		System.out.print("b :");
		printArray(b);
		System.out.print("c :");
		printArray(c);
		
		System.out.println("");
		
		rcopy(c,a);
		System.out.print("c :");
		printArray(c);
		System.out.print("a :");
		printArray(a);
		
	}
	
	static void copy(int[] a, int[] b) {
		
		int arrayLength = a.length < b.length ? a.length : b.length;
		
		for(int i=0; i<arrayLength; i++) {
			a[i] = b[i];
		}

		System.out.println("요소 복사 완료");
	}
	
	static void rcopy(int[] a, int[] b) {
		
		int arrayLength = a.length < b.length ? a.length : b.length;
		
		for(int i=0; i<arrayLength; i++) {
			a[i] = b[b.length - (i+1)];
		}
		
		System.out.println("요소 역순복사 완료");
	}
	
	static void printArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			
			System.out.print(arr[i]+ " ");
			
		}
		System.out.println("");
	}
}
