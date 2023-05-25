package com.bookrides.util;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import com.bookrides.model.Ride;
import com.bookrides.model.User;

public class RideDetails {
	static User user1 = new User ("Raman","rall","raman@gmail.com");
	static User user2 = new User ("Pavan","pall","Pavan@gmail.com");
	static User user3 = new User("Hareesha","hall","Hareesha@gmail.com");
	static User user4 = new User("Neha","nall","Neha@gmail.com");
	static User user5 = new User("Kiran","kall","Kiran@gmail.com");	
	public static List<Ride> showRides() {
		List<Ride> rides = Arrays.asList(
				new Ride(11,user1, "Ram Nagar","Shiv Nagar",LocalDateTime.now(),2,88.0),
				new Ride(22,user2, "BG Road","Prestige Park",LocalDateTime.now(),4,98.0),
				 new Ride(33,user3, "Yellenhalli","Shivaji Nagar",LocalDateTime.now(),3,66.0),
				 new Ride(44,user4, "MG Road","Akshay Nagar",LocalDateTime.now(),1,97.0),
				 new Ride(55,user5, "Ram Nagar","Shiv Nagar",LocalDateTime.now(),2,108.0)
				);
			
		return rides;
	}
	public static List<User> showUsers() {
		List<User> users = Arrays.asList(
				user1,user2,user3,user4, user5);
				
		return users;
	}
}
