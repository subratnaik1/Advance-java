package pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/alog")
public class AdminLoginServlet extends HttpServlet {
    @Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
	AdminBean ab=new AdminLoginDAO().login(req.getParameter("a_name"), req.getParameter("a_pwd"));
	if(ab==null) {
		req.setAttribute("msg", "Invalid login credentials!!");
		req.getRequestDispatcher("adminlogin.html").forward(req, res);
	}
	else {
		HttpSession session=req.getSession();
		session.setAttribute("AdminBean", ab);
		Cookie ck=new Cookie("ck1",ab.getA_fname());
		res.addCookie(ck);
		req.getRequestDispatcher("AdminHome.jsp").forward(req, res);	
	}	
	}
}
