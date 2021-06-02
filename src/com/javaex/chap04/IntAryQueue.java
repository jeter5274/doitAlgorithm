package com.javaex.chap04;

public class IntAryQueue {

	private int max;
	private int num;
	private int[] que;
	
	public IntAryQueue(int capacity){
		max = capacity;
		num = 0;
		try {
			que = new int[max];
		}catch(OutOfMemoryError e) {
			max = 0;
		}
	}
	
	//인큐
	public int enque(int x) throws OverflowIntQueueException {
		if(num >= max) throw new OverflowIntQueueException();
		return que[num++] = x;
	}
	
	//디큐
	public int deque() throws EmptyIntQueueException {
		if(num <= 0) throw new EmptyIntQueueException();
		
		int dequeData = que[0];
		
		num--;
		
		for(int i=0; i<num; i++) {
			que[i] = que[i+1];
		}
		
		return dequeData;
	}
	
	//피크
	public int peek() throws EmptyIntQueueException {
		if(num <= 0) throw new EmptyIntQueueException();
		return que[0];
	}
	
	//데이터 검색
	public int indexOf(int x) {
		
		for(int i=0; i<num; i++) {
			if(que[i] == x) return i;
		}
		
		return -1;
	}
	
	//초기화
	public void clear() {
		num = 0;
	}
	
	//용량
	public int capacity() {
		return max;
	}
	
	//데이터 수
	public int size() {
		return num;
	}
	
	//큐가 비어 있는지?
	public boolean isEmpty() {
		return num == 0;
	}
	
	//큐가 가득 찼는지?
	public boolean isFull() {
		return num == max;
	}
	
	//큐 안의 모든 데이터를 프런트 -> 리어 순으로 출력
	public void dump() {
		
		if(num <=0) System.out.println("큐가 비어 있습니다.");
		else {
			for(int i=0; i<num; i++) {
				System.out.print(que[i] + " ");
			}
			System.out.println();
		}
		
	}
	
	@SuppressWarnings("serial")
	class EmptyIntQueueException extends RuntimeException {
		EmptyIntQueueException() {}
	}
	
	@SuppressWarnings("serial")
	class OverflowIntQueueException extends RuntimeException {
		OverflowIntQueueException() {}
	}
}
