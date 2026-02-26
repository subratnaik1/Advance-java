package pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/delete")
public class DeleteProductServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException ,IOException {
		HttpSession session=req.getSession(false);
		if(session==null) {
			throw new RuntimeException("session expired");
		}
		else {
			int rowCount=new DeleteProductDAO().deleteProduct(req.getParameter("pcode"));
			if(rowCount>0) {
				req.setAttribute("msg", "product deleted!!");
				req.getRequestDispatcher("DeleteProduct.jsp").forward(req, res);
			}
			else {
				req.setAttribute("msg", "product deletion failed");
				req.getRequestDispatcher("DeleteProduct.jsp").forward(req, res);
			}
		}
	}

}
