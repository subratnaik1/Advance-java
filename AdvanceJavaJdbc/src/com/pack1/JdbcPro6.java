package com.pack1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcPro6 {
	String driver="oracle.jdbc.OracleDriver";
	String dbUrl="jdbc:oracle:thin:@localhost:1521:orcl";
	String dbName="subrat";
	String dbPwd="67890";
	
	Connection connect() {
		Connection con=null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(dbUrl, dbName, dbPwd);
			IO.println("connected");
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
		return con;		
	}
	void m2() {
		Connection con=connect();
		try {
			Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=stmt.executeQuery("select eid,efname,esal from employee");
			while(rs.next()) {
				
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
void main() {
	JdbcPro6 j6=new JdbcPro6();
	
}
}
