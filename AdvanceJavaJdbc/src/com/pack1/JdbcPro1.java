package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcPro1 {
	String drivers = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUname = "subrat";
	String dbPwd = "67890";

	void connect() {
		System.out.println("connecting to database");
		try {
			Class.forName(drivers);
			Connection con = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
			IO.println("connection created");
		} catch (Exception e) {
         e.printStackTrace();
		}
	}
	void main() {
		JdbcPro1 jp=new JdbcPro1();
		jp.connect();
	}
}
