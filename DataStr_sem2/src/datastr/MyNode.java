package datastr;

public class MyNode<T> {
	private T element;
	private MyNode next = null;
	private MyNode previous = null;
	
	public MyNode(T element) {
		setElement(element);
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		if (element != null) {
			this.element = element;
		} else {
			element = (T)new Object();
		}
	}

	public MyNode getNext() {
		return next;
	}

	public void setNext(MyNode next) {
		this.next = next;
	}

	public MyNode getPrevious() {
		return previous;
	}

	public void setPrevious(MyNode previous) {
		this.previous = previous;
	}
	
	public String toString() {
		return "" + element;
	}
	

}
