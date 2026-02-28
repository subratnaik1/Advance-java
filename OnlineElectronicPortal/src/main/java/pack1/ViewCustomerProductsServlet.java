package pack1;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/view2")
public class ViewCustomerProductsServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req,HttpServletResponse res )throws ServletException ,IOException{
		List<ProductBean> list=new ViewCustomerProductDAO().retriveCustomerData();
		req.setAttribute("msg", list);
		req.getRequestDispatcher("ViewProduct2.jsp").forward(req, res);
	}
		    

}
