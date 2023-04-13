package model;

public class Grade {
	
	private long g_ID;
	private int value;
	private Student student;
	private Course course;
	private static long idCounter = 15000;
	
	public Grade() {
		setID();
		setValue(1);
		setCourse(new Course());
		setStudent(new Student());
	}
	
	public Grade(int value, Student student, Course course) {
		setID();
		setValue(value);
		setCourse(course);
		setStudent(student);
	}

	public int getValue() {
		return value;
	}
	
	public Student getStudent() {
		return student;
	}

	public Course getCourse() {
		return course;
	}
	
	public long getID() {
		return g_ID;
	}
	
	public void setValue(int value) {
		if (value > 0 && value <= 10) {
			this.value = value;
		} else {
			this.value = 0;
		}
	}

	public void setStudent(Student student) {
		if (student != null) {
			this.student = student;
		} else {
			this.student = new Student();
		}
	}

	public void setCourse(Course course) {
		if (course != null) {
			this.course = course;
		} else {
			this.course = new Course();
		}
	}
	
	public void setID() {
		this.g_ID = idCounter;
		idCounter++;
	}

	public String toString() {
		return "Grade " + g_ID + ": " + student + " - " + course + ", " + value;
	}
}
