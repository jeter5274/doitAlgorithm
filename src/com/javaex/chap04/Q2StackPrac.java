package com.javaex.chap04;

public class Q2StackPrac<E> {

	private int max;			//스택의 크기
	private int stackPoint;		//데이터 위치
	private E[] stack;		//스택배열
	
	//스택 생성자
	public Q2StackPrac(int capacity) {
		
		stackPoint = 0;
		max = capacity;
		try {
			stack = (E[]) new Object[max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
		
	}
	
	//스택에 데이터 추가
	public E push(E x) throws OverflowEStackException{
		
		if( stackPoint >= max ) throw new OverflowEStackException();
		
		return stack[stackPoint++] = x;
	}
	
	//스택에서 데이터 제거
	public E pop() throws EmptyEStackException{
		
		if( stackPoint <= 0 ) throw new EmptyEStackException();
		return stack[--stackPoint];
		
	}
	
	//스택에서 top데이터를 확인
	public E peek() throws EmptyEStackException{
		
		if( stackPoint <= 0 ) throw new EmptyEStackException();
		
		return stack[stackPoint-1];
		
	}
	
	//스택에 값이 있는지 확인
	public int indexOf(E value) {
		
		for(int i=stackPoint-1; i>=0; i--) {
			if(stack[i] == value) return i;
		}
		
		return -1;
		
	}
	//스택을 비움
	public void clear() {
		stackPoint = 0;
	}
	
	//스택 용량확인
	public int capacity() {
		return max;
	}
	
	//스택의 데이터 수 확인
	public int size() {
		return stackPoint;
	}
	
	//스택이 비어 있는지 확인
	public boolean isEmpty() {
		
		/*
		if( stackPoint == 0 ) return true;

		return false;
		*/
		
		return stackPoint <= 0;
	}
	
	//스택이 가득 차 있는지 확인
	public boolean isFull() {
		
		/*
		if( stackPoint == max-1 ) return true;

		return false;
		*/
		
		return stackPoint >= max;
	}
	
	//스택의 데이터 출력 bottom -> top 순
	public void dump() {
		
		if(isEmpty()) System.out.println("스택이 비어 있습니다.");
		else {
			for(int i=0; i<stackPoint; i++) {
				System.out.print(stack[i]+ " ");
			}
			System.out.println();
		}
	}
	
	//스택이 비어있을 떄의 오류
	@SuppressWarnings("serial")	//serial warnings를 무시
	static class EmptyEStackException extends RuntimeException{
		
		public EmptyEStackException() {}
		
	}
	
	//스택이 가득 찻을 때의 오류
	@SuppressWarnings("serial") //serial warnings를 무시
	static class OverflowEStackException extends RuntimeException{
		
		public OverflowEStackException() {}
		
	}

	
}
