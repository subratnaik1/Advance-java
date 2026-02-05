package com.Jdbc.Lab;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcLabPro5 {
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUname = "subrat";
	String dbPwd = "67890";

	String q1 = "insert into customerinfo values(?,?,?,?,?)";

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
		Connection con = connect();
		try {
			PreparedStatement pstmt1 = con.prepareStatement(q1);
			int customerId = Integer.parseInt(IO.readln("enter costumer id"));
			String customerName = IO.readln("enter customer name");
			String customerEmail = IO.readln("enter costumer email");
			String customerPhone = IO.readln("enter customer phone no");
			pstmt1.setInt(1, customerId);
			pstmt1.setString(2, customerName);
			pstmt1.setString(3, customerEmail);
			pstmt1.setString(4, customerPhone);
			FileInputStream fs = new FileInputStream("E:\\NIT\\pic1.png");
			pstmt1.setBlob(5, fs, fs.available());
			int rs = pstmt1.executeUpdate();
			if (rs > 0) {
				IO.println("inserted");
			} else {
				IO.println("not inserted");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void main() {
		JdbcLabPro5 j5 = new JdbcLabPro5();
		j5.m1();
	}
}
