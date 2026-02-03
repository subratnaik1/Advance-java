package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcPro15 {
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUname = "subrat";
	String dbPwd = "67890";

	String q1 = "select * from food";
	String q2 = "select food_name,price from food where food_id=?";
	String q3 = "insert into orders values(?,?,?,?)";
	String q4 = "select * from orders";

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

	void showItems() {
		Connection con = connect();
		try {
			PreparedStatement pstmt1 = con.prepareStatement(q1);
			ResultSet rs1 = pstmt1.executeQuery();
			while (rs1.next()) {
				IO.println(rs1.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void insertCalculate() {
		Connection con = connect();
		try {
			PreparedStatement pstmt2 = con.prepareStatement(q2);
			PreparedStatement pstmt3 = con.prepareStatement(q3);
			PreparedStatement pstmt4 = con.prepareStatement(q4);

			int food_id = Integer.parseInt(IO.readln("enter food id"));
			int quantity = Integer.parseInt(IO.readln("enter quantity"));

			pstmt2.setInt(1, food_id);
			ResultSet rs2 = pstmt2.executeQuery();
			while (rs2.next()) {
				String foodName = rs2.getString(1);
				int price = rs2.getInt(2);
				int totalPrice = price * quantity;
				IO.println("item :" + foodName);
				IO.println("price :" + price);
				IO.println("=======================");
				IO.println("total Price:" + totalPrice);

				int orderId = (int) (Math.random() * 100);
				pstmt3.setInt(1, orderId);
				pstmt3.setInt(2, food_id);
				pstmt3.setInt(3, quantity);
				pstmt3.setInt(4, totalPrice);
				pstmt3.executeUpdate();
				ResultSet rs4 = pstmt4.executeQuery();
				while (rs4.next()) {
					IO.println(rs4.getInt(1) + " " + rs4.getInt(2) + " " + rs4.getInt(3) + " " + rs4.getInt(4));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	void main() {
		JdbcPro15 j15 = new JdbcPro15();
		
		j15.insertCalculate();

	}
}
