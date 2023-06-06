package com.doctorapp.repository;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.doctorapp.model.Doctor;
import com.doctorapp.util.Columns;
import com.doctorapp.util.Queries;

@Repository
public class DoctorRepositoryImpl implements IDoctorRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void addDoctor(Doctor doctor) {
		
		Object[] doctorArray = {doctor.getDoctorName(),doctor.getSpeciality(),doctor.getExperience(),doctor.getFees()
				,Timestamp.valueOf(doctor.getStartTime())
				, Timestamp.valueOf(doctor.getEndTime())};
		jdbcTemplate.update(Queries.INSERTQUERY, doctorArray);	
		
	}

	@Override
	
	public Doctor updateDoctor(int doctorId, double fees) {
		jdbcTemplate.update(Queries.UPDATEQUERY,fees, doctorId);
		return findById(doctorId);
	}

	@Override
	
	public Doctor findById(int doctorId) {
		Doctor doc=null;
		try {doc= jdbcTemplate.queryForObject(Queries.QUERYBYID, new DoctorMapper(),doctorId);
		}
		catch (EmptyResultDataAccessException e) {
			//return null;
			   }				  
		return doc;
}
		
	

	@Override
	public void deleteDoctor(int doctorId) {
		jdbcTemplate.update(Queries.DELETEQUERY, doctorId);
		

	}

	@Override
	public List<Doctor> findAllDoctors() {
		return jdbcTemplate.query(Queries.SELECTALL, new DoctorMapper());
		
		}
		

	@Override
	public List<Doctor> findBySpeciality(String speciality) {
		return jdbcTemplate.query(Queries.QUERYBYSPECIALITY, new DoctorMapper(),speciality);
		
	}

	@Override
	public List<Doctor> findBySpecialityAndExp(String speciality, int experience) {
		return jdbcTemplate.query(Queries.QUERYBYSPECIALITYEXP, new DoctorMapper(),speciality,experience);
		
	}

	@Override
	public List<Doctor> findBySpecialityAndfees(String speciality, double fees) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(Queries.QUERYBYSPECIALITYFEES, new DoctorMapper(),speciality,fees);
	}

	@Override
	public List<Doctor> findByAvailability(String speciality, LocalDateTime startTime, LocalDateTime endTime) {
		return jdbcTemplate.query(Queries.QUERYBYAVAILABILITY, new DoctorMapper(),speciality,startTime,endTime);
	}

}
