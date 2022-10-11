package br.edu.ifpb.dac.projetomvc.model.dtos;

import br.edu.ifpb.dac.projetomvc.model.entity.Car;

import java.util.Set;

public class PersonDTO {


    private String cpf;
    private String name;
    private Integer age;
    private String sex;
    private Set<Car> cars;


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
