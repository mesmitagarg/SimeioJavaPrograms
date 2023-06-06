package com.doctorapp.service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.doctorapp.exceptions.DoctorNotFoundException;
import com.doctorapp.model.Doctor;
import com.doctorapp.repository.DoctorRepositoryImpl;
import com.doctorapp.repository.IDoctorRepository;


@Service
public class DoctorServiceImpl implements IDoctorService {
	IDoctorRepository doctorRepository = new DoctorRepositoryImpl();
	public static final Logger logger = LoggerFactory.getLogger(DoctorServiceImpl.class);
	
	public DoctorServiceImpl(IDoctorRepository doctorRepository) {
		super();
		this.doctorRepository = doctorRepository;
	}
	@Override
	public void addDoctor(Doctor doctor) {
		doctorRepository.addDoctor(doctor);
		
	}
	@Override
	@CachePut(cacheNames ="doctorsCache",key = "#doctorID")
	public Doctor updateDoctor(int doctorID, double fees) {
		logger.info("updating doctor from Db " + doctorID);
		return doctorRepository.updateDoctor(doctorID, fees);
	}

	@Override
	@Cacheable(cacheNames ="doctorsCache",key = "#doctorID")
	public Doctor getById(int doctorID) {
		logger.info("getting doctor from Db " + doctorID);
		Doctor doctor = doctorRepository.findById(doctorID);
		if (doctor==null) throw new DoctorNotFoundException("doctor by id cannot be found " + doctorID);
		return doctor;
	}

	@Override
	@CacheEvict(cacheNames ="doctorsCache",key = "#doctorID")
	public void deleteDoctor(int doctorID) {
		logger.info("updating doctor from Db " + doctorID);
		doctorRepository.deleteDoctor(doctorID);

	}

	@Override
	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAllDoctors();
	}

	@Override
	public List<Doctor> getBySpeciality(String speciality)  {
		return doctorRepository.findBySpeciality(speciality);
	}

	@Override
	public List<Doctor> getBySpecialityAndExp(String speciality, int experience)  {
		return doctorRepository.findBySpecialityAndExp(speciality, experience);
	}

	@Override
	public List<Doctor> getBySpecialityAndfees(String speciality, double fees)  {
		// TODO Auto-generated method stub
		return doctorRepository.findBySpecialityAndfees(speciality, fees);
	}

	@Override
	public List<Doctor> getByAvai1ability(LocalDateTime appointmentTime, String speciality) {
		LocalDateTime endTime=appointmentTime;
		
		return doctorRepository.findByAvailability(speciality, appointmentTime, endTime);
	}

	

}
