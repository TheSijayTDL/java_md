package datastr;

public class MyDeque<T> {
	private MyNodeD<T> frontNode, rearNode;
	private int length;
	
	public MyDeque() {
		frontNode = null;
		rearNode = null;
		length = 0;
	}
	
	public boolean isFull() {
		try {
			MyNodeD<String> temp = new MyNodeD<String>("Hello World");
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
	
	public void enqueueAtFront(T value) {	
		MyNodeD<T> node = new MyNodeD<T>(value);
		
		if (isEmpty()) {
			frontNode = node;
			rearNode = node;
		} else {
			node.setNext(frontNode);
			frontNode.setPrev(node);
			frontNode = node;
		}
		length++;
	}
	
	public void enqueueAtEnd(T value) {	
		MyNodeD<T> node = new MyNodeD<T>(value);
		
		if (isEmpty()) {
			frontNode = node;
			rearNode = node;
		} else {
			node.setPrev(rearNode);
			rearNode.setNext(node);
			rearNode = node;
		}
		length++;
	}
	
	public T dequeueFromFront() throws Exception {	
		if (isEmpty()) {
			throw new Exception("Deque is empty!");
		} else {
			T value = frontNode.getData();
			frontNode = frontNode.getNext();
			if (frontNode == null) {
				rearNode = null;
			} else {
				frontNode.setPrev(null);
			}
			length--;
			
			return value;
		}
	}
	
	public T dequeueFromEnd() throws Exception {	
		if (isEmpty()) {
			throw new Exception("Deque is empty!");
		} else {
			T value = rearNode.getData();
			rearNode = rearNode.getPrev();
			if (rearNode == null) {
				frontNode = null;
			} else {
				rearNode.setNext(null);
			}
			length--;
			
			return value;
		}
	}
	
	public void print() {
		MyNodeD curr = frontNode;
		
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