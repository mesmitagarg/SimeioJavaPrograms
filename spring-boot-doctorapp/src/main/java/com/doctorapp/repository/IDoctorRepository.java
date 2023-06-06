package com.doctorapp.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.doctorapp.model.Doctor;

public interface IDoctorRepository {
	void addDoctor(Doctor doctor);
	 Doctor updateDoctor(int doctorId, double fees);
	 
	Doctor findById(int doctorId);
	 void deleteDoctor(int doctorId);
	 
	List<Doctor> findAllDoctors();
	 List<Doctor> findBySpeciality(String speciality);
	 List<Doctor> findBySpecialityAndExp(String speciality, int experience);
	 List<Doctor> findBySpecialityAndfees(String speciality,double fees);

	 List<Doctor> findByAvailability(String speciality, LocalDateTime startTime, LocalDateTime endTime);

}
