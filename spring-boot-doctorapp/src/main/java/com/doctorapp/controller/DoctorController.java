package com.doctorapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctorapp.model.Doctor;
import com.doctorapp.service.IDoctorService;

@RestController
@RequestMapping("doctor-api")
public class DoctorController {
	@Autowired
	IDoctorService doctorService;
	@GetMapping("/doctors")
	public ResponseEntity<List<Doctor>> showAllDoctors() {
		List<Doctor> doctors = doctorService.getAllDoctors();
		return ResponseEntity.status(HttpStatus.OK).body(doctors);
	
}
	
	@PostMapping("/doctors")
	public ResponseEntity addDoctors(@RequestBody Doctor doctor) {
		doctorService.addDoctor(doctor);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "added new doctor");		
		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();
		
	}
	@GetMapping("/doctors/{doctorID}")
	public ResponseEntity<Doctor> getById(@PathVariable("doctorID") int doctorID){
		Doctor doctor = doctorService.getById(doctorID);
		return ResponseEntity.status(HttpStatus.OK).body(doctor);
		
	}
	@DeleteMapping("/doctors/{doctorID}")
	public ResponseEntity deleteById(@PathVariable int doctorID){
		doctorService.deleteDoctor(doctorID);
		return ResponseEntity.accepted().build();
		
	}
	@PatchMapping("/doctors/{doctorID}/fees/{fees}")
	public ResponseEntity updateById(@PathVariable int doctorID, @PathVariable double fees){
		Doctor doctor = doctorService.updateDoctor(doctorID, fees);		
		return ResponseEntity.accepted().build();
		
	}
	@PutMapping("/doctors")
	public ResponseEntity updateById(@RequestBody Doctor doctor){
		 doctorService.updateDoctor(doctor.getDoctorld(),doctor.getFees());		
		return ResponseEntity.accepted().build();
		
	}
}
