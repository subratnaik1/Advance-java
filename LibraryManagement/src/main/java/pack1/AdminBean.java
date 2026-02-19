package pack1;

import java.io.Serializable;

public class AdminBean implements Serializable{
	
private String Admin_name;
private String Admin_password;
private String Admin_First_name;
private String Admin_last_name;
private String Mail_id;
private String phone_no;

public AdminBean() {}

public String getAdmin_name() {
	return Admin_name;
}

public void setAdmin_name(String admin_name) {
	Admin_name = admin_name;
}

public String getAdmin_password() {
	return Admin_password;
}

public void setAdmin_password(String admin_password) {
	Admin_password = admin_password;
}

public String getAdmin_First_name() {
	return Admin_First_name;
}

public void setAdmin_First_name(String admin_First_name) {
	Admin_First_name = admin_First_name;
}

public String getAdmin_last_name() {
	return Admin_last_name;
}

public void setAdmin_last_name(String admin_last_name) {
	Admin_last_name = admin_last_name;
}

public String getMail_id() {
	return Mail_id;
}

public void setMail_id(String mail_id) {
	Mail_id = mail_id;
}

public String getPhone_no() {
	return phone_no;
}

public void setPhone_no(String phone_no) {
	this.phone_no = phone_no;
};

}
