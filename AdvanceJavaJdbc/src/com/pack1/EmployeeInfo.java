package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class EmployeeInfo {
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUname = "subrat";
	String dbPwd = "67890";

	String q1="select * from studentinfo where emp_id=? and emp_name=?";
    String q2="select * from studentinfo";
    String q3="update studentinfo set emp_mailid=? ,emp_phno=? where emp_id=?";
    String q4="delete from studentinfo where emp_sal between 50000 and 70000";
    String q5="update studentinfo set emp_sal=emp_sal+(emp_sal*0.10) ";
    
	Connection connect() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	void m1() {
		try {
			IO.println("logging in");
			Connection con=connect();
			con.setAutoCommit(true);
			PreparedStatement pstmt1=con.prepareStatement(q1);	
			PreparedStatement pstmt2=con.prepareStatement(q2);	
			PreparedStatement pstmt3=con.prepareStatement(q3);
			PreparedStatement pstmt4=con.prepareStatement(q4);	
			PreparedStatement pstmt5=con.prepareStatement(q5);	
			
			String emp_id=IO.readln("enter id");
			String emp_name=IO.readln("enter name");
			pstmt1.setString(1, emp_id);
			pstmt1.setString(2, emp_name);
			ResultSet rs1=pstmt1.executeQuery();
			if(rs1.next()) {
				IO.println("1-Show all employees");
				IO.println("2-update MAILID & PHNO based in ID");
				IO.println("3-DELETE employees whose salary between 50000-70000");
				IO.println("4-INCREASE 10% salary on each employee");
				
			    int choice=Integer.parseInt(IO.readln("enter your choice"));
			    switch(choice) {
			    case 1->{
			    	ResultSet rs2=pstmt2.executeQuery();
			    	while(rs2.next()) {
					IO.println(rs2.getString(1)+" "+rs2.getString(2)+" "+rs2.getString(3)+" "+rs2.getString(4)+" "+rs2.getString(5)+" "+rs2.getString(6)+" "+rs2.getString(7)+" ");
			    	}
			    }
			    case 2->{
			    	String emp_mailid2=IO.readln("enter mail id"); 
			    	Long emp_phno2=Long.parseLong(IO.readln("enter phone no"));
			    	String emp_id2=IO.readln("enter employee id");
			    	pstmt3.setString(1, emp_mailid2);
			    	pstmt3.setLong(2, emp_phno2);
			    	pstmt3.setString(3, emp_id2);
			    	int rs3=pstmt3.executeUpdate();
			    	if(rs3>0) {
			    		IO.println("row updated");
			    	}
			    	else {
			    		IO.println("not updated");
			    	}
			    }
			    case 3->{
			    	int rs4=pstmt4.executeUpdate();
			    	if(rs4>0) {
			    		IO.println("DELETED employees whose salary between 50000-70000");
			    	}
			    	else {
			    		IO.println("not deleted");
			    	}			    	
			    }
			    case 4->{
			    	int rs5=pstmt5.executeUpdate();
			    	if(rs5>0) {
			    		IO.println("Incresed salary of every employee bu 10 %");
			    	}
			    	else {
			    		IO.println("no increment");
			    	}	
			    }
			    }
			}
			else {
				IO.println("login failed");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void main() {
		EmployeeInfo e = new EmployeeInfo();
	e.m1();
	}
}
