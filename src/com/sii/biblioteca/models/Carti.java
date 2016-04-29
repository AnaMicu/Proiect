package com.sii.biblioteca.models;

public class Carti extends BaseModel{
	
	int idCarti;
	 String titlu;
	 double pret;
	 int status;
	 int idEditura;
	 int an;
	 int nr_imprumuturi;
	 
	public int getNr_imprumuturi() {
		return nr_imprumuturi;
	}
	public void setNr_imprumuturi(int nr_imprumuturi) {
		this.nr_imprumuturi = nr_imprumuturi;
	}
	public int getAn() {
		return an;
	}
	public void setAn(int an) {
		this.an = an;
	}
	public int getIdCarti() {
		return idCarti;
	}
	public void setIdCarti(int idCarti) {
		this.idCarti = idCarti;
	}
	public String getTitlu() {
		return titlu;
	}
	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}
	public double getPret() {
		return pret;
	}
	public void setPret(double pret) {
		this.pret = pret;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getIdEditura() {
		return idEditura;
	}
	public void setIdEditura(int idEditura) {
		this.idEditura = idEditura;
	}
	public Carti(int idCarti, String titlu, double pret, int status,
			int idEditura, int an,int nr_imprumuturi) {
		super();
		this.idCarti = idCarti;
		this.titlu = titlu;
		this.pret = pret;
		this.status = status;
		this.idEditura = idEditura;
		this.an = an;
		this.nr_imprumuturi=nr_imprumuturi;
	}
	public Carti(){
		
	}
	@Override
	public String toString() {
		return titlu;
	}
	
	public String toStringListaSuma() {
		return "Pret:"+ pret + ",An:" + an ;
	}
	
	public String toStringTOP() {
		return "Titlu: " + titlu +  "   "   + " ,Imprumuturi: " + nr_imprumuturi;
	}
	public int toStringId() {
		return idCarti;
	}
	public int toStringStatus() {
		return status;
	}
}
