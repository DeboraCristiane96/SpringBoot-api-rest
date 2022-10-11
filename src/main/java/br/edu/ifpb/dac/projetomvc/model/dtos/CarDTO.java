package br.edu.ifpb.dac.projetomvc.model.dtos;

import br.edu.ifpb.dac.projetomvc.model.entity.Person;

public class CarDTO {

    private String licensePlateCar;
    private String model;
    private String year;
    private String color;
    private Person person;

    public String getLicensePlateCar() {
        return licensePlateCar;
    }

    public void setLicensePlateCar(String licensePlateCar) { this.licensePlateCar = licensePlateCar; }

    public String getModel() {
        return model;
    }

    public void setModel() {
        this.model = model;
    }

    public String getYear() { return year; }

    public void setYear(String year) { this.year = year; }

    public String getColor() { return color; }

    public void setColor(String color) { this.color = color; }

    public Person getPerson() { return person; }

    public void setPerson(Person person) { this.person = person; }

}
