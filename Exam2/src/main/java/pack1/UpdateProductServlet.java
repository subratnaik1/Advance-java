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

@WebServlet("/b")
public class UpdateProductServlet extends HttpServlet{

	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		
			ProductBean pb=new ProductBean();			
			int rowCount=new UpdateProductDAO().updateProduct(pb);
			if(rowCount>0) {
				req.setAttribute("msg", "product inventory not updated");
				req.getRequestDispatcher("UpdateProduct.jsp").forward(req, res);
			}
			else {
				req.setAttribute("msg", "product inventory updated successfully");
				req.getRequestDispatcher("UpdateProduct.jsp").forward(req, res);
			}
		}
	}

