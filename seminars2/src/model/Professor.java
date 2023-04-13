package model;

public class Professor extends Person {
	
	private long p_ID;
	private Degree degree;
	private static long idCounter = 10000;
	
	public Professor() {
		super();
		setID();
		setDegree(Degree.other);
	}
	
	public Professor(String name, String surname, String personCode, Degree degree) {
		super(name, surname, personCode);
		setID();
		setDegree(degree);
	}

	public Degree getDegree() {
		return degree;
	}
	
	public long getID() {
		return p_ID;
	}

	public void setDegree(Degree degree) {
		if (degree != null) {
			this.degree = degree;
		} else {
			this.degree = Degree.other;
		}
	}
	
	public void setID() {
		this.p_ID = idCounter;
		idCounter++;
	}

	public String toString() {
		return "" + p_ID + ": " + super.toString() + ", " + degree;
	}	
}
