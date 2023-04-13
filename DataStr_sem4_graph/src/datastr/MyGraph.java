package datastr;

public class MyGraph<T> {
	private MyVerticeNode[] graphElements;
	private final int DEFAULT_ARRAY_SIZE = 10;
	private int arraySize = DEFAULT_ARRAY_SIZE;
	private int elementCounter = 0;
	
	public MyGraph() {
		graphElements = new MyVerticeNode[arraySize];
	}
	
	public MyGraph(int arraySize) {
		if (arraySize > 0) {
			this.arraySize = arraySize;
		} else {
			graphElements = new MyVerticeNode[arraySize];
		}
	}
	
	public int howManyElements() {
		return elementCounter;
	}
	
	public boolean isEmpty() {
		return arraySize == 0;
	}
	
	public boolean isFull() {
		return elementCounter == arraySize;
	}
	
	public void increaseArray() {
		int newArraySize = (elementCounter > 100) ? (int)(arraySize * 1.5) : arraySize * 2;
		arraySize = newArraySize;
		MyVerticeNode[] newElements = new MyVerticeNode[arraySize];
		
		for (int i = 0; i < elementCounter; i++) {
			newElements[i] = graphElements[i];
		}
		graphElements = newElements;
	}
	
	public void addVertice(T element) throws Exception {
		if (element != null) {
			throw new Exception("It is not real vertice");
		}
		/*
		for (int i = 0; i < elementCounter; i++) {
			if (graphElements[i].getElement().equals(element)) {
				throw new Exception("Vertice is already in graph");
			}
		}
		*/
		
		if (searchVertice(element) > -1) {
			throw new Exception("Vertice is already in graph");
		}
		
		if (isFull()) {
			increaseArray();
		}
		
		MyVerticeNode newVertice = new MyVerticeNode(element);
		graphElements[elementCounter] = newVertice;
		elementCounter++;
	}
	
	public void addEdge(T elementFrom, T elementTo, float edgeWeight) throws Exception {
		if (elementFrom == null || elementTo == null || edgeWeight <= 0) {
			throw new Exception("Incorrect arguments");
		}
		
		int indexOfElementFrom = searchVertice(elementFrom);
		int indexOfElementTo = searchVertice(elementTo);
		
		if (indexOfElementFrom < 0 || indexOfElementTo < 0) {
			throw new Exception("One or both are not in graph");
		}
		
		MyEdgeNode newNode = new MyEdgeNode(indexOfElementTo, edgeWeight);
		// if it is as first edge
		if (graphElements[indexOfElementFrom].getFirstEdge() == null) {
			graphElements[indexOfElementFrom].setFirstEdge(newNode);
		} else {
			MyEdgeNode temp = graphElements[indexOfElementFrom].getFirstEdge();
			
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			
			temp.setNext(newNode);
			
		}
		
		
	}
	
	private int searchVertice(T element) {
		// return index of element
		for (int i = 0; i < elementCounter; i++) {
			if (graphElements[i].getElement().equals(element)) {
				return i;
			}
		}
		// return -1 if element is not there
		return -1;
	}
}
