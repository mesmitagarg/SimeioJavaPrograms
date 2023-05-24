package com.voterapp.main;

import com.voterapp.Service.ElectionBoothImpl;
import com.voterapp.Service.IElectionBooth;

public class Voter {

	public static void main(String[] args) {
		IElectionBooth electionBooth= new ElectionBoothImpl();
		try {
		if (electionBooth.checkAvailability(19, "BG", 1))
			System.out.println("eligible");
		
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
