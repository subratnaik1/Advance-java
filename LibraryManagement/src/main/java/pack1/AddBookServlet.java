package pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addb")
public class AddBookServlet extends HttpServlet {
    @Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException ,IOException{
		BookBean bb=new BookBean();
		bb.setBook_Id(req.getParameter("addid"));
		bb.setBook_Name(req.getParameter("addbname"));
		bb.setBook_Author_name(req.getParameter("addbau"));
		bb.setBook_Price(req.getParameter("addbprice"));
		bb.setBook_quantity(req.getParameter("addbqty"));
		
		AddBookDAO abd=new AddBookDAO();
		int rowCount=abd.insert_Book(bb);
		if(rowCount>0) {
			req.setAttribute("msg", "Book added Successfully!!!");
			req.getRequestDispatcher("AddBook.jsp").forward(req, res);
		}
		else {
			req.setAttribute("msg", "Book not added");
			req.getRequestDispatcher("AddBook.jsp").forward(req, res);
		}
		
	}
}
