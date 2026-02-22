package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CheckAdminDAO {

	public UserBean adminLogin(String username,String password ) {
		UserBean ub=null;
		try {
			Connection con=DBconnect.getCon();
			PreparedStatement pstmt=con.prepareStatement("select * from users where username=? and password=?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				ub=new UserBean();
				ub.setEmp_id(rs.getInt(1));
				ub.setUsername(rs.getString(2));
				ub.setPsssword(rs.getString(3));
				ub.setRole(rs.getString(4));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ub;
	}
}
