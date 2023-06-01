package lv.autoosta.model;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Table(name = "cashier_table") // DB table
@Entity
public class Cashier {
	@Column(name = "Name")
	@NotNull
	@Pattern(regexp = "[A-Z]{1}[a-z\\ ]+")
	@Size(min = 3, max = 35)
	private String name;
	
	@Column(name = "Surname")
	@NotNull
	@Pattern(regexp = "[A-Z]{1}[a-z\\ ]+")
	@Size(min = 3, max = 35)
	private String surname;
		
	@Column(name = "Idcas")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idcas;
	
	@OneToMany(mappedBy = "cashier")
	private Collection<Ticket> tickets;
	
	public Cashier() {
		this.name = "Test";
		this.surname = "Test";
	}

	public Cashier(@NotNull @Pattern(regexp = "[A-Z]{1}[a-z\\ ]+") @Size(min = 3, max = 35) String name,
			@NotNull @Pattern(regexp = "[A-Z]{1}[a-z\\ ]+") @Size(min = 3, max = 35) String surname) {
		this.name = name;
		this.surname = surname;
	}

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
	
	public long getIdcas() {
		return idcas;
	}

}
