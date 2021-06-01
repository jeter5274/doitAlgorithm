package com.javaex.chap03;

public class Q03 {
	
	public static void main(String args[]) {
		
		int[] arr = {1,9,2,9,4,6,7,9};
		int[] idx = new int[arr.length];
		
		int findCnt = searchIdx(arr, 9, idx);
		System.out.println("찾은 갯수 :" +findCnt);
		
		if(findCnt > 0) {
			for(int i=0; i<findCnt; i++) {
				System.out.print(idx[i]+ " ");
			}
			System.out.println("");
		}
		
	}
	
	static int searchIdx(int[] a, int key, int[] idx) {
		
		int idxIndex = 0;
		
		for(int i=0; i<a.length; i++) {
			if(a[i] == key) idx[idxIndex++] = i;
		}
		
		return idxIndex;
	}
}
