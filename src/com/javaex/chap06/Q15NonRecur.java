package com.javaex.chap06;

import com.javaex.chap04.StackPrac;

public class Q15NonRecur {

	private int[] array;

	public Q15NonRecur(int capacity) {
		array = new int[capacity];
	}

	public void set() {

		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 100);

			for (int j = 0; j < i; j++) {
				if (array[i] == array[j])
					i--;
			}
		}

		System.out.println("길이가 " + array.length + "인 배열을 생성했습니다.");
		print();
	}

	public void print() {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public int pivotSort(int a, int b, int c) {
		
		if (array[a] > array[b]) swap(a, b);
		if (array[b] > array[c]) swap(b, c);
		if (array[a] > array[b]) swap(a, b);
		
		swap(b, c-1);
		
		print();
		return array[c-1];
	}

	public void quickSort(int arrayLength) {
		quickSort(0, arrayLength - 1);
	}

	public void quickSort(int front, int rear) {

		StackPrac sFront = new StackPrac(rear - front + 1);
		StackPrac sRear = new StackPrac(rear - front + 1);

		System.out.print("push : " + sFront.push(front));
		System.out.println(", " + sRear.push(rear));

		while (sFront.isEmpty() != true) {

			front = sFront.pop();
			rear = sRear.pop();
			System.out.print("pop : "+front);
			System.out.println(", " +rear);
			
			print(front, rear);

			if (rear - front + 1 < 9) justSelectionSort(front, rear);
			else {
				
				int pivot= pivotSort(front, (front + rear) / 2, rear); 

				int arrFront = front+1;
				int arrRear =  rear-1;
				
				print(arrFront, arrRear);
				
				while (arrFront <= arrRear) {
					while (array[arrFront] < pivot)
						arrFront++;
					while (array[arrRear] > pivot)
						arrRear--;

					if (arrFront <= arrRear)
						swap(arrFront++, arrRear--);
				}

				/*
				 * arrRear <-> rear arrFront <-> front
				 */

				if (arrRear - front < rear - arrFront) {
					int temp = arrRear;
					arrRear = rear;
					rear = temp;
					temp = arrFront;
					arrFront = front;
					front = temp;
				}

				if (arrRear > front) {
					System.out.print("push : " + sFront.push(front));
					System.out.println(", " + sRear.push(arrRear));
				}

				if (arrFront < rear) {
					System.out.print("push : " + sFront.push(arrFront));
					System.out.println(", " + sRear.push(rear));
				}

			}

		}

	}

	public void justSelectionSort(int front, int rear) {
		
		for(int i=front; i<=rear; i++) {
			int min=i;
			for(int j=i+1; j<array.length; j++) {
				if(array[j] < array[min]) min = j;
			}
			swap(i, min);
		}
		
		System.out.println("[단순 삽입 정렬]");
		print(front, rear);
	}
	
	// 보충수업 6-1
	public void print(int front, int rear) {

		System.out.print("array[" + front + "] ~ [" + rear + "] : ");
		for (int i = front; i <= rear; i++) {
			System.out.print(array[i] + " ");
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

		int maxArrayLength = 100;
		int minArrayLength = 3;

		Q15NonRecur sort = new Q15NonRecur((int) (Math.random() * (maxArrayLength - minArrayLength)) + minArrayLength);

		sort.set();
		System.out.println();

		sort.quickSort(sort.getArrayLenght());
		System.out.println();

		System.out.println("정렬 결과");
		sort.print();
	}
}
