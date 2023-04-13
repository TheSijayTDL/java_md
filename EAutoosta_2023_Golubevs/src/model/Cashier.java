package model;

import java.time.LocalDate;

public class Cashier extends Employee {
	private long id;
	private static long idCounter = 0;
	
	public Cashier() {
		super(); 
		setID();
	}
	
	public Cashier(String name, String surname, String personCode, LocalDate date, String contractNumber) {
		super(name, surname, personCode, date, contractNumber);
		setID();
	}
	
	public long getID() {
		return id;
	}
		
	public void setID() {
		this.id = idCounter;
		idCounter++;
	}
	
	public String toString() {
		return super.toString();
	}
}
