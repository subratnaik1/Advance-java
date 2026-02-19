package com.sn.pack3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/fs")
public class ThirdServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    String EmpName=req.getParameter("uname");
    int empId=Integer.parseInt(req.getParameter("eid"));
    int EmpSal=Integer.parseInt(req.getParameter("esal"));
    int EmpExp=Integer.parseInt(req.getParameter("eexp"));
    if(EmpExp>=5) {
    	EmpSal=(int)(EmpSal+(EmpSal*0.10));    	
    }
    PrintWriter pw=res.getWriter();
    res.setContentType("text/html");
    
    pw.println("<center><h1>");
    pw.println("Users Data<br>");
    pw.println("emp Name : "+EmpName+"<br><br>");
    pw.println("emp id : "+empId+"<br><br>");
    pw.println("emp salary : "+EmpSal+"<br><br>");
    pw.println("emp exp : "+EmpExp+"<br><br>");
    pw.println("</h1></centre>");
	}
	

}
