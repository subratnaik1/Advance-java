package pack1;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
@Override
public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException {
	AdminBean ab=new AdminBean();
	if(ab==null) {
		req.setAttribute("msg", "invalid login credentials");
		req.getRequestDispatcher("login.html").forward(req, res);
		
	}
	else {
		ServletContext context=req.getServletContext();
		context.setAttribute("AdminBean", ab.getAdmin_name());
		Cookie ck=new Cookie("ck1",ab.getAdmin_First_name());
		res.addCookie(ck);
		req.getRequestDispatcher("loginSuccess.html").forward(req, res);
	}
}
}
