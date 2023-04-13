package model;

public class Student implements Comparable<Student> {
	
	private long st_ID;
	private String name;
	private String surname;
	private Faculty faculty;
	private String personCode;
	private static long idCounter = 0;
	
	public Student() {
		setID();
		setName("Unknown");
		setSurname("Unknown");
		setFaculty(Faculty.other);
		setPersonCode("000000-00000");
	}
	
	public Student(String name, String surname, Faculty faculty, String personCode) {
		setID();
		setName(name);
		setSurname(surname);
		setFaculty(faculty);
		setPersonCode(personCode);
	}

	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public long getID() {
		return st_ID;
	}
	
	public Faculty getFaculty() {
		return faculty;
	}
	
	public String getPersonCode() {
		return personCode;
	}
	// regex101.com
	public void setName(String name) {
		if (name != null && name.matches("[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]+[ ]?([A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]+)?")) {
			this.name = name;
		} else {
			this.name = "Unknown";
		}
	}

	public void setSurname(String surname) {
		if (surname != null && surname.matches("[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]+")) {
			this.surname = surname;
		} else {
			this.surname = "Unknown";
		}
	}
	
	public void setFaculty(Faculty faculty) {
		if (faculty != null) {
			this.faculty = faculty;
		} else {
			this.faculty = Faculty.other;
		}
	}
	
	public void setPersonCode(String personCode) {
		// new personCode 32{1}[0-9]{9}
		if (personCode != null && personCode.matches("[0-9]{6}[-]{1}[0-9]{5}")) {
			this.personCode = personCode;
		} else {
			this.personCode = "000000-00000";
		}
	}
	
	public void setID() {
		this.st_ID = idCounter;
		idCounter++;
	}

	public String toString() {
		return "Student " + st_ID + ": " + name + " " + surname + ", " + personCode + ", " + faculty;
	}

	@Override
	public int compareTo(Student o) {
		if (surname.charAt(0) > o.surname.charAt(0)) {
			return 1;
		} 
		else if (surname.charAt(0) < o.surname.charAt(0)) {
			return -1;
		} else {
			return 0;
		}
	}
}
