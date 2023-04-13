package model;

public class Course {
	
	private long c_ID;
	private String title;	// letters, digits and spaces
	private int creditPoints;	// min = 1, max = 20
	private CourseGradeType type;	// not null
	private Professor professor;	// not null
	private static long idCounter = 12000;
	
	public Course() {
		setID();
		setTitle("Unknown");
		setCreditPoints(0);
		setCourseGradeType(CourseGradeType.other);
		setProfessor(new Professor());
	}
	
	public Course(String title, int creditPoints, CourseGradeType type, Professor professor) {
		setID();
		setTitle(title);
		setCreditPoints(creditPoints);
		setCourseGradeType(type);
		setProfessor(professor);
	}

	public String getTitle() {
		return title;
	}
	
	public int getCreditPoints() {
		return creditPoints;
	}
	
	public CourseGradeType getCourseGradeType() {
		return type;
	}
	
	public Professor getProfessor() {
		return professor;
	}

	public long getID() {
		return c_ID;
	}
	
	public void setTitle(String title) {
		if (title != null && title.matches("[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ\\s]+")) {
			this.title = title;
		} else {
			this.title = "Unknown";
		}
	}

	public void setCreditPoints(int creditPoints) {
		if (creditPoints > 0 && creditPoints <= 20) {
			this.creditPoints = creditPoints;
		} else {
			creditPoints = 0;
		}
	}
	
	public void setCourseGradeType(CourseGradeType type) {
		if (type != null) {
			this.type = type;
		} else {
			this.type = CourseGradeType.other;
		}
	}

	public void setProfessor(Professor professor) {
		if (professor != null) {
			this.professor = professor;
		} else {
			this.professor = new Professor();
		}
	}
	
	public void setID() {
		this.c_ID = idCounter;
		idCounter++;
	}

	public String toString() {
		return "" + c_ID + ": " + title + " (" + creditPoints + ") " + type + ", " + professor.getName() + " " + professor.getSurname();
	}
}
