package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddCustomerDAO {

	public int insert_ustomerData(CustomerBean cb) {
		int rowCount=0;
		try {
		Connection con=DBconnect.getCon()	;
		PreparedStatement pstmt=con.prepareStatement("insert into customer values(?,?,?,?,?,?,?)");
		pstmt.setString(1, cb.getC_name());
		pstmt.setString(2, cb.getC_pword());
		pstmt.setString(3, cb.getC_fname());
		pstmt.setString(4, cb.getC_lname());
		pstmt.setString(5, cb.getC_addr());
		pstmt.setString(6, cb.getC_mid());
		pstmt.setString(7, cb.getC_phno());
		
		rowCount=pstmt.executeUpdate();
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return rowCount;
	}
}
