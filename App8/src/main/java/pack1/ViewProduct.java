package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewProduct {
ArrayList<ProductBean> pb=new ArrayList();
public ArrayList<ProductBean> retrive_product(){
	Connection con =DBconnect.getCon();
	try {
		PreparedStatement pstmt=con.prepareStatement("select * from product1");
		ResultSet rs=	pstmt.executeQuery();
		while(rs.next()) {
			ProductBean p=new ProductBean();
			p.setP_code(rs.getString(1));
			p.setP_name(rs.getString(2));
			p.setP_company(rs.getString(3));
			p.setP_price(rs.getString(4));
			p.setP_quantity(rs.getString(5));
			
			pb.add(p);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return pb;
}
}
