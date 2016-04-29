package com.sii.biblioteca.models;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Autor extends BaseModel {

	//fields shouldn't be public
	public int id;
	public String nume;
	public Date data_nastere;
	
	
	public Autor() {
		super();
	}
	
	public Autor(int id, String nume, Date dataNastere) {
		super();
		this.id = id;
		this.nume = nume;
		this.data_nastere = dataNastere;
	}
	
	public Autor(String nume, Date dataNastere) {
		super();
		this.nume = nume;
		this.data_nastere = dataNastere;
	}
	public Autor(int id, String nume) {
		super();
		this.id = id;
		this.nume = nume;
		
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
	public Date getData_nastere() {
		return data_nastere;
	}
	public void setData_nastere(Date dataNastere) {
		this.data_nastere = dataNastere;
	}

	//show the timestamp into a more readble format
	public String getDataNastereString(){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String sd = df.format(new Date(data_nastere.getTime()));
		return sd;
		
	}
	
}
