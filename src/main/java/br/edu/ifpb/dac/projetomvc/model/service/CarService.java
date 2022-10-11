package br.edu.ifpb.dac.projetomvc.model.service;

import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.projetomvc.model.repository.CarRepository;
import br.edu.ifpb.dac.projetomvc.model.entity.Car;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class CarService {

	final CarRepository caRepository;

	public CarService(CarRepository caRepository) { this.caRepository = caRepository; }

	public Object saveCar(Car car) { return caRepository.save(car); }

	public boolean existsByLincencePlateCar(String licencePlate) { return caRepository.existsByLicencePlateCar(licencePlate); }

	public List<Car> findAll() { return caRepository.findAll(); }

	public Optional<Car> findById(UUID id) { return caRepository.findById(id); }

	public void deleteCar(Car car) { caRepository.delete(car); }
}
