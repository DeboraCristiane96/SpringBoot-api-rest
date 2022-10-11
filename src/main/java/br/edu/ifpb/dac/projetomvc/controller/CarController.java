package br.edu.ifpb.dac.projetomvc.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.edu.ifpb.dac.projetomvc.model.dtos.CarDTO;
import org.springframework.beans.BeanUtils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.edu.ifpb.dac.projetomvc.model.entity.Car;
import br.edu.ifpb.dac.projetomvc.model.service.CarService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/car")
public class CarController {
	
	final CarService carService;

	public CarController(CarService carSevice) { this.carService = carSevice;}

	@PostMapping
	public ResponseEntity <Object> seveCar(@RequestBody CarDTO cardto){
		if(carService.existsByLincencePlateCar(cardto.getLicensePlateCar())){
			return ResponseEntity.status(HttpStatus.CREATED).body("Conflict: This license plate has already been registered");}
		var car  = new Car();
		BeanUtils.copyProperties(cardto,car);
			return ResponseEntity.status(HttpStatus.CREATED).body(carService.saveCar(car)); }

	@GetMapping
	public ResponseEntity <List<Car>> getAllCars(){
		return ResponseEntity.status(HttpStatus.OK).body(carService.findAll()); }

	@GetMapping(value = "/{id}")
	public ResponseEntity <Object> getOneCar(@PathVariable (value = "id") UUID id){
		Optional<Car> carOptional = carService.findById(id);
		if(!carOptional.isPresent()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found."); }
		return ResponseEntity.status(HttpStatus.OK).body(carOptional.get()); }

	@DeleteMapping(value = "/{id}")
	public ResponseEntity <Object> deleteCar(@PathVariable (value = "id") UUID id){
		Optional<Car> carOptional = carService.findById(id);
		if(!carOptional.isPresent()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found."); }
		carService.deleteCar(carOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Car deleted successfully."); }

	@PutMapping
	public ResponseEntity <Object> updateCar(@PathVariable (value = "id") UUID id, @RequestBody CarDTO cardto) {
		Optional<Car> carOptional = carService.findById(id);
		if (!carOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found.");
		}
		var car = carOptional.get();
		car.setLicensePlateCar(cardto.getLicensePlateCar());
		car.setModel(cardto.getModel());
		car.setColor(cardto.getColor());
		car.setYear(cardto.getYear());
		car.setPerson(cardto.getPerson());
		return ResponseEntity.status(HttpStatus.OK).body(carService.saveCar(car)); }

}

