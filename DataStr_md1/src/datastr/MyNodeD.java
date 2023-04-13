package datastr;

public class MyNodeD<T> {
	private T data;
	private MyNodeD prev, next = null;
	
	public MyNodeD(T data) {
		setData(data);
	}

	public T getData() {
		return data;
	}
	
	public MyNodeD getPrev() {
		return prev;
	}
	
	public MyNodeD getNext() {
		return next;
	}

	public void setData(T data) {
		if (data != null) {
			this.data = data;
		} else {
			this.data = (T)new Object();
		}
	}
	
	public void setPrev(MyNodeD prev) {
		this.prev = prev;
	}

	public void setNext(MyNodeD next) {
		this.next = next;
	}

	public String toString() {
		return "" + data;
	}
}