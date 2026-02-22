package pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/del")
public class DeleteBookServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		BookBean bb=new BookBean();
		bb.setBook_Id(req.getParameter("delete"));
		DeleteBookDAO db = new DeleteBookDAO();
		
		int rowCount=db.delete_Book(bb);
		if(rowCount>0) {
			req.setAttribute("msg","book Deleted from the records");
			req.getRequestDispatcher("addBook.html").forward(req, res);
		}
		else {
			req.setAttribute("msg","book not Deleted ");
			req.getRequestDispatcher("addBook.html").forward(req, res);
		}
	}
}
