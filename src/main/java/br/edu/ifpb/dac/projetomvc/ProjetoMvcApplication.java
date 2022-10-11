package br.edu.ifpb.dac.projetomvc;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ifpb.dac.projetomvc.controller.CarController;
import br.edu.ifpb.dac.projetomvc.controller.PersonController;
import br.edu.ifpb.dac.projetomvc.model.entity.Car;
import br.edu.ifpb.dac.projetomvc.model.entity.Person;
@SpringBootApplication
public class ProjetoMvcApplication implements CommandLineRunner{

	@Autowired
	PersonController personController;
	
	@Autowired
	CarController carController;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoMvcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner s = new Scanner (System.in);
		boolean goout = false;
		while (! goout) {
			System.out.println("(1) create list of people who own cars");
			System.out.println("(2) list of people who own cars");
			System.out.println("(3) go out");
			int op = s.nextInt();
			if(op == 1) {
				Person person = new Person();
				Car car = new Car();
				car.setBoard(s.nextLine());
				car.setBrand(s.nextLine());
				car.setYear(s.nextInt());
				car.setColor(s.nextLine());
				carController.create(car);
				person.setName(person.getName());
				person.setAge(person.getAge());
				person.setSex(person.getSex());
				personController.create(person);

			} else if (op == 2) {
				List<Person> people = personController.list();
				for(Person p: people) {
					System.out.println(p);
				}
			} else {
				goout = true;
			}
		 }
	}
}
