package com.javaex.chap06;

import com.javaex.chap04.StackPrac;

public class Q14NonRecur {

private int[] array;
	
	public Q14NonRecur(int capacity) {
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
	
	public int findMiddle(int a, int b, int c) {
		
		if(a >= b) {
			if(b >= c) return b;
			else if(a <= c) return a;
			else return c;
		}else {
			if(a > c) return a;
			else if(b > c) return c;
			else return b;
		}
		
	}

	public void quickSort(int arrayLength) {
		quickSort(0, arrayLength-1);
	}
	
	public void quickSort(int front, int rear) {
		
		StackPrac sFront = new StackPrac(rear - front + 1);
		StackPrac sRear = new StackPrac(rear - front + 1);
		
		System.out.print("push : "+sFront.push(front));
		System.out.println(", " +sRear.push(rear));
				
		while(sFront.isEmpty() != true) {
		
			int arrFront = front = sFront.pop();
			int arrRear = rear = sRear.pop();
			System.out.print("pop : "+arrFront);
			System.out.println(", " +arrRear);
			
			print(arrFront, arrRear);
			
			int pivot= findMiddle(array[(arrFront + arrRear) / 2], array[front], array[rear]);
			
			while(arrFront <= arrRear){
				while(array[arrFront] < pivot) arrFront++;
				while(array[arrRear] > pivot) arrRear--;
				
				if(arrFront <= arrRear) swap(arrFront++, arrRear--);
			}
			
			if(arrRear > front) {
				System.out.print("push : "+sFront.push(front));
				System.out.println(", " +sRear.push(arrRear));
			}
			
			if(arrFront < rear) {
				System.out.print("push : "+sFront.push(arrFront));
				System.out.println(", " +sRear.push(rear));
			}
			
		}
		
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
		
		Q14NonRecur sort = new Q14NonRecur((int)(Math.random()*(maxArrayLength - minArrayLength))+minArrayLength);
		
		sort.set();
		System.out.println();
		
		sort.quickSort(sort.getArrayLenght());
		System.out.println();
		
		System.out.println("정렬 결과");
		sort.print();		
	}
}
