package br.edu.ifpb.dac.projetomvc.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifpb.dac.projetomvc.model.entity.Car;
import java.util.UUID;

import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository <Car,UUID> {

	boolean existsByLicencePlateCar(String licencePlateCar);
}