package lv.autoosta.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Table(name = "trip_table") // DB table
@Entity
public class Trip {
	@Column(name = "Startdatetime")
	@NotNull
	private LocalDateTime startDateTime;
	
	@Column(name = "Duration")
	@Min(1)
	@Max(100)
	private float duration;
	
	@Column(name = "Idtr")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idtr;
	
	@ManyToMany
	@JoinTable(name = "trip_city_table", joinColumns = @JoinColumn(name = "Idc"), inverseJoinColumns = @JoinColumn(name = "Idtr"))
	private Collection<City> cities = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "Idd")
	private Driver driver;
	
	@OneToMany(mappedBy = "trips", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Collection<Ticket> tickets;
	
	private static DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	
	public Trip() {
		this.startDateTime = LocalDateTime.now();
		this.duration = 0;
		this.driver = new Driver();
	}
	
	public Trip(@NotNull LocalDateTime startDateTime, @Min(1) @Max(100) float duration, Collection<City> cities, Driver driver) {
		this.startDateTime = startDateTime;
		this.duration = duration;
		this.cities = cities;
		this.driver = driver;
	}

	public void addCity(City inputCity) {
		if (!cities.contains(inputCity)) {
			cities.add(inputCity);
		}
	}
	
	public void removeCity(City inputCity) {
		if (cities.contains(inputCity)) {
			cities.remove(inputCity);
		}
	}
	
	public String getStartDateTime() {
		return startDateTime.format(pattern);
	}
	
	public LocalDateTime getTimeInfo() {
		return startDateTime;
	}
	
	public float getDuration() {
		return duration;
	}
	
	public long getIdtr() {
		return idtr;
	}
	
	public Driver getDriver() {
		return driver;
	}
	
	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}
	
	public void setDuration(float duration) {
		this.duration = duration;
	}
	
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	public Collection<City> getCities() {
		return cities;
	}
	
}
