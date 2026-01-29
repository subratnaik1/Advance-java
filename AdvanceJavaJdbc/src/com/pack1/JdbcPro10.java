package com.pack1;

import java.sql.Connection;
import java.util.*;

public class JdbcPro10 {
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUname = "subrat";
	String dbPwd = "67890";

	void m1() {
		ConnectionPool cp = new ConnectionPool(driver, dbUrl, dbUname, dbPwd);
		cp.con_Initialization();
		IO.println("------user1-------");
		Connection con1 = cp.con_Acquasition();
		IO.println("user1 :" + con1);
		IO.println("==>" + cp.v1.size());
		IO.println("------user2-------");
		Connection con2 = cp.con_Acquasition();
		IO.println("user1 :" + con2);
		IO.println("==>" + cp.v1.size());
		IO.println("------user3-------");
		Connection con3 = cp.con_Acquasition();
		IO.println("user1 :" + con3);
		IO.println("==>" + cp.v1.size());

		IO.println("============");
		cp.con_return(con1);
		cp.con_return(con2);
		cp.con_return(con3);
	}

	void main() {
		JdbcPro10 j10 = new JdbcPro10();
         j10.m1();
	}
}
