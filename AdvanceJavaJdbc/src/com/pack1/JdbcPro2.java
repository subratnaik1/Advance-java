package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcPro2 {
	String driver = "oracle.jdbc.OracleDriver";//oracle Jdbc driver name
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";//where oracle is running
	String dbUname = "subrat";//oracle user id
	String dbPwd = "67890";//oracle user password
	String querr="Select * from employee";//sql command
	String quer2="insert into employee values('102','rahulss','usaress',5,'maharastra')";
	String quer3="delete from employee where eid='102'";
	String quer4="update employee set esal=5000 where eid=5";
	Scanner sc=new Scanner(System.in);
	
	void connect() {
		try {
			IO.println("connecting to database");
			Class.forName(driver);//step 1 loading the class	
			Connection con=DriverManager.getConnection(dbUrl, dbUname, dbPwd);
			IO.println("connected SuccessFully");
		    Statement stm=con.createStatement();
		    ResultSet rs=stm.executeQuery(querr);
		    while (rs.next()) {
		    	IO.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
		    }
						
		}
		catch(Exception e) {			
		}
	}
	void insert() {
		try {
			Class.forName(driver);
			Connection cnn=DriverManager.getConnection(dbUrl, dbUname, dbPwd);
			Statement stm=cnn.createStatement();
			int rs=stm.executeUpdate(quer2);
			if(rs==0) {
				IO.println("data not inserted");
			}
			else {
				IO.println(rs+"row data inserted ");
				connect();
			}					
		}
		catch(SQLIntegrityConstraintViolationException scve) {
			IO.println("Dublicates not allowed");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	Connection conn() {
		Connection con =null;
		try {
			Class.forName(driver);	
			 con=DriverManager.getConnection(dbUrl, dbUname, dbPwd);

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	
	void deleteEmployee() {
		try {
			Connection con=conn();
			Statement stm=con.createStatement();
			int rc=stm.executeUpdate(quer3);
			if(rc==0) {
				IO.println("no row deleted");
			}
			else {
				IO.println("deleted successfully");
				char choice=sc.nextLine().charAt(0);
				switch(choice) {
				case'y','Y':
					connect();
				break;
				case 'n','N':
					IO.println("nothing to display");
					System.exit(0);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	void UpdateEmployeeDetails() {
		try {
			Connection con=conn();
			Statement stm=con.createStatement();
			int rc=stm.executeUpdate(quer4);
			if(rc==0) {
				IO.println("querry not updated");
			}
			else {
				IO.println("employee updated");
				IO.println("y/n");
				char choice=sc.nextLine().charAt(0);
				switch(choice) {
				case'y','Y':
					connect();
				break;
				case 'n','N':
					IO.println("nothing to display");
					System.exit(0);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	void main() {
//		new JdbcPro2().connect();
//		new JdbcPro2().insert();
//		new JdbcPro2().deleteEmployee();
		new JdbcPro2().UpdateEmployeeDetails();
	}
}
