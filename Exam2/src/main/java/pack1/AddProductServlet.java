package pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/a")
public class AddProductServlet extends HttpServlet{

	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		
			ProductBean pb=new ProductBean();
			
			pb.setP_id(req.getParameter("pid"));
			pb.setP_name(req.getParameter("pname"));
			pb.setP_price(Integer.parseInt(req.getParameter("pprice")));
			pb.setQuantity(Integer.parseInt(req.getParameter("pqty")));
			
			int rowCount=new AddProductDAO().insertProduct(pb);
			if(rowCount>0) {
				req.setAttribute("msg", "product inserted successfully");
				req.getRequestDispatcher("AddSuccess.jsp").forward(req, res);
			}
			else {
				throw new RuntimeException("product insertion failed");
			}
		}
	
}
