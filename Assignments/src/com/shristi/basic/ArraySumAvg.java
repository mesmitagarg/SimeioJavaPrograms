package com.shristi.basic;

import java.util.Scanner;

public class ArraySumAvg {

	public static void main(String[] args) {
		int marks[] = new int[4];
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("Enter %d Marks",marks.length );
		/*marks[0] = sc.nextInt();
		marks[1] = sc.next();
		marks[2] = sc.next();*/
		int sum = 0;
		int average;
		for (int i = 0; i < marks.length; i++) 
		{
			marks[i]=sc.nextInt();
		}
		for (var num:marks)
			sum+=num;
		average = sum/marks.length;
		System.out.println(sum);
		System.out.println(average);
		


	}

}
