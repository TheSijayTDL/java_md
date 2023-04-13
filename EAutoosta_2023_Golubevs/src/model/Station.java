package model;

public class Station {
	private String name;
	private City stationOfCity;
	private String workingHours;
	private long id;
	private static long idCounter = 1000;
	
	public Station() {
		setID();
		setName("Unknown");
		setStationOfCity(City.unknown);
		setWorkingHours("Unknown");
	}
	
	public Station(String name, City city, String hours) {
		setID();
		setName(name);
		setStationOfCity(city);
		setWorkingHours(hours);
	}
	
	public String getName() {
		return name;
	}
	
	public City getStationOfCity() {
		return stationOfCity;
	}
	
	public String getWorkingHours() {
		return workingHours;
	}
	
	public long getID() {
		return id;
	}
	
	public void setName(String name) {
		// I think stations can have almost all kind of names so... Maybe no need in regex check?
		if (name != null) {
			this.name = name;
		} else {
			this.name = "Test-Station";
		}
	}
	
	public void setStationOfCity(City stationOfCity) {
		if (stationOfCity != null) {
			this.stationOfCity = stationOfCity;
		} else {
			this.stationOfCity = City.unknown;
		}
	}
	
	public void setWorkingHours(String hours) {
		if (hours != null && hours.matches("^([0-1]?[0-9]|2[0-3]):[0-5][0-9]-([0-1]?[0-9]|2[0-3]):[0-5][0-9]$")) { // Pattern: 12:00-18:00 
			workingHours = hours;
		} else {
			workingHours = "Unknown";
		}
	}
	
	public void setID() {
		this.id = idCounter;
		idCounter++;
	}
	
	public String toString() {
		return "Station Name: " + name + ", City: " + stationOfCity + " (" + workingHours + ")";
	}
	
}
