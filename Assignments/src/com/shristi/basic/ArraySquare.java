package com.shristi.basic;

import java.util.Scanner;

public class ArraySquare {

	public static void main(String[] args) {
		int numbers[] = new int[4];
		double sqrtnumbers[] = new double[4];
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("Enter %d Numbers",numbers.length );
		
		int j=0;
		
		for (int i = 0; i < numbers.length; i++) 
		{
			numbers[i]=sc.nextInt();
		}
		for (var num:numbers) {
			sqrtnumbers[j]= Math.sqrt(num);
			j=j+1;
		}
		for (var sqrtnum:sqrtnumbers) {
			System.out.println(sqrtnum);
		}
		
	}

}
