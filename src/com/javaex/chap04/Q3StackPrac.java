package com.javaex.chap04;

public class Q3StackPrac {

	private int max;			//스택의 크기
	private int stackAPoint;	//스택 A 데이터 위치
	private int stackBPoint;	//스택 A 데이터 위치
	private int[] stack;		//스택배열
	
	//스택 생성자
	public Q3StackPrac(int capacity) {
		
		stackAPoint = 0;
		stackBPoint = capacity-1;
		max = capacity;
		try {
			stack = new int[max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
		
	}
	
	//스택에 데이터 추가
	public int push(String ab, int x) throws OverflowInStackException{
		
		if( stackAPoint >= stackBPoint+1 ) throw new OverflowInStackException();
		
		if("A".equals(ab.toUpperCase())) stack[stackAPoint++] = x;
		else if("B".equals(ab.toUpperCase())) stack[stackBPoint--] = x;
		return x;
		
	}
	
	//스택에서 데이터 제거
	public int pop(String ab) throws EmptyInStackException{
		
		int result = 0;
		
		if("A".equals(ab.toUpperCase())) {
			if( stackAPoint <= 0 ) throw new EmptyInStackException();
			result = stack[--stackAPoint];
		}else if("B".equals(ab.toUpperCase())) {
			if( stackBPoint >= max-1 ) throw new EmptyInStackException();
			result = stack[++stackBPoint];
		}		
		return result;
	
	}
	
	//스택에서 top데이터를 확인
	public int peek(String ab) throws EmptyInStackException{
		
		int result = 0;
		
		if("A".equals(ab.toUpperCase())) {
			if( stackAPoint <= 0 ) throw new EmptyInStackException();
			result = stack[stackAPoint-1];
		}else if("B".equals(ab.toUpperCase())) {
			if( stackBPoint >= max-1 ) throw new EmptyInStackException();
			result = stack[stackBPoint+1];
		}		
		return result;
		
	}
	
	//스택에 값이 있는지 확인
	public int indexOf(String ab, int value) {
				
		if("A".equals(ab.toUpperCase())) {
			for(int i=stackAPoint-1; i>=0; i--) {
				if(stack[i] == value) return i;
			}
		}else if("B".equals(ab.toUpperCase())) {
			for(int i=stackBPoint-1; i<max; i++) {
				if(stack[i] == value) return i;
			}
		}		
		
		return -1;
		
	}
	//스택을 비움
	public void clear() {
		stackAPoint = 0;
		stackBPoint = max-1;
	}
	
	//스택 용량확인
	public int capacity() {
		return max;
	}
	
	//스택의 데이터 수 확인
	public int size(String ab) {
		
		int result = 0;
		
		if("A".equals(ab.toUpperCase())) {
			result = stackAPoint;
		}else if("B".equals(ab.toUpperCase())) {
			result = max - stackBPoint -1;
		}		
		return result;
	}
	
	//스택이 비어 있는지 확인
	public boolean isEmpty(String ab) {
		
		boolean result = true;
		
		if("A".equals(ab.toUpperCase())) {
			result = stackAPoint <= 0;
		}else if("B".equals(ab.toUpperCase())) {
			result = stackBPoint >= max-1;
		}
		
		return result;
		
	}
	
	//스택이 가득 차 있는지 확인
	public boolean isFull() {
		return stackAPoint >= stackBPoint+1;
	}
	
	//스택의 데이터 출력 bottom -> top 순
	public void dump(String ab) {
		
		if("A".equals(ab.toUpperCase())) {
			if(isEmpty("A")) System.out.println("스택이 비어 있습니다.");
			else {
				for(int i=0; i<stackAPoint; i++) {
					System.out.print(stack[i]+ " ");
				}
				System.out.println();
			}
		}else if("B".equals(ab.toUpperCase())) {	
			if(isEmpty("B")) System.out.println("스택이 비어 있습니다.");
			else {
				for(int i=max-1; i>stackBPoint; i--) {
					System.out.print(stack[i]+ " ");
				}
				System.out.println();
			}
		}
	}
	
	//스택이 비어있을 떄의 오류
	@SuppressWarnings("serial")	//serial warnings를 무시
	class EmptyInStackException extends RuntimeException{
		
		public EmptyInStackException() {}
		
	}
	
	//스택이 가득 찻을 때의 오류
	@SuppressWarnings("serial") //serial warnings를 무시
	class OverflowInStackException extends RuntimeException{
		
		public OverflowInStackException() {}
		
	}

	
}
