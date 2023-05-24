package com.shristi.basic;

import java.util.Scanner;

public class Registration {

	public static void main(String[] args) {
		String usernames[] = {"smita", "Neha","Kira", "Harisha"};
		boolean found = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter name to register");
		String name = sc.nextLine();
		
		for (var username:usernames) {
			if (name.equals(username)) found=true;
		}
		if (found) System.out.println("Name is not unique");
		else System.out.println("You are Registered");
		
	}

}
