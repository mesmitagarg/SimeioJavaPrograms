package com.bookrides.main;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.bookrides.model.Ride;
import com.bookrides.model.RideRequest;
import com.bookrides.model.User;
import com.bookrides.service.BookRideImpl;
import com.bookrides.service.IBookRides;

public class QuickRides {

	public static void main(String[] args) {
		User user1 = new User ("Pavan","pall","pavan@gmail.com");
		RideRequest riderequest = new RideRequest(user1, "Ram Nagar","Shiv Nagar",LocalDateTime.now(),1);
		IBookRides bookRide= new BookRideImpl();
		List<Ride> mathchingRides = bookRide.getAllMatchingRides(riderequest);
		if (mathchingRides!=null)
			mathchingRides.forEach(ride-> System.out.println(ride));
		else {
			System.out.println("Invalid User"); return;
		}
		System.out.println("select the Ride by entering Ride ID");
		Scanner sc = new Scanner(System.in);
		riderequest.setRideIDMapped(sc.nextInt());
		boolean isRideBooked =  bookRide.bookRide(riderequest, mathchingRides);
		if (isRideBooked) System.out.println(riderequest.getRideIDMapped()+" Ride is Confirmed");
		else System.out.println(riderequest.getRideIDMapped()+" Ride does not exist. Give the valid Entry.");
		mathchingRides.forEach(ride-> System.out.println(ride));
		Ride confirmedRide = mathchingRides.stream().filter(ride-> (ride.getRideID() == riderequest.getRideIDMapped()))
		.findFirst().get();
		confirmedRide.getPassengers().forEach(user -> System.out.println(user.getUsername()));
		
		
		System.out.println("Do You want to Cancel the Ride ? (Y/N)");
		if (sc.next().equals("Y")) {
			boolean isRideCancel =bookRide.CancelRide(riderequest, mathchingRides);
			if (isRideCancel) System.out.println(riderequest.getRideIDMapped()+" Ride is Cancelled");
			else System.out.println(riderequest.getRideIDMapped()+" Ride cannot be Cancelled.");
		}
		mathchingRides.forEach(ride-> System.out.println(ride));
		Ride cancelledRide = mathchingRides.stream().filter(ride-> (ride.getRideID() == riderequest.getRideIDMapped()))
				.findFirst().get();
		cancelledRide.getPassengers().forEach(user -> System.out.println(user.getUsername()));
				
	}

}
