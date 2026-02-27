package pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/clog")
public class CustomerLoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
	CustomerBean cb=new CustomerLoginDAO().login(req.getParameter("c_name"), req.getParameter("c_pwd"));
	if(cb==null) {
		req.setAttribute("msg", "Invalid Admin login credentials!!");
		req.getRequestDispatcher("customerlogin.html").forward(req, res);
	}
	else {
		
		HttpSession session=req.getSession();
		session.setAttribute("customerBean", cb);
				
		req.getRequestDispatcher("CustomerHome.jsp").forward(req, res);	
	}	
	}

}
