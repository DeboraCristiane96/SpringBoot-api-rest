package br.edu.ifpb.dac.projetomvc.model.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.projetomvc.model.repository.PersonRepository;

import br.edu.ifpb.dac.projetomvc.model.entity.Person;

@Service
public class PersonService {
	final PersonRepository personRepository;

	public PersonService(PersonRepository personRepository) { this.personRepository = personRepository; }

	public boolean existsBycName(String name){ return personRepository.existsByName(name); }

	public Object savePerson(Person person) { return personRepository.save(person); }

	public List<Person> findAll() { return personRepository.findAll(); }

	public Optional<Person> findById(UUID id) { return personRepository.findById(id);}

	public void deletePerson(Person person) {  personRepository.delete(person); }
}
