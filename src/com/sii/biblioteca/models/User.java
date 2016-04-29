package com.sii.biblioteca.models;

public class User extends BaseModel{
	
	int id;
	String nume;
	String pass;
	int type;
	int admin;

	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	public User(int id, String nume, String pass, int type,int admin) {
		super();
		this.id = id;
		this.nume = nume;
		this.pass = pass;
		this.type = type;
		this.admin=admin;
		
	}
	
	public User(){}
	@Override
	public String toString() {
		return nume;
	}
	
	
}
