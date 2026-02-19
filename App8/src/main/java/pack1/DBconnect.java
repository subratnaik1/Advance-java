package pack1;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnect {
	static Connection con=null;
	static {
		try {
			IO.println("hiii");
		Class.forName(DBinfo1.driver);
		con=DriverManager.getConnection(DBinfo1.dbUrl, DBinfo1.dbUname, DBinfo1.dbPwd);
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getCon() {
		return con;
	}
}
