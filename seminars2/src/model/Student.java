package model;

public class Student extends Person {
	
	private long st_ID;
	private Faculty faculty;
	private static long idCounter = 0;
	
	public Student() {
		super(); // calls Person()
		setID();
		setFaculty(Faculty.other);
	}
	
	public Student(String name, String surname, Faculty faculty, String personCode) {
		super(name, surname, personCode);
		setID();
		setFaculty(faculty);
	}
	
	public long getID() {
		return st_ID;
	}
	
	public Faculty getFaculty() {
		return faculty;
	}
	
	public void setFaculty(Faculty faculty) {
		if (faculty != null) {
			this.faculty = faculty;
		} else {
			this.faculty = Faculty.other;
		}
	}
	
	public void setID() {
		this.st_ID = idCounter;
		idCounter++;
	}
	
	public String toString() {
		return "" + st_ID + ": " + super.toString() + ", " + faculty;
	}
}

