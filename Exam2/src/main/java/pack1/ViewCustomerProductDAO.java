package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ViewCustomerProductDAO {
	public List<ProductBean> retriveCustomerData() {
		List<ProductBean> list=new ArrayList<>();
    try {
    	Connection con=DBconnect.getCon();
    PreparedStatement pstmt=con.prepareStatement("select * from products");
    ResultSet rs=pstmt.executeQuery();
    while (rs.next()) {
    	
    	ProductBean pb=new ProductBean();
    	pb.setP_id(rs.getString(1));
    	pb.setP_name(rs.getString(2));
    	pb.setP_price(rs.getInt(3));
    	pb.setQuantity(rs.getInt(4));
    	 	
    	list.add(pb);
    }
    }
    catch(Exception e) {
    	e.printStackTrace();
    }
	return list;	
	}
}
