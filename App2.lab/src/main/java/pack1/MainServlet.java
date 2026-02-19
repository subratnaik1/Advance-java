package pack1;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/fs")
public class MainServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String p=req.getParameter("choice");
		IO.println(p);
		if(p.equals("prime")) {
			req.getRequestDispatcher("/pri").forward(req, res);
		}
		else if(p.equals("factor")) {
			req.getRequestDispatcher("/fact").forward(req, res);
		}
		else if(p.equals("factorial")) {
			req.getRequestDispatcher("/factori").forward(req, res);
		}
		else if(p.equals("square")) {
			req.getRequestDispatcher("/sq").forward(req, res);
		}
	}

}
