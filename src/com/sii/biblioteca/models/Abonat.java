package com.sii.biblioteca.models;

public class Abonat extends BaseModel {
	
	int idAbonat;
	String cnp;
	String nume;
	String prenume;
	String oras;
	String tel;
	String stare;
	int nr_penalizari;
	
	public Abonat(){}
	
	
	public Abonat(int idAbonat, String cnp, String nume, String prenume,
			String oras, String tel, String stare, int nr_penalizari) {
		super();
		this.idAbonat = idAbonat;
		this.cnp = cnp;
		this.nume = nume;
		this.prenume = prenume;
		this.oras = oras;
		this.tel = tel;
		this.stare = stare;
		this.nr_penalizari = nr_penalizari;
	}

	public int getIdAbonat() {
		return idAbonat;
	}
	public void setIdAbonat(int idAbonat) {
		this.idAbonat = idAbonat;
	}
	public String getCnp() {
		return cnp;
	}
	public void setCnp(String cnp) {
		this.cnp = cnp;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getPrenume() {
		return prenume;
	}
	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
	public String getOras() {
		return oras;
	}
	public void setOras(String oras) {
		this.oras = oras;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getStare() {
		return stare;
	}
	public void setStare(String stare) {
		this.stare = stare;
	}
	public int getNr_penalizari() {
		return nr_penalizari;
	}
	public void setNr_penalizari(int nr_penalizari) {
		this.nr_penalizari = nr_penalizari;
	}


	@Override
	public String toString() {
		return nume;
	}

	public int toStringIdAbnt() {
		return idAbonat;
	}

	public String toStringLista()
	{
		return "Id:" + idAbonat + ",Cnp: " + cnp + ",Nume:"
				+ nume + ",Prenume:" + prenume + ",Oras:" + oras + ",Tel:"
				+ tel + ",Stare:" + stare + ",Penalizari:" + nr_penalizari;
		
		
	}
	
	
	
	
}
