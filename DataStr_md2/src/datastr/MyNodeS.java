package datastr;

public class MyNodeS<T> {
	private T data;
	private MyNodeS next = null;
	
	public MyNodeS(T data) {
		setData(data);
	}

	public T getData() {
		return data;
	}
	
	public MyNodeS getNext() {
		return next;
	}

	public void setData(T data) {
		if (data != null) {
			this.data = data;
		} else {
			this.data = (T)new Object();
		}
	}

	public void setNext(MyNodeS next) {
		this.next = next;
	}

	public String toString() {
		return "" + data;
	}
}
