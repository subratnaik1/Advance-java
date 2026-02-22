package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;

public class AddProduct1 {
	public int insertProductdata(ProductBean pb) {
		int rowCount = 0;
		try {
			Connection con = DBconnect.getCon();
			PreparedStatement pstmt = con.prepareStatement("insert into Product1 values(?,?,?,?,?)");
			pstmt.setString(1, pb.getP_code());
			pstmt.setString(2, pb.getP_name());
			pstmt.setString(3, pb.getP_company());
			pstmt.setString(4, pb.getP_price());
			pstmt.setString(5, pb.getP_quantity());
			rowCount = pstmt.executeUpdate();
		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
		}
		catch(Exception s) {
			s.printStackTrace();
		}
		return rowCount;
	}
}
