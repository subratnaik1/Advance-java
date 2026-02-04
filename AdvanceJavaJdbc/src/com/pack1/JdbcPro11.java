package com.pack1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.sql.RowSetMetaData;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JdbcPro11 {
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUname = "subrat";
	String dbPwd = "67890";
	String q = "select * from employee where EID=?";

	Connection connect() {
		Connection con = null;
		try {
			IO.println("connecting");
			Class.forName(driver);
			con = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
			IO.println("connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	void m1() {
		IO.println("executing metadata");
		Connection con = connect();
		try {

			DatabaseMetaData dmdt = con.getMetaData();
			IO.println("getDatabaseProductName : " + dmdt.getDatabaseProductName());
			IO.println("getDatabaseMinorVersion : " + dmdt.getDatabaseMinorVersion());
			IO.println("getDriverName : " + dmdt.getDriverName());
			IO.println("supportsStoredProcedures : " + dmdt.supportsStoredProcedures());
			IO.println("-------------------------------------------------");
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, "2");
			ResultSet rs1 = pstmt.executeQuery();
			ParameterMetaData pmtdt = pstmt.getParameterMetaData();
			IO.println("getParameterCount : " + pmtdt.getParameterCount());
//			IO.println("getParameterType : " + pmtdt.getParameterType(1));
//			IO.println("getParameterMode : " + pmtdt.getParameterMode(1));
//			IO.println("isNullable : " + pmtdt.isNullable(1));
			IO.println("---------------------------------");
			ResultSetMetaData rsmtdt = rs1.getMetaData();
			IO.println("getColumnCount" + rsmtdt.getColumnCount());
			IO.println("getColumnName" + rsmtdt.getColumnName(1));
			IO.println("getColumnDisplaySize" + rsmtdt.getColumnDisplaySize(1));
			IO.println("isAutoIncrement" + rsmtdt.isAutoIncrement(1));
			IO.println("---------------------------------");
			RowSetFactory rsf = RowSetProvider.newFactory();
			CachedRowSet jrs = rsf.createCachedRowSet();
			jrs.setUrl(dbUrl);
			jrs.setUsername(dbUname);
			jrs.setPassword(dbPwd);
			jrs.setCommand("select * from employee");
			jrs.execute();
			RowSetMetaData rsmtdt2 = (RowSetMetaData) jrs.getMetaData();
			IO.println("getColumnCount" + rsmtdt2.getColumnCount());
			IO.println("getColumnName" + rsmtdt2.getColumnName(1));
			IO.println("getColumnDisplaySize" + rsmtdt2.getColumnDisplaySize(1));
			IO.println("isAutoIncrement" + rsmtdt2.isAutoIncrement(1));
			IO.println("getColumnType" + rsmtdt2.getColumnType(1));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void main() {
		JdbcPro11 j1 = new JdbcPro11();
		j1.m1();
	}
}
