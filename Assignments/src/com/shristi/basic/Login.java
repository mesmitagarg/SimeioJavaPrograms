package com.shristi.basic;

import java.util.Scanner;

public class Login {

	public static void main(String[] args) {
		String usernames[] = {"smita", "Neha","Kiran", "Harisha"};
		boolean found = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter name to Login");
		String name = sc.next();
				
		for (var username:usernames) {
			if (name.equals(username)) found=true;
		}
		if (found) System.out.println("Logged in successfully");
		else System.out.println("Invalid user name");

	}

}
