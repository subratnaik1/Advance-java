package pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/factori")
public class ThirdServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		int x=Integer.parseInt(req.getParameter("num"));
		int fact=1;
		for(int i=1;i<=x;i++) {
			fact=fact*i;
		}
		pw.println("</center></fieldset>");
		pw.println("factorial of "+x+": "+fact);
	}

}
