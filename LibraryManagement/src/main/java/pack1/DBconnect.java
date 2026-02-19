package pack1;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnect {
	static Connection con = null;
	static {
    try {
    	Class.forName(DBinfo.driver);
    	con=DriverManager.getConnection(DBinfo.DBurl, DBinfo.DBuname, DBinfo.DBpwd);
    }
    catch(Exception e){
    	e.printStackTrace();
    }
	}
	public static Connection getCon() {
		return con;
	}
}
