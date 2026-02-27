package pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ncus")
public class AddNewCustomerServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       
		CustomerBean bean=new CustomerBean();
		
		bean.setC_name(req.getParameter("uname"));
		bean.setC_pword(req.getParameter("pwd"));
		bean.setC_fname(req.getParameter("fname"));
		bean.setC_lname(req.getParameter("lname"));
		bean.setC_addr(req.getParameter("addr"));
		bean.setC_mid(req.getParameter("mail"));
		bean.setC_phno(req.getParameter("mno"));
		
		AddCustomerDAO regDAO_obj=new AddCustomerDAO();
		int rowCount=regDAO_obj.insert_ustomerData(bean);
		if(rowCount>0) {
			req.setAttribute("msg", "customer registered Successfully");
			req.getRequestDispatcher("Register.jsp").forward(req, res);
		}
		else {
			req.setAttribute("msg", "customer registrstion failed");
			req.getRequestDispatcher("Register.jsp").forward(req, res);
		}
	}

}
