package datastr;

public class MyArrayList<T> {
	private T[] elements;
	private final int DEFAULT_ARRAY_SIZE = 6;
	private int arraySize = DEFAULT_ARRAY_SIZE;
	private int elementCounter = 0;

	public MyArrayList() {
		elements = (T[]) new Object[arraySize];
	}
	
	public MyArrayList(int arraySize) {
		if (arraySize > 0) {
			this.arraySize = arraySize;
		}
		elements = (T[]) new Object[arraySize];
	}
	
	public boolean isFull() {
		return (elementCounter == arraySize);
	}	
	
	public boolean isEmpty() {
		return (elementCounter == 0);
	}
	
	public int numberOfElements() {
		return elementCounter;
	}
	
	public void increaseArrayList() {
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
			increaseArrayList();
		}
		elements[elementCounter++] = element;
	}
	
	public void add(T newElement, int index) throws Exception{
		if(index >= 0 && index <= elementCounter ) {
			if(index == elementCounter) {
				add(newElement);
			} else {
				if(isFull()) {
					increaseArrayList();
				}
				for(int i = elementCounter; i > index; i--) {
					elements[i] = elements[i-1];
				}
				elements[index] = newElement;
				elementCounter++;
			}

		}
		else
		{
			throw (new Exception("Wrong index"));
		}
	}
	
	public void deleteFromIndex(int index) throws Exception {
		//2. verify isEmpty
		if(isEmpty()) {
			throw (new Exception("Array is empty and it is not possible to remove elements"));
		}
		else
		{
	//3. verify the index - is it not appropriate
			if(index < 0 || index >= elementCounter) {
				throw (new Exception("Wrong index"));
			}
			else
			{
				//4. copy elements from index to end
				for(int i = index; i < elementCounter-1; i++)
				{
					elements[i] = elements[i+1];
				}
				//5. initialize the last element with NUL symbol (int value is 0)
				elements[elementCounter-1] = null; //NUL symbol

				//6. decrease elementCounter
				elementCounter--;
				
				//for optimization
				//elements[--elementCounter] = 0;
			}
		}
	}
	// TODO check method
	public T retrieve(int index) throws Exception {
		if (isEmpty()) {
			throw (new Exception("List is empty!"));
		}
		else if (index < 0 || index >= elementCounter) {
			throw (new Exception("Not a valid index"));
		}
		return elements[index];
	}
	// TODO check method
	public boolean search(T element) throws Exception {
		for(int i = 0; i < elementCounter; i++) {
			if(elements[i].equals(element)) {
				return true;
			}
		}
		return false;
	}
	
	public T[] retrieveNextNeighbours(T element) throws Exception {
		if (search(element)) {
			int howManyElements = 0;
			for (int i = 0; i < elementCounter; i++) {
				if (elements[i].equals(element)) {
					howManyElements++;
				}
			}
			if (elements[elementCounter - 1].equals(element)) {
				howManyElements--;
			}
			T[] nextNeighbours = (T[]) new Object[howManyElements];
			int indexForNeighbors = 0;
			for (int i = 0; i < elementCounter - 1; i++) {
				if (elements[i].equals(element)) {
					nextNeighbours[indexForNeighbors] = elements[i + 1];
					indexForNeighbors++;
				}
			}
			return nextNeighbours;
		} else {
			throw (new Exception("Input element is not found in the list!"));
		}
	}
	
	public T[] sort(SortingType type) throws Exception {
		if (isEmpty()) {
			throw new Exception("List is empty!");
		} else {
			T[] sortArray = (T[]) new Object[elementCounter];	
			
			for (int i = 0; i < elementCounter; i++) {
				sortArray[i] = elements[i];
			}
			
			int sortVariable = 1; //DESC
			if (type == SortingType.ASC) {
				sortVariable = -1;
			}
			
				for (int i = 0; i < elementCounter; i++) {
					for (int j = 0; j < elementCounter; j++) {
						//if (sortArray[i] > sortArray[j]) {
						if ( ((Comparable)(sortArray[i])).compareTo(sortArray[j]) > 0 ) {
							T temp = sortArray[i];
							sortArray[i] = sortArray[j];
							sortArray[j] = temp;
						}
					}
				}
				return sortArray;
			}
	}
	
	public void print() {
		if (isEmpty()) {
			System.out.println("List is empty!");
		} else {
			for (int i = 0; i < elementCounter; i++) {
				System.out.print(elements[i] + " ");
			}
			System.out.println();
		}
	}
	
	public void makeEmpty() {
		arraySize = DEFAULT_ARRAY_SIZE;
		elementCounter = 0;
		elements = (T[]) new Object[arraySize];
	}
	
}
