package pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/upd")
public class UpdateServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException {
    BookBean bb=new BookBean();
    bb.setBook_Id(req.getParameter("bid"));
    bb.setBook_Name(req.getParameter("nm"));
    bb.setBook_Author_name(req.getParameter("Aname"));
    bb.setBook_Price(req.getParameter("pr"));
    bb.setBook_quantity(req.getParameter("qty"));
    
    UpdateDAO ud=new UpdateDAO();
    int rowCount= ud.update_Book(bb);
    if(rowCount>0) {
    	req.setAttribute("msg","book updated");
    	req.getRequestDispatcher("UpdateBook.html").forward(req, res);
    }
    else {
    	req.setAttribute("msg","book not updated");
    	req.getRequestDispatcher("UpdateBook.html").forward(req, res);
    }
    	
	}
}
