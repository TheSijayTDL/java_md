package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Random;
import java.util.Scanner;

import datastr.MyDeque;
import datastr.MyQueue;
import datastr.MyStack;
import model.Student;

public class MainService {
	
	public static void main(String args[]) {
		try {
			System.out.println("-----STACK-----");
			MyStack stack = new MyStack();
			System.out.println("Number of elements: " + stack.numberOfElements()); // 0
			stack.push(10); // 10
			stack.push(20); // 20 10
			stack.push(30); // 30 20 10
			stack.push(40); // 40 30 20 10
			System.out.println("Number of elements: " + stack.numberOfElements()); // 4
			System.out.println("Is empty: " + stack.isEmpty()); // false
			System.out.println("Is full: " + stack.isFull()); // false
			System.out.println(stack.top()); // 40
			stack.print(); // 40 30 20 10
			
			System.out.println("Removing: " + stack.pop()); // 40
			System.out.println("Number of elements: " + stack.numberOfElements()); // 3
			stack.print(); // 30 20 10
			
			stack.makeEmpty();
			System.out.println("Number of elements after makeEmpty() " + stack.numberOfElements()); // 0
			stack.print();
			
			System.out.println("-----STACK WITH OBJECTS-----");
			MyStack<Student> student = new MyStack<>();
			System.out.println("Number of elements: " + student.numberOfElements()); // 0
			System.out.println("Is empty: " + student.isEmpty()); // true
			student.push(new Student("Ruslans", "Golubevs", new int[] {10, 9})); // Ruslans Golubevs
			student.push(new Student("Cool", "Guy", new int[] {5, 4})); // Cool Guy, Ruslans Golubevs
			student.push(new Student("Another", "Person", new int[] {6, 7})); // Another Person, Cool Guy, Ruslans Golubevs
			System.out.println("Number of elements: " + student.numberOfElements()); // 3
			System.out.println("Is empty: " + student.isEmpty()); // false
			System.out.println("Is full: " + student.isFull()); // false
			System.out.println(student.top()); // Another Person
			student.print(); // Another Person, Cool Guy, Ruslans Golubevs
			
			System.out.println("Removing: " + student.pop()); // Another Person
			System.out.println("Number of elements: " + student.numberOfElements()); // 2
			student.print(); // Cool Guy, Ruslans Golubevs
			
			System.out.println("-----QUEUE-----");
			MyQueue queue = new MyQueue();
			System.out.println("Number of elements: " + queue.numberOfElements()); // 0
			queue.enQueue(10); // 10
			queue.enQueue(20); // 10 20
			queue.enQueue(30); // 10 20 30
			queue.enQueue(40); // 10 20 30 40
			queue.enQueue(50); // 10 20 30 40 50
			queue.print(); // 10 20 30 40 50
			System.out.println("Number of elements: " + queue.numberOfElements()); // 5
			queue.deQueue(); // 10
			queue.print(); // 20 30 40 50
			System.out.println("Number of elements: " + queue.numberOfElements()); // 4
			queue.makeEmpty();
			queue.print();
			System.out.println("Number of elements after makeEmpty(): " + queue.numberOfElements()); // 0
			
			System.out.println("-----QUEUE WITH OBJECTS-----");
			MyQueue<Student> studentQueue = new MyQueue<>();
			System.out.println("Number of elements: " + studentQueue.numberOfElements()); // 0
			studentQueue.enQueue(new Student("Ruslans", "Golubevs", new int[] {10, 9})); // Ruslans Golubevs
			studentQueue.enQueue(new Student("Cool", "Guy", new int[] {5, 4})); // Ruslans Golubevs, Cool Guy
			studentQueue.enQueue(new Student("Another", "Person", new int[] {6, 7})); // Ruslans Golubevs, Cool Guy, Another Person
			studentQueue.print(); // Ruslans Golubevs, Cool Guy, Another Person
			System.out.println("Number of elements: " + studentQueue.numberOfElements()); // 3
			studentQueue.deQueue(); // Ruslans Golubevs
			studentQueue.print(); // Cool Guy, Another Person
			System.out.println("Number of elements: " + studentQueue.numberOfElements()); // 2
		
			System.out.println("-----DEQUE-----");
			MyDeque deque = new MyDeque();
			System.out.println("Number of elements: " + deque.numberOfElements()); // 0
			deque.enqueueAtEnd(10); // 10
			deque.enqueueAtEnd(20); // 10 20
			deque.enqueueAtEnd(30); // 10 20 30
			deque.enqueueAtFront(40); // 40 10 20 30
			deque.enqueueAtFront(50); // 50 40 10 20 30
			deque.print(); // 50 40 10 20 30
			System.out.println("Number of elements: " + deque.numberOfElements()); // 5
			System.out.println("Deque from front: " + deque.dequeueFromFront()); // 50
			deque.print(); // 40 10 20 30
			System.out.println("Number of elements: " + deque.numberOfElements()); // 4	
			System.out.println("Deque from end: " + deque.dequeueFromEnd()); // 30
			deque.print(); // 40 10 20
			System.out.println("Is empty: " + deque.isEmpty()); // false
			deque.makeEmpty();
			System.out.println("Number of elements after makeEmpty(): " + deque.numberOfElements()); // 0
			System.out.println("Is empty: " + deque.isEmpty()); // true
			
			System.out.println("-----DEQUE WITH OBJECTS-----");
			MyDeque<Student> studentDeque = new MyDeque<>();
			System.out.println("Number of elements: " + studentDeque.numberOfElements()); // 0
			studentDeque.enqueueAtFront(new Student("Ruslans", "Golubevs", new int[] {10, 9})); // Ruslans Golubevs
			studentDeque.enqueueAtFront(new Student("Cool", "Guy", new int[] {5, 4})); // Cool Guy, Ruslans Golubevs
			studentDeque.enqueueAtEnd(new Student("Another", "Person", new int[] {6, 7})); // Cool Guy, Ruslans Golubevs, Another Person
			studentDeque.enqueueAtFront(new Student("Test", "Student", new int[] {3, 4})); // Test Student, Cool Guy, Ruslans Golubevs, Another Person
			studentDeque.enqueueAtEnd(new Student("End", "Student", new int[] {6, 7})); // Test Student, Cool Guy, Ruslans Golubevs, Another Person, End Student
			studentDeque.print(); // Test Student, Cool Guy, Ruslans Golubevs, Another Person, End Student
			System.out.println("Number of elements: " + studentDeque.numberOfElements()); // 5
			System.out.println("Deque from end: " + studentDeque.dequeueFromEnd()); // End Student
			System.out.println("Deque from front: " + studentDeque.dequeueFromFront()); // Test Student
			studentDeque.print(); // Cool Guy, Ruslans Golubevs, Another Person
			System.out.println("Number of elements: " + studentDeque.numberOfElements()); // 3
			System.out.println("Is empty: " + studentDeque.isEmpty()); // false
			studentDeque.makeEmpty();
			System.out.println("Number of elements after makeEmpty(): " + studentDeque.numberOfElements()); // 0
			System.out.println("Is empty: " + studentDeque.isEmpty()); // true
			
			System.out.println("-----STACK: CHECK BRACKETS-----");
			// Some explanation:
			// I really wanted to implement program in the way that brackets inside String are ignored
			// Because of that I made removeBracketsFromStrings(str) function which makes a copy of original file and replaces all Strings with brackets
			// "_temp" files then can be removed with Files.delete() because they are needed only to check if everything is fine with Strings
			// Maybe not the best implementation since it is possible to make one big function instead of two, but...
			// It just works.
			System.out.println("Is everything fine with brackets in: " + checkBrackets("resources/Student.txt"));
			System.out.println("Is everything fine with brackets in: " + checkBrackets("resources/UserController.txt"));
			System.out.println("Is everything fine with brackets in: " + checkBrackets("resources/UserServiceImplTest.txt"));
			
			System.out.println("-----QUEUE: PHONE NUMBER SIMULATION-----");
			//phoneNumberSimulation();
			
			System.out.println("-----DEQUE: BROWSER HISTORY SIMULATION-----");
			browserHistory();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	public static boolean checkBrackets(String str) throws Exception {
		File myFile = new File(removeBracketsFromStrings(str));
	    Reader reader = new FileReader(myFile);
	    MyStack<Character> stack = new MyStack<Character>();
	    
	    int lineNumber = 1;
	    int current;

	    while((current = reader.read()) != -1) {
	    	if (current == '\n') {
	    		lineNumber++;
	    	}
	    	if (current == '{' || current == '(' || current == '[') {	
	    		stack.push((char)current);
	    	}
	    	if (current == '}' || current == ')' || current == ']') {
	    		if (stack.isEmpty()) {
	    			return false;
	    		}
	    		char last = stack.top();
	    		if (current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[') {
	    			stack.pop();
	    		} else { 
	    			System.out.println("Bracket issue: " + closingBracket(stack.top()) + " expected somewhere in the current block below line number " + lineNumber);
	    			return false;
	    		}
	    	}
	    }
	    //Files.delete(myFile.toPath());
	    return stack.isEmpty();  
	}
	
	private static String removeBracketsFromStrings(String str) throws IOException {
		File myFileBrackets = new File(str);
		BufferedWriter writer = null;
	    BufferedReader reader = null;
    	File newFile = new File(str + "_temp");
	    String oldContent = "";
	    
	    try {

	    	Files.copy(myFileBrackets.toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
	    	reader = new BufferedReader(new FileReader(newFile));
	    	String currLine = reader.readLine();

	    	// https://javaconceptoftheday.com/modify-replace-specific-string-in-text-file-in-java/
	    	while (currLine != null) {
	    		oldContent += currLine + System.lineSeparator();
	    		currLine = reader.readLine();
	    	}
	 
	    	String newContent = oldContent.replaceAll("[\"][a-zA-Z0-9 ]*[(){}<>\\[\\]]+[\\s]*[ a-zA-Z0-9(){}<>\\[\\]]*[\"]", "\"String is replaced\"");
	    	writer = new BufferedWriter(new FileWriter(newFile));
	    	writer.write(newContent);
	    	reader.close();
	    	writer.close();
	
	    } catch (IOException e) {
	    	System.out.println("Exception: " + e);
	    } finally {
	    	try {
	    		if (reader != null) {
	    			reader.close();
	    		}
	    		
	    		if (writer != null) {
	    			writer.close();	
	    		}
	    	} catch (IOException e) {
	    		System.out.println("Exception: " + e);
	    	}
	    }
	    return newFile.getPath();
	}
	
	private static char closingBracket(char bracket) {
		if (bracket == '(') return ')';
		else if (bracket == '{') return '}';
		else return ']';
	}
	
	public static void phoneNumberSimulation() throws Exception {
		int phoneNumbers = 5; // the number of phone numbers to generate
		int min = 1000;
		int max = 9999;
		Random rand = new Random();
		MyQueue<String> phoneSimulation = new MyQueue<String>();
		
		for (int i = 0; i < phoneNumbers; i++) {
			Thread.sleep(rand.nextInt(5000));
			System.out.println("New call in the queue!");
			phoneSimulation.enQueue("+371 " + rand.nextInt(max - min + 1) + min);
		}
		System.out.println("Calls in the queue: ");
		phoneSimulation.print();
		
		for (int i = 0; i < phoneNumbers; i++) {
			Thread.sleep(rand.nextInt(5000));
			System.out.println("Answering call: " + phoneSimulation.deQueue());	
			
			if (phoneSimulation.isEmpty()) {
				System.out.println("Queue is empty!");
			}
		}
	}
	
	public static void browserHistory() throws Exception {
		int dataToSave = 10; // the number of entries allowed in deque
		Scanner input = new Scanner(System.in);
		MyDeque<String> savedEntries = new MyDeque<String>();

		while (true) {
			savedEntries.print();
			
			System.out.println("Pattern: (http/https)://website.com");
			System.out.println("Type 1 to remove from front, 0 to end the program");
			System.out.println("Enter a website: ");
			String website = input.nextLine();
			
			if (savedEntries.numberOfElements() >= dataToSave) {
				System.out.println("Removing: " + savedEntries.dequeueFromEnd());
			} 
			else if (website.equals("1")) {
				System.out.println("Removing: " + savedEntries.dequeueFromFront());
				continue;
			} 
			else if (website.equals("0")) {
				System.out.println("End of loop");
				break;
			} 
			// https://stackoverflow.com/questions/3809401/what-is-a-good-regular-expression-to-match-a-url
			else if (website.matches("https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)")) {
					savedEntries.enqueueAtFront(website);	
				} else {
					System.out.println("Website doesn't match the pattern!");
				}
			}
		input.close();
		}
	}

