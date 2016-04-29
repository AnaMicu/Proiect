package com.sii.biblioteca.models;

import java.util.Date;

public class Return extends BaseModel{
	
	String numeC;
	Date data_r;
	
	
	public Return(String numeC, Date data_r, String numeA) {
		super();
		this.numeC = numeC;
		this.data_r = data_r;
		this.numeA = numeA;
	}
	String numeA;
	public String getNumeA() {
		return numeA;
	}
	public void setNumeA(String numeA) {
		this.numeA = numeA;
	}
	public String getNumeC() {
		return numeC;
	}
	public void setNumeC(String numeC) {
		this.numeC = numeC;
	}
	public Date getData_r() {
		return data_r;
	}
	public void setData_r(Date data_r) {
		this.data_r = data_r;
	}

	

}
