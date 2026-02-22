package pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/pri")
public class FirstServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		int x = Integer.parseInt(req.getParameter("num"));
		int count = 0;
		for (int i = 1; i <= x; i++) {
			if (x % i == 0) {
				count++;
			}			
		}
		if (count == 2) {
			pw.println("<center><fieldset>");
			pw.println(x+"is a prime.");
			pw.println("</center></fieldset>");

		}
	}

}
