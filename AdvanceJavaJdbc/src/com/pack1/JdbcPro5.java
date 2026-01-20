package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcPro5 {
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbuName = "subrat";
	String dbPwd = "67890";

	Connection connect() {
		Connection con = null;
		try {
			IO.println("connecting");
			Class.forName(driver);
			con = DriverManager.getConnection(dbUrl, dbuName, dbPwd);
			IO.println("connected");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	void patient_operations() {
		try {
			Connection con = connect();
			PreparedStatement pstm = con.prepareStatement("insert into patient values(?,?,?,?)");
			while (true) {

				IO.println("-------patient data---------");
				IO.println("1-Add patient details");
				IO.println("2-retrive patient details");
				IO.println("3-update patient details");
				IO.println("4-delete patient details");
				IO.println("5-exit");
				int choice = Integer.parseInt(IO.readln("enter your choice"));
				switch (choice) {

				case 1:
					String pid = IO.readln("enter patient id");
					String pname = IO.readln("enter patient name");
					int age = Integer.parseInt(IO.readln("enter age"));
					long pcontact = Long.parseLong(IO.readln("enter contact number"));

					pstm.setString(1, pid);
					pstm.setString(2, pname);
					pstm.setInt(3, age);
					pstm.setLong(4, pcontact);
					int result = pstm.executeUpdate();
					if(result>0) {
						IO.println("patient inserted");						
					}
					else {
						IO.println("not inserted");
					}
					break;

				case 5:System.exit(0);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void main() {
		JdbcPro5 j5=new JdbcPro5();
		j5.patient_operations();
	}
}
