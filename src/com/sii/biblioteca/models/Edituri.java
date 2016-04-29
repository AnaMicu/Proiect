package com.sii.biblioteca.models;

public class Edituri extends BaseModel{
	
	int idEditura;
	String denumire;
	public int getIdEditura() {
		return idEditura;
	}
	public void setIdEditura(int idEditura) {
		this.idEditura = idEditura;
	}
	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	public Edituri(int idEditura, String denumire) {
		super();
		this.idEditura = idEditura;
		this.denumire = denumire;
	}
	 public Edituri() {
		
	}
	@Override
	public String toString() {
		return this.denumire;
	}

}
