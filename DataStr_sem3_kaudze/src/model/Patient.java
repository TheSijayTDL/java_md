package model;

public class Patient implements Comparable<Patient>{
	
	private String name;
	private String surname;
	private int prio;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getPrio() {
		return prio;
	}
	public void setPrio(int prio) {
		this.prio = prio;
	}
	
	public Patient()
	{
		setName("Unknown");
		setSurname("Unknown");
		setPrio(1);
	}
	public Patient(String name, String surname, int prio) {
		this.name = name;
		this.surname = surname;
		this.prio = prio;
	}
	@Override
	public String toString() {
		return "Patient [name=" + name + ", surname=" + surname + ", prio=" + prio + "]";
	}
	@Override
	public int compareTo(Patient o) {
		if(prio > o.prio) {
			return 1;
		}
		else if (prio < o.prio) {
			return -1;
		}
		else
		{
			return 0;
		}
	}
	
	

}
