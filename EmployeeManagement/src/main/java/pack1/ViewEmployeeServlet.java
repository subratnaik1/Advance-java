package pack1;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/viewEmployees")
public class ViewEmployeeServlet extends HttpServlet{
    @Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
	
		ViewEmployeeDAO ve=new ViewEmployeeDAO();
		List<EmpBean>list=ve.getAllEmployees();
		
		req.setAttribute("msg", list);
		
		req.getRequestDispatcher ("ViewEmployee.jsp").forward(req, res);
	}
}
