package com.sii.biblioteca.models;



public class Carti_Autori extends BaseModel{
	String titlu;
	String nume;
	int idCA;
	int idA;
	int idC;
	Carti c;
	Autor a;
	
	
	public Carti_Autori(int idCA, Carti c, Autor a) {
		super();
		this.idCA = idCA;
		this.c = c;
		this.a = a;
	}
	public int getIdCA() {
		return idCA;
	}
	public void setIdCA(int idCA) {
		this.idCA = idCA;
	}
	public String getTitlu() {
		return titlu;
	}
	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	
	public Carti_Autori(String titlu, String nume) {
		super();
		this.titlu = titlu;
		this.nume = nume;
	}
	
	public Carti_Autori()
	{
		
	}
	public int getIdA() {
		return idA;
	}
	public void setIdA(int idA) {
		this.idA = idA;
	}
	public int getIdC() {
		return idC;
	}
	public void setIdC(int idC) {
		this.idC = idC;
	}
	public Carti getC() {
		return c;
	}
	public void setC(Carti c) {
		this.c = c;
	}
	public Autor getA() {
		return a;
	}
	public void setA(Autor a) {
		this.a = a;
	}
	public Carti_Autori(int idA, int idC) {
		super();
		this.idA = idA;
		this.idC = idC;
	}
	public Carti_Autori(Carti c, Autor a) {
		super();
		this.c = c;
		this.a = a;
	}
	
	


}
