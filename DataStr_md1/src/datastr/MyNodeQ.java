package datastr;

public class MyNodeQ<T> {
	private T data;
	private MyNodeQ next = null;
	
	public MyNodeQ(T data) {
		setData(data);
	}

	public T getData() {
		return data;
	}
	
	public MyNodeQ getNext() {
		return next;
	}

	public void setData(T data) {
		if (data != null) {
			this.data = data;
		} else {
			this.data = (T)new Object();
		}
	}

	public void setNext(MyNodeQ next) {
		this.next = next;
	}

	public String toString() {
		return "" + data;
	}
}