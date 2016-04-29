package com.sii.biblioteca.models;

public class Carti_Abonat {
	String numeA;
	String numeC;
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
	public Carti_Abonat(String numeA, String numeC) {
		super();
		this.numeA = numeA;
		this.numeC = numeC;
	}
	@Override
	public String toString() {
		return "Carti_Abonat [numeA=" + numeA + ", numeC=" + numeC + "]";
	}

}
