package com.bookrides.model;

import java.time.LocalDateTime;

public class RideRequest {
	private User user;
    private String source;
    private String destination;
    private LocalDateTime requestTime;
    private int noOfSeats;
    private int rideIDMapped;

    public RideRequest(User user, String source, String destination, LocalDateTime requestTime, int noOfSeats) {
        this.user = user;
        this.source = source;
        this.destination = destination;
        this.requestTime = requestTime;
        this.noOfSeats = noOfSeats;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getSource() {
		return source;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
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

	public LocalDateTime getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(LocalDateTime requestTime) {
		this.requestTime = requestTime;
	}

	public int getRideIDMapped() {
		return rideIDMapped;
	}

	public void setRideIDMapped(int rideIDMapped) {
		this.rideIDMapped = rideIDMapped;
	}

    // Getters and setters
}
