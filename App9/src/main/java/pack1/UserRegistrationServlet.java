package pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/reg")
public class UserRegistrationServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res )throws ServletException,IOException{
	UserBean bean=new UserBean();
	
	bean.setU_name(req.getParameter("uname"));
	bean.setU_pwd(req.getParameter("upwd"));
	bean.setU_fname(req.getParameter("ufname"));
	bean.setU_lname(req.getParameter("ulname"));
	bean.setU_mail(req.getParameter("umail"));
	bean.setU_phn(req.getParameter("uphn"));
	
	UserRegisterDAO regDAO_obj=new UserRegisterDAO();
	int rowCount=regDAO_obj.insert_UserData(bean);
	if(rowCount>0) {
		req.setAttribute("msg", "user registered Successfully");
		req.getRequestDispatcher("Register.jsp").forward(req, res);
	}
	else {
		req.setAttribute("msg", "user registrstion failed");
		req.getRequestDispatcher("Register.jsp").forward(req, res);
	}
	
	}

}
