package datastr;

import java.util.EmptyStackException;

public class MyStack<T> {
	private MyNodeS<T> topNode;
	private int length;
	
	public MyStack() {
		topNode = null;
		length = 0;
	}
	
	public boolean isFull() {
		try {
			MyNodeS<String> temp = new MyNodeS<String>("Hello World");
			return false;
		} catch (OutOfMemoryError e) {
			return true;
		}
	}
	
	public boolean isEmpty() {
		return (topNode == null);
	}
	
	public int numberOfElements() {
		return length;
	}

	public void push(T value) throws Exception {
		if (isFull()) {
			throw new Exception("Stack is already full!");
		} else {
			MyNodeS<T> temp = new MyNodeS<T>(value);
			temp.setNext(topNode);
			topNode = temp;
			length++;
		}
	}
	
	public T pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		} else {
			T value = topNode.getData(); 
			topNode = topNode.getNext();
			length--;
			
			return value;
		}
	}
	
	public T top() {
		if (isEmpty()) {
			throw new EmptyStackException();
		} else {
			return topNode.getData();
		}
	}
	
	public void print() {
		MyNodeS curr = topNode;
		
		while (curr != null) {
			System.out.print(curr.getData() + " ");
			curr = curr.getNext();
		}
		System.out.println();
	}
	
	public void makeEmpty() {
		topNode = null;
		length = 0;
	}
	
}
