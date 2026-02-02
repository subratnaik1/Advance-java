package com.pack1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcPro12 {
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUname = "subrat";
	String dbPwd = "67890";
	String q1="insert into mydatabase values(?,?)";
	String q2="Select pic_data from mydatabase where id=?";
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
		try {
			
			Connection con=connect();
			PreparedStatement pstmt1=con.prepareStatement(q1);
			pstmt1.setString(1, "101");
			FileInputStream fis=new FileInputStream("E:\\NIT\\pic1.png");
			pstmt1.setBlob(2, fis, fis.available());
			int rowCount=pstmt1.executeUpdate();
			if(rowCount==0) {
				throw new RuntimeException("not inserted");
			}
			else {
				IO.println("inserted");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}       
	}
	void m2() {
		IO.println("retriving image");
		try {
			Connection con=connect();
			PreparedStatement pstmt2=con.prepareStatement(q2);
			pstmt2.setString(1, "101");
			ResultSet rs=pstmt2.executeQuery();
			if(rs.next()) {
				Blob b=rs.getBlob(1);
				byte arr[]=b.getBytes(1,(int) b.length());
				FileOutputStream fos=new  FileOutputStream("E:\\NIT\\pic2.png");
				fos.write(arr);
				IO.println("image retrived");
			}
			else {
				IO.println("image not found");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
void main() {
	JdbcPro12 j12=new JdbcPro12();
	//j12.m1();
	j12.m2();

}
}
