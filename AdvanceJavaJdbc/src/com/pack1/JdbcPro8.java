package com.pack1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class JdbcPro8 {
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUname = "subrat";
	String dbPwd = "67890";

	Connection connect() {
		Connection con = null;
		try {
			IO.println("connecting to database");
			Class.forName(driver);
			con = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
			IO.println("connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

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

	void m2() {
		IO.println("implementing callable statement===>procedure2");
		try {
			Connection con = connect();
			CallableStatement cstmt = con.prepareCall("{call retriveEmpData(?,?,?,?,?)}");
			String e_id = IO.readln("enter id");
			cstmt.setString(1, e_id);
			cstmt.registerOutParameter(2, Types.VARCHAR);
			cstmt.registerOutParameter(3, Types.VARCHAR);
			cstmt.registerOutParameter(4, Types.NUMERIC);
			cstmt.registerOutParameter(5, Types.NUMERIC);
			cstmt.execute();
			IO.println("---------employee details-------");
			IO.println("employee id " + e_id);
			IO.println("employee name " + cstmt.getString(2));
			IO.println("employee desg " + cstmt.getString(3));
			IO.println("employee basic sal " + cstmt.getInt(4));
			IO.println("employee total sal " + cstmt.getInt(5));
		} catch (Exception e) {
			IO.println(e.getMessage());
		}
	}
    void m3() {
		IO.println("implementing callable statement===>functions");
		try {
			Connection con=connect();
			CallableStatement cstmt =con.prepareCall("{call ?:=RetriveTsal(?)}");
			String e_id = IO.readln("enter id");
			cstmt.setString(2, e_id);
			cstmt.registerOutParameter(1, Types.NUMERIC);
			cstmt.execute();
			IO.println("---------employee details-------");
			IO.println("employee id" + e_id);
			IO.println("employee total sal" + cstmt.getInt(1));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
    }

	void main() {
		JdbcPro8 j8 = new JdbcPro8();
		j8.m1();
		//j8.m2();
		//j8.m3();
	}
}
