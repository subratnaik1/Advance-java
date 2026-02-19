package com.exam.elc;

import java.util.Scanner;

import com.exam.blc.Discount;

public class ShoppingCart {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		{
			System.out.println("Enter Customer Name");
			String name=sc.nextLine();
			System.out.println("Entertotal billamount ");
			double bill=Double.parseDouble(sc.nextLine());
			
			System.out.println("Customer Name: "+name);
			System.out.println("Original Bill:"+bill);
			System.out.println(Discount.calculateDiscount(bill));
		}

	}

}
