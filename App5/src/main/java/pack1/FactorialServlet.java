package pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/fs")
public class FactorialServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		int x=Integer.parseInt(req.getParameter("num"));
		int fact=1;
		for(int i=1;i<=x;i++) {
			fact=fact*i;
		}
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("<center><h1>");
		pw.println("the factorial for : "+x+" is ====>"+fact+"<br><br>");
		pw.println("</center></h1>");
		RequestDispatcher rd = req.getRequestDispatcher("index.html");
		rd.include(req, res);
	}

}
