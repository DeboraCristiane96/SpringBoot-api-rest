package br.edu.ifpb.dac.projetomvc.controller;

import br.edu.ifpb.dac.projetomvc.model.dtos.PersonDTO;

import org.springframework.beans.BeanUtils;;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import br.edu.ifpb.dac.projetomvc.model.entity.Person;
import br.edu.ifpb.dac.projetomvc.model.service.PersonService;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("api/person")
public class PersonController {
	final PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService; }
	@Transactional
	@PostMapping
	public ResponseEntity <Object> savePerson(@RequestBody PersonDTO persondto) {
		if (personService.existsByName(persondto.getName())) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Conflict: This name has already been registered");
		}
		var person = new Person();
		BeanUtils.copyProperties(persondto, person);
		return ResponseEntity.status(HttpStatus.CREATED).body(personService.savePerson(person)); }

	@GetMapping
	public ResponseEntity <List<Person>> getAllPersons(){
		return ResponseEntity.status(HttpStatus.OK).body(personService.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity <Object> getOnePerson(@PathVariable (value = "id") UUID id){
		Optional<Person> personOptional = personService.findById(id);
		if(!personOptional.isPresent()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found."); }
		return ResponseEntity.status(HttpStatus.OK).body(personOptional.get());}

	@Transactional
	@DeleteMapping(value = "/{id}")
	public ResponseEntity <Object> deletePerson(@PathVariable (value = "id") UUID id){
		Optional<Person> personOptional = personService.findById(id);
		if(!personOptional.isPresent()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found."); }
		personService.deletePerson(personOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Person deleted successfully."); }

	@PutMapping
	public ResponseEntity <Object> updatePerson(@PathVariable (value = "id") UUID id, @RequestBody PersonDTO persondto){
		Optional<Person> personOptional = personService.findById(id);
		if(!personOptional.isPresent()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found."); }
		var person = personOptional.get();
		person.setName(persondto.getName());
		person.setAge(persondto.getAge());
		return ResponseEntity.status(HttpStatus.OK).body(personService.savePerson(person)); }
}

