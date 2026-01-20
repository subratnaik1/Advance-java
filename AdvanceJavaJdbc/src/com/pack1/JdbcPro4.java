package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcPro4 {
	String driver="oracle.jdbc.OracleDriver";
	String dbUrl="jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUname="subrat";
	String dbPwd="67890";
	
	
	Scanner sc=new Scanner(System.in);
	
	Connection connect() {
		Connection con=null;
		try {
			IO.println("connecting to database");
			Class.forName(driver);
			con=DriverManager.getConnection(dbUrl, dbUname, dbPwd);
			IO.println("connected");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
	void library_menu() {
		System.out.println("welcome to library management system\n" + "choose your option\n" + "1-add book to the library\n"
				+ "2-retrive specific book\n" + "3-delete specific database\n" + "4-view all the books\n" + "5-exit");
		int choice =sc.nextInt();
		switch (choice) {
		case 1:
		System.out.println("Adding book onto the library");
		
		int bookId=Integer.parseInt(IO.readln("enter book id"));
		String bookName=IO.readln("enter bookname");
		String author=IO.readln("enter author name");
		String genere=IO.readln("enter genere name");
		int bookCost=Integer.parseInt(IO.readln("enter the cost of book"));
		String addq="insert into library values("+bookId+",'"+bookName+"','"+author+"','"+genere+"',"+bookCost+")";
		try {
			Connection c=connect();
			Statement stm=c.createStatement();
			int rs=stm.executeUpdate(addq);
			if(rs==1) {
				IO.println("row added");
			}
			else {
				IO.println("roow not added");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
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
     JdbcPro4 j4=new JdbcPro4();
     j4.library_menu();
    // j4.connect();
	}
}
