package pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/a")
public class AddProductServlet extends HttpServlet{
@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException ,IOException{
		ProductBean pb=new ProductBean();
//		IO.println(req.getParameter("code"));
		pb.setP_code(req.getParameter("code"));
		pb.setP_name(req.getParameter("name"));
		pb.setP_company(req.getParameter("company"));
		pb.setP_price(req.getParameter("price"));
		pb.setP_quantity(req.getParameter("quantity"));
		
		AddProduct1 addP=new AddProduct1();
		int RowCount=addP.insertProductdata(pb);
		if(RowCount>0) {
			req.setAttribute("msg","Product record inserted");
			req.getRequestDispatcher("AddProduct.jsp").forward(req, res);
		}
		else {
			throw new RuntimeException("product record not inserted");
		}		
	}
}
