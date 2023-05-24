package com.voterapp.Service;

import java.util.Arrays;

import com.voterapp.Exceptions.InValidVoterException;
import com.voterapp.Exceptions.LocalityNotFoundException;
import com.voterapp.Exceptions.NoVoterIDException;
import com.voterapp.Exceptions.UnderAgeException;

public class ElectionBoothImpl implements IElectionBooth{
	String[] localities = {"BG", "yella", "shiva"};
	int[] voterIDs = {3,4,5,6};
	@Override
	public boolean checkAvailability(int age, String locality, int vid) throws InValidVoterException  {
		if (checkAge(age) && checkLocality(locality) && checkVoterId(vid))
		return true;
		else return false;
	}
	private boolean checkAge(int age) throws InValidVoterException  {
		if (age<18 ) throw new UnderAgeException("under Age");
		return true;
	}
	private boolean checkLocality (String locality) throws InValidVoterException  {
		for (String loc :localities ) {
			if (loc.equals(locality)) return true;
		}
		throw new LocalityNotFoundException("Locality not found");
		//return true;
	}
	private boolean checkVoterId(int vid) throws InValidVoterException {
		if (Arrays.stream(voterIDs).anyMatch(id -> (id==vid))) return true;
		else throw new NoVoterIDException("Voted ID not found");
	}
}
