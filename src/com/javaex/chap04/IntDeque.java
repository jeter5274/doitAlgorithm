package com.javaex.chap04;

public class IntDeque {

	private int max;
	private int front;
	private int rear;
	private int num;
	private int[] que;
	
	public IntDeque(int capacity){
		max = capacity;
		num = front = rear = 0;
		try {
			que = new int[max];
		}catch(OutOfMemoryError e) {
			max = 0;
		}
	}
	
	//인큐 프론트
 	public int enqueFront(int x) throws OverflowIntQueueException {
		if(num >= max) throw new OverflowIntQueueException();
		
		que[front--] = x;
		num++;
		
		if(front == -1) front = max;
		
		return x;
	}
	
	//인큐 리니어
	public int enqueRear(int x) throws OverflowIntQueueException {
		if(num >= max) throw new OverflowIntQueueException();
		
		que[rear++] = x;
		num++;
		
		if(rear == max) rear = 0;
		
		return x;
	}
	
	//디큐 프론트
	public int dequeFront() throws EmptyIntQueueException {
		if(num <= 0) throw new EmptyIntQueueException();
		
		
		int dequeData = que[front++];
		
		if(front == max) front = 0;
		num--;
		
		return dequeData;
	}
	
	//디큐 리니어
	public int dequeRear() throws EmptyIntQueueException {
		if(num <= 0) throw new EmptyIntQueueException();
		
		
		int dequeData = que[rear--];
		
		if(rear == 0) rear = max;
		num--;
		
		return dequeData;
	}
	
	//피크 프론트
	public int peekFront() throws EmptyIntQueueException {
		if(num <= 0) throw new EmptyIntQueueException();
		return que[front];
	}
	
	//피크 리니어
	public int peekRear() throws EmptyIntQueueException {
		if(num <= 0) throw new EmptyIntQueueException();
		//return que[rear]; 꼬리는 index+1인 상태임
		return que[rear == 0 ? max-1 : rear-1];
	}
	
	//데이터 검색
	public int indexOf(int x) {
		
		
		for(int i=0; i<num; i++) {
			int idx = (i + front) % max;
			
			if(que[idx] == x) return idx;
		}
		
		return -1;
	}
	
	//초기화
	public void clear() {
		num = front = rear = 0;
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
				int idx = (i + front) % max;
				System.out.print(que[idx] + " ");
			}
			System.out.println();
		}
		
	}
	
	//데이터 검색 (프론트 1 기준)
	public int search(int x) {
		
		for(int i=0; i<num; i++) {
			int idx = (i + front) % max;
			
			if(que[idx] == x) return i+1;
		}
		
		return 0;
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
