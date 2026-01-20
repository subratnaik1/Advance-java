package com.pack1;

import java.util.Scanner;

public class JdbcPro4 {
	Scanner sc=new Scanner(System.in);
	void library_menu() {
		System.out.println("welcome to library management system\n" + "choose your option\n" + "1-add book to the library"
				+ "2-retrive specific book" + "3-delete specific database" + "4-view all the books" + "5-exit");
		int choice =sc.nextInt();
		switch (choice) {
		case 1:
		System.out.println("Adding book onto the library");
			break;
		case 2:
			System.out.println("retriving book from the library");
			break;
		case 3:
			System.out.println("deleting book from the library");
			break;
		case 4:
			System.out.println("view all the books");
			break;
		case 5:
			System.out.println("thank you see you soon");
			System.exit(0);
			break;
		}
	}

	public static void main(String [] args) {
		IO.println("11111111111111");
     JdbcPro4 j4=new JdbcPro4();
     j4.library_menu();
	}
}
