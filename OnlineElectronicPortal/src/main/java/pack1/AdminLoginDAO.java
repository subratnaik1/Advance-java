package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminLoginDAO {

	public AdminBean login(String username,String password) {
		AdminBean ab=null;
		try {
			Connection con=DBconnect.getCon();
			PreparedStatement pstmt=con.prepareStatement("select * from admin where uname=? and pword=?");
			pstmt.setString(1,username);
			pstmt.setString(2,password);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				ab=new AdminBean();
				ab.setA_name(rs.getString(1));
				ab.setA_pwd(rs.getString(2));
				ab.setA_fname(rs.getString(3));
				ab.setA_lname(rs.getString(4));
				ab.setA_addr(rs.getString(5));
				ab.setA_mid(rs.getString(6));
				ab.setA_phn(rs.getString(7));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ab;
	}
}
