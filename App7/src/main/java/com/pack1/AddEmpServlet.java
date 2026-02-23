package com.pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/aes")
public class AddEmpServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
		EmpBean eb=new EmpBean();
		eb.setEmp_id(req.getParameter("eid"));
		eb.setEmp_fname(req.getParameter("efname"));
		eb.setEmp_lname(req.getParameter("elname"));
		eb.setEmp_sal(Integer.parseInt(req.getParameter("esal")));
		eb.setEmp_addr(req.getParameter("eaddr"));
		
		AddEmpDAO addDAO_obl=new AddEmpDAO();
		int rowCount=addDAO_obl.insertEmpdata(eb);
		if(rowCount>0) {
			req.setAttribute("msg", "Employee Record inserted successfully");
			req.getRequestDispatcher("AddEmployee.jsp").forward(req, res);
		}
		else
			throw new RuntimeException("Employee record not inserted");
			
	}
}
