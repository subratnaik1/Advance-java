package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewEmployeeDAO {
	ArrayList<EmpBean> al=new ArrayList();
	public ArrayList<EmpBean> retrive_empData(){
		try {
			Connection con=DBConnect.getCon();
			PreparedStatement pstmt=con.prepareStatement("select * from employee");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				EmpBean eb=new EmpBean();
				eb.setEmp_id(rs.getString(1));
				eb.setEmp_fname(rs.getString(2));
				eb.setEmp_lname(rs.getString(3));
				eb.setEmp_sal(rs.getInt(4));
				eb.setEmp_addr(rs.getString(5));
				
				al.add(eb);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return al;
		
	}
}
