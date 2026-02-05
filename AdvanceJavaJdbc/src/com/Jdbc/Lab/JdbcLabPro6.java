package com.Jdbc.Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcLabPro6 {
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUname = "subrat";
	String dbPwd = "67890";

	String q1 = "insert into student_info values(?,?,?,?,?)";
	String q2 ="select STUDENTPHOTO from student_info where STUDENTID =?";

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
		Connection con = connect();
		try {
			PreparedStatement pstmt = con.prepareStatement(q1);
			int studentId = Integer.parseInt(IO.readln("enter student id"));
			String studentName = IO.readln("enter name");
			String studentEmail = IO.readln("enter student email");
			String studentCourse = IO.readln("enter student course");
			String studentPhoto = IO.readln("enter photo path");
			pstmt.setInt(1, studentId);
			pstmt.setString(2, studentName);
			pstmt.setString(3, studentEmail);
			pstmt.setString(4, studentCourse);
			FileInputStream fs = new FileInputStream(studentPhoto);
			pstmt.setBlob(5, fs, fs.available());
			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				IO.println("inserted");
			} else {
				IO.println("not inserted");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void m2() {
		Connection con = connect();
		try {
			PreparedStatement pstmt1=con.prepareStatement(q2);
			pstmt1.setInt(1, 1);
			ResultSet rs=pstmt1.executeQuery();
			if(rs.next()) {
				Blob b=rs.getBlob(1);
				byte arr[]=b.getBytes(1, (int)b.length());
				FileOutputStream fo=new FileOutputStream("E:\\NIT\\pic3.png");
				fo.write(arr);
				IO.println("image retrived");
			}
			else {
				IO.println("not retrived");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	void main() {
		JdbcLabPro6 j6 = new JdbcLabPro6();
		//j6.m1();
		j6.m2();
	}
}
