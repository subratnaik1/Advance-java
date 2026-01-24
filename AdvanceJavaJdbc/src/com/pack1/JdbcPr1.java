package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcPr1 {
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUname = "subrat";
	String dbPwd = "67890";
	String q1 = ("select * from library");

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

	void show() {
		try {
			Connection con = connect();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(q1);
			rs.last();
			IO.println("last");
			IO.println(rs.getObject(1) + " " + rs.getObject(2) + " " + rs.getObject(3) + " " + rs.getObject(4) + " "
					+ rs.getObject(5));
			while (rs.previous()) {
				IO.println(rs.getObject(1) + " " + rs.getObject(2) + " " + rs.getObject(3) + " " + rs.getObject(4) + " "
						+ rs.getObject(5));
			}
			rs.relative(3);
			IO.println(rs.getObject(1) + " " + rs.getObject(2) + " " + rs.getObject(3) + " " + rs.getObject(4) + " "
					+ rs.getObject(5));
			rs.relative(-1);
			IO.println(rs.getObject(1) + " " + rs.getObject(2) + " " + rs.getObject(3) + " " + rs.getObject(4) + " "
					+ rs.getObject(5));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void main() {
		JdbcPr1 j1 = new JdbcPr1();
		j1.show();
	}
}
