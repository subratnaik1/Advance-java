package pack1;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/buy")
public class BuyProductServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		
		String pcode=req.getParameter("pcode");
		ProductBean pb=new BuyProductServletDAO().getProduct(pcode);
		req.setAttribute("product", pb);
		req.getRequestDispatcher("BuyProduct.jsp").forward(req, res);
						
	}

}
