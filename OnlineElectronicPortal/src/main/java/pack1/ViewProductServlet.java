package pack1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/view1")
public class ViewProductServlet extends HttpServlet {
       protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
    	   HttpSession session=req.getSession(false);
    	   if(session==null) {
    		  throw new RuntimeException("SessionExpired"); 
    	   }
    	   else {   		   
    			   ViewProductDAO vd= new ViewProductDAO ();
    			   ArrayList<ProductBean> al=vd.retriveProducts();
    			   HttpSession session2=req.getSession();
    			   session2.setAttribute("productList", al);
    			   req.getRequestDispatcher("ViewProduct.jsp").forward(req, res);  			   
    		   }
    		  	  
    	   }     
}
