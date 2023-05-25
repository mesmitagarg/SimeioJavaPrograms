package com.bookrides.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.bookrides.model.Ride;
import com.bookrides.model.RideRequest;
import com.bookrides.model.User;
import com.bookrides.util.RideDetails;

public class BookRideImpl implements IBookRides {
	@Override
	public List<Ride> getAllMatchingRides(RideRequest riderequest) {
		List<User> users = RideDetails.showUsers();
		boolean userExists = users.stream()
				.anyMatch(user -> user.getUsername().equals(riderequest.getUser().getUsername()));
		if (userExists) {
			List<Ride> matchingRides = RideDetails.showRides();

			return matchingRides.stream()
					.filter(ride -> ride.getDestination().equals(riderequest.getDestination())
							&& ride.getSource().equals(riderequest.getSource()))
					.filter(ride -> ride.getAvailableSeats() >= riderequest.getNoOfSeats())
					.collect(Collectors.toList());
		} else
			return null;

	}

	private Optional<Ride> getRideByUser(User userDriver, List<Ride> matchingRides) {
		return matchingRides.stream().filter(ride -> ride.getDriver().getUsername().equals(userDriver.getUsername()))
				.findFirst();

	}

	@Override
	public boolean bookRide(RideRequest riderequest, List<Ride> matchingRides) {
		Optional<Ride> matchRide = matchingRides.stream()
				.filter(ride -> (ride.getRideID() == riderequest.getRideIDMapped())).findFirst();
		if (matchRide.isPresent()) {
			Ride bookedRide = matchRide.get();
			bookedRide.getPassengers().add(riderequest.getUser());
			int availableSeats = bookedRide.getAvailableSeats();
			bookedRide.setAvailableSeats(availableSeats - riderequest.getNoOfSeats());

			return true;
		} else
			return false;
	}

	@Override
	public boolean CancelRide(RideRequest riderequest, List<Ride> matchingRides) {
		Optional<Ride> matchRide = matchingRides.stream()
				.filter(ride -> (ride.getRideID() == riderequest.getRideIDMapped())).findFirst();
		if (matchRide.isPresent()) {
			Ride bookedRide = matchRide.get();
			boolean isRemoved = bookedRide.getPassengers().remove(riderequest.getUser());
			if (isRemoved) {
				int availableSeats = bookedRide.getAvailableSeats();
				bookedRide.setAvailableSeats(availableSeats + riderequest.getNoOfSeats());
				return true;
			} else
				return false;
		} else
			return false;
	}

}
