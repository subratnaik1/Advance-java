package pack1;

import java.io.Serializable;

public class CustomerBean implements Serializable{

	private String c_name;
	private String c_pword;
	private String c_fname;
	private String c_lname;
	private String c_addr;
	private String c_mid;
	private String c_phno;
	
	public CustomerBean() {		
	}

	
	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_pword() {
		return c_pword;
	}

	public void setC_pword(String c_pword) {
		this.c_pword = c_pword;
	}

	public String getC_fname() {
		return c_fname;
	}

	public void setC_fname(String c_fname) {
		this.c_fname = c_fname;
	}

	public String getC_lname() {
		return c_lname;
	}

	public void setC_lname(String c_lname) {
		this.c_lname = c_lname;
	}

	public String getC_addr() {
		return c_addr;
	}

	public void setC_addr(String c_addr) {
		this.c_addr = c_addr;
	}

	public String getC_mid() {
		return c_mid;
	}

	public void setC_mid(String c_mid) {
		this.c_mid = c_mid;
	}

	public String getC_phno() {
		return c_phno;
	}

	public void setC_phno(String c_phno) {
		this.c_phno = c_phno;
	}
	
}
