package com.bookrides.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Ride {
	private int rideID;
	 private User driver;
	    private List<User> passengers;
	    private String source;
	    private String destination;
	    private LocalDateTime departureTime;
	    private int availableSeats;
	    private double fare;

	    public Ride(int rideID, User driver, String source, String destination, LocalDateTime departureTime, int availableSeats, double fare) {
	        this.rideID = rideID;
	    	this.driver = driver;
	        this.source = source;
	        this.destination = destination;
	        this.departureTime = departureTime;
	        this.availableSeats = availableSeats;
	        this.fare = fare;
	        this.passengers = new ArrayList<>();
	    }
	    
		public int getRideID() {
			return rideID;
		}

		public void setRideID(int rideID) {
			this.rideID = rideID;
		}

		public User getDriver() {
			return driver;
		}

		public void setDriver(User driver) {
			this.driver = driver;
		}

		public List<User> getPassengers() {
			return passengers;
		}

		public void setPassengers(List<User> passengers) {
			this.passengers = passengers;
		}

		public String getSource() {
			return source;
		}

		public void setSource(String source) {
			this.source = source;
		}

		public String getDestination() {
			return destination;
		}

		public void setDestination(String destination) {
			this.destination = destination;
		}

		public LocalDateTime getDepartureTime() {
			return departureTime;
		}

		public void setDepartureTime(LocalDateTime departureTime) {
			this.departureTime = departureTime;
		}

		public int getAvailableSeats() {
			return availableSeats;
		}

		public void setAvailableSeats(int availableSeats) {
			this.availableSeats = availableSeats;
		}

		@Override
		public String toString() {
			return "Ride ID=" + rideID +", driver=" + driver.getUsername() + ", source=" + source + ", destination="
					+ destination + ", departureTime=" + departureTime + ", availableSeats=" + availableSeats
					+ ", fare=" + fare;
		}

}
