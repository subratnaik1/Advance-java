package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Arrays;

public class JdbcPro14 {
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUname = "subrat";
	String dbPwd = "67890";
	
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
	void m1(){
		IO.println("implementing batch processing");
		try {
			Connection con=connect();
			Statement stmt=con.createStatement();
			int no_of_queries=Integer.parseInt(IO.readln("enter how many querries you want to add to the batch"));
			for(int i=1;i<=no_of_queries;i++) {
				stmt.addBatch(IO.readln());
			}
			IO.println(no_of_queries+"queries added to the batch");
			int rowCount[]=stmt.executeBatch();
			IO.println("==="+Arrays.toString(rowCount));
			stmt.clearBatch();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
void main() {
	JdbcPro14 j14=new JdbcPro14();
	j14.m1();
}
}
