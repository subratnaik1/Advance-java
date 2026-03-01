package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateProductDAO2 {

	public int customerPUpdate(String pcode,String qty) {
		int rowCount =0;
		try {
			Connection con=DBconnect.getCon();
			PreparedStatement pstmt=con.prepareStatement("update products set pqty=pqty-? where pcode=?");
			pstmt.setString(1, qty);
			pstmt.setString(2, pcode);
			rowCount=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rowCount ;
	}
}
