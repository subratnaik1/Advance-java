package com.Jdbc.Lab;

import java.util.*;
import java.sql.*;

record Employee(int id, String name, int age, double salary) {

}

public class JdbcLabPro1 {
	List<Employee>e=new ArrayList<>();
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbName = "subrat";
	String dbPwd = "67890";
    
	String q1="select * from emp";
	String q2="select * from emp where age>25";
	Connection connect() {
		Connection con = null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(dbUrl, dbName, dbPwd);
			IO.println("connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	void m1() {
     Connection con=connect();
     try {
    	 PreparedStatement pstmt1=con.prepareStatement(q1);
    	 PreparedStatement pstmt2=con.prepareStatement(q2);
    	 
    	 ResultSet rs1=pstmt1.executeQuery();
    	 while(rs1.next()) {
    		int id=rs1.getInt(1);
    		String name=rs1.getString(2);
    		int age=rs1.getInt(3);
    		double salary=rs1.getDouble(4);
    		e.add(new Employee(id,name,age,salary)); 
    		}
    	 for(Employee e1:e) {
    		 IO.println(e1);
    		
    	 }
    	 ResultSet rs2=pstmt2.executeQuery();
         while(rs2.next()) {
        	 IO.println(rs2.getInt(1)+" "+rs2.getInt(2)+" "+rs2.getInt(3)+" "+rs2.getInt(4)+" ");
         }
     }
     catch(Exception e) {
    	 e.printStackTrace();
     }
	}

	void main() {
		JdbcLabPro1 j1 = new JdbcLabPro1();
        j1.m1();
	}
}

/*Assignment01:
============
You are tasked with developing a Java application that interacts with a relational database using JDBC. The application needs to perform a series of database operations within a single transaction. Your task is to design and implement a Java program that accomplishes the following:
Connect to a database of your choice (e.g., MySQL, Oracle, PostgreSQL) using JDBC.
 
=>create a table and insert records. your table data should represent as below.

Table Name: Employee:
======================
Column name          data type
-----------	    -----------
Id		     number(8)
name		     varchar2(20)
age		     number(3)
salary		     number(8,2)

Employee Data:
==============
1	Naresh	22	23432.6
2	Suresh	23	32222.5
3	Jain	32	43332.6
4	David	27	15009.2
5	Anthony	34	32322.5

Create Employee class:
======================
instance variables:
-------------------
int id;
String name;
int age;
double salary;

retrive the data from employee table and store it in list<Employee> objecct;

get list of employees who are older than 25 years.

Expected output:
---------------- 
3	Jain	32	43332.6
4	David	27	15009.2
5	Anthony	34	32322.5*/