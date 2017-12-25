package com.tcs.Repo.model;

public class UserVO {

	private String username;

	private String iduser;

	private String fname;
	private String confirmpwd;
	private String lname;

	private String password;

	private String email;

	private String state;
	private String cntry;
	private String city;

	public UserVO() { }

	public UserVO(String iduser,String username,String fname,String confirpwd,String lname,String password,String email,String state,String cntry,String city){
		this.iduser=iduser;
		this.username=username;
		this.fname=fname;
		this.lname=lname;
		this.password=password;
		this.email=email;
		this.state=state;
		this.cntry=cntry;
		this.city=city;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCntry() {
		return cntry;
	}

	public void setCntry(String cntry) {
		this.cntry = cntry;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getIduser() {
		return iduser;
	}

	public void setIduser(String iduser) {
		this.iduser = iduser;
	}

	public String getConfirmpwd() {
		return confirmpwd;
	}

	public void setConfirmpwd(String confirmpwd) {
		this.confirmpwd = confirmpwd;
	}

}
