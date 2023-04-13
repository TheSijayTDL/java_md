package service;

import datastr.MyLinkedList;

public class MainService {

	public static void main(String[] args) {
		try {
			MyLinkedList<String> stringList = new MyLinkedList<>();
			stringList.add("Karina"); // Karina
			stringList.add("Janis"); // Karina Janis
			stringList.print();	// Karina Janis
			stringList.add("Jana", 0);	// Jana Karina Janis
			stringList.print();	// Jana Karina Janis
			stringList.add("Liga", 2); // Jana Karina Liga Janis
			stringList.print(); // Jana Karina Liga Janis	
			
			System.out.println("-----REMOVE-------");
			stringList.remove(0); // Karina Liga Janis 
			stringList.print(); // Karina Liga Janis
			stringList.remove(1); // Karina Janis
			stringList.print(); // Karina Janis
			stringList.remove(1); // Karina
			stringList.print(); // Karina
			stringList.remove(0); // empty
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
