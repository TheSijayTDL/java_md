package datastr;

public class MyHeap<T> {
	private T[] elements;
	private final int DEFAULT_ARRAY_SIZE = 10;
	private int arraySize = DEFAULT_ARRAY_SIZE;
	private int elementCounter = 0;
	
	public MyHeap() {
		elements = (T[]) new Object[arraySize];
	}
	
	public MyHeap(int arraySize) {
		if (arraySize > 0) {
			this.arraySize = arraySize;
		}
		elements = (T[]) new Object[arraySize];
	}
	
	// TODO isFull, isEmpty, howManyElements, increaseArray
	
	public int howManyElements() {
		return elementCounter;
	}
	
	public boolean isFull() {
		return elementCounter == arraySize;
	}
	
	public boolean isEmpty() {
		return elementCounter == 0;
	}
	
	public void increaseArray() {
		int newArraySize = (elementCounter > 100) ? (int)(arraySize * 1.5) : arraySize * 2;
		arraySize = newArraySize;
		T[] newElements = (T[]) new Object[arraySize];
		
		for (int i = 0; i < elementCounter; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
	}
	
	public void add(T element) {
		if (isFull()) {
			increaseArray();
		}
		elements[elementCounter++] = element;
		reHeapUp(elementCounter - 1);
	}
	
	public T remove() throws Exception {
		if (isEmpty()) {
			throw (new Exception("Heap is empty"));
		}
		T element = elements[0];
		elements[0] = elements[elementCounter - 1];
		elements[elementCounter] = null;
		elementCounter--;
		reHeapDown(0);
		return element;
	}
	
	private void reHeapUp(int index) {
		// rightChIndex = parentIndex * 2 + 2
		// leftChIndex = parentIndex * 2 + 1
		
		// (rightChIndex - 2) / 2 = parentIndex
		// (leftChIndex - 1) / 2 = parentIndex
		
		// (4 - 2) / 2 = 1 -> (4 - 1) / 2 = 3 / 2 = 1.5 -> (int)1.5 = 1
		// (3 - 1) / 2 = 1
		int indexOfParent = (int)((index - 1) / 2);
		
		if (indexOfParent >= 0) {
			if (((Comparable)(elements[index])).compareTo(elements[indexOfParent]) > 0) {
				swap(index, indexOfParent);
				reHeapUp(indexOfParent);
			}
		}
	}
	
	private void swap(int i, int j) {
		T temp = elements[i];
		elements[i] = elements[j];
		elements[j] = temp;
	}
	
	private void reHeapDown(int index) {
		// find out both children indexes
		int rightChIndex = index * 2 + 2;
		int leftChIndex = index * 2 + 1;
		// only left child
		if (leftChIndex < elementCounter && rightChIndex >= elementCounter) {
			// compare element with left child, if necessary swap it
			if (((Comparable)(elements[leftChIndex])).compareTo(elements[index]) > 0) {
				swap(leftChIndex, index);
			}
		}
		// has two children
		else if (leftChIndex < elementCounter && rightChIndex < elementCounter) {
			// find out the largest child
			// left child is larger
			if (((Comparable)(elements[leftChIndex])).compareTo(elements[rightChIndex]) > 0) {
				if (((Comparable)(elements[leftChIndex])).compareTo(elements[index]) > 0) {
					swap(leftChIndex, index);
					reHeapDown(leftChIndex);
				}
				// right child is larger
			} else {
				if (((Comparable)(elements[rightChIndex])).compareTo(elements[index]) > 0) {
					swap(rightChIndex, index);
					reHeapDown(rightChIndex);
				}
			}
			// compare element with the largest child and if necessary swap it
			// call this function again (recursion)
		}
	}
	
	public void print() {
		if (isEmpty()) {
			System.out.println("Heap is empty!");
		} else {
			for (int i = 0; i < elementCounter; i++) {
				System.out.print(elements[i] + " ");
			}
		}
		
	}
	
	public void makeEmpty() {
		arraySize = DEFAULT_ARRAY_SIZE;
		elementCounter = 0;
		elements = (T[]) new Object[arraySize];
		System.gc();
	}
	
	public void printByPrefix() {
		if (isEmpty()) {
			System.out.println("Heap is empty!");
		} else {
			printByPrefixHelper(0);
		}	
		System.out.println();
	}
	
	private void printByPrefixHelper(int index) {
		int rightChIndex = index * 2 + 2;
		int leftChIndex = index * 2 + 1;
		// ROOT - LEFT - RIGHT
		// ROOT
		System.out.print(" Parent: " + elements[index]);
		// lEFT
		if (leftChIndex < elementCounter) {
			System.out.print("; LeftCh: " + elements[leftChIndex]);
			printByPrefixHelper(leftChIndex);
		}
		if (rightChIndex < elementCounter) {
			System.out.print("; RightCh: " + elements[rightChIndex]);
			printByPrefixHelper(rightChIndex);
		}
	}
	
	// TODO print postfix
	// TODO print inOrder
}
