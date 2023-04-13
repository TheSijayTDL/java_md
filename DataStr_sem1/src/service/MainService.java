package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import datastr.MyArrayList;
import datastr.SortingType;
import model.Faculty;
import model.Student;

public class MainService {
	
	public static void main(String args[]) {
		MyArrayList charList = new MyArrayList();
		try {
			charList.add('a'); // a
			charList.add('f'); // a f
			charList.add('b'); // a f b
			charList.add('z', 0); // z a f b
			charList.print(); // z a f b
			System.out.println(charList.numberOfElements());
			charList.deleteFromIndex(1);
			charList.print(); // z f b
			System.out.println(charList.retrieve(1)); // f
			System.out.println("Search: " + charList.search('b')); // true
			charList.add('d'); // z f b d
			charList.add('z'); // z f b d z
			charList.add('a'); // z f b d z a
			charList.add('z'); // z f b d z a z increaseArrayList() called
			System.out.println(Arrays.toString(charList.retrieveNextNeighbours('z'))); // f a
			System.out.println(charList.sort(SortingType.ASC)); // a b d f z z z
			charList.print();
			charList.makeEmpty();
			charList.print();
			charList.add('d'); // d
			charList.print();
			
			System.out.println("-----------------");
			MyArrayList fileList = getArrayElementsFromFile("resources/numbers.txt");
			fileList.print();
			fileList.add('z');
			fileList.deleteFromIndex(2);
			fileList.print();
			System.out.println(Arrays.toString(fileList.sort(SortingType.ASC)));
			
			MyArrayList<String> stringList = new MyArrayList<>();
			stringList.add("Karina");
			stringList.add("Janis");
			stringList.add("Zanis", 0);
			stringList.print();
			System.out.println(Arrays.toString(stringList.sort(SortingType.DESC)));
			stringList.deleteFromIndex(1);
			stringList.print();
			
			MyArrayList<Student> studentList = new MyArrayList<>();
			studentList.add(new Student("Janis", "Berzins", Faculty.EPF, "123456-12345"));
			studentList.add(new Student("Laine", "Jauka", Faculty.ITF, "123546-12125"));
			studentList.add(new Student("Peteris", "Forsais", Faculty.EPF, "125456-12125"));
			studentList.print();
			studentList.add(new Student("Gatis", "Nejaukais", Faculty.EPF, "625456-72125"), 0);
			studentList.print();
			studentList.deleteFromIndex(1);
			studentList.print();
			
			System.out.println(Arrays.toString(studentList.sort(SortingType.DESC)));
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public static MyArrayList getArrayElementsFromFile(String path) throws FileNotFoundException {
		File myFile = new File(path);
		FileInputStream myInputStream = new FileInputStream(myFile);
		Scanner myScanner = new Scanner(myInputStream);
		MyArrayList listFromFile = new MyArrayList();	
		
		while (myScanner.hasNextLine()) {
			String line = myScanner.nextLine();
			char element = line.charAt(0);
			listFromFile.add(element);
		}
		myScanner.close();
		return listFromFile;
	}
}
