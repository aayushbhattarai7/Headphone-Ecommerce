package model;

public class adminModel {
private String email;
private String password;

public adminModel(String email, String password){
	super();

this.email = email;
this.password = password;
}

public adminModel() {
	
}

public String getEmail() {
	return email;
}

public String getPassword() {
	return password;
}

public void setEmail(String email) {
	this.email = email;
}

public void setPassword(String password) {
this.password = password;
}
}
