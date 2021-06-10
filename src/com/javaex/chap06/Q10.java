package com.javaex.chap06;

public class Q10 {

private int[] array;
	
	public Q10(int capacity) {
		array = new int[capacity];
	}
	
	public void set() {
		
		for(int i=0; i<array.length; i++) {
			array[i] = (int)(Math.random()*100);
			
			for(int j=0; j<i; j++) {
				if(array[i] == array[j]) i--;
			}
		}
		
		System.out.println("길이가 " +array.length+ "인 배열을 생성했습니다.");
		print();
	}
	
	public void print() {
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+ " ");
		}
		System.out.println();
	}
	
	public void quickSort(int arrayLength) {
		quickSort(0, arrayLength-1);
	}
	
	public void quickSort(int front, int rear) {
		int arrFront = front;
		int arrRear = rear;
		int pivot= array[(arrFront + arrRear) / 2];
		
		//보충수업 6-1
		print(front, rear);
		
		while(arrFront <= arrRear){
			while(array[arrFront] < pivot) arrFront++;
			while(array[arrRear] > pivot) arrRear--;
			
			if(arrFront <= arrRear) swap(arrFront++, arrRear--);
		}
		
		if(arrRear > front) quickSort(front, arrRear);
		if(arrFront < rear) quickSort(arrFront, rear);
		
	}
	
	//보충수업 6-1
	public void print(int front, int rear) {
		
		System.out.print("array["+front+"] ~ ["+rear+"] : ");
		for(int i=front; i<=rear; i++) {
			System.out.print(array[i]+ " ");
		}
		System.out.println();
	}
	
	public void swap(int idx1, int idx2) {
		int temp = array[idx1];
		array[idx1] = array[idx2];
		array[idx2] = temp;
	}
	
	public int getArrayLenght() {
		return array.length;
	}
	
	public static void main(String[] args) {
		
		int maxArrayLength = 10;
		int minArrayLength = 3;
		
		Q10 sort = new Q10((int)(Math.random()*(maxArrayLength - minArrayLength))+minArrayLength);
		
		sort.set();
		System.out.println();
		
		sort.quickSort(sort.getArrayLenght());
		System.out.println();
		
		System.out.println("정렬 결과");
		sort.print();		
	}
}
