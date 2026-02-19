package pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reg")
public class RegisterServlet extends HttpServlet {
     @Override 
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException	
	{
		AdminBean ab=new AdminBean();
		ab.setAdmin_name(req.getParameter("adName"));
		ab.setAdmin_password(req.getParameter("adpwd"));
		ab.setAdmin_First_name(req.getParameter("adfName"));
		ab.setAdmin_last_name(req.getParameter("adlName"));
		ab.setMail_id(req.getParameter("admail"));
		ab.setPhone_no(req.getParameter("adphno"));
		 
		AdminDAO regDAO_obj=new AdminDAO();
		int rowCount= regDAO_obj.insert_userData(ab);
		if(rowCount>0) {
			req.setAttribute("msg", "Adminn registered Successfully");
			req.getRequestDispatcher("AdminRegister.jsp").forward(req, res);
		}
		else {
			req.setAttribute("msg", "Adminn NOT registered ");
			req.getRequestDispatcher("AdminRegister.jsp").forward(req, res);
		}
	}
}
