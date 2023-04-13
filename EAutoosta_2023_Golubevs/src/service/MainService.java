package service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

import model.BusCategory;
import model.BusDriver;
import model.BusTrip;
import model.Cashier;
import model.City;
import model.Employee;
import model.Station;
import model.Ticket;

public class MainService {

	public static ArrayList<BusTrip> allBusTrips = new ArrayList<>();
	public static ArrayList<Employee> allEmployees = new ArrayList<>();
	public static ArrayList<Station> allStations = new ArrayList<>();
	
	public static LocalDateTime plusHour = LocalDateTime.now().plusHours(1);
	public static LocalDateTime plusTwoHours = LocalDateTime.now().plusHours(2);
	public static LocalDateTime plusThreeHours = LocalDateTime.now().plusHours(3);
	
	public static void main(String[] args) {
	
		try {
			addNewCashier("Test", "Cashier", "123456-12345", LocalDate.of(2023, 5, 11), "2023_T_C");
			addNewCashier("Cool", "Guy", "000000-00001", LocalDate.of(2023, 6, 6), "2023_C_G");
			addNewCashier("Another", "Test", "654321-00000", LocalDate.of(2023, 2, 4), "2023_A_T");
			addNewCashier("Hello", "World", "000000-12345", LocalDate.of(2023, 6, 1), "2023_H_W");
			System.out.println(findAllCashiers());
			
			System.out.println(findCashierByPersonCode("654321-00000"));
			
			updateCashierByPersonCode("Updatedname", "Updatedsurname", "654321-00000", LocalDate.of(2023, 10, 10), "2025_A_G");
			System.out.println(findCashierByPersonCode("654321-00000"));
			
			deleteCashierByPersonCode("654321-00000");
			
			System.out.println(findAllCashiers());
			
			System.out.println("--------------");
			addNewBusDriver("Firstdrivername", "Firstdriversurname", "010203-00000", LocalDate.of(2023, 10, 10), "2025_A_G", BusCategory.minibus, 10);
			addNewBusDriver("Seconddrivername", "Seconddriversurname", "016203-00000", LocalDate.of(2023, 8, 8), "2027_A_C", BusCategory.minibus, 13);
			addNewBusDriver("Thirddrivername", "Thirddriversurname", "901620-00000", LocalDate.of(2023, 7, 7), "2027_Y_R", BusCategory.largebus, 7);
			
			
			System.out.println(findBusDriversWithCategory(BusCategory.minibus));
			
			addNewBusDriverCategoryByPersonCode("901620-00000", BusCategory.minibus);
			System.out.println(findBusDriversWithCategory(BusCategory.minibus));
			
			System.out.println(findAllBusDrivers());
			
			System.out.println("------------");
			addNewStation(City.Daugavpils, "Daugava1", "12:00-16:00");
			addNewStation(City.Ventspils, "Ventspils1", "12:00-18:00");
			addNewStation(City.Jelgava, "Jelgava1", "12:00-18:00");
			
			System.out.println("----------------");	
			//addNewBusTrip(allStations.get(0), allStations.get(2), plusTwoHours, plusThreeHours, findAllBusDrivers().get(0), 50);
			//addNewBusTrip(allStations.get(0), allStations.get(1), plusHour, plusThreeHours, findAllBusDrivers().get(0), 30);
			//addNewBusTrip(allStations.get(1), allStations.get(2), plusTwoHours, plusThreeHours, findAllBusDrivers().get(1), 50);
			
			System.out.println("--------TRIPS TODAY--------");
			System.out.println(findAllBusTripsToday(allStations.get(0)));
			
			System.out.println("------------");
			addTicket(findAllCashiers().get(0), 50, plusHour, true, 5, allStations.get(0), allStations.get(1));
			addTicket(findAllCashiers().get(0), 10, plusHour, false, 2, allStations.get(0), allStations.get(1));
			addTicket(findAllCashiers().get(0), 30, plusHour, true, 4, allStations.get(0), allStations.get(1));
			addTicket(findAllCashiers().get(1), 5, plusHour, true, 14, allStations.get(1), allStations.get(2));
			System.out.println(allBusTrips);
			
			System.out.println("------------");
			System.out.println(findAllTicketsForBusTrip(plusHour, allStations.get(0), allStations.get(1)));
			
			System.out.println("------------");
			System.out.println(findAllVIPTicketsToday());
			System.out.println(incomeTodayByCashier("123456-12345"));
			System.out.println(sortBusTripByTime(allStations.get(0)));
			System.out.println("------------");
			// Not really working as intended because I want to sleep... maybe will figure it out a little bit later
			generateBusTrips();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void addNewCashier(String name, String surname, String personCode, LocalDate date, String contractNumber) throws Exception {
		if (name == null || surname == null || personCode == null || date == null || contractNumber == null) {
			throw new Exception("Arguments are not valid!");
		} 
		
		for (int i = 0; i < allEmployees.size(); i++) {
			if (allEmployees.get(i).getPersonCode() == personCode) {
				throw new Exception("Person with this person code already exists!");
			}
		}
		
		allEmployees.add(new Cashier(name, surname, personCode, date, contractNumber));
	}
	
	public static Cashier findCashierByPersonCode(String personCode) throws Exception {
		Cashier tempCashier = null;
		
		if (personCode == null) {
			throw new Exception("Arguments are not valid!");
		}
		
		for (Employee temp : allEmployees) {
			if (temp instanceof Cashier && temp.getPersonCode() == personCode) {
				tempCashier = (Cashier) temp;
			}	
		}
		
		if (tempCashier == null) {
			throw new Exception("Cashier not found!!");
		}
		
		return tempCashier;
	}
	
	public static void updateCashierByPersonCode(String name, String surname, String personCode, LocalDate date, String contractNumber) throws Exception {
		if (name == null || surname == null || personCode == null || date == null || contractNumber == null) {
			throw new Exception("Arguments are not valid!");
		} else {
			 Cashier foundCashier = findCashierByPersonCode(personCode);
			 foundCashier.setName(name);
			 foundCashier.setSurname(surname);
			 foundCashier.setContractDate(date);
			 foundCashier.setContractNumber(contractNumber);
		}
	}
	
	public static void deleteCashierByPersonCode(String personCode) throws Exception {
		if (personCode == null) {
			throw new Exception("Arguments are not valid!");
		} else {
			Cashier foundCashier = findCashierByPersonCode(personCode);
			allEmployees.remove(foundCashier);
		}
	}
	
	public static ArrayList<Cashier> findAllCashiers() {
		ArrayList<Cashier> result = new ArrayList<>();
		
		for (Employee temp : allEmployees) {
			if (temp instanceof Cashier) {
				result.add((Cashier) temp);
			}	
		}
		return result;
	}
	
	public static void addNewBusDriver(String name, String surname, String personCode, LocalDate date, String contractNumber, BusCategory category, int driverExperience) throws Exception {
		if (name == null || surname == null || personCode == null || date == null || contractNumber == null) {
			throw new Exception("Arguments are not valid!");
		} 
		
		for (int i = 0; i < allEmployees.size(); i++) {
			if (allEmployees.get(i).getPersonCode() == personCode) {
				throw new Exception("Person with this person code already exists!");
			}
		}
		
		allEmployees.add(new BusDriver(name, surname, personCode, date, contractNumber, category, driverExperience));	
	}
	
	public static ArrayList<BusDriver> findBusDriversWithCategory(BusCategory category) throws Exception {
		ArrayList<BusDriver> result = new ArrayList<>();
		
		if (category == null) {
			throw new Exception("Arguments are not valid!");
		}
		
		for (Employee temp : allEmployees) {
			if (temp instanceof BusDriver && ((BusDriver) temp).getBusCategories().contains(category)) {
				result.add((BusDriver) temp);
			}	
		}
		return result;
	}
	
	public static void addNewBusDriverCategoryByPersonCode(String personCode, BusCategory category) throws Exception {
		if (personCode == null || category == null) {
			throw new Exception("Arguments are not valid!");
		}
		
		for (Employee temp : allEmployees) {
			if (temp instanceof BusDriver && temp.getPersonCode() == personCode) {
				((BusDriver) temp).addBusCategory(category);
			}	
		}
	}
	
	public static ArrayList<BusDriver> findAllBusDrivers() {
		ArrayList<BusDriver> result = new ArrayList<>();
		
		for (Employee temp : allEmployees) {
			if (temp instanceof BusDriver) {
				result.add((BusDriver) temp);
			}	
		}
		return result;
	}
	
	public static void addNewStation(City city, String name, String hours) throws Exception {
		if (city == null || name == null || hours == null) {
			throw new Exception("Arguments are not valid!");
		}
		
		for (int i = 0; i < allStations.size(); i++) {
			if (allStations.get(i).getStationOfCity() == city && allStations.get(i).getName() == name) {
				throw new Exception("This station already exists!");
			}
		}
		
		allStations.add(new Station(name, city, hours));	
	}
	
	public static void addNewBusTrip(Station stationFrom, Station stationTo, LocalDateTime timeFrom, LocalDateTime timeTo, BusDriver driver, int numberOfSeats) throws Exception {
		if (stationFrom == null || stationTo == null || timeFrom == null || timeTo == null || driver == null) {
			throw new Exception("Arguments are not valid!");
		}
		
		for (int i = 0; i < allBusTrips.size(); i++) {
			if (allBusTrips.get(i).getTimeFrom() == timeFrom && allBusTrips.get(i).getDriver() == driver) {
				throw new Exception("This driver already has planned trip!");
			}
		}
		
		allBusTrips.add(new BusTrip(stationFrom, stationTo, timeFrom, timeTo, driver, numberOfSeats));
	}
	
	public static int howManyFreeSeats(LocalDateTime timeFrom, Station stationFrom, Station stationTo) throws Exception {
		if (stationFrom == null || stationTo == null || timeFrom == null) {
			throw new Exception("Arguments are not valid!");
		}
		
		int tickets = findAllTicketsForBusTrip(timeFrom, stationFrom, stationTo).size();
		return tickets;
	}
	
	public static ArrayList<Ticket> findAllTicketsForBusTrip(LocalDateTime timeFrom, Station stationFrom, Station stationTo) throws Exception {
		if (stationFrom == null || stationTo == null || timeFrom == null) {
			throw new Exception("Arguments are not valid!");
		}
		
		ArrayList<Ticket> result = new ArrayList<>();
		for (int i = 0; i < allBusTrips.size(); i++) {
			if (allBusTrips.get(i).getTimeFrom() == timeFrom && allBusTrips.get(i).getStationFrom() == stationFrom && allBusTrips.get(i).getStationTo() == stationTo) {
				result = allBusTrips.get(i).getTicketList();
			}
		}
		return result;
	}
	
	public static ArrayList<BusTrip> findAllBusTripsToday(Station stationFrom) throws Exception {
		if (stationFrom == null) {
			throw new Exception("Arguments are not valid!");
		}
		
		ArrayList<BusTrip> result = new ArrayList<>();
		for (int i = 0; i < allBusTrips.size(); i++) {
			if (allBusTrips.get(i).getStationFrom() == stationFrom && allBusTrips.get(i).getTimeFrom().isAfter(LocalDateTime.now()) && allBusTrips.get(i).getTimeFrom().isBefore(LocalDateTime.of(LocalDate.now(), LocalTime.parse("23:59")))) {
				result.add(allBusTrips.get(i));
			}
		}
		return result;
	}
	
	public static void addTicket(Cashier cashier, int discount, LocalDateTime timeFrom, boolean isVIP, float price, Station stationFrom, Station stationTo) throws Exception {
		if (cashier == null || stationFrom == null || stationTo == null) {
			throw new Exception("Arguments are not valid!");
		} 

		for (int i = 0; i < allBusTrips.size(); i++) {
			if (allBusTrips.get(i).getStationFrom() == stationFrom && allBusTrips.get(i).getStationTo() == stationTo && allBusTrips.get(i).getTimeFrom() == timeFrom && allBusTrips.get(i).getTicketList().size() < allBusTrips.get(i).getNumberOfSeats() + 1) {
				allBusTrips.get(i).addTicketToBusTrip(new Ticket(discount, price, cashier, isVIP));
			}
		}
	}
	
	public static ArrayList<Ticket> findAllVIPTicketsToday() {
		ArrayList<Ticket> result = new ArrayList<>();
		
		for (int i = 0; i < allBusTrips.size(); i++) {
			for (Ticket temp : allBusTrips.get(i).getTicketList()) {
				if (temp.isVIP()) {
					result.add(temp);
				} else {
					continue;
				}
			}
		}
		
		return result;
	}
	
	public static float incomeTodayByCashier(String personCode) throws Exception {
		if (personCode == null) {
			throw new Exception("Arguments are not valid!");
		}
		
		float result = 0;
		for (int i = 0; i < allBusTrips.size(); i++) {
			for (Ticket temp : allBusTrips.get(i).getTicketList()) {
				if (temp.getCashier().getPersonCode() == personCode) {
					result += temp.getPrice();
				}
			}
		}
		
		return result;
	}
	
	public static ArrayList<BusTrip> sortBusTripByTime(Station stationFrom) throws Exception {
		if (stationFrom == null) {
			throw new Exception("Arguments are not valid!");
		}
		
		ArrayList<BusTrip> result = allBusTrips;
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.size(); j++) {
				if (result.get(i).getTimeFrom().isBefore(result.get(j).getTimeFrom())) {
					BusTrip temp = result.get(j);
					result.set(j, result.get(i));
					result.set(i, temp);
				}
			}
		}
		return result;
	}
	
	public static void generateBusTrips() throws Exception {
		LocalDate today = LocalDate.now();
		
		if (today.getDayOfWeek().getValue() <= 7) {
			Random rand = new Random();
			int schedule = 7 - today.getDayOfWeek().getValue();
			int numberOfStations = allStations.size();
			int drivers = findAllBusDrivers().size();
			
			for (int i = 0; i < schedule; i++) {
				int randomStation = rand.nextInt(numberOfStations);
				int randomDriver = rand.nextInt(drivers);
				int hours = 0;
				for (int j = 0; j < numberOfStations; j++) {
					for (int k = 0; k < allBusTrips.size(); k++) {
						if (allBusTrips.get(k).getTimeFrom() == plusHour.plusHours(hours) && allBusTrips.get(k).getDriver() == findAllBusDrivers().get(randomDriver)) {
							randomDriver = rand.nextInt(drivers);
							hours +=1;
						}
					}
				
					addNewBusTrip(allStations.get(j), allStations.get(randomStation), plusHour.plusHours(hours), plusTwoHours.plusHours(hours), findAllBusDrivers().get(randomDriver), 40);
					hours +=1;	
				}
				hours += 24;
			}
		}
	}

}
