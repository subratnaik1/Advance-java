package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
	
void main() {
	JdbcPro3 j3=new JdbcPro3();
	j3.viewDetails();
}
}
