package lv.autoosta.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Table(name = "ticket_table") // DB table
@Entity
public class Ticket {
	@Column(name = "Purchasedatetime")
	@NotNull
	private LocalDateTime purchaseDateTime;
	
	@Column(name = "Price")
	@Min(0)
	@Max(100)
	private float price;
	
	@Column(name = "Ischild")
	private boolean isChild;
	
	@Column(name = "Idt")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idt;
	
	@ManyToOne
	@JoinColumn(name = "Idcas")
	private Cashier cashier;
	
	@ManyToOne
	@JoinColumn(name = "Idtr")
	private Trip trips;
		
	private static DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	
	public Ticket() {
		this.purchaseDateTime = LocalDateTime.now();
		this.price = 0;
		this.isChild = false;
	}
	
	public Ticket(@NotNull LocalDateTime purchaseDateTime, @Min(0) @Max(100) float price, boolean isChild,
			Cashier cashier, Trip trip) {
		this.purchaseDateTime = purchaseDateTime;
		this.price = price;
		this.isChild = isChild;
		this.cashier = cashier;
		this.trips = trip;
	}
	
	public Ticket(@Min(0) @Max(100) float price, boolean isChild, Cashier cashier, Trip trip) {
		this.purchaseDateTime = LocalDateTime.now();
		this.price = price;
		this.isChild = isChild;
		this.cashier = cashier;
		this.trips = trip;
	}

	public String getPurchaseDateTime() {
		return purchaseDateTime.format(pattern);
	}

	public void setPurchaseDateTime(LocalDateTime purchaseDateTime) {
		this.purchaseDateTime = purchaseDateTime;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean getIsChild() {
		return isChild;
	}

	public void setIsChild(boolean isChild) {
		this.isChild = isChild;
	}

	public Cashier getCashier() {
		return cashier;
	}

	public void setCashier(Cashier cashier) {
		this.cashier = cashier;
	}

	public Trip getTrip() {
		return trips;
	}

	public void setTrip(Trip trip) {
		this.trips = trip;
	}
	
	public long getIdt() {
		return idt;
	}
	
	
}
