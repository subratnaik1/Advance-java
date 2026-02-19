package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AdminDAO {
public int insert_userData(AdminBean ab) {
	int rowCount=0;
	try {
		Connection con=DBconnect.getCon();
		PreparedStatement pstmt=con.prepareStatement("insert into  adminregistration values(?,?,?,?,?,?)");
		pstmt.setString(1, ab.getAdmin_name());
		pstmt.setString(2, ab.getAdmin_password());
		pstmt.setString(3, ab.getAdmin_First_name());
		pstmt.setString(4, ab.getAdmin_last_name());
		pstmt.setString(5, ab.getMail_id());
		pstmt.setString(6, ab.getPhone_no());
		
		rowCount=pstmt.executeUpdate();
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return rowCount;
}
}
