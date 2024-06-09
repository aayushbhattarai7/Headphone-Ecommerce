package model;

public class userModel {
private String fullName;
private String email;
private String phoneNumber;
private String password;

public userModel(String fullName, String email, String phoneNumber, String password){
	super();
this.fullName = fullName;
this.email = email;
this.phoneNumber = phoneNumber;
this.password = password;
}
public userModel() {
	
}
public String getFullName() {
	return fullName;
}
public String getEmail() {
	return email;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public String getPassword() {
	return password;
}

public void setFullName(String fullName) {
	this.fullName = fullName;
	}

public void setEmail(String email) {
	this.email = email;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber =  phoneNumber;
}
public void setPassword(String password) {
this.password = password;
}
}
