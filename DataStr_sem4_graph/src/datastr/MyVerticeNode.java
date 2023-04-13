package datastr;

public class MyVerticeNode<T> {
	private T element;
	private MyEdgeNode firstEdge = null;
	
	public MyVerticeNode(T element) {
		setElement(element);
	}
	
	public T getElement() {
		return element;
	}
	
	public void setElement(T element) {
		if (element != null) {
			this.element = element;
		} else {
			this.element = (T)new Object();
		}
	}
	
	public MyEdgeNode getFirstEdge() {
		return firstEdge;
	}
	
	public void setFirstEdge(MyEdgeNode firstEdge) {
		this.firstEdge = firstEdge;
	}
	
	public String toString() {
		return "" + element;
	}
	
	
}
