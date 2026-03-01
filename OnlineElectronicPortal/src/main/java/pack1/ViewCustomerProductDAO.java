package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ViewCustomerProductDAO {
	public List<ProductBean> retriveCustomerData() {
		List<ProductBean> cplist=new ArrayList<>();
    try {
    	Connection con=DBconnect.getCon();
    PreparedStatement pstmt=con.prepareStatement("select * from products");
    ResultSet rs=pstmt.executeQuery();
    while (rs.next()) {
    	
    	ProductBean cb=new ProductBean();
    	cb.setP_code(rs.getString(1));
    	cb.setP_name(rs.getString(2));
    	cb.setP_company(rs.getString(3));
    	cb.setP_price(rs.getString(4));
    	cb.setP_quantity(rs.getString(5));   	
    	cplist.add(cb);
    }
    }
    catch(Exception e) {
    	e.printStackTrace();
    }
	return cplist;	
	}
}
