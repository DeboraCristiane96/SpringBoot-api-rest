package br.edu.ifpb.dac.projetomvc.model.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.projetomvc.model.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository <Person, UUID> {

	boolean existsByName(String name);

	Optional<Person> findById(UUID id);
}
