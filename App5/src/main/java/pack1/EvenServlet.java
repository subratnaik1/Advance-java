package pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/es")
public class EvenServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int x=Integer.parseInt(req.getParameter("num"));
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("<center><h1>");
		if(x%2==0) {
			pw.println(x+" ix even number");
		}
		else {
			pw.println(x+" ix even odd");
		}
	}

}
