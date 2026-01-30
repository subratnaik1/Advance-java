package com.Jdbc.Lab;

import java.sql.*;

public class JdbcLabPro2 {
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbName = "subrat";
	String dbPwd = "67890";

	String q1 = "insert into product values(?,?,?,?)";
	String q2 = "Select * from product";

	Connection connect() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(dbUrl, dbName, dbPwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	void m1() {

		Connection con = connect();
		try {
			while (true) {	
			IO.println("");
			IO.println("1.Insert productdetails into product table.");
			IO.println("2.Retrieve productdetails in forward direction.");
			IO.println("3.Retrieve productdetails in reverse direction.");
			IO.println("4.Retrieve 3rd record from top");
			IO.println("5.Retrieve 3rd record from bottom.");
			IO.println("6.Retrieve last three record from product table");
			IO.println("");
			int choice = Integer.parseInt(IO.readln("enter your choice:"));
            IO.println("");
			PreparedStatement pstmt1 = con.prepareStatement(q1);
			PreparedStatement pstmt2 = con.prepareStatement(q2);
			PreparedStatement pstmt3 = con.prepareStatement(q2, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			switch (choice) {
			case 1 -> {

				String pid = IO.readln("enter product id");
				String pname = IO.readln("enter product name");
				int pprice = Integer.parseInt(IO.readln("enter product price"));
				int pqty = Integer.parseInt(IO.readln("enter product quantity"));

				pstmt1.setString(1, pid);
				pstmt1.setString(2, pname);
				pstmt1.setInt(3, pprice);
				pstmt1.setInt(4, pqty);

				int rs1 = pstmt1.executeUpdate();
				if (rs1 > 0) {
					IO.println("row inserted");
				} else {
					IO.println("not inserted");
				}
			}
			case 2 -> {
				ResultSet rs2 = pstmt2.executeQuery();
				while (rs2.next()) {
					IO.println(rs2.getString(1) + " " + rs2.getString(2) + " " + rs2.getString(3) + " "
							+ rs2.getString(4) + " ");
				}
			}
			case 3 -> {
				ResultSet rs3 = pstmt3.executeQuery();
				rs3.afterLast();
				while (rs3.previous()) {
					IO.println(rs3.getString(1) + " " + rs3.getString(2) + " " + rs3.getString(3) + " "
							+ rs3.getString(4) + " ");
				}
				rs3.beforeFirst();
			}
			case 4 -> {
				ResultSet rs4 = pstmt3.executeQuery();
				if (rs4.absolute(3)) {
					IO.println(rs4.getString(1) + " " + rs4.getString(2) + " " + rs4.getString(3) + " "
							+ rs4.getString(4) + " ");
				}
				rs4.afterLast();
			}
			case 5 -> {
				ResultSet rs5 = pstmt3.executeQuery();
				if (rs5.absolute(-3)) {
					IO.println(rs5.getString(1) + " " + rs5.getString(2) + " " + rs5.getString(3) + " "
							+ rs5.getString(4) + " ");
				}
			}
			case 6 -> {
				ResultSet rs6 = pstmt3.executeQuery();
				rs6.afterLast();
				int count = 0;
				while (rs6.previous() && count < 3) {
					IO.println(rs6.getString(1) + " " + rs6.getString(2) + " " + rs6.getString(3) + " "
							+ rs6.getString(4) + " ");
					count++;
				}
			}

			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	void main() {
		JdbcLabPro2 j2 = new JdbcLabPro2();
		j2.m1();
	}
}
