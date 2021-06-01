package com.javaex.chap03;

public class Q05 {

	public static void main(String[] args) {
		
		int[] arr = {1, 3, 5, 7, 7, 7, 7, 8, 8, 9, 9};
		int key = 7;
		int result = binSerachX(arr, key);
		
		if(result == -1) System.out.println("검색 실패");
		else System.out.println(key+ "는 배열의 " +(result+1)+ "번째에 있습니다.");

	}
	
	static int binSerachX(int[] a, int key) {
		
		int ps = 0, pe = a.length-1, pc =0;
		
		while(ps <= pe) {
			
			pc = (ps + pe) /2;
			
			if(a[pc] == key){
				
				while(a[pc] == key) {
					pc--;
				}
				
				return pc+1;
				
			}else if(key > a[pc]) {
				ps = pc+1;
			}else {
				pe = pc-1;
			}
		}
		
		return -1;
	}

}
