package datastr;

public class MyLinkedList<T> {
	private MyNode first = null;
	private MyNode last = null;
	private int elementCounter = 0;
	
	// we will use no-args constructor from Object class
	// TODO isFull, isEmpty, howManyElements
	
	public void add(T element) {
		// TODO verify it is not full
		
		// list is empty
		if (elementCounter == 0) {
			MyNode<T> newNode = new MyNode<T>(element);
			first = newNode;
			last = newNode;
			elementCounter++;
		} else {
			MyNode<T> newNode = new MyNode<T>(element);
			last.setNext(newNode);
			newNode.setPrevious(last);
			last = newNode;
			elementCounter++;
		}
	}
	
	public void add(T element, int position) throws Exception {
		// TODO verify it is not full
		
		if (position < 0 || position >= elementCounter) {
			throw (new Exception("Wrong position"));
		}
		
		// add at the beginning
		if (position == 0) {
			MyNode<T> newNode = new MyNode<T>(element);
			first.setPrevious(newNode);
			newNode.setNext(first);
			first = newNode;
			elementCounter++;
		}
		// add at the end
		else if (position == elementCounter) {
			add(element);
			// add in the middle
		} else {
			MyNode tempNode = first;
			for (int i = 0; i < position - 1; i++) {
				tempNode = tempNode.getNext();
			}
			MyNode tempNode2 = tempNode.getNext();
			MyNode<T> newNode = new MyNode<T>(element);
			
			tempNode.setNext(newNode);
			newNode.setPrevious(tempNode);
			
			tempNode2.setPrevious(newNode);
			newNode.setNext(tempNode2);
			elementCounter++;
		}
	}
	
	public void remove(int position) {
		// TODO verify if list is empty
		// TODO verify if position is wrong
		
		// remove from the beginning
		if (position == 0) {
			first = first.getNext();
			first.setPrevious(null);
			elementCounter--;
		}
		
		// remove from the end
		else if (position == elementCounter - 1) {
			last = last.getPrevious();
			last.setNext(null);
			elementCounter--;
		}
		// remove from the middle
		else {
			MyNode tempNode = first;
			
			for (int i = 0; i < position; i++) {
				tempNode = tempNode.getNext();
			}
			MyNode tempNodePrevious = tempNode.getPrevious();
			MyNode tempNodeNext = tempNode.getNext();
			tempNodePrevious.setNext(tempNodeNext);
			tempNodeNext.setPrevious(tempNodePrevious);
			elementCounter--;
		}
	}
	
	// TODO makeEmpty()
	// TODO sort(), retrieve(), search(), retrieveNextNeigbours()
	
	public void print() {
		// TODO verify if list is empty
		
		MyNode tempNode = first;
		while (tempNode != null) {
			System.out.print(tempNode.getElement() + " ");
			tempNode = tempNode.getNext();
		}
		System.out.println();
	}
}
