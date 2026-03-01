package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BuyProductServletDAO {

	public ProductBean getProduct(String pcode) {
		ProductBean pb=null;
		try {
			Connection con=DBconnect.getCon();
			PreparedStatement pstmt=con.prepareStatement("select * from products where pcode=?");
			pstmt.setString(1, pcode);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				pb=new ProductBean();
				pb.setP_code(rs.getString(1));
				pb.setP_name(rs.getString(2));
				pb.setP_company(rs.getString(3));
				pb.setP_price(rs.getString(4));
				pb.setP_quantity(rs.getString(5));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return pb;
	}
}
