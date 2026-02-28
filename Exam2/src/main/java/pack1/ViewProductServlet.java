package pack1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/view")
public class ViewProductServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		ViewCustomerProductDAO vd = new ViewCustomerProductDAO();
		ArrayList<ProductBean> al = (ArrayList<ProductBean>) vd.retriveCustomerData();
		req.getRequestDispatcher("ViewProduct.jsp").forward(req, res);
	}

}
