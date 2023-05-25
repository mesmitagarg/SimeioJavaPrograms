package com.bookrides.service;

import java.util.List;

import com.bookrides.model.Ride;
import com.bookrides.model.RideRequest;

public interface IBookRides {
	List<Ride> getAllMatchingRides(RideRequest riderequest);
	boolean bookRide(RideRequest riderequest ,List<Ride> matchingRides);
	boolean CancelRide(RideRequest riderequest ,List<Ride> matchingRides);
}
