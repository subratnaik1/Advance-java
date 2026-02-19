package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateDAO {
	public int update_Book(BookBean bb) {
		int rowCount = 0;
		try {
			Connection con = DBconnect.getCon();
			PreparedStatement pstmt = con.prepareStatement("update book set bookname=?,bookauthorname=?,bookprice=?,bookqty=? where bookid=?");
			pstmt.setString(1, bb.getBook_Name());
			pstmt.setString(2, bb.getBook_Author_name());
			pstmt.setString(3, bb.getBook_Price());
			pstmt.setString(4, bb.getBook_quantity());
			pstmt.setString(5, bb.getBook_Id());

			rowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}
}
