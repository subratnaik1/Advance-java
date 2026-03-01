package pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/upd")
public class UpdateProductServlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		if (session == null) {
			throw new RuntimeException("session expires");
		} else {
			String pcode = req.getParameter("pcode");
			String qty = req.getParameter("qty");
			String price=req.getParameter("pprice");
			if(pcode==null||qty==null) {
				req.setAttribute("msg", "Invalid product code or quantity");
				req.getRequestDispatcher("OrderConfirmed.jsp").forward(req, res);
			}
			int msg1=Integer.parseInt(price)*Integer.parseInt(qty);
			int rowcount=new UpdateProductDAO2().customerPUpdate(pcode, qty);
			if(rowcount>0) {
				String msg="you have been charged "+msg1+"";
				req.setAttribute("msg",msg);
				req.getRequestDispatcher("OrderConfirmed.jsp").forward(req, res);
			}
			else {
				req.setAttribute("msg", "Update failed. Check product code or quantity");
				req.getRequestDispatcher("OrderConfirmed.jsp").forward(req, res);
			}
		}
	}
}
