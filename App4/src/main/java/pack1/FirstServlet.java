package pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/fs")
public class FirstServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	String userName=req.getParameter("uname");
	String password=req.getParameter("pwd");
	String ProductName=req.getParameter("pname");
	String ProductId=req.getParameter("pid");
	int ProductQuantity=Integer.parseInt(req.getParameter("pqty"));
	double ProductPrice=Double.parseDouble(req.getParameter("pprice"));
	
	if(ProductQuantity<=5) {
		ProductPrice=(ProductPrice+(ProductPrice*0.10));
	}
	PrintWriter pw=res.getWriter();
	res.setContentType("text/html");
	if(userName.equals("subrat") && password.equals("123")) {
		
		 pw.println("<center><h1>");
		 pw.println("user Data<br>");
		 pw.println("Produc tName :"+ProductName+"<br><br>");
		 pw.println("Product Id :"+ProductId+"<br><br>");
		 pw.println("Product Quantity :"+ProductQuantity+"<br><br>");
		 pw.println("Product Price :"+ProductPrice+"<br><br>");		
		 pw.println("</h1></centre>");

		
	}
	else {
		pw.println("welcome "+userName+" Invalid credentials");
	}
	}

}
