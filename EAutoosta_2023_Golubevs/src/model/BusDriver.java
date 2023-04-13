package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class BusDriver extends Employee {
	private ArrayList<BusCategory> categories = new ArrayList<>();
	private int driverExperience; // byte ?
	
	public BusDriver() {
		super();
		setDriverExperience(1);
	}
	
	public BusDriver(String name, String surname, String personCode, LocalDate date, String contractNumber, BusCategory category, int driverExperience) {
		super(name, surname, personCode, date, contractNumber);
		addBusCategory(category);
		setDriverExperience(driverExperience);
	}
		
	public ArrayList<BusCategory> getBusCategories() {
		return categories;
	}
	
	public int getDriverExperience() {
		return driverExperience;
	}
		
	public void setDriverExperience(int driverExperience) {
		if (driverExperience > 0 && driverExperience <= 100) {
			this.driverExperience = driverExperience;
		} else {
			this.driverExperience = 1;
		}
	}
	
	public void addBusCategory(BusCategory category) {
		if (category != null && !categories.contains(category)) {
			categories.add(category);
		} else {
			System.out.println("Check your input, something is wrong or driver already has this category!");
		}
	}
	
	public void removeBusCategory(BusCategory category) {
		if (category != null && categories.contains(category)) {
			categories.remove(category);
		} else {
			System.out.println("Nothing was removed!");
		}
	}
	
	public String toString() {
		return "" + super.toString() + ", " + categories + ", Experience: " + driverExperience;
	}

}
