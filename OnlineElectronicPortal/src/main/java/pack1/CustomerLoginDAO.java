package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerLoginDAO {
	public CustomerBean login(String username,String password) {
		CustomerBean cb=null;
		try {
			Connection con=DBconnect.getCon();
			PreparedStatement pstmt=con.prepareStatement("select * from customer where uname=? and pword=?");
			pstmt.setString(1,username);
			pstmt.setString(2,password);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				cb=new CustomerBean();
				cb.setC_name(rs.getString(1));
				cb.setC_pword(rs.getString(2));
				cb.setC_fname(rs.getString(3));
				cb.setC_lname(rs.getString(4));
				cb.setC_addr(rs.getString(5));
				cb.setC_mid(rs.getString(6));
				cb.setC_phno(rs.getString(7));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return cb;
	}
}
