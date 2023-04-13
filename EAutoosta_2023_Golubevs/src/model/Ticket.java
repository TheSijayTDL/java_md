package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {
	private LocalDateTime transactionTime;
	private int discount;
	private float price;
	private Cashier ticketSeller;
	private boolean isVIP;
	private long id;
	private static long idCounter = 1500;
	
	public Ticket() {
		setID();
		setTransactionTime();
		setDiscount(0);
		setPrice(2);
		setTicketSeller(new Cashier());
		setVIP(false);
	}
	
	public Ticket(int discount, float price, Cashier tickerSeller, boolean isVIP) {
		setID();
		setTransactionTime();
		setDiscount(discount);
		setPrice(price);
		setTicketSeller(tickerSeller);
		setVIP(isVIP);
	}
	
	public long getID() {
		return id;
	}
	
	public LocalDateTime getTransactionTime() {
		return transactionTime;
	}
	
	public int getDiscount() {
		return discount;
	}
	
	public float getPrice() {
		return price;
	}
	
	public Cashier getCashier() {
		return ticketSeller;
	}
	
	public boolean isVIP() {
		return isVIP;
	}
	
	public void setTransactionTime() {
		this.transactionTime = LocalDateTime.now();
	}
	
	public void setDiscount(int discount) {
		if (discount > 0 && discount < 101) {
			this.discount = discount;
		} else {
			this.discount = 0;
		}
	}
	
	public void setPrice(float price) {
		if (price > 0) {
			this.price = price;
		} else {
			this.price = 0;
		}
	}
	
	public void setTicketSeller(Cashier ticketSeller) {
		if (ticketSeller != null) {
			this.ticketSeller = ticketSeller;
		} else {
			this.ticketSeller = new Cashier();
		}
	}
	
	public void setVIP(boolean VIP) {
		if (VIP == true) {
			isVIP = true;
		} else {
			isVIP = false;
		}
	}
	
	public void setID() {
		this.id = idCounter;
		idCounter++;
	}
	
	public String toString() {
		return transactionTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss")) + " Price: " + price +  " Discount: " + discount + " Is ticket VIP: " + isVIP + " (" + ticketSeller.getName() + " " + ticketSeller.getSurname() + ") ";
	}
}
