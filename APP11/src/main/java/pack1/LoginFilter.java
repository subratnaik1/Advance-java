package pack1;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
@WebFilter("/log")
public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc)
			throws IOException, ServletException {
		UserBean ub=new UserLoginDAO().checkLogin(req.getParameter("uname"), req.getParameter("upwd"));
		if (ub==null) {
			throw new RuntimeException("Invalid login credentials");
		}
		else {
			req.setAttribute("userBean", ub);
			fc.doFilter(req, res);
		}
	}

}
