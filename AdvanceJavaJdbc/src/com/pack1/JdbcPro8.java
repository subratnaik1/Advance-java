package com.pack1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcPro8 {
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUname = "subrat";
	String dbPwd = "67890";

	void m1() {
		IO.println("implementing callable statement");
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
			CallableStatement cstmt = con.prepareCall("{call INSERTDATA(?,?,?,?,?)}");
			String id = IO.readln("enter id");
			String name = IO.readln("enter name");
			String desg = IO.readln("enter desgination  name");
			int bsal = Integer.parseInt(IO.readln("entern your basic salary"));

			float tsal = bsal + (0.35f * bsal) + (0.15f * bsal);

			cstmt.setString(1, id);
			cstmt.setString(2, name);
			cstmt.setString(3, desg);
			cstmt.setInt(4, bsal);
			cstmt.setFloat(5, tsal);
			cstmt.execute();

			IO.println("data inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void main() {
		JdbcPro8 j8 = new JdbcPro8();
		j8.m1();
	}
}
