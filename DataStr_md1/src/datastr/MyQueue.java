package datastr;

public class MyQueue<T> {
	private MyNodeQ<T> frontNode, rearNode;
	private int length;
	
	public MyQueue() {
		frontNode = null;
		rearNode = null;
		length = 0;
	}
	
	public boolean isFull() {
		try {
			MyNodeQ<String> temp = new MyNodeQ<String>("Hello World");
			return false;
		} catch (OutOfMemoryError e) {
			return true;
		}
	}
	
	public boolean isEmpty() {
		return (length == 0);
	}
	
	public int numberOfElements() {
		return length;
	}
	
	public void enQueue(T value) {	
		MyNodeQ<T> node = new MyNodeQ<T>(value);
		
		if (isEmpty()) {
			frontNode = node;
		} else {
			rearNode.setNext(node);
		}
		rearNode = node;
		length++;
	}
	
	public T deQueue() throws Exception {
		if (isEmpty()) {
			throw new Exception("Queue is empty!");
		} else {
			T value = frontNode.getData();
			frontNode = frontNode.getNext();
			length--;
			
			return value;
		}
	}
	
	public void print() {
		MyNodeQ curr = frontNode;
		
		while (curr != null) {
			System.out.print(curr.getData() + " ");
			curr = curr.getNext();
		}
		System.out.println();
	}
	
	public void makeEmpty() {
		rearNode = null;
		while (frontNode != null) {
			frontNode = frontNode.getNext();
		}
		length = 0;
	}
	
}
