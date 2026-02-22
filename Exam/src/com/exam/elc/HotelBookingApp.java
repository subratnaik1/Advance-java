package com.exam.elc;

import java.util.Scanner;

import com.exam.blc.Discount;

public class HotelBookingApp {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		{
			System.out.println("Enter Customer Name");
			String name=sc.nextLine();
			System.out.println("Enter Hotel Name");
			String hname=sc.nextLine();
			System.out.println("Enter Room Rate per Day:");
			int roomrate=Integer.parseInt(sc.nextLine());
			System.out.println("Enter Room Rate per Day:");
			int days=Integer.parseInt(sc.nextLine());
			double bill=Double.parseDouble(sc.nextLine());
			
			System.out.println("--------- HOTEL BOOKING SUMMARY -----");
			System.out.println("Customer Name: "+name);
			System.out.println("Original Bill:"+hname);
			System.out.println("Enter Room Rate per Day:: "+name);
			
			
			System.out.println(Discount.calculateDiscount(bill));
		}

	}

}
