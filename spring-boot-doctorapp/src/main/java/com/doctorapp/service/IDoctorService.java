package com.doctorapp.service;

import java.time.LocalDateTime;
import java.util.List;

import com.doctorapp.exceptions.DoctorNotFoundException;
import com.doctorapp.model.Doctor;

public interface IDoctorService {
	void addDoctor(Doctor doctor); 
	Doctor updateDoctor(int doctorld, double fees); 
	Doctor getById(int doctorld); 
	void deleteDoctor(int doctorld); 
	List<Doctor> getAllDoctors ( ) ; 
	List<Doctor> getBySpeciality(String speciality); 
	List<Doctor> getBySpecialityAndExp(String speciality, int experience);
	List<Doctor> getBySpecialityAndfees(String speciality, double fees); 
	List<Doctor> getByAvai1ability(LocalDateTime appointmentTime, String speciality); 

}
