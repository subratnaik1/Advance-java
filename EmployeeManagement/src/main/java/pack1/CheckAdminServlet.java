package pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/alogin")
public class CheckAdminServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		UserBean ub = new CheckAdminDAO().adminLogin(req.getParameter("username"), req.getParameter("password"));
		if (ub != null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", ub);
			if (ub.getRole().equalsIgnoreCase("admin")) {
			  	req.getRequestDispatcher("AdminDashBoard.jsp").forward(req, res);
			} else if (ub.getRole().equalsIgnoreCase("employee")) {

				req.getRequestDispatcher("EmployeeDashBoard.jsp").forward(req, res);
			}
		} else {
			req.setAttribute("msg", "Invalid login credentials!!!");
			req.getRequestDispatcher("login.html").forward(req, res);
		}
	}
}
