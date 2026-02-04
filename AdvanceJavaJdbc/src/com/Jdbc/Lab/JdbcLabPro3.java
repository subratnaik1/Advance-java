package com.Jdbc.Lab;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcLabPro3 {
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUname = "subrat";
	String dbPwd = "67890";
	
	Connection connect() {
		Connection con = null;
		try {
			IO.println("connecting");
			Class.forName(driver);
			con = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
			IO.println("connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	void m1() {
		IO.println("implementing collable statement procedure insertdata");
		try {
			Class.forName(driver);
			Connection con=connect();
			CallableStatement pc1=con.prepareCall("{call insertdata(?,?,?,?,?,?,?,?)}");
			String stuid=IO.readln("enter id");
			int sturollno=Integer.parseInt(IO.readln("enter studentroll"));
			String stubranch=IO.readln("enter student branch");
			String stuhno=IO.readln("enter house no");
			String city=IO.readln("enter your city");
			String pincode=IO.readln("enter pin code");
			String mid=IO.readln("enter mail id");
			int phno=Integer.parseInt(IO.readln("enter phon number"));
			
         pc1.setString(1, stuid);
         pc1.setInt(2,sturollno);
         pc1.setString(3, stubranch);
         pc1.setString(4, stuhno);
         pc1.setString(5, city);
         pc1.setString(6, pincode);
         pc1.setString(7, mid);
         pc1.setInt(8, phno);
         pc1.execute();
         IO.println("data inserted");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void main() {
		JdbcLabPro3 j3=new JdbcLabPro3();
		j3.m1();
	}
}
//Assignment01:
//============
//step-1 : Create the following DB Tables
//StuData(stuId,stuRollNo,stuName,stuBranch)
//StuAddress(stuId,stuHno,city,pincode)
//StuContact(stuId,mid,phno)
//
//step-2 : Construct Procedure to insert student details into DB Tables.
//step-3 : Construct JDBC Application to execute Procedure.


