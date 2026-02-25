package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateProductDAO {

	public int updateProduct(ProductBean pb) {
		int rowCount=0;
		try {
			Connection con=DBconnect.getCon();
			PreparedStatement pstmt=con.prepareStatement("update products set pprice=?,pqty=? where pcode=?");
			pstmt.setString(1, pb.getP_price());
			pstmt.setString(2, pb.getP_quantity());
			pstmt.setString(3, pb.getP_code());
			
			rowCount=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}
}
