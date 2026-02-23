package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;

public class AddEmpDAO {
	public int insertEmpdata(EmpBean eb) {
		int rowCount = 0;
		try {
	        Connection con=DBConnect.getCon();
	        PreparedStatement pstmt=con.prepareStatement("insert into employee values(?,?,?,?,?)");
	        pstmt.setString(1, eb.getEmp_id());
	        pstmt.setString(2, eb.getEmp_fname());
	        pstmt.setString(3, eb.getEmp_lname());
	        pstmt.setInt(4, eb.getEmp_sal());
	        pstmt.setString(5, eb.getEmp_addr());
	        rowCount=pstmt.executeUpdate();
		}
		catch(SQLIntegrityConstraintViolationException s) {
			s.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
		return rowCount;
	}
}
