package com.doctorapp.util;

public class Queries {
	public static final String INSERTQUERY="INSERT INTO DOCTOR (doctorname,doctorid,speciality,experience,fees,startdate,endtime) values(?,doc_seq.nextval,?,?,?,?,?)";
	public static final String UPDATEQUERY= "update DOCTOR set fees=? where doctorid=?";	
	public static final String DELETEQUERY="DELETE FROM DOCTOR WHERE doctorid = ?";
	public static final String SELECTALL="SELECT * FROM DOCTOR";
	public static final String QUERYBYID="SELECT * FROM DOCTOR WHERE doctorid = ?";
	public static final String QUERYBYSPECIALITY="SELECT * FROM DOCTOR WHERE speciality = ?";
	public static final String QUERYBYSPECIALITYEXP="SELECT * FROM DOCTOR WHERE speciality = ? AND experience=? ";
	public static final String QUERYBYSPECIALITYFEES="SELECT * FROM DOCTOR WHERE speciality = ? AND fees=? ";
	public static final String QUERYBYAVAILABILITY = "select * from doctor where speciality=? and startdate<=? and endTime>=?";
}
