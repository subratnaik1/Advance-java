package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddBookDAO {

	public int insert_Book(BookBean bb) {
		int rowCount = 0;
		try {
			Connection con = DBconnect.getCon();
			PreparedStatement pstmt = con.prepareStatement("insert into book values(?,?,?,?,?)");
			pstmt.setString(1, bb.getBook_Id());
			pstmt.setString(2, bb.getBook_Name());
			pstmt.setString(3, bb.getBook_Author_name());
			pstmt.setString(4, bb.getBook_Price());
			pstmt.setString(5, bb.getBook_quantity());

			rowCount = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}
}
