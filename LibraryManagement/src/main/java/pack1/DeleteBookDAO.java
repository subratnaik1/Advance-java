package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteBookDAO {
	public int delete_Book(BookBean bb) {

		int rowCount = 0;
		try {
			Connection con = DBconnect.getCon();
			PreparedStatement pstmt = con.prepareStatement("delete from book where bookid=?");
			pstmt.setString(1, bb.getBook_Id());
			rowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}

}
