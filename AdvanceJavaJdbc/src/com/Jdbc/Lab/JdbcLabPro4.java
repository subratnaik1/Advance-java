package com.Jdbc.Lab;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;

public class JdbcLabPro4 {
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
	void m1() {
		IO.println("implementing collable statement procedure retriveEmp");
		try {
			Connection con=connect();
			CallableStatement pc1 =con.prepareCall("{call retriveEmp(?,?,?)}");
			pc1.setString(1, "1");
            pc1.registerOutParameter(1, Types.VARCHAR);
            pc1.registerOutParameter(2, Types.NUMERIC);
            pc1.registerOutParameter(3, Types.VARCHAR);
			pc1.execute();
			
				IO.println(pc1.getString(1)+" "+pc1.getInt(2)+" "+pc1.getString(3));
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

	void main() {
		JdbcLabPro4 j4 = new JdbcLabPro4();
        j4.m1();
	}
}

//Assignment02:
//============
//step-1 :Construct Procedure to display the complete details of student based on stuId.
//CREATE OR REPLACE PROCEDURE retriveEmp(
//		  2      s_id     IN  VARCHAR2,
//		  3      s_roll   OUT NUMBER,
//		  4      s_branch OUT VARCHAR2
//		  5  ) IS
//		  6  BEGIN
//		  7      SELECT sturollno, stubranch
//		  8      INTO   s_roll, s_branch
//		  9      FROM   studata
//		 10      WHERE  stuid = s_id;
//		 11  END;
//		 12  /
//step-2 :Construct JDBC Application to execute Procedure.
//
