package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLoginDAO {

	public UserBean login(String userName,String password) {
		UserBean ub=null;
		try {
			Connection con=DBconnect.getCon();
			PreparedStatement pstmt=con.prepareStatement("select * from registration where username=? and password=?");
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				ub=new UserBean();
				ub.setU_name(rs.getString(1));
				ub.setU_pwd(rs.getString(2));
				ub.setU_fname(rs.getString(3));
				ub.setU_lname(rs.getString(4));
				ub.setU_mail(rs.getString(5));
				ub.setU_phn(rs.getString(6));
			}
		}
		catch(Exception e) {
			IO.println("Exception occured in userLoginDAO");
			e.printStackTrace();
		}
		return ub;
	}
}
