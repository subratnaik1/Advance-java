package pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/ms")
public class FirstServelet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		String name=req.getParameter("nm");
		int age=Integer.parseInt(req.getParameter("ag"));
		Long number=Long.parseLong(req.getParameter("mo"));
		String gender =req.getParameter("mal");	
		String hobbies=req.getParameter("s");
		
		pw.println("</h1></center>");
		pw.println("Name : "+name);
		pw.println("Age : "+age);
		pw.println("Pnone number : "+number);
		pw.println("Gender : "+gender);
		
		if(hobbies.equalsIgnoreCase("reading")) {
			pw.println("Hobbies - "+hobbies);
		}
		else if(hobbies.equalsIgnoreCase("searching")) {
			pw.println("Hobbies - "+hobbies);
		}
		else if(hobbies.equalsIgnoreCase("sleep")) {
			pw.println("Hobbies - "+hobbies);
		}
		else if(hobbies.equalsIgnoreCase("dance")) {
			pw.println("Hobbies - "+hobbies);
		}
	}
	                              
}
