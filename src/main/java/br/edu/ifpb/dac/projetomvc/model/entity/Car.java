package br.edu.ifpb.dac.projetomvc.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
public class Car {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String licensePlateCar;
    private String model;
    private String year;
    private String color;

	public Car() {}

    @ManyToOne
    private Person person;

	public UUID getId() { return id; }

	public void setId(UUID id) {this.id = id; }

	public String getLicensePlateCar() {
		return licensePlateCar;
	}

	public void setLicensePlateCar(String licensePlateCar) { this.licensePlateCar = licensePlateCar; }

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}