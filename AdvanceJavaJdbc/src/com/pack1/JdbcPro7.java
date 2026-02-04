package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JdbcPro7 {
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUname = "subrat";
	String dbPwd = "67890";

	void m1() {
		try {
			IO.println("Implementing jdbcRowset");
			RowSetFactory rsf = RowSetProvider.newFactory();
			JdbcRowSet jrs = rsf.createJdbcRowSet();
			jrs.setUrl(dbUrl);
			jrs.setUsername(dbUname);
			jrs.setPassword(dbPwd);
			jrs.setCommand("select * from employee");
			jrs.execute();

			while (jrs.next()) {
				IO.println(jrs.getString(1) + " " + jrs.getString(2) + " " + jrs.getString(3) + " " + jrs.getString(4)
						+ " " + jrs.getString(5) + " ");
			}
			IO.println("--------------------");
			jrs.afterLast();
			while (jrs.previous()) {
				IO.println(jrs.getString(1) + " " + jrs.getString(2) + " " + jrs.getString(3) + " " + jrs.getString(4)
						+ " " + jrs.getString(5) + " ");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void m2() {
		IO.println("implementing cashedRowset");
		try {
			RowSetFactory rsf = RowSetProvider.newFactory();
			CachedRowSet crs = rsf.createCachedRowSet();
			crs.setUrl(dbUrl);
			crs.setUsername(dbUname);
			crs.setPassword(dbPwd);
			crs.setCommand("select eid,efname,esal from employee");
			crs.execute();

			while (crs.next()) {
				String e_id = crs.getString(1);
				if (e_id.equals("1")) {
					crs.updateInt(3, 7000);
					crs.updateRow();
				}
			}
			crs.acceptChanges();
			crs.beforeFirst();
			while (crs.getString(1).equals("9")) {
				IO.println(crs.getString(1) + " " + crs.getString(2));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void main() {
		JdbcPro7 j7 = new JdbcPro7();
		j7.m1();
		j7.m2();
	}
}
