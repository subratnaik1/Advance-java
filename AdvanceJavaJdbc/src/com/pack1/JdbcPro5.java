package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
			PreparedStatement pstm1 = con.prepareStatement("insert into patient values(?,?,?,?)");
			PreparedStatement pstm2 = con.prepareStatement("select * from patient");
			PreparedStatement pstm3 = con.prepareStatement("select * from patient where pid=?");
			PreparedStatement pstm4 = con.prepareStatement("update patient set age=? where pid=?");
			PreparedStatement pstm5 = con.prepareStatement("delete from patient where pid=?");
			while (true) {

				IO.println("-------patient data---------");
				IO.println("1-Add patient details");
				IO.println("2-view all patients");
				IO.println("3-retrive patient details");
				IO.println("4-update patient details");
				IO.println("5-delete patient details");
				IO.println("6-exit");
				int choice = Integer.parseInt(IO.readln("enter your choice"));
				switch (choice) {

				case 1:
					String pid = IO.readln("enter patient id");
					String pname = IO.readln("enter patient name");
					int age = Integer.parseInt(IO.readln("enter age"));
					long pcontact = Long.parseLong(IO.readln("enter contact number"));

					pstm1.setString(1, pid);
					pstm1.setString(2, pname);
					pstm1.setInt(3, age);
					pstm1.setLong(4, pcontact);
					int result = pstm1.executeUpdate();
					if (result > 0) {
						IO.println("patient inserted");
					} else {
						IO.println("not inserted");
					}
					break;
				case 2:
					ResultSet rs = pstm2.executeQuery();
					while (rs.next()) {
						IO.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
					}
					break;
				case 3:
					String pid3 = IO.readln("enter patient id");
					pstm3.setString(1, pid3);
					ResultSet rs3 = pstm3.executeQuery();
					if (rs3.next()) {
						IO.println(rs3.getString(1) + " " + rs3.getString(2) + " " + rs3.getString(3));
					} else {
						IO.println("not foind dta for");
					}
					break;
				case 4:
					String pid4 = IO.readln("enter patient id");
					int age4 = Integer.parseInt(IO.readln("enter age"));
					pstm4.setInt(1, age4);
					pstm4.setString(2, pid4);
					int result4 = pstm4.executeUpdate();
					if (result4 > 0) {
						IO.println("patient uppdated");
					} else {
						IO.println("not found");
					}

					break;
				case 5:
					String pid5 = IO.readln("enter patient id");
					pstm5.setString(1, pid5);
					int result5 = pstm5.executeUpdate();
					if (result5 > 0) {
						IO.println("patient record deleted");
					} else {
						IO.println("patient record not found");
					}

				case 6:
					IO.println("thank u for visiting");
					System.exit(0);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void main() {
		JdbcPro5 j5 = new JdbcPro5();
		j5.patient_operations();
	}
}
