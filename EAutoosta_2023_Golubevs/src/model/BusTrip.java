package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BusTrip {
	private Station stationFrom, stationTo;
	private LocalDateTime timeFrom, timeTo;
	private int numberOfSeats;
	private BusDriver driver;
	private ArrayList<Ticket> ticketList = new ArrayList<>();
	private long id;
	private static DateTimeFormatter pattern = DateTimeFormatter.ofPattern("HH:mm");
	private static long idCounter = 7500;
	
	public BusTrip(Station stationFrom, Station stationTo, LocalDateTime timeFrom, LocalDateTime timeTo, BusDriver driver, int numberOfSeats) {
		setBusStations(stationFrom, stationTo);
		setTripTime(timeFrom, timeTo);
		changeDriver(driver);
		setNumberOfSeats(numberOfSeats);
	}
	
	public Station getStationFrom() {
		return stationFrom;
	}
	
	public Station getStationTo() {
		return stationTo;
	}
	
	public LocalDateTime getTimeFrom() {
		return timeFrom;
	}
	
	public LocalDateTime getTimeTo() {
		return timeTo;
	}
	
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	
	public BusDriver getDriver() {
		return driver;
	}
	
	public ArrayList<Ticket> getTicketList() {
		return ticketList;
	}
	
	public long getID() {
		return id;
	}
	
	public void setBusStations(Station stationFrom, Station stationTo) {
		if (stationFrom == null || stationTo == null) {
			this.stationFrom = new Station();
			this.stationTo = new Station();
		}
		if (stationFrom.getName() == stationTo.getName() && stationFrom.getStationOfCity() == stationTo.getStationOfCity()) {
			this.stationFrom = new Station();
			this.stationTo = new Station();
		} else {
			this.stationFrom = stationFrom;
			this.stationTo = stationTo;
		}
	}
	
	public void setTripTime(LocalDateTime timeFrom, LocalDateTime timeTo) {
		if (timeFrom == null || timeTo == null) {
			this.timeFrom = LocalDateTime.now();
			this.timeTo = LocalDateTime.now().plusHours(4);
		} 
		else if (timeTo.isAfter(timeFrom) && timeFrom.isAfter(LocalDateTime.now()) && timeTo.isAfter(LocalDateTime.now())) {
			this.timeFrom = timeFrom;
			this.timeTo = timeTo;
		}
	}
	
	public void setNumberOfSeats(int numberOfSeats) {
		if (numberOfSeats > 0 && driver.getBusCategories().contains(BusCategory.minibus) && numberOfSeats <= 30 || driver.getBusCategories().contains(BusCategory.largebus) && numberOfSeats >= 31) {
			this.numberOfSeats = numberOfSeats;
		} else {
			this.numberOfSeats = 0;
		}
	}
		
	public void setID() {
		this.id = idCounter;
		idCounter++;
	}
	
	public void changeDriver(BusDriver driver) {
		if (driver != null) {
			if (driver.getBusCategories().contains(BusCategory.minibus) && numberOfSeats <= 30) {
				this.driver = driver;
			}
			else if (driver.getBusCategories().contains(BusCategory.largebus) && numberOfSeats >= 31) {
				this.driver = driver;
			}
		} else {
			this.driver = new BusDriver();
		}
	}
	
	public void addTicketToBusTrip(Ticket ticket) {
		if (ticket != null && ticketList.size() <= numberOfSeats) {
			if (ticket.isVIP()) {
				ticketList.add(0, ticket);
			} else {
				ticketList.add(ticket);
			}
		} 
	}
	
	public String toString() {
		return "From: " + stationFrom + ", To: " + stationTo + " (" + timeFrom.format(pattern) + "-" + timeTo.format(pattern) + ") Driver: " + driver + ", Seats: " + numberOfSeats + " Tickets: " + ticketList;
	}

}
