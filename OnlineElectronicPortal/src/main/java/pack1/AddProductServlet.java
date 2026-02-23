package pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/aps")
public class AddProductServlet extends HttpServlet{

	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		HttpSession session=req.getSession(false);
		if(session==null) {
			throw new RuntimeException("Session Expired");
		}
		else {
			ProductBean pb=new ProductBean();
			
			pb.setP_code(req.getParameter("pcode"));
			pb.setP_name(req.getParameter("pname"));
			pb.setP_company(req.getParameter("pcomp"));
			pb.setP_price(req.getParameter("pprice"));
			pb.setP_quantity(req.getParameter("pqty"));
			
			int rowCount=new AddProductDAO().insertProduct(pb);
			if(rowCount>0) {
				req.setAttribute("msg", "product inserted successfully");
				req.getRequestDispatcher("AddProduct.jsp").forward(req, res);
			}
			else {
				throw new RuntimeException("product insertion failed");
			}
		}
	}
}
