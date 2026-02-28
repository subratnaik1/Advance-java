package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateProductDAO {

	public int updateProduct(ProductBean pb) {
		int rowCount=0;
		try {
			Connection con=DBconnect.getCon();
			PreparedStatement pstmt=con.prepareStatement("update product set pprice=?,pqty=? where pcode=?");
			pstmt.setString(1, pb.getP_id());
			pstmt.setString(2, pb.getP_name());
			pstmt.setInt(3, pb.getP_price());
			pstmt.setInt(4, pb.getQuantity());
			
			rowCount=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}
}
