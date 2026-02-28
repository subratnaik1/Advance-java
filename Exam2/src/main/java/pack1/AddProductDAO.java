package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddProductDAO {

	public int insertProduct(ProductBean pb) {
		int rowCount=0;
		try {
			Connection con=DBconnect.getCon();
			PreparedStatement pstmt=con.prepareStatement("insert into product values(?,?,?,?)");
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
