package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcPro3 {
	
	String driver="oracle.jdbc.OracleDriver";
	String dbUrl="jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUname="subrat";
	String dbPwd="67890";
	String quer1="select * from employee";
	
	
	Connection connect() {
		Connection con=null;
		try {
//			IO.println("connection started");
			Class.forName(driver);
			con=DriverManager.getConnection(dbUrl, dbUname, dbPwd);
//			IO.println("connecion done");
		}
		catch(Exception e){
			e.printStackTrace();
		}		
		return con;
	}
	void viewDetails() {
		try {
			connect();
			Connection con=connect();
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(quer1);	
			IO.println("-----------employee details------------");
			while(rs.next()) {
				IO.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
			}
			IO.println("--------------------------------------------------");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	void insert() {
		try {
			Connection con=connect();
			String eid=IO.readln("ENTER EID");
			String efname=IO.readln("ENTER EFNAME");
			String eLname=IO.readln("ENTER ELNAME");
			int esal=Integer.parseInt(IO.readln("ENTER E SAL"));
			String eAddress=IO.readln("ENTER E ADDRESS");
			String quer2="insert into employee values('"+eid+"','"+efname+"','"+eLname+"',"+esal+",'"+eAddress+"')";
			Statement stm=con.createStatement();
			int rs=stm.executeUpdate(quer2);
			
			if (rs==0) {
				IO.println("row not inserted");
			}
			else {
				IO.println("row inserted");
				viewDetails();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	void search() {
		try {
			Connection con=connect();
			String eid=IO.readln("ENTER EID");
			String quer3="select * from employee where eid='"+eid+"'";
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(quer3);
			while(rs.next()) {
				IO.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
			}			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	void delete() {
		try {
			Connection con=connect();
			String eid=IO.readln("ENTER EID");
			String quer4="delete from employee where eid='"+eid+"'";
			Statement stm=con.createStatement();
			int rs=stm.executeUpdate(quer4);
			
			if (rs==0) {
				IO.println("row not found");
			}
			else {
				IO.println("row deleted");
				viewDetails();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	void uRecord() {
		try {
			Connection con=connect();
			String eid=IO.readln("ENTER EID");
			int esal=Integer.parseInt(IO.readln("ENTER E SAL"));
			String quer6="update employee set esal='"+esal+"' where eid='"+eid+"'";
			Statement stm=con.createStatement();
			int rs=stm.executeUpdate(quer6);
			if(rs==0) {
				IO.println("RECORD NOT AVAILABLE");
			}
			else {
				viewDetails();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
void main() {
	JdbcPro3 j3=new JdbcPro3();
	//j3.viewDetails();
	//j3.insert();
	//j3.search();
	//j3.delete();
	j3.uRecord();
}
}
