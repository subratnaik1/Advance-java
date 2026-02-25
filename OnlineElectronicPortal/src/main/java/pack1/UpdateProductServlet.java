package pack1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/update")
public class UpdateProductServlet extends HttpServlet{

	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		
		HttpSession session=req.getSession(false);
		if(session==null) {
			throw new RuntimeException("session expires");
		}
		else {
			String pcode=req.getParameter("pcode");
			String price=req.getParameter("price");
			String quantity=req.getParameter("qty");
			
			ArrayList<ProductBean> al = (ArrayList<ProductBean>) session.getAttribute("productList");
			Iterator<ProductBean> i = al.iterator();
			ProductBean pb = null;
			while (i.hasNext()) {
				pb = i.next();
				if (pcode.equals(pb.getP_code())) {
					break;
				}
			}
			pb.setP_price(price);
			pb.setP_quantity(quantity);
			
			int rowCount=new UpdateProductDAO().updateProduct(pb);
			if(rowCount>0) {
				req.setAttribute("msg", "product inventory updated successfully");
				req.getRequestDispatcher("UpdateProduct.jsp").forward(req, res);
			}
			else {
				req.setAttribute("msg", "product inventory not updated");
				req.getRequestDispatcher("UpdateProduct.jsp").forward(req, res);
			}
		}
	}
}
