package pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insertEmployee")
public class AddEmpServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
	    EmpBean eb=new EmpBean();
	    eb.setEmp_id(Integer.parseInt(req.getParameter("emp_id")));
	    eb.setName(req.getParameter("name"));
	    eb.setEmail(req.getParameter("email"));
	    eb.setPhone(Integer.parseInt(req.getParameter("phone")));
	    eb.setDepartmant_id(req.getParameter("department_id"));
	    eb.setSalary(Double.parseDouble(req.getParameter("salary")));
	    eb.setStatus(req.getParameter("status"));
	    
	    AddEmpDAO ad=new AddEmpDAO();
	    int rowCount=ad.AddEmployee(eb);
	    if(rowCount>0) {
	    	req.setAttribute("msg","Employee added successfully!!");
	    	req.getRequestDispatcher("AdminDashBoard.jsp").forward(req, res);
	    }
	    else {
	    	req.setAttribute("msg", "Employee not registered!!!");
	    	req.getRequestDispatcher("AdminDashBoard.jsp").forward(req, res);
	    }
	}
}
