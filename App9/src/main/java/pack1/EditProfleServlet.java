package pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/edit")
public class EditProfleServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Cookie arr[] = req.getCookies();
		String user_name = null;
		if (arr == null) {
			req.setAttribute("msg", "seccion Expired!!!");
			req.getRequestDispatcher("Register.jsp").forward(req, res);
		} else {
			for (Cookie c : arr) {
				if ("ck1".equals(c.getName())) {
					user_name = c.getValue();
					System.out.print(user_name);
				}
			}
			req.setAttribute("user_name", user_name);
			req.getRequestDispatcher("EditProfile.jsp").forward(req, res);
			
	}
}
}
