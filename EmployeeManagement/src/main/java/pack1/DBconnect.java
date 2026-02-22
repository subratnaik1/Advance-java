package pack1;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnect {
	static Connection con=null;
	static {
		try {			
		Class.forName(DBinfo.driver);
		con=DriverManager.getConnection(DBinfo.dbUrl, DBinfo.dbUname, DBinfo.dbPwd);
		
		}
		catch(Exception e) {
			IO.println("error occured in db connect");
			e.printStackTrace();
		}
	}
	public static Connection getCon() {
		return con;
}
}
