package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ViewEmployeeDAO {
	public List<EmpBean> getAllEmployees(){
		List<EmpBean>list=new ArrayList<>();
		try{
			Connection con=DBconnect.getCon();
			PreparedStatement pstmt=con.prepareStatement("select * from employees");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				EmpBean eb=new EmpBean();
				eb.setEmp_id(rs.getInt(1));
				eb.setName(rs.getString(2));
				eb.setEmail(rs.getString(3));
				eb.setPhone(rs.getLong(4));
				eb.setDepartmant_id(rs.getString(5));
				eb.setSalary(rs.getDouble(6));
				eb.setStatus(rs.getString(7));
				
				list.add(eb);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
