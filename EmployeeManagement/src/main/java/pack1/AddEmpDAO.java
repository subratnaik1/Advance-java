package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddEmpDAO {

	public  int AddEmployee(EmpBean eb) {
	int rowCount=0;
			try {
			Connection con=DBconnect.getCon();
			PreparedStatement pstmt=con.prepareStatement("insert into employees values(?,?,?,?,?,?,?)");
			pstmt.setInt(1, eb.getEmp_id());
			pstmt.setString(2, eb.getName());
			pstmt.setString(3, eb.getEmail());
			pstmt.setInt(4, eb.getPhone());
			pstmt.setString(5, eb.getDepartmant_id());
			pstmt.setDouble(6, eb.getSalary());
			pstmt.setString(7, eb.getStatus());
			
			rowCount=pstmt.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}
			return rowCount;
	}
}
