package br.edu.ifpb.dac.projetomvc.model.service;

import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.projetomvc.model.repository.CarRepository;
import br.edu.ifpb.dac.projetomvc.model.entity.Car;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class CarService {

	final CarRepository carRepository;

	public CarService(CarRepository carRepository) { this.carRepository = carRepository; }

	public Object saveCar(Car car) { return carRepository.save(car); }

	public boolean existsByLincensePlateCar(String licensePlate) { return carRepository.existsByLicensePlateCar(licensePlate); }

	public List<Car> findAll() { return carRepository.findAll(); }

	public Optional<Car> findById(UUID id) { return carRepository.findById(id); }

	public void deleteCar(Car car) { carRepository.delete(car); }
}
