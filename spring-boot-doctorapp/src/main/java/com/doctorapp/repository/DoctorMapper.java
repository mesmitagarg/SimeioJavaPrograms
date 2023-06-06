package com.doctorapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.doctorapp.model.Doctor;
import com.doctorapp.util.Columns;



public class DoctorMapper implements RowMapper<Doctor>{
@Override
public Doctor mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Doctor doctor = new Doctor();
		doctor.setDoctorld(rs.getInt(Columns.DOCTORID));
		doctor.setDoctorName(rs.getString(Columns.DOCTORNAME));
		doctor.setSpeciality(rs.getString(Columns.SPECIALITY));
		doctor.setExperience(rs.getInt(Columns.EXPERIENCE));
		doctor.setFees(rs.getInt(Columns.FEES));
		if (rs.getTimestamp(Columns.STARTDATE)!=null)
		doctor.setStartTime(rs.getTimestamp(Columns.STARTDATE).toLocalDateTime());
		if (rs.getTimestamp(Columns.ENDTIME)!=null)
		doctor.setEndTime(rs.getTimestamp(Columns.ENDTIME).toLocalDateTime());
		return doctor;
		
	}
}
