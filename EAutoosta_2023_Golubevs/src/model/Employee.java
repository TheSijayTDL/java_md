package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee extends Person {
	private LocalDate contractDate;
	private String contractNumber; 
	protected static DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd.MM.yyyy");

	public Employee() {
		super();
		setContractDate(LocalDate.of(2023, 2, 24));
		setContractNumber("Unknown");
	}
	
	public Employee(String name, String surname, String personCode, LocalDate date, String contractNumber) {
		super(name, surname, personCode);
		setContractDate(date);
		setContractNumber(contractNumber);
	}
	
	public LocalDate getContractDate() {
		return contractDate;
	}
	
	public String getContractNumber() {
		return contractNumber;
	}
	
	public void setContractDate(LocalDate date) {
		LocalDate specifiedDate = LocalDate.of(2023, 2, 24);
		LocalDate temp = LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth());
		if (temp.isAfter(specifiedDate)) {
			//contractDate = pattern.format(temp);
			this.contractDate = temp;
		} else {
			//contractDate = pattern.format(specifiedDate);
			this.contractDate = specifiedDate;
		}
	}
	
	public void setContractNumber(String contractNumber) {
		if (contractNumber != null && contractNumber.matches("[0-9]{4}[_]{1}[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[_]{1}[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}")) {
			this.contractNumber = contractNumber;
		} else {
			this.contractNumber = "Unknown";
		}
	}
	
	public String toString() {
		return "" + getName() + " " + getSurname() + " (" + getPersonCode() + ") " + contractNumber + " Date: " + contractDate.format(pattern);
	}
	

}
