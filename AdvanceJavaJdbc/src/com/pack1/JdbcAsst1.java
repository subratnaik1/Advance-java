package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcAsst1 {
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbName = "subrat";
	String dbPwd = "67890";

	Connection connect() {
		Connection con = null;
		try {
			IO.println("connection database");
			Class.forName(driver);
			con = DriverManager.getConnection(dbUrl, dbName, dbPwd);
			IO.println("connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	void add_emp() {
		try {
			Connection con = connect();
			PreparedStatement pstm1 = con.prepareStatement("insert into  employeeregistration values(?,?,?,?,?,?,?)");
			PreparedStatement pstm2 = con.prepareStatement("select * from  employeeregistration where ename=? and pword=?");
			PreparedStatement pstm3 = con.prepareStatement("update employeeregistration set addr=?,phn=? where ename=?");

			int choice = Integer.parseInt(IO.readln("enter your choice"));
			switch (choice) {
			case 1:
				String ename = IO.readln("enter employee name");
				String pword = IO.readln("enter employee password");
				String fname = IO.readln("enter employee firse name");
				String lname = IO.readln("enter employee last name");
				String address = IO.readln("enter employee address");
				String mail = IO.readln("enter employee mail id");
				long phone = Long.parseLong(IO.readln("enter phone number"));

				pstm1.setString(1, ename);
				pstm1.setString(2, pword);
				pstm1.setString(3, fname);
				pstm1.setString(4, lname);
				pstm1.setString(5, address);
				pstm1.setString(6, mail);
				pstm1.setLong(7, phone);
				int result = pstm1.executeUpdate();
				if (result > 0) {
					IO.println("employee ADDED");
				} else {
					IO.println("employee NOT ADDED");
				}
			case 2:
				String ename2 = IO.readln("enter employee name");
				String pword2 = IO.readln("enter employee password");
				pstm2.setString(1, ename2);
				pstm2.setString(2, pword2);
				ResultSet rs2 = pstm2.executeQuery();
				if (rs2.next()) {
					IO.println("------employee found-----");
					IO.println("1-view profile");
					IO.println("2-update profile");
					IO.println("3-exit");
					int choice2=Integer.parseInt(IO.readln("enter choice"));
					switch(choice2) {
					case 1:
						IO.println(
								rs2.getString(1) + " " + rs2.getString(2) + " " + rs2.getString(3) + " " + rs2.getString(4)
										+ " " + rs2.getString(5) + " " + rs2.getString(6) + " " + rs2.getString(7));
					case 2:
						String ename21 = IO.readln("enter employee name");
						String address21 = IO.readln("update 	employee address");
						long phone21 = Long.parseLong(IO.readln("update phone number"));
                        pstm3.setString(1, address21);
                        pstm3.setLong(2,phone21);
                        pstm3.setString(3, ename21);
                        ResultSet rs21 = pstm3.executeQuery();
                        if(rs21.next()) {
                        	IO.println("updated");
                        }
                        else {
                        	IO.println("not updated");
                        }
					case 3:
						System.exit(0);
					}
				} else {
					IO.println("data not found");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void main() {
		JdbcAsst1 j1 = new JdbcAsst1();
		j1.add_emp();
	}
}
