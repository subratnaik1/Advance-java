package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;

public class ConnectionPool {
	String driver, dbUrl, dbUname, dbPwd;
	Vector<Connection> v1 = new Vector<Connection>();

	public ConnectionPool(String driver, String dbUrl, String dbUname, String dbPwd) {
		super();
		this.driver = driver;
		this.dbUrl = dbUrl;
		this.dbUname = dbUname;
		this.dbPwd = dbPwd;

	}
public void con_Initialization() {
	IO.println("connection pool is empety");
	IO.println("there are "+v1.size()+" connection objects");
	while(v1.size()<5) {
		try {
			Class.forName(driver);
			Connection con=DriverManager.getConnection(dbUrl, dbUname, dbPwd);
			v1.addElement(con);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	for(Object o:v1) {
		IO.println(o);
		IO.println("there are "+v1.size()+" connection objects");
	}
}
public Connection con_Acquasition() {
	Connection con=v1.get(0);
	v1.remove(0);
	return con;
}
public void con_return(Connection con) {
	IO.println("adding the connection object to the connection pool");
	v1.addElement(con);
	IO.println("there are "+v1.size()+"connections object");
	for(Object o:v1) {
		IO.println(o);
	}
}
}
