package com.pack1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;

public class JdbcPro9 {
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUname = "subrat";
	String dbPwd = "67890";
	
	String sqlQuery = "update trainseatavailability set AVAILABLE_SEATS=AVAILABLE_SEATS-1 where TRAIN_ID =? "
			+ " and JOURNEY_DATE=? and  CLASS =? and AVAILABLE_SEATS>0 ";
	String sqlQuery2 = "insert into bookingdetails values(?,?,?,?,?)";
	String sqLQuery3 = "select PAYMENT_STATUS from costomerpayment where COSTOMER_ID=?";
	String sqLQuery4 = "update bookingdetails set STATUS='confirmed' where  COSTOMER_ID=?";

	Connection connect() {//connect method
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
			Connection con = connect();//connection established
			IO.println("before disabling auto commit==>" + con.getAutoCommit());//till now auto commit not disabled
			con.setAutoCommit(false);//here auto commit disabled
			IO.println("After disabling autocommit==>" + con.getAutoCommit());//shows auto commit false
			PreparedStatement pstmt1 = con.prepareStatement(sqlQuery);//updating available train seat to -1, where Train_id,journy_date,class will be inserted(booking a seat) 
			pstmt1.setString(1, "12345");
			pstmt1.setString(2, "20-10-10");
			pstmt1.setString(3, "sleeper");

			int rowCount = pstmt1.executeUpdate();//executing the querry
			if (rowCount <= 0) {//if row is updated then count must be >0
				throw new RuntimeException("seats not available for booking!!");//if row not updated then throws a runtime exception
			} else {
				IO.println("seat is locked for booking");
				Savepoint sp = con.setSavepoint();//till here all input done are safe 
				PreparedStatement pstmt2 = con.prepareStatement(sqlQuery2);//train seat is available so ,now you can insert data for booking seat
				pstmt2.setString(1, "B101");
				pstmt2.setString(2, "12345");
				pstmt2.setString(3, "c123");
				pstmt2.setInt(4, 1);
				pstmt2.setString(5, "payment pending");//details are entered but payment is inserted as 'still pending'
				int rowCount2 = pstmt2.executeUpdate();//booking details inserted
				if (rowCount2 == 0) {
					throw new RuntimeException("booking record not inserted");//if row not inserted then throws a runtime exception
				} else {
					IO.println("booking record created \n awating for payment confirmation!!!");//if row inserted then moving forward for payment processing
					PreparedStatement pstmt3 = con.prepareStatement(sqLQuery3);
					pstmt3.setString(1, "c123");//entering costomer_id to retrive the payment status of costomer
					ResultSet rs = pstmt3.executeQuery();//executing query
					String status = "failed";//initially assume status=failed
					if (rs.next()) {
						status = rs.getString(1);//fatches payment status from costomerpayment
						if (status.equals("failed")) {//if fatches failed then
							throw new RuntimeException("tranction failed");//throws runtime exception.
						} else {
							PreparedStatement pstmt4 = con.prepareStatement(sqLQuery4);//else execute updates as confirmed.
							pstmt4.setString(1, "c123");//set costomer id.
							int rowCount3 = pstmt4.executeUpdate();
							if (rowCount3 == 0) {	//if no row updated.
								throw new RuntimeException("transaction failed at payment portal");//throws exception.
							} else {
								IO.println("ticket successfully BOOKED");//else booked.
								con.commit();
							}
						}
					}
					else {
						IO.println("transaction failed");
					}
				}
				// con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	void main() {
		JdbcPro9 j9 = new JdbcPro9();
		// j9.connect();
		j9.m1();
	}
}
